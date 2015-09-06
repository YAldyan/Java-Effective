package _02_CreatingDestroyingObject.Item_03;

// // Singleton with public final field
public class ElvisPublicFinal {
	
	public static final ElvisPublicFinal INSTANCE = new ElvisPublicFinal();
	private ElvisPublicFinal() {}
	public void leaveTheBuilding() {}

}

// membuat kelas singleton dengan public final
// sehingga objek bisa di-akses setiap kali
// dengan nilai yang sama dan tidak bisa
// di-modifikasi lanjutan.