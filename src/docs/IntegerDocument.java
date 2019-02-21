package docs;

import javax.swing.text.PlainDocument;

public class IntegerDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;
	private int validLength;

	public IntegerDocument(int i) {
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
		String valid = "0123456789";

		for (int i = 0; i < str.length(); i++) {
			if (valid.indexOf(str.charAt(i)) == -1
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