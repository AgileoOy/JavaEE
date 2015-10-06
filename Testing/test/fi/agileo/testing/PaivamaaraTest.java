package fi.agileo.testing;

/* 
 Harjoitus: 1: Paivamaara-luokka päivämäärien käsittelyyn ja tarkastamiseen

Tee staattinen luokka Paivamaara, joka tarkastaa, onko Paivamaara validi sekä
sisältää muita hyödyllisiä metodeja:

Luokan staattisia ominaisuuksia:
 
        private static final String kuukaudetMjonona[]
          = {"Tammi", "Helmi", "Maalis", "Huhti", "Touko", "Kesä",
             "Heinä", "Elo", "Syys", "Loka", "Marras", "Joulu"};

        private static final  String paivatMjonona[]
          = {"Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai", "Lauantai",
             "Sunnuntai"};

        private static final  int paiviaKuukaudessa[]
          = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

Kirjoita metodi onKarkausvuosi, joka palauttaa true, jos vuosi on karkausvuosi.
   public static boolean onKarkausvuosi(int vuosi)  { .... }

Kirjoita metodi onValidiPaivamaara(int vuosi, int kuukausi, int paiva), 
joka palauttaa true, jos annettu paiva on validi.

  public static boolean onValidiPaivamaara(int vuosi, int kuukausi, int paiva) { ..... }

Sallitut arvot ovat:

  vuosi: 1700-2499
  kuukausi: 1 - 12
  paiva: 1-31. maksimi riippuu kuukaudesta

Kirjoitetaan JUnit-yksikkötestit, jolla testataan luokan toimivuus käytännössä.

Alla on testimetodit, jolla testaat, että luokan metodit toimivat oikein. 

    @Test
    public void testKarkausvuosi() {
        assertEquals(false, Paivamaara.onKarkausvuosi(1800));  
        assertEquals(true, Paivamaara.onKarkausvuosi(2000));  
        assertEquals(true, Paivamaara.onKarkausvuosi(2012));  
        assertEquals(false, Paivamaara.onKarkausvuosi(2015));  
        assertEquals(true, Paivamaara.onKarkausvuosi(1600));  
    }

    @Test
    public void testValidiPaivamaara() {
        assertEquals(false, Paivamaara.onValidiPaivamaara(2015, 2, 29));  
        assertEquals(true, Paivamaara.onValidiPaivamaara(2016, 2, 29));  
        assertEquals(true, Paivamaara.onValidiPaivamaara(2029, 12, 31)); 
        assertEquals(false, Paivamaara.onValidiPaivamaara(2029, 12, 32)); 
        assertEquals(false, Paivamaara.onValidiPaivamaara(2029, -1, 28)); 
    }


 -------------------------------
 Harjoitus: 1b: Paivamaara-luokka jatkoa

Kirjoita metodi viikonPaiva, joka palauttaa, mikä viikonpaiva kyseinen paiva on!

ks. lisätietoa: https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week#Centuries_table

1700  1800   1900  2000  2100  2200  2300   2400
4     2      0     6     4     2     0      6

Yllä on lista eri vuosisatojen ensimmäisestä viikonpäivästä, missä 0 =  Sunnuntai ja 6 = Lauantai.

Lähin 100 saadaan jakamalla vuosi kokonaisluvulla 100 (tulos on pyöristetty esim. 1955 / 100 = 19 jne.)
ja kertomalla saatu luku arvolla 100.


Kirjoita metodi tulosta, joka tulostaa paivamaaran merkkijonona:

esim. "Torstai 3. Syyskuuta 2015".

Alla on testimetodit, jolla testaat, että luokan metodit toimivat oikein. 


    @Test 
    public void testViikonpaiva() {
        assertEquals(6, Paivamaara.viikonPaiva(2000, 1, 1));  // 6: lauantai
        assertEquals(0, Paivamaara.viikonPaiva(2002, 2, 24)); // 4:Torstai
        assertEquals(0, Paivamaara.viikonPaiva(2015, 9, 6));  // 0:Sunnuntai
        assertEquals(4, Paivamaara.viikonPaiva(2015, 9, 3));  // 4:Torstai
        assertEquals(2, Paivamaara.viikonPaiva(1801, 1, 7));  // 2: Tiistai
    }
    @Test 
    public void testTulostus() {
        assertEquals("Virhe Päivämäärässä!", Paivamaara.tulosta(1801, 15, 9) );
        assertEquals("Torstai 3. Syyskuuta 2015.", Paivamaara.tulosta(2015, 9, 3) );  
        assertEquals("Sunnuntai 6. Syyskuuta 2015.", Paivamaara.tulosta(2015, 9, 6) );  
    }

*/

import org.junit.*;
import static org.junit.Assert.*;

public class PaivamaaraTest {
    @Test
    public void testKarkausvuosi() {
    	Paivamaara pvm = new Paivamaara();
        assertEquals(false, pvm.onKarkausvuosi(1800));  
        assertEquals(true, pvm.onKarkausvuosi(2000));  
        assertEquals(true, pvm.onKarkausvuosi(2012));  
        assertEquals(false, pvm.onKarkausvuosi(2015));  
        assertEquals(true, pvm.onKarkausvuosi(1600));  
        assertEquals(true, pvm.onKarkausvuosi(2400));  
        assertEquals(false, pvm.onKarkausvuosi(-1));  
    }

    @Test
    public void testValidiPaivamaara() {
    	Paivamaara pvm = new Paivamaara();
        assertEquals(false, pvm.onValidiPaivamaara(2015, 2, 29));  
        assertEquals(true, pvm.onValidiPaivamaara(2016, 2, 29));  
        assertEquals(true, pvm.onValidiPaivamaara(2029, 12, 31)); 
        assertEquals(false, pvm.onValidiPaivamaara(2029, 12, 32)); 
        assertEquals(false, pvm.onValidiPaivamaara(2029, -1, 28)); 
    }

    @Test 
    public void testViikonpaiva() {
    	Paivamaara pvm = new Paivamaara();
        assertEquals(6, pvm.viikonPaiva(2000, 1, 1));  // 6: lauantai
        assertEquals(0, pvm.viikonPaiva(2002, 2, 24)); // 4:Torstai
        assertEquals(0, pvm.viikonPaiva(2015, 9, 6));  // 0:Sunnuntai
        assertEquals(4, pvm.viikonPaiva(2015, 9, 3));  // 4:Torstai
        assertEquals(2, pvm.viikonPaiva(1801, 1, 7));  // 2: Tiistai
    }

    @Test 
    public void testTulostus() {
    	Paivamaara pvm = new Paivamaara();
        assertEquals("Virhe Päivämäärässä!", pvm.tulosta(1801, 15, 9) );
        assertEquals("Torstai 3. Syyskuuta 2015.", pvm.tulosta(2015, 9, 3) );  
        assertEquals("Sunnuntai 6. Syyskuuta 2015.", pvm.tulosta(2015, 9, 6) );  
    }

}
