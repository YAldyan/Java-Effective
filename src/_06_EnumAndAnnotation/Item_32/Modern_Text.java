package _06_EnumAndAnnotation.Item_32;

import java.util.Set;

//EnumSet - a modern replacement for bit fields

public class Modern_Text {

	public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

	//Any Set could be passed in, but EnumSet is clearly best
	public void applyStyles(Set<Style> styles) {}

	// text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
}
