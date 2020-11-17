package rhea.evaluation.EMFdynamicity;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.utils.EMFIO;

public class DynamicityTests {
	public static final String BASEDIR = "D:/Workspaces/RHEA-ws/rhea/";
	public static final String BASEDIR_METAMODELS = BASEDIR + "rhea.metamodels/metamodels/";
	public static final String BASEDIR_OUTPUT_MODELS_DYNAMICITY = BASEDIR + "rhea.evaluation/dynamicity/";
	
	public static final String metamodelPath = BASEDIR_METAMODELS + "BasicFMs/BasicFMs.ecore";
	
	public static void main(String[] args) throws IOException {
		// Dynamic model instance	
		EPackage dynamicMetamodel = (EPackage) EMFIO.loadMetamodel(metamodelPath);
		EObject dynamicModel = createDynamicModel(dynamicMetamodel, "FeatureModel", "my-fm");
		EMFIO.saveModel(dynamicModel, List.of(dynamicMetamodel), BASEDIR_OUTPUT_MODELS_DYNAMICITY + "myDynamicModel.xmi");
		//FeatureModel fm1 = (FeatureModel) dynamicModel; // ERROR!!
		
		// Static model instance
		EPackage staticMetamodel = BasicFMsPackage.eINSTANCE;
		EObject staticModel = createStaticModel(staticMetamodel, "FeatureModel", "my-fm");
		EMFIO.saveModel(staticModel, List.of(staticMetamodel), BASEDIR_OUTPUT_MODELS_DYNAMICITY + "myStaticModel.xmi");
		FeatureModel fm2 = (FeatureModel) staticModel;
	}

	
	public static EObject createDynamicModel(EPackage dynamicMetamodel, String mainClass, String instanceName) {
		EFactory factory = dynamicMetamodel.getEFactoryInstance();
		EClass eClass = (EClass) dynamicMetamodel.getEClassifier(mainClass);
		EObject model = factory.create(eClass);
		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
		model.eSet(eAttributeName, instanceName);

		return model;
	}
	
	public static EObject createStaticModel(EPackage staticMetamodel, String mainClass, String instanceName) {
		EFactory factory = staticMetamodel.getEFactoryInstance();
		EClass eClass = (EClass) staticMetamodel.getEClassifier(mainClass);
		EObject model = factory.create(eClass);
		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
		model.eSet(eAttributeName, instanceName);

		return model;
	}
}
