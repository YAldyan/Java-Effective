package _07_Method.Item_40;

public class BuilderPattern {
	
	private String nama ;
	private String kelas;
	private String jurusan;
	private String status ;
	
	public String getNama() {
		return nama;
	}
	public BuilderPattern setNama(String nama) {
		this.nama = nama;
		
		return this ;
	}
	public String getKelas() {
		return kelas;
	}
	public BuilderPattern setKelas(String kelas) {
		this.kelas = kelas;
		
		return this ;
	}
	public String getJurusan() {
		return jurusan;
	}
	public BuilderPattern setJurusan(String jurusan) {
		this.jurusan = jurusan;
		
		return this ;
	}
	public String getStatus() {
		return status;
	}
	public BuilderPattern setStatus(String status) {
		this.status = status;
		
		return this;
	}
	

}
