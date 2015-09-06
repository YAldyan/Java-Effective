package _02_CreatingDestroyingObject.Item_01;

public class BooleanObject {
	
	// method valueOf adalah salah satu contoh static factory method
	// boolean yang berupa tipe data primitif pada argument/parameter
	// dikonversi saat return menjadi Boolean Object Reference
	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}

}
