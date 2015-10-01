package fi.agileo.testing;



/* 
 Harjoitus: 2: Paivamäärien erotusten laskenta

Tee luokka PaivamaaraLaskenta, jossa on seuraava metodi:

int laskePaivat() 

joka palauttaa ja laskee montako päivää on kahden 

int laskeArkipaivat() 

joka palauttaa ja laskee montako arkipäivää on kahden parametrinä annetun päivämäärän välissä. 

Arkipäiviksi lasketaan kaikki ma-pe väliset päivät, jotka ovat
alku- ja loppupäivämäärän välissä. 

class PaivamaaraLaskenta {

       private Calendar alku;
       private Calendar loppu;

        public PaivamaaraLaskenta(Calendar alku, Calendar loppu) {
          this.alku = alku;
          this.loppu = loppu;
        }
        // TODO: toteuta metodit
        public int laskePaivat() {  .... }
        public int laskeArkiPaivat() {  .... }
}

Tulosta alku-loppu päivämäärien välissä olevat päivät:


Testataan metodien toimivuus JUnitilla. 
Testiohjelma:

    @Test
    public void testArkipaivat() {
        // aikaväli: 01.09.2015 - 18.09.2015
        PaivamaaraLaskenta pvmLaskenta = new PaivamaaraLaskenta(new GregorianCalendar(2015,8,1), new GregorianCalendar(2015,8,18));
        assertEquals(14, pvmLaskenta.laskeArkipaivat());  
        assertEquals(18, pvmLaskenta.laskePaivat());  
        // aikaväli: 01.09.2015 - 22.10.2015
        PaivamaaraLaskenta pvmLaskenta2 = new PaivamaaraLaskenta(new GregorianCalendar(2015,8,1), new GregorianCalendar(2015,9,22));
        assertEquals(38, pvmLaskenta2.laskeArkipaivat());  
        assertEquals(52, pvmLaskenta2.laskePaivat());  
    }

Extrakysymys: Mieti miten voisit huomioida arkipyhät ohjelmassa?
Tätä ei tarvitse toteuttaa harjoituksessa.

*/

import java.util.*;
import java.text.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LaskeArkipaivatTest {

    private class PaivamaaraLaskenta {

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
            paivaLaskuri.add( Calendar.DATE, 1 );
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
            
            paivaLaskuri.add( Calendar.DATE, 1 );
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


    @Test
    public void testArkipaivat() {
        // aikaväli: 01.09.2015 - 18.09.2015
        PaivamaaraLaskenta pvmLaskenta = new PaivamaaraLaskenta(new GregorianCalendar(2015,8,1), new GregorianCalendar(2015,8,18));
        assertEquals(14, pvmLaskenta.laskeArkipaivat());  
        assertEquals(18, pvmLaskenta.laskePaivat());  
        // aikaväli: 01.09.2015 - 22.10.2015
        PaivamaaraLaskenta pvmLaskenta2 = new PaivamaaraLaskenta(new GregorianCalendar(2015,8,1), new GregorianCalendar(2015,9,22));
        assertEquals(38, pvmLaskenta2.laskeArkipaivat());  
        assertEquals(52, pvmLaskenta2.laskePaivat());  
    }
}
