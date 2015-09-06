package _06_EnumAndAnnotation.Item_31;

// Use instance fields instead of ordinals
// code for item 31 in java efective 2nd edition.

//Abuse of ordinal to derive an associated value - DON'T DO THIS
public enum Ensemble {
	
	SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;
	
	public int numberOfMusicians() { return ordinal() + 1; }
}