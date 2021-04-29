package rhea.evaluation.refactorings;

import java.util.Set;
import rhea.metamodels.BasicFMs.Feature;

public class TransformationInformation {
	private int run;
	
	private String henshinModule;
	private Set<String> henshinUnits;
	
	private String inputModel;
	
	public int nFeaturesBefore;
	private int nFeaturesAfter;
	
	private Set<Set<Feature>> productsBefore;
	private Set<Set<Feature>> productsAfter;
	
	private double timeBefore;
	private double timeAfter;
	
	public int numberOfFeaturesTypeBefore;
	private int numberOfFeaturesTypeAfter;
	
	private int rulesExecuted;
	private int rulesSuccessExecuted;
	
	private int nOptionals;
	private int nMandatories;
	private int nSelectionGroups;
	private int nAlternativeGroups;
	private int nConstraints;
	
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
	
	public Set<String> getHenshinUnits() {
		return henshinUnits;
	}
	
	public void setHenshinUnits(Set<String> henshinUnits) {
		this.henshinUnits = henshinUnits;
	}
	
	public String getInputModel() {
		return inputModel;
	}
	
	public void setInputModel(String inputModel) {
		this.inputModel = inputModel;
	}
	
	public int getnFeaturesBefore() {
		return nFeaturesBefore;
	}
	
	public void setnFeaturesBefore(int nFeaturesBefore) {
		this.nFeaturesBefore = nFeaturesBefore;
	}
	
	public int getnFeaturesAfter() {
		return nFeaturesAfter;
	}
	
	public void setnFeaturesAfter(int nFeaturesAfter) {
		this.nFeaturesAfter = nFeaturesAfter;
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
	
	public double getTimeBefore() {
		return timeBefore;
	}
	
	public void setTimeBefore(double timeBefore) {
		this.timeBefore = timeBefore;
	}
	
	public double getTimeAfter() {
		return timeAfter;
	}
	
	public void setTimeAfter(double timeAfter) {
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
	
	public double getPerformance() {
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

	public int getnOptionals() {
		return nOptionals;
	}

	public void setnOptionals(int nOptionals) {
		this.nOptionals = nOptionals;
	}

	public int getnMandatories() {
		return nMandatories;
	}

	public void setnMandatories(int nMandatories) {
		this.nMandatories = nMandatories;
	}

	public int getnSelectionGroups() {
		return nSelectionGroups;
	}

	public void setnSelectionGroups(int nSelectionGroups) {
		this.nSelectionGroups = nSelectionGroups;
	}

	public int getnAlternativeGroups() {
		return nAlternativeGroups;
	}

	public void setnAlternativeGroups(int nAlternativeGroups) {
		this.nAlternativeGroups = nAlternativeGroups;
	}

	public int getnConstraints() {
		return nConstraints;
	}

	public void setnConstraints(int nConstraints) {
		this.nConstraints = nConstraints;
	}
}
