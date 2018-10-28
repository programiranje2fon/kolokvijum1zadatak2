package restoran.vodic;

import java.util.GregorianCalendar;

import restoran.Restoran;
import restoran.vrsta.VrstaHrane;

public class VodicKrozRestorane {
	
	private Restoran[] restorani;
	
	public VodicKrozRestorane(int kapacitet) {
		if (kapacitet > 0)
			restorani = new Restoran[kapacitet];
		else
			restorani = new Restoran[20];
	}

	public void unesiRestoran(Restoran r) {
		if (r == null) {
			System.out.println("GRESKA");
			return;
		}
		
		for(int i=restorani.length-1; i>=0; i--)
			if (restorani[i] == null) {
				restorani[i] = r;
				return;
			}
		
		//Ovo ce se izvrsiti samo ako nije unet tj. niz je pun
		System.out.println("GRESKA");
	}
	
	public void napraviTopListu(VrstaHrane hrana, int godina) {
		for (int i=0; i<restorani.length; i++)
			if (restorani[i].getHrana().equals(hrana) &&
					godina == restorani[i].getDatumProcene().get(GregorianCalendar.YEAR) &&
					restorani[i].getOcena() == 5)
				System.out.println( restorani[i] );
	}
	
	public Restoran[] napraviTopListu(VrstaHrane hrana) {
		Restoran[] niz = new Restoran[10];
		
		//int tekucaGodina = new GregorianCalendar().get(GregorianCalendar.YEAR);
		
		return niz;
		
	}
	
}
