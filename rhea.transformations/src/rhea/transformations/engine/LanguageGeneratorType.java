package rhea.transformations.engine;

import java.util.Map;

public enum LanguageGeneratorType { 
	Root("Root", "deterministic/GenRoot", "GenSimpleRoot", Map.of()),
	OptionalFeature("Optional Feature", "nondeterministic/GenFeatureRandomly", "GenSimpleFeatureRandomly", Map.of(LanguageGeneratorParam.MANDATORY.getName(), false)),
	MandatoryFeature("Mandatory Feature", "nondeterministic/GenFeatureRandomly", "GenSimpleFeatureRandomly", Map.of(LanguageGeneratorParam.MANDATORY.getName(), true)),
	OrdinaryFeature("Ordinary Feature", "nondeterministic/GenFeatureRandomly", "GenSimpleFeatureRandomly", Map.of()),
	SelectionGroup("Selection Group", "nondeterministic/GenFeatureRandomly", "GenSelectionGroupRandomly", Map.of()),
	AlternativeGroup("Alternative Group", "nondeterministic/GenFeatureRandomly", "GenAlternativeGroupRandomly", Map.of());
	
	private String name;
	private String henshinModule;
	private String henshinRule;
	private Map<String, Object> params;
	
	LanguageGeneratorType(String name, String henshinModule, String henshinRule, Map<String, Object> params) {
		this.name = name;
		this.henshinModule = henshinModule;
		this.henshinRule = henshinRule;
		this.params = params;
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

	public Map<String, Object> getParams() {
		return params;
	}
	
}
