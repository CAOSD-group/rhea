package rhea.transformations.engine;

public enum LanguageGeneratorParam {
	NAME("name"),
	MANDATORY("mandatory"),
	ABSTRACT("abs");
	
	private String name;
	
	LanguageGeneratorParam(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
