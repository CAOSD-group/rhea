package rhea.evaluation.refactorings;

import java.util.List;
import java.util.Set;
import rhea.metamodels.BasicFMs.Feature;

public class TransformationInformation {
	private int run;
	
	private String henshinModule;
	private List<String> henshinUnits;
	
	private String inputModel;
	
	private int nFeatures;
	
	private Set<Set<Feature>> productsBefore;
	private Set<Set<Feature>> productsAfter;
	
	private long timeBefore;
	private long timeAfter;
	
	private int numberOfFeaturesTypeBefore;
	private int numberOfFeaturesTypeAfter;
	
	private int rulesExecuted;
	private int rulesSuccessExecuted;
	
	public int getRun() {
		return run;
	}
	
	public void setRun(int run) {
		this.run = run;
	}
	
	public String getHenshinModule() {
		return henshinModule;
	}
	
	public void setHenshinModule(String henshinModule) {
		this.henshinModule = henshinModule;
	}
	
	public List<String> getHenshinUnits() {
		return henshinUnits;
	}
	
	public void setHenshinUnits(List<String> henshinUnits) {
		this.henshinUnits = henshinUnits;
	}
	
	public String getInputModel() {
		return inputModel;
	}
	
	public void setInputModel(String inputModel) {
		this.inputModel = inputModel;
	}
	
	public int getnFeatures() {
		return nFeatures;
	}
	
	public void setnFeatures(int nFeatures) {
		this.nFeatures = nFeatures;
	}
	
	public Set<Set<Feature>> getProductsBefore() {
		return productsBefore;
	}
	
	public void setProductsBefore(Set<Set<Feature>> productsBefore) {
		this.productsBefore = productsBefore;
	}
	
	public Set<Set<Feature>> getProductsAfter() {
		return productsAfter;
	}
	
	public void setProductsAfter(Set<Set<Feature>> productsAfter) {
		this.productsAfter = productsAfter;
	}
	
	public long getTimeBefore() {
		return timeBefore;
	}
	
	public void setTimeBefore(long timeBefore) {
		this.timeBefore = timeBefore;
	}
	
	public long getTimeAfter() {
		return timeAfter;
	}
	
	public void setTimeAfter(long timeAfter) {
		this.timeAfter = timeAfter;
	}
	
	public int getNumberOfFeaturesTypeBefore() {
		return numberOfFeaturesTypeBefore;
	}
	
	public void setNumberOfFeaturesTypeBefore(int numberOfFeaturesTypeBefore) {
		this.numberOfFeaturesTypeBefore = numberOfFeaturesTypeBefore;
	}
	
	public int getNumberOfFeaturesTypeAfter() {
		return numberOfFeaturesTypeAfter;
	}
	
	public void setNumberOfFeaturesTypeAfter(int numberOfFeaturesTypeAfter) {
		this.numberOfFeaturesTypeAfter = numberOfFeaturesTypeAfter;
	}
	
	public long getPerformance() {
		return timeAfter-timeBefore;
	}

	public int getRulesExecuted() {
		return rulesExecuted;
	}

	public void setRulesExecuted(int rulesExecuted) {
		this.rulesExecuted = rulesExecuted;
	}

	public int getRulesSuccessExecuted() {
		return rulesSuccessExecuted;
	}

	public void setRulesSuccessExecuted(int rulesSuccessExecuted) {
		this.rulesSuccessExecuted = rulesSuccessExecuted;
	}
}