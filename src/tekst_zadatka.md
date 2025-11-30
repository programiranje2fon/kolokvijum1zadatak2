# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

Napraviti javni nabrojivi tip **VrstaHrane** u paketu **restoran.vrsta** koji ima sledeće instance:

* KINESKA
* INTERNACIONALNA
* DOMACA
* ITALIJANSKA

Napraviti javnu klasu **Restoran** u paketu **restoran** koja ima:

* Privatni atribut **naziv**.

* Privatni atribut **hrana** koji predstavlja vrstu hrane koja se služi u restoranu (nabrojivi tip VrstaHrane)

* Privatni atribut **ocena** koji predstavlja ocenu za taj restoran koja je u rasponu od 1 do 5 (ceo broj).

* Privatni atribut **datumProcene** koji predstavlja datum kada je data ocena za restoran (GregorianCalendar).

* Odgovarajuće javne get i set metode za ove atribute. Nedozvoljene vrednosti za atribut naziv su null i prazan String. Ocena treba da bude u rasponu od 1 do 5 a datum procene ne sme da bude null. U slučaju unosa nedozvoljenih vrednosti potrebno je na ekranu ispisati reč "GRESKA".

* Redefinisanu metodu **toString** klase Object koja vraća String sa svim podacima o restoranu.

Napraviti javnu klasu **VodicKrozRestorane** u paketu **restoran.vodic** koja ima:

* Privatni atribut **restorani** koji je niz objekata klase Restoran.

* Javni konstruktor koji kao parametar prima ceo broj i inicijalizuje niz restorani na toliki kapacitet. Ako je uneti broj nula ili manji od nule, konstruktor treba da inicijalizuje niz na kapacitet 20.

* Javnu metodu **unesiRestoran** koja kao ulazni argument prima objekat klase Restoran i unosi ga u niz i to na prvo slobodno mesto ali gledano od KRAJA niza. Mesto je slobodno ako element na tom mestu ima vrednost null. Unošenje se vrši samo ako uneti objekat nije null i ako niz nije pun. U suprotnom, na ekranu ispisati reč "GRESKA".

* Javnu metodu **napraviTopListu** koja ima dva parametra: vrstu hrane (nabrojivi tip) i godinu (kao ceo broj, npr. 2009). Ova metoda bi trebalo da ispisuje na ekranu podatke o svim restoranima koji imaju tu vrstu kuhinje i ocenjeni su ocenom 5 godine koja je uneta kao ulazni parametar.

* Javnu metodu **napraviTopListu** koja ima jedan parametar: vrstu hrane. Metoda vraća niz sa 10 najbolje ocenjenih restorana u **tekućoj godini** koji spremaju tu vrstu hrane. Naravno, prvo bi trebalo redom uneti sve one restorane koji su dobili ocenu 5 pa, ako ostane mesta, onda i one restorane koji su dobili ocenu 4. Ako niz ni onda ne bude popunjen, ostaviti da svi preostali elementi budu null.

Napraviti javnu klasu **ProbaVodicKrozRestorane** u paketu **restoran.proba** koja u okviru main metode pravi jedan objekat klase VodicKrozRestorane sa kapacitetom od 4 restorana i unosi u njega dva restorana: restoran kineske hrane "Makao" koji je ocenjen ocenom 5 datuma 26.10.2012., i restoran domaće hrane "Kuhinja" koji je ocenjen ocenom 4 datuma 1.11.2017.


# Zadatak 2 (ispravka koda)

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

U produžetku teksta je dat kod klase sa metodom koja kao parametar dobija niz String vrednosti i na ekranu ispisuje sve String-ove ali dijagonalno, jedan pored drugog: u prvom redu su samo prva slova svih stringova, u drugom redu prvo jedan blanko znak pa sva druga slova itd. Smatrati da nijedan element niza nije null niti duži od 5 znakova. Na primer, ako metoda kao ulaz dobije niz sa četiri String vrednosti {"PAS", "MACKA", "LOPTA", "DRVO"}konačan izlaz na
ekranu treba da izgleda ovako:

	PMLD
	 AAOR
	  SCPV
	   KTO
	    AA

Dati kod se kompajlira, ali ne radi to šta treba. Napraviti u Eclipse-u klasu **StringIspisivac2** u paketu **ispravka_koda**, prekucati u nju kod koji je dat i, uz minimalne izmene ga ispraviti tako da funkcioniše kako treba. Napraviti test klasu i, koristeći njenu main metodu, pozvati metodu **ispisiDijagonalno()** i proveriti njen rad.

	package ispravka_koda;
	
	public class StringIspisivac2 {
		public static void ispisiDijagonalno(String[] niz){
			String prazno=""; int j=0;
			while(j>5){
			String s = null;
			for(int i=0;i<niz.length;i++)
				if (j < niz[i].length()) s = s + niz[j].charAt(i);
				else s = s + " ";
			System.out.println(prazno+s);
			prazno = prazno + " ";j++;
		}
	} }
