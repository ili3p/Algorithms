package old.code;

public class PrinterVirus {
	public String getPrintedText(String text) {
		char[] tekst = new char[text.length()];
		tekst = text.toCharArray();
		int dol = text.length();
		char[] t1 = new char[dol / 3];
		char[] t2 = new char[dol / 3];
		char[] t3 = new char[dol / 3];
		for (int j = dol / 3 - 1, i = 0; i < dol / 3; --j, ++i)
			t1[j] = tekst[i];
		for (int j = dol / 3 - 1, i = dol / 3; i < 2 * dol / 3; --j, ++i)
			t2[j] = tekst[i];
		for (int j = dol / 3 - 1, i = 2 * dol / 3; i < dol; --j, ++i)
			t3[j] = tekst[i];
		String s1 = new String(t1);
		String s2 = new String(t2);
		String s3 = new String(t3);

		return s1 + s2 + s3;
	}

	public static void main(String[] args) {
		PrinterVirus p = new PrinterVirus();
		System.out.print(p.getPrintedText("ABCDEFGHIJKLMNOPQRSTUVWXYZ."));
	}

}
