package rhea.parsers.featureide;

import java.util.Collection;
import java.util.Iterator;

import de.ovgu.featureide.fm.core.base.IConstraint;
import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.IFeatureModelStructure;
import de.ovgu.featureide.fm.core.base.IFeatureStructure;
import rhea.metamodels.BasicCTCs.BasicCTCsFactory;
import rhea.metamodels.BasicFMs.BasicFMsFactory;
import rhea.metamodels.BasicFMs.CrossTreeConstraint;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;

/**
 * hay que adaptarlo, ahora mismo solo contempla restricciones básicas (IMPLIES, EXCLUDES).
 * 
 *
 */
public class FeatureIDE2FM {

	public static FeatureModel create(IFeatureModel fm) {
		// fm and root
		FeatureModel myfm = BasicFMsFactory.eINSTANCE.createFeatureModel();
		IFeatureModelStructure structure = fm.getStructure();
		IFeatureStructure fs = structure.getRoot();
		myfm.setName(fs.getFeature().getName());

		Feature root = createStructure(fs);
		myfm.setRoot(root);
		
		// constraints
		// TODO currently only support for implies and mutex
		for(IConstraint c : fm.getConstraints()) {
			Collection<IFeature> f = c.getContainedFeatures();
			if(f.size() == 2) {
				Iterator<IFeature> i = f.iterator();
				IFeature left = i.next();
				IFeature right = i.next();
				// requires and excludes
				// TODO basic string comparison, there are other possible representations for excludes
				//System.out.println(c);
				if (c.getDisplayName().contains(" | ") || c.getDisplayName().contains(" => ")) {
					//CrossTreeConstraint ctc = BasicCTCsFactory.eINSTANCE.creacreateCrossTreeConstraint();
					ctc.setLeftFeature(FeatureModelHelper.getFeatureByName(myfm, left.getName()));
					ctc.setRightFeature(FeatureModelHelper.getFeatureByName(myfm, right.getName()));
					//System.out.println(c.getDisplayName());
					if (c.getDisplayName().startsWith("-") && c.getDisplayName().contains(" | -")) {
						ctc.setType(CrossTreeConstraintType.EXCLUDES);
					} else if (c.getDisplayName().startsWith("-") && c.getDisplayName().contains(" => -")) {
						ctc.setType(CrossTreeConstraintType.EXCLUDES);
					} else {
						ctc.setType(CrossTreeConstraintType.REQUIRES);	
						if(c.getDisplayName().contains(" | -") || c.getDisplayName().contains(" => -")) {
							ctc.setLeftFeature(FeatureModelHelper.getFeatureByName(myfm, right.getName()));
							ctc.setRightFeature(FeatureModelHelper.getFeatureByName(myfm, left.getName()));	
						}
					}
					myfm.getCrossTreeConstraints().add(ctc);
				}
			}
		}

		return myfm;
	}

	/**
	 * To be used recursively
	 * 
	 * @param current
	 *            featureIde feature structure
	 * @return feature
	 */
	public static Feature createStructure(IFeatureStructure current) {
		IFeature f = current.getFeature();
		Feature myf = null;

		// group feature or not
		if (current.isAlternative() || current.isOr()) {
			myf = BasicFMsFactory.eINSTANCE.createGroupFeature();
			if (current.isAlternative()) {
				((GroupFeature) myf).setChildMinCardinality(1);
				((GroupFeature) myf).setChildMaxCardinality(1);
			} else if (current.isOr()) {
				((GroupFeature) myf).setChildMinCardinality(1);
				((GroupFeature) myf).setChildMaxCardinality(current.getChildrenCount());
			}
		} else {
			myf = MDEOptimiser4EFMFactory.eINSTANCE.createFeature();
		}

		// mandatory or not
		if (current.getParent() != null && (current.getParent().isAlternative() || current.getParent().isOr())) {
			// in featureide the children of group feature are marked as
			// mandatory
			myf.setOptional(true);
		} else if (current.isMandatory()) {
			myf.setOptional(false);
		} else {
			myf.setOptional(true);
		}

		myf.setName(f.getName());

		// children
		for (IFeatureStructure cfs : current.getChildren()) {
			Feature c = createStructure(cfs);
			myf.getOwnedFeatures().add(c);
		}

		return myf;
	}

}
