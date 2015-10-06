package fi.agileo.testing;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class RahanLaskenta {
	private BigDecimal raha1;
	private BigDecimal raha2;

	private final static int PYORISTYS_MOODI = BigDecimal.ROUND_HALF_EVEN;
	private final static int DESIMAALIT = 2;
	private BigDecimal SATA = new BigDecimal("100");
	private BigDecimal KAKSI = new BigDecimal("2");

	public RahanLaskenta(BigDecimal r1, BigDecimal r2) {
		raha1 = pyorista(r1);
		raha2 = pyorista(r2);
	}

	public BigDecimal getSumma() {
		return raha1.add(raha2);
	}

	public BigDecimal getEro() {
		return raha2.subtract(raha1);
	}

	public BigDecimal getKeskiarvo() {
		return getSumma().divide(KAKSI, PYORISTYS_MOODI);
	}

	public BigDecimal getProsentit(BigDecimal lisaprosentti) {
		BigDecimal tulos = raha1.multiply(lisaprosentti);
		tulos = tulos.divide(SATA, PYORISTYS_MOODI);
		return pyorista(tulos);
	}

	public BigDecimal getProsentitLisatty(BigDecimal lisaprosentti) {
		return getProsentit(lisaprosentti).add(raha1);
	}

	private BigDecimal pyorista(BigDecimal luku) {
		return luku.setScale(DESIMAALIT, PYORISTYS_MOODI);
	}

	// tulostetan rahayksikkönä
	public String tulostaDollareina() {
		NumberFormat formaatti = NumberFormat.getCurrencyInstance(Locale.US);
		double raha = raha1.doubleValue();
		String dollareina = formaatti.format(raha);
		return "Raha dollareina: " + dollareina;
	}

	// tulostetan rahayksikkönä
	public String tulostaEuroina() {
		// NumberFormat formaatti =
		// NumberFormat.getCurrencyInstance(Locale.GERMAN);
		NumberFormat formaatti = NumberFormat.getCurrencyInstance(Locale.GERMANY); // Locale.JAPAN
		double raha = raha1.doubleValue();
		String euroina = formaatti.format(raha);
		return "Raha euroina: " + euroina;
	}

}
