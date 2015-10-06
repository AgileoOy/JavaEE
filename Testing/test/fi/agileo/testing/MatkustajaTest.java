package fi.agileo.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyDouble;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MatkustajaTest {

	@Mock
	Profiili mockProfiili;
	
	@Before
	public void setUp() {
		when(mockProfiili.muunnaHinta(anyDouble())).thenReturn(100.0);		
//		when(mockProfiili.muunnaHinta(200.0)).thenReturn(200.0);		
//		when(mockProfiili.muunnaHinta(300.0)).thenReturn(300.0);		
	}
	
	@Test
	public void testKerroHinta() {
//		Profiili mockProfiili = mock(Profiili.class);
		Matkustaja testattava = new Matkustaja(mockProfiili);
//		stub(mockProfiili.muunnaHinta(200.0)).toReturn(100.0);
//		when(mockProfiili.muunnaHinta(100.0)).thenReturn(100.0);

		assertEquals("Hinta on 100.0", testattava.kerroHinta(100));
		assertEquals("Hinta on 100.0", testattava.kerroHinta(200));
		assertEquals("Hinta on 100.0", testattava.kerroHinta(300));
		
		verify(mockProfiili).muunnaHinta(100.0);
	}

}
