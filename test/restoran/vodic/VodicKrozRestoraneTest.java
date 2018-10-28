package restoran.vodic;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restoran.Restoran;
import test.TestUtil;

public class VodicKrozRestoraneTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	VodicKrozRestorane instance;

	@Before
	public void setUp() throws Exception {
		instance = new VodicKrozRestorane(5);
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test(timeout = 2000)
	public void atribut_restorani() {
		assertTrue("U klasi nije definisan atribut restorani", TestUtil.doesFieldExist(VodicKrozRestorane.class, "restorani"));
	}
	
	@Test
	public void atribut_restorani_vidljivost() {
		assertTrue("Atribut restorani nije privatan", TestUtil.hasFieldModifier(VodicKrozRestorane.class, "restorani", Modifier.PRIVATE));
	}

	@Test(timeout = 2000)
	public void konstruktor_VodicKrozRestorane() {
		instance = new VodicKrozRestorane(5);
		
		Restoran[] niz = (Restoran[])(TestUtil.getFieldValue(instance,"restorani"));
		
		assertEquals("Ako se pozove sa kapacitetom 5, ne inicijalizuje niz na taj kapacitet", 5, niz.length);
	}
	
	@Test(timeout = 2000)
	public void konstruktor_VodicKrozRestorane_negativanKapacitet() {
		instance = new VodicKrozRestorane(-5);
		
		Restoran[] niz = (Restoran[])(TestUtil.getFieldValue(instance,"restorani"));
		
		assertEquals("Ako se pozove sa kapacitetom -5, ne inicijalizuje niz na kapacitet 20", 20, niz.length);
	}

	@Test(timeout = 2000)
	public void metoda_unesiRestoran() {
		Restoran r1 = new Restoran();
		
		instance.unesiRestoran(r1);
		
		Restoran[] niz = (Restoran[])(TestUtil.getFieldValue(instance,"restorani"));

		assertEquals("Metoda ne unosi restoran na prvo slobodno mesto od kraja niza", r1, niz[4]);
		assertEquals("Metoda unosti isti restoran na vise slobodnih mesta", null, niz[0]);
		assertEquals("Metoda unosti isti restoran na vise slobodnih mesta", null, niz[1]);
		assertEquals("Metoda unosti isti restoran na vise slobodnih mesta", null, niz[2]);
		assertEquals("Metoda unosti isti restoran na vise slobodnih mesta", null, niz[3]);
	}
	
	@Test(timeout = 2000)
	public void metoda_unesiRestoran_dvaUnosa() {
		Restoran r1 = new Restoran();
		Restoran r2 = new Restoran();
		
		instance.unesiRestoran(r1);
		instance.unesiRestoran(r2);
		
		Restoran[] niz = (Restoran[])(TestUtil.getFieldValue(instance,"restorani"));

		assertEquals("Metoda ne unosi restoran na prvo slobodno mesto od kraja niza", r1, niz[4]);
		assertEquals("Metoda ne unosi restoran na prvo slobodno mesto od kraja niza", r2, niz[3]);
		assertEquals("Metoda unosti isti restoran na vise slobodnih mesta", null, niz[0]);
		assertEquals("Metoda unosti isti restoran na vise slobodnih mesta", null, niz[1]);
		assertEquals("Metoda unosti isti restoran na vise slobodnih mesta", null, niz[2]);
	}
	
	@Test(timeout = 2000)
	public void metoda_unesiRestoran_NULL() {
		instance = new VodicKrozRestorane(2);
		
		Restoran r1 = new Restoran();
		Restoran r2 = new Restoran();
		
		instance.unesiRestoran(r1);
		instance.unesiRestoran(r2);

		
		Restoran r3 = new Restoran();
		instance.unesiRestoran(r3);

		assertEquals("NE ispisuje se rec GRESKA u slucaju da je niz pun", "GRESKA", outContent.toString().trim().toUpperCase());
	}
	
	@Test(timeout = 2000)
	public void metoda_unesiRestoran_NizPun() {
		instance.unesiRestoran(null);

		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());
	}


	@Test(timeout = 2000)
	public void metoda_napraviTopListuVrstaHraneInt() {
		fail("Not yet implemented");
	}

	@Test(timeout = 2000)
	public void metoda_napraviTopListuVrstaHrane() {
		fail("Not yet implemented");
	}

}
