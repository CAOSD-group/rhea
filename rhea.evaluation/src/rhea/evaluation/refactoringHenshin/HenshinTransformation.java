package rhea.evaluation.refactoringHenshin;

public class HenshinTransformation {
	String fileName;
	String unitName;
	
	public HenshinTransformation(String fileName, String unitName) {
		this.fileName = fileName;
		this.unitName = unitName;
	}

	public String getfileName() {
		return fileName;
	}

	public String getUnitName() {
		return unitName;
	}
}
