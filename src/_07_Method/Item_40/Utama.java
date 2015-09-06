package _07_Method.Item_40;

public class Utama {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuilderPattern bp = new BuilderPattern();
		
		bp.setNama("Aldi").setKelas("IF-B").setJurusan("Informatika").setStatus("Jomblo");
		
		System.out.println(bp.getNama()+" "+bp.getKelas()+" "+bp.getJurusan()+" "+bp.getStatus());

	}

}
