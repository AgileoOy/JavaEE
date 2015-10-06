package fi.agileo.testing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PaivamaaraLaskenta {

	private Calendar alku;
	private Calendar loppu;

	public PaivamaaraLaskenta(Calendar alku, Calendar loppu) {
		this.alku = alku;
		this.loppu = loppu;
	}

	public int laskePaivat() {
		int paivat = 0;
		Calendar paivaLaskuri = new GregorianCalendar();
		paivaLaskuri.setTime(alku.getTime());

		// kaikki päivät ennen loppu päivää
		while (paivaLaskuri.before(loppu)) {
			paivat++;
			paivaLaskuri.add(Calendar.DATE, 1);
		}
		return ++paivat; // huomioidaan sama päivämäärä
	}

	public int laskeArkipaivat() {
		int arkipaivat = 0;
		Calendar paivaLaskuri = new GregorianCalendar();
		paivaLaskuri.setTime(alku.getTime());
		SimpleDateFormat formatoija = new SimpleDateFormat("yyyy MMM dd");

		// kaikki arkipäivät ennen loppu päivää
		while (paivaLaskuri.before(loppu)) {

			int viikonpaiva = paivaLaskuri.get(Calendar.DAY_OF_WEEK);
			if (viikonpaiva >= 2 && viikonpaiva <= 6) {
				arkipaivat++;
				System.out.println(formatoija.format(paivaLaskuri.getTime()));
			}

			paivaLaskuri.add(Calendar.DATE, 1);
		}
		// sama päivämäärä käsitellään erikseen
		int viikonpaiva = paivaLaskuri.get(Calendar.DAY_OF_WEEK);
		if (viikonpaiva >= 2 && viikonpaiva <= 6) {
			arkipaivat++;
		}

		return arkipaivat;
	}

	public Calendar teePaivamaara(int v, int kk, int pv) {
		Calendar kalenteri = new GregorianCalendar();
		kalenteri.set(GregorianCalendar.YEAR, v);
		kalenteri.set(GregorianCalendar.MONTH, kk);
		kalenteri.set(GregorianCalendar.DATE, pv);
		return kalenteri;
	}

}
