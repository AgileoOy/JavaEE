package fi.agileo.testing;

public class Matkustaja {
	private Profiili profiili;

	public Matkustaja(Profiili profiili) {
		this.profiili = profiili;
	}
	
	public Profiili getProfiili() {
		return profiili;
	}

	public void setProfiili(Profiili profiili) {
		this.profiili = profiili;
	}
	
	public String kerroHinta(double hinta) {
		return "Hinta on " +  profiili.muunnaHinta(hinta);
	}
	
}
