package rhea.transformations.engine;

import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.LoggingApplicationMonitor;

public class MyLoggingApplicationMonitor extends LoggingApplicationMonitor {
	protected int successSteps = 0;
	
	public int getSteps() {
		return this.step;
	}
	
	public int getSuccessSteps() {
		return this.successSteps;
	}

	@Override
	protected void logStep(UnitApplication application, boolean success, String stepKind) {
		super.logStep(application, success, stepKind);
		if (success) {
			successSteps++;
		}
	}
}
