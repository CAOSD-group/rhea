package rhea.transformations.engine;

import java.util.Map;

public enum LanguageGeneratorType { 
	Root("Root", "deterministic/GenRoot", "GenSimpleRoot", Map.of()),
	OptionalFeature("Optional Feature", "nondeterministic/GenFeatureRandomly", "GenSimpleFeatureRandomly", Map.of(LanguageGeneratorParam.MANDATORY.getName(), false)),
	MandatoryFeature("Mandatory Feature", "nondeterministic/GenFeatureRandomly", "GenSimpleFeatureRandomly", Map.of(LanguageGeneratorParam.MANDATORY.getName(), true)),
	OrdinaryFeatureNonDeterministic("ND Ordinary Feature", "nondeterministic/GenFeatureRandomly", "GenSimpleFeatureRandomly", Map.of()),
	OrdinaryFeatureDeterministic("D Ordinary Feature", "deterministic/GenFeature", "GenSimpleFeature", Map.of()),
	SelectionGroupNonDeterministic("ND Selection Group", "nondeterministic/GenFeatureRandomly", "GenSelectionGroupRandomly", Map.of()),
	SelectionGroupDeterministic("D Selection Group", "deterministic/GenFeature", "GenSelectionGroup", Map.of()),
	AlternativeGroupNonDeterministic("ND Alternative Group", "nondeterministic/GenFeatureRandomly", "GenAlternativeGroupRandomly", Map.of()),
	AlternativeGroupDeterministic("D Alternative Group", "deterministic/GenFeature", "GenAlternativeGroup", Map.of()),
	MutexGroupNonDeterministic("ND Mutex Gorup", "nondeterministic/GenFeatureRandomly", "GenMutexGroupRandomly", Map.of()),
	GroupCardinalityNonDeterministic("ND Group Cardinality", "nondeterministic/GenFeatureRandomly", "GenGroupCardinalityRandomly", Map.of());
	
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
