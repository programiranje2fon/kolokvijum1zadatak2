package restoran.vrsta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VrstaHraneTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void enum_KINESKA() {
		assertEquals(VrstaHrane.KINESKA, VrstaHrane.KINESKA);
	}
	
	@Test
	public void enum_DOMACA() {
		assertEquals(VrstaHrane.DOMACA, VrstaHrane.DOMACA);
	}
	
	@Test
	public void enum_INTERNACIONALNA() {
		assertEquals(VrstaHrane.INTERNACIONALNA, VrstaHrane.INTERNACIONALNA);
	}
	
	@Test
	public void enum_ITALIJANSKA() {
		assertEquals(VrstaHrane.ITALIJANSKA, VrstaHrane.ITALIJANSKA);
	}
	
}
