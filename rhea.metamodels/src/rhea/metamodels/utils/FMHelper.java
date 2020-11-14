package rhea.metamodels.utils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import rhea.metamodels.BasicFMs.BasicFMsFactory;
import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.FeatureModel;

public class FMHelper {

	
//	public FeatureModel createEmptyFeatureModel() {
//		EPackage initialMetamodel = BasicFMsPackage.eINSTANCE;
//		EFactory mFactory = initialMetamodel.getEFactoryInstance();
//		EClass eClass = (EClass) initialMetamodel.getEClassifier("FeatureModel");
//		EObject model = mFactory.create(eClass);
//		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
//		model.eSet(eAttributeName, "fm");
//
//		return (FeatureModel) model;
//	}
}
