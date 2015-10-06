package fi.agileo.testing;

public class Profiili {
	private String status;
	private double alennusProsentti;
	
	public Profiili() {
		alennusProsentti = 15;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getAlennusProsentti() {
		return alennusProsentti;
	}
	
	public void setAlennusProsentti(double alennusProsentti) {
		this.alennusProsentti = alennusProsentti;
	}
	
	public double muunnaHinta(double alkuperainenHinta) {
		return alkuperainenHinta * (100.0 - alennusProsentti) / 100.0; 
	}
}
