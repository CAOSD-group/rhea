package rhea.transformations.engine;

public enum LanguageGeneratorType {
	Root("Root", "deterministic/GenRoot", "GenSimpleRoot"),
	Feature("Feature", "nondeterministic/GenFeatureRandomly", "GenSimpleFeatureRandomly"),
	
	SelectionGroup("Selection Group", "GenFeatureRandomly", "GenSelectionGroupRandomly");
	
	private String name;
	private String henshinModule;
	private String henshinRule;
	
	LanguageGeneratorType(String name, String henshinModule, String henshinRule) {
		this.name = name;
		this.henshinModule = henshinModule;
		this.henshinRule = henshinRule;
	}

	public String getName() {
		return name;
	}

	public String getHenshinModule() {
		return henshinModule;
	}

	public String getHenshinRule() {
		return henshinRule;
	}
}
