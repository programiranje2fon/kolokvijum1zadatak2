package restoran;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restoran.vrsta.VrstaHrane;
import test.TestUtil;

public class RestoranTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	Restoran instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Restoran();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut naziv", TestUtil.doesFieldExist(Restoran.class, "naziv"));
	}
	
	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut naziv nije privatan", TestUtil.hasFieldModifier(Restoran.class, "naziv", Modifier.PRIVATE));
	}

	@Test
	public void atribut_hrana() {
		assertTrue("U klasi nije definisan atribut hrana", TestUtil.doesFieldExist(Restoran.class, "hrana"));
	}
	
	@Test
	public void atribut_hrana_vidljivost() {
		assertTrue("Atribut hrana nije privatan", TestUtil.hasFieldModifier(Restoran.class, "hrana", Modifier.PRIVATE));
	}

	@Test
	public void atribut_ocena() {
		assertTrue("U klasi nije definisan atribut ocena", TestUtil.doesFieldExist(Restoran.class, "ocena"));
	}
	
	@Test
	public void atribut_ocena_vidljivost() {
		assertTrue("Atribut ocena nije privatan", TestUtil.hasFieldModifier(Restoran.class, "ocena", Modifier.PRIVATE));
	}

	@Test
	public void atribut_datumProcene() {
		assertTrue("U klasi nije definisan atribut datumProcene", TestUtil.doesFieldExist(Restoran.class, "datumProcene"));
	}
	
	@Test
	public void atribut_datumProcene_vidljivost() {
		assertTrue("Atribut datumProcene nije privatan", TestUtil.hasFieldModifier(Restoran.class, "datumProcene", Modifier.PRIVATE));
	}

	@Test
	public void metoda_setNaziv() {
		instance.setNaziv("Pink");
		
		assertEquals("Ako se unese naziv 'Pink', atribut ne dobija tu vrednost", "Pink", instance.getNaziv());
	}

	@Test
	public void metoda_setNaziv_NULL() {
		instance.setNaziv(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());
	}
	
	@Test
	public void metoda_setNaziv_PrazanString() {
		instance.setNaziv("");
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa praznog Stringa", "GRESKA", outContent.toString().trim().toUpperCase());
		assertEquals("Uneta je nedozvoljena vrednost (prazan String) u atribut naziv", null, instance.getNaziv());
	}
	
	
	@Test
	public void metoda_setOcena_1() {
		instance.setOcena(1);

		assertEquals("Ako se unese ocena 1, atribut ne dobija tu vrednost", 1, instance.getOcena());
	}
	
	@Test
	public void metoda_setOcena_5() {
		instance.setOcena(5);

		assertEquals("Ako se unese ocena 5, atribut ne dobija tu vrednost", 5, instance.getOcena());
	}
	
	@Test
	public void metoda_setOcena_minus1() {
		instance.setOcena(-1);

		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa -1 kao ocene", "GRESKA", outContent.toString().trim().toUpperCase());
		assertEquals("Uneta je nedozvoljena vrednost (-1) u atribut ocena", 0, instance.getOcena());
	}

	@Test
	public void metoda_setDatumProcene() {
		GregorianCalendar gc = new GregorianCalendar();
		
		instance.setDatumProcene(gc);
		
		assertEquals("Kad se unese trenutni datum kao datum procene, atribut ne dobija tu vrednost", gc, instance.getDatumProcene());
	}
	
	@Test
	public void metoda_setDatumProcene_NULL() {
		instance.setDatumProcene(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());
	}

	@Test
	public void metoda_toString() {
		GregorianCalendar gc = new GregorianCalendar();
		
		instance.setDatumProcene(gc);
		instance.setNaziv("MAKAO");
		instance.setHrana(VrstaHrane.KINESKA);
		instance.setOcena(4);
		
		assertTrue("Povratni String ne sadrzi naziv restorana", instance.toString().contains("MAKAO"));
		assertTrue("Povratni String ne sadrzi vrstu hrane", instance.toString().contains("KINESKA"));
		assertTrue("Povratni String ne sadrzi ocenu", instance.toString().contains("4"));
		assertTrue("Povratni String ne sadrzi datumProcene", instance.toString().contains(""+gc.get(GregorianCalendar.YEAR)));
	}

}
