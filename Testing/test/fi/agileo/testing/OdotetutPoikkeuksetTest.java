package fi.agileo.testing;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doThrow;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

/*
 Harjoitus: 3: Poikkeusten käsittely yksikkötesteissä 
 JUnit ja odotetut poikkeukset 

  JUnitissa voidaan kirjoittaa testejä, joilta odotetaan poikkeuksia 

  Testi annotoidaan tällöin seuraavasti

   @Test(expected = MikaTahansaJavanException.class)  

   Kirjoita testit, jotka aiheuttavat seuraavat poikkeukset, joita suorittava metodi odottaa:
  
   ArithmeticException
   NullPointerException
   ArrayIndexOutOfBoundsException
   IndexOutOfBoundsException

   Sinun täytyy selvittää kuinka aiheuttaa yo. poikkeus testimetodissa.

*/

public class OdotetutPoikkeuksetTest {
   
    @Test(expected = ArithmeticException.class)  
    public void jakoNollalla() {  
      int i = 15/0;
    }  

   @Test(expected = ArrayIndexOutOfBoundsException.class)  
    public void divisionWithException() {  
       int t[] = new int[] {1, 2, 3, 4, 5};
       for(int i = 0; i <= t.length; ++i) {
            System.out.println(t[i]);
            assertEquals(t[i]-1, i);
       }
    }
    @Test(expected = IndexOutOfBoundsException.class)  
     public void lisaaListaan() {  
      List<Integer> t = new ArrayList<Integer>();
      t.add(1);
      t.add(2);
      t.add(3);
      System.out.println(t.get(3)); // get indeksin perusteella
    }

    @Test(expected = NullPointerException.class)  
    public void lisaaListaan2() {  
      List<Integer> t = null;
      //List<Integer> t = new ArrayList<Integer>();
      t.add(1);
    }
    
    @Test(expected=IOException.class)
    public void kirjoitusStreamiin() throws IOException {
    	OutputStream mockStream = mock(OutputStream.class);
    	doThrow(new IOException()).when(mockStream).close();
    	
    	OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);
    	//streamWriter.write("jotain");
    	streamWriter.close();
    }










}
