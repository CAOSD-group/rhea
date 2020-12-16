package rhea.evaluation.refactorings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Module;

import rhea.metamodels.BasicFMs.FeatureModel;

public class MainTest {
	private void run(FeatureModel fm, List<String> mds) {
		
		List<Class<?>> refactorings = new ArrayList<>();
		
		for (String m : mds) {
			try 
			{
				refactorings.add(Class.forName(m));
			} 
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		
		for (Class<?> r : refactorings) {
			r.getDeclaredMethod(name, parameterTypes);
			//CONTINUAR
		}
	}
}
