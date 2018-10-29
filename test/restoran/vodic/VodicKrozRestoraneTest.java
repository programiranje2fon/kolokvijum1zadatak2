package restoran.vodic;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restoran.Restoran;
import restoran.vrsta.VrstaHrane;
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
		instance = new VodicKrozRestorane(10);
		
		GregorianCalendar datum = new GregorianCalendar(2007, 11, 1);
		
		Restoran r1 = new Restoran();
		r1.setDatumProcene(datum);
		r1.setNaziv("Restoran 1");
		r1.setOcena(5);
		r1.setHrana(VrstaHrane.INTERNACIONALNA);
		
		Restoran r2 = new Restoran();
		r2.setDatumProcene(datum);
		r2.setNaziv("Restoran 2");
		r2.setOcena(5);
		r2.setHrana(VrstaHrane.KINESKA);
		
		Restoran r3 = new Restoran();
		r3.setDatumProcene(datum);
		r3.setNaziv("Restoran 3");
		r3.setOcena(4);
		r3.setHrana(VrstaHrane.INTERNACIONALNA);
		
		Restoran r4 = new Restoran();
		r4.setDatumProcene(new GregorianCalendar());
		r4.setNaziv("Restoran 4");
		r4.setOcena(5);
		r4.setHrana(VrstaHrane.INTERNACIONALNA);
		
		Restoran r5 = new Restoran();
		r5.setDatumProcene(datum);
		r5.setNaziv("Restoran 5");
		r5.setOcena(5);
		r5.setHrana(VrstaHrane.INTERNACIONALNA);

		instance.unesiRestoran(r1);
		instance.unesiRestoran(r2);
		instance.unesiRestoran(r3);
		instance.unesiRestoran(r4);
		instance.unesiRestoran(r5);
		
		instance.napraviTopListu(VrstaHrane.INTERNACIONALNA, 2007);
		
		assertEquals("Ako je uneto 5 restorana od kojih 2 odgovaraju kriterijumima za Internacionalnu"
				+ " kuhinju"+ " i 2007 godinu, metoda umesto njih ispisuje",
				r5.toString()+System.lineSeparator()+r1.toString()+System.lineSeparator(),
				outContent.toString());
	}

	@Test(timeout = 2000)
	public void metoda_napraviTopListuVrstaHrane() {
		instance = new VodicKrozRestorane(10);
		
		GregorianCalendar datum = new GregorianCalendar(2007, 11, 1);
		
		Restoran r1 = new Restoran();
		r1.setDatumProcene(new GregorianCalendar());
		r1.setNaziv("Restoran 1");
		r1.setOcena(5);
		r1.setHrana(VrstaHrane.INTERNACIONALNA);
		
		Restoran r2 = new Restoran();
		r2.setDatumProcene(datum);
		r2.setNaziv("Restoran 2");
		r2.setOcena(5);
		r2.setHrana(VrstaHrane.KINESKA);
		
		Restoran r3 = new Restoran();
		r3.setDatumProcene(datum);
		r3.setNaziv("Restoran 3");
		r3.setOcena(4);
		r3.setHrana(VrstaHrane.INTERNACIONALNA);
		
		Restoran r4 = new Restoran();
		r4.setDatumProcene(new GregorianCalendar());
		r4.setNaziv("Restoran 4");
		r4.setOcena(4);
		r4.setHrana(VrstaHrane.INTERNACIONALNA);
		
		Restoran r5 = new Restoran();
		r5.setDatumProcene(new GregorianCalendar());
		r5.setNaziv("Restoran 5");
		r5.setOcena(5);
		r5.setHrana(VrstaHrane.INTERNACIONALNA);

		instance.unesiRestoran(r1);
		instance.unesiRestoran(r2);
		instance.unesiRestoran(r3);
		instance.unesiRestoran(r4);
		instance.unesiRestoran(r5);
		
		Restoran[] niz2 = instance.napraviTopListu(VrstaHrane.INTERNACIONALNA);
		Restoran[] niz3 = {r5, r1, r4, null, null, null, null, null, null, null};
		
		assertArrayEquals("Ocekivani i stvarni niz se ne poklapaju", niz3, niz2);
	}

}
