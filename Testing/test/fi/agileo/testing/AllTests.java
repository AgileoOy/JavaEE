package fi.agileo.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OdotetutPoikkeuksetTest.class, PaivamaaraLaskentaTest.class, PaivamaaraTest.class,
		RahaLaskentaTest.class })
public class AllTests {

}
