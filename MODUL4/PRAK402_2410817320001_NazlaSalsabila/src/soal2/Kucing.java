package soal2;

public class Kucing extends HewanPeliharaan {
	private String warnaBulu;
	
	Kucing(String r, String n, String w) {
		super(r, n);
		setWarnaBulu(w);
	}
	
	public void displayDetailKucing() {
		super.display();
		System.out.printf("Memiliki warna bulu: %s\n", getWarnaBulu());
	}
	
	public String getWarnaBulu() {
		return warnaBulu;
	}

	public void setWarnaBulu(String warnaBulu) {
		this.warnaBulu = warnaBulu;
	}

}