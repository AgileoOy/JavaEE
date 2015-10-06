package fi.agileo.testing;


import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.text.NumberFormat;

import org.junit.*;
import static org.junit.Assert.*;

/*

Harjoitus 4: Rahanlaskentaa BigDecimal-luokalla. 

Rahan laskemisessä on Javassa käyttökelpoinen luokka BigDecimal. 
Se soveltuu rahayksikköön, joka käyttää kahta desimaalia (tai mitä tahansa muuta desimaalimäärää).
Laskennassa selvitään myös ilman pyöristysvirheitä, toisin kuin liukulukujen kanssa (double tai float).
Esimerkiksi Doublen Pyöristysvirheet voivat vaikuttaa lopputulokseen viimeisen desimaalin osalta.


    @Test
      public void testRahalaskut() {
        BigDecimal r1 = new BigDecimal("14.504");
        BigDecimal r2 = new BigDecimal("35.566");
        RahanLaskenta laskenta = new RahanLaskenta(r1, r2);
        
        assertEquals("50.07",  laskenta.getSumma().toString());
        assertEquals("21.07",  laskenta.getEro().toString());
        assertEquals("25.04",  laskenta.getKeskiarvo().toString());
        assertEquals("0.94",   laskenta.getProsentit(new BigDecimal("6.50")).toString());
        assertEquals("15.44",  laskenta.getProsentitLisatty(new BigDecimal("6.50")).toString());
    }

    class RahanLaskenta {


      private BigDecimal raha1;
      private BigDecimal raha2;

      private final static int PYORISTYS_MOODI = BigDecimal.ROUND_HALF_EVEN;
      private final static int DESIMAALIT = 2;
      private BigDecimal SATA = new BigDecimal("100");      
      private BigDecimal KAKSI = new BigDecimal("2");     

      public RahanLaskenta(BigDecimal r1, BigDecimal r2){
        raha1 = pyorista(r1);
        raha2 = pyorista(r2);
      }

      // palauttaa kahden luvun summan
      public BigDecimal getSumma(){ ... }
      // palauttaa kahden luvun erotuksen
      public BigDecimal getEro(){ ... }
      // palauttaa kahden luvun keskiarvon
      public BigDecimal getKeskiarvo() { ... }
      // palauttaa raha1:n lisätyn lisaprosentin arvon
      public BigDecimal getProsentit(BigDecimal lisaprosentti){ ... }
      // palauttaa raha1:n lisätyn lisaprosentin arvon lisättynä alkuperäiseen rahamäärään.
      public BigDecimal getProsentitLisatty(BigDecimal lisaprosentti){ ... }

Lisätehtävä:  
    Kuinka tulostaisit rahan eri maiden rahayksikkönä?


Tekijä: Juha Peltomäki.      
*/

public class RahaLaskentaTest {

    @Test
      public void testRahalaskut() {
        BigDecimal r1 = new BigDecimal("14.504");
        BigDecimal r2 = new BigDecimal("35.566");
        RahanLaskenta laskenta = new RahanLaskenta(r1, r2);

        assertEquals("50.07",  laskenta.getSumma().toString());
        assertEquals("21.07",  laskenta.getEro().toString());
        assertEquals("25.04",  laskenta.getKeskiarvo().toString());
        assertEquals("0.94",   laskenta.getProsentit(new BigDecimal("6.50")).toString());
        assertEquals("15.44",  laskenta.getProsentitLisatty(new BigDecimal("6.50")).toString());


    }

    @Test
    public void lokalisointiTesti() {
        BigDecimal r1 = new BigDecimal("14.504");
        BigDecimal r2 = new BigDecimal("35.566");
        RahanLaskenta laskenta = new RahanLaskenta(r1, r2);

        assertEquals("Raha euroina: 14,50 €", laskenta.tulostaEuroina());
        assertEquals("Raha dollareina: $14.50", laskenta.tulostaDollareina());
    }


}
