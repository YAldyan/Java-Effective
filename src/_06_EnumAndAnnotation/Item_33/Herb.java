package _06_EnumAndAnnotation.Item_33;

public class Herb {

	public enum Type { ANNUAL, PERENNIAL, BIENNIAL }

	private final String name;

	public Type type;
	
	Herb(String name, Type type) {
		this.name = name;
	}

	@Override public String toString() {
		return name;
	}
}
