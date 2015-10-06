package fi.agileo.testing;

public class Paivamaara {
	private static final String kuukaudetMjonona[]
        = {"Tammi", "Helmi", "Maalis", "Huhti", "Touko", "Kesä",
           "Heinä", "Elo", "Syys", "Loka", "Marras", "Joulu"};

      private static final  String paivatMjonona[]
        = {"Sunnuntai", "Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai", "Lauantai" };

      private static final  int paiviaKuukaudessa[]
        = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

      private static final int ensimmainenPaiva[][] =
      { {1700, 4}, {1800, 2}, {1900, 0}, {2000, 6}, {2100, 4}, {2200, 2}, {2300, 0}, {2400, 6}};
   
      // Palauttaa true, jos vuosi on karkausvuosi
      public boolean onKarkausvuosi(int vuosi) { 
        return (vuosi % 4 == 0) && ( !(vuosi % 100 == 0) || (vuosi % 400 == 0));
      }


      public boolean onValidiPaivamaara(int vuosi, int kuukausi, int paiva) { 
      if (vuosi >= 1700 && vuosi <= 2499 && kuukausi >= 1 && kuukausi <= 12 && paiva >= 0) {
          if (onKarkausvuosi(vuosi) && kuukausi == 2) {
              return paiva <= paiviaKuukaudessa[kuukausi-1]+1;
          }
          else {
              return paiva <= paiviaKuukaudessa[kuukausi-1];
         }
      }
      return false;
      }
   
     public int viikonPaiva(int vuosi, int kuukausi, int paiva) { 
         if (!onValidiPaivamaara(vuosi, kuukausi, paiva)) return -1; // virhe

        // lähin 100 saadaan jakamalla vuosi kokonaisluvulla 100 (tulos on pyöristetty esim. 1955 / 100 = 19 jne.)
        // ja kertomalla saatu luku arvolla 100.
        int vuosisadanAlku = (vuosi / 100 ) * 100;
        int viikonPaivaAlussa = 0;
        for (int i=0; i < ensimmainenPaiva.length; i++) {
          if ( ensimmainenPaiva[i][0] == vuosisadanAlku) 
              viikonPaivaAlussa = ensimmainenPaiva[i][1];
        }
        System.out.printf("Vuosisadan alku %d ja viikonpaiva alussa %d\n", vuosisadanAlku, viikonPaivaAlussa);
        
        int paivatVuosisadanAlusta = 0;

        for (int i = vuosisadanAlku; i < vuosi; i++ ) {
          paivatVuosisadanAlusta += 365;
          if (onKarkausvuosi(i)) paivatVuosisadanAlusta++; 
        }
        for (int i = 1; i < kuukausi; i++ ) {
          paivatVuosisadanAlusta += paiviaKuukaudessa[i-1];
          if (kuukausi > 2 && onKarkausvuosi(vuosi)) {
              paivatVuosisadanAlusta++;
          }
        }
        paivatVuosisadanAlusta += paiva - 1;


        System.out.printf("Vuosisadan alku %d ja viikonpaiva alussa %d ja paivia yht. %d\n", vuosisadanAlku, viikonPaivaAlussa, paivatVuosisadanAlusta);
        return (paivatVuosisadanAlusta + viikonPaivaAlussa) % 7;
      }
   
      public String tulosta(int vuosi, int kuukausi, int paiva) { 
          if (!onValidiPaivamaara(vuosi, kuukausi, paiva)) return "Virhe Päivämäärässä!";

          int viikonpaiva = this.viikonPaiva(vuosi, kuukausi, paiva);
          return String.format("%s %d. %skuuta %d.", paivatMjonona[viikonpaiva], paiva, kuukaudetMjonona[kuukausi-1], vuosi);
       }

}
