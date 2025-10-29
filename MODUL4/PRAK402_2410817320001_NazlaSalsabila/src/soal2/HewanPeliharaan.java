package soal2;

public class HewanPeliharaan {
	private String nama;
	private String ras;
	
	HewanPeliharaan(String r, String n){
		setRas(r);
		setNama(n);
	}
	
	public void display(){
		System.out.println("Detail Hewan Peliharaan:");
		System.out.printf("Nama hewan peliharaanku adalah : %s\n", getNama());
		System.out.printf("Dengan ras: %s\n", getRas());
	}
	
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getRas() {
		return ras;
	}

	public void setRas(String ras) {
		this.ras = ras;
	}
}