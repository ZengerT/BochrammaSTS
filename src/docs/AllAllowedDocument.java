package docs;

import javax.swing.text.PlainDocument;

public class AllAllowedDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;
	private int validLength;

	public AllAllowedDocument(int i) {
		super();
		validLength = i;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return super.getLength();
	}

	public void insertString(int offset, String str,
			javax.swing.text.AttributeSet a)
			throws javax.swing.text.BadLocationException {

		// Zeichenkette mit den gültigen Zeichen
		String invalid = "+!\"§$%&/()=?*/#~<>|";

		for (int i = 0; i < str.length(); i++) {
			if (invalid.indexOf(str.charAt(i)) >= 0
					|| this.getLength() + str.length() > validLength) {
				// Beep
				java.awt.Toolkit.getDefaultToolkit().beep();
				return;
			}
			// Aufruf der übergeordneten Methode zur Eingabe des Strings
			super.insertString(offset, str, a);
		}
	}

}