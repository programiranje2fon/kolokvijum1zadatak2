package ispravka_koda;

public class StringIspisivac2 {
	public static void ispisiDijagonalno(String[] niz) {
		String prazno = "";
		int j = 0;
		while (j < 5) {
			String s = "";
			for (int i = 0; i < niz.length; i++)
				if (j < niz[i].length())
					s = s + niz[i].charAt(j);
				else
					s = s + " ";
			System.out.println(prazno + s);
			prazno = prazno + " ";
			j++;
		}
	}
}