package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import docs.IntegerDocument;
import hmi.PunkteEintragen;

public class ControllerPunkteRnd2Eintragen {

	private int spieler1;
	private int spieler2;
	private int spieler3;
	private int spieler4;

	private int punkteP1;
	private int punkteP2;
	private int punkteP3;
	private int punkteP4;

	private int punkteM1;
	private int punkteM2;
	private int punkteM3;
	private int punkteM4;

	private int punkteG1;
	private int punkteG2;
	private int punkteG3;
	private int punkteG4;

	private int soli1;
	private int soli2;
	private int soli3;
	private int soli4;

	private int tischnummer;

	private int[][] daten = new int[5][4];

	private PunkteEintragen runde2;

	// Konstruktor, Getter&Setter

	public ControllerPunkteRnd2Eintragen(JFrame main) {

		this.runde2 = new PunkteEintragen(main, "Runde 2");
		addDocs();
		addListener();
		okNotPossible();
		this.runde2.setVisible(true);

	}

	public int getSpieler1() {
		return spieler1;
	}

	public void setSpieler1(int spieler1) {
		this.spieler1 = spieler1;
	}

	public int getSpieler2() {
		return spieler2;
	}

	public void setSpieler2(int spieler2) {
		this.spieler2 = spieler2;
	}

	public int getSpieler3() {
		return spieler3;
	}

	public void setSpieler3(int spieler3) {
		this.spieler3 = spieler3;
	}

	public int getSpieler4() {
		return spieler4;
	}

	public void setSpieler4(int spieler4) {
		this.spieler4 = spieler4;
	}

	public int getPunkteP1() {
		return punkteP1;
	}

	public void setPunkteP1(int punkteP1) {
		this.punkteP1 = punkteP1;
	}

	public int getPunkteP2() {
		return punkteP2;
	}

	public void setPunkteP2(int punkteP2) {
		this.punkteP2 = punkteP2;
	}

	public int getPunkteP3() {
		return punkteP3;
	}

	public void setPunkteP3(int punkteP3) {
		this.punkteP3 = punkteP3;
	}

	public int getPunkteP4() {
		return punkteP4;
	}

	public void setPunkteP4(int punkteP4) {
		this.punkteP4 = punkteP4;
	}

	public int getPunkteM1() {
		return punkteM1;
	}

	public void setPunkteM1(int punkteM1) {
		this.punkteM1 = punkteM1;
	}

	public int getPunkteM2() {
		return punkteM2;
	}

	public void setPunkteM2(int punkteM2) {
		this.punkteM2 = punkteM2;
	}

	public int getPunkteM3() {
		return punkteM3;
	}

	public void setPunkteM3(int punkteM3) {
		this.punkteM3 = punkteM3;
	}

	public int getPunkteM4() {
		return punkteM4;
	}

	public void setPunkteM4(int punkteM4) {
		this.punkteM4 = punkteM4;
	}

	public int getPunkteG1() {
		return punkteG1;
	}

	public void setPunkteG1(int punkteG1) {
		this.punkteG1 = punkteG1;
	}

	public int getPunkteG2() {
		return punkteG2;
	}

	public void setPunkteG2(int punkteG2) {
		this.punkteG2 = punkteG2;
	}

	public int getPunkteG3() {
		return punkteG3;
	}

	public void setPunkteG3(int punkteG3) {
		this.punkteG3 = punkteG3;
	}

	public int getPunkteG4() {
		return punkteG4;
	}

	public void setPunkteG4(int punkteG4) {
		this.punkteG4 = punkteG4;
	}

	public int getSoli1() {
		return soli1;
	}

	public void setSoli1(int soli1) {
		this.soli1 = soli1;
	}

	public int getSoli2() {
		return soli2;
	}

	public void setSoli2(int soli2) {
		this.soli2 = soli2;
	}

	public int getSoli3() {
		return soli3;
	}

	public void setSoli3(int soli3) {
		this.soli3 = soli3;
	}

	public int getSoli4() {
		return soli4;
	}

	public void setSoli4(int soli4) {
		this.soli4 = soli4;
	}

	public int getTischnummer() {
		return tischnummer;
	}

	public void setTischnummer(int tischnummer) {
		this.tischnummer = tischnummer;
	}

	public int[][] getDaten() {
		return daten;
	}

	public void setDaten(int[][] daten) {
		this.daten = daten;
	}

	public PunkteEintragen getrunde2() {
		return runde2;
	}

	public void setrunde2(PunkteEintragen runde2) {
		this.runde2 = runde2;
	}

	// Methoden

	public void okNotPossible() {
		getrunde2().getOkButton().setEnabled(false);
	}

	public void okPossible() {
		getrunde2().getOkButton().setEnabled(true);
	}

	public void addDocs() {
		this.runde2.getPunkteMinusSpieler1()
				.setDocument(new IntegerDocument(3));
		this.runde2.getPunkteMinusSpieler2()
				.setDocument(new IntegerDocument(3));
		this.runde2.getPunkteMinusSpieler3()
				.setDocument(new IntegerDocument(3));
		this.runde2.getPunkteMinusSpieler4()
				.setDocument(new IntegerDocument(3));

		this.runde2.getPunktePlusSpieler1().setDocument(new IntegerDocument(3));
		this.runde2.getPunktePlusSpieler2().setDocument(new IntegerDocument(3));
		this.runde2.getPunktePlusSpieler3().setDocument(new IntegerDocument(3));
		this.runde2.getPunktePlusSpieler4().setDocument(new IntegerDocument(3));

		this.runde2.getSpielerNummer1().setDocument(new IntegerDocument(3));
		this.runde2.getSpielerNummer2().setDocument(new IntegerDocument(3));
		this.runde2.getSpielerNummer3().setDocument(new IntegerDocument(3));
		this.runde2.getSpielerNummer4().setDocument(new IntegerDocument(3));

		this.runde2.getSoli1().setDocument(new IntegerDocument(3));
		this.runde2.getSoli2().setDocument(new IntegerDocument(3));
		this.runde2.getSoli3().setDocument(new IntegerDocument(3));
		this.runde2.getSoli4().setDocument(new IntegerDocument(3));

		this.runde2.getTischNummer().setDocument(new IntegerDocument(4));
	}

	public void addListener() {
		this.runde2.setokButtonListener(new okPA1Listener());
		this.runde2.setCancelButtonListener(new cancelPA1Listener());

		this.runde2.setTextFieldListener(runde2.getSpielerNummer1(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getSpielerNummer2(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getSpielerNummer3(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getSpielerNummer4(),
				new isEmptyListener());

		this.runde2.setTextFieldListener(runde2.getPunktePlusSpieler1(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getPunktePlusSpieler2(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getPunktePlusSpieler3(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getPunktePlusSpieler4(),
				new isEmptyListener());

		this.runde2.setTextFieldListener(runde2.getPunkteMinusSpieler1(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getPunkteMinusSpieler2(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getPunkteMinusSpieler3(),
				new isEmptyListener());
		this.runde2.setTextFieldListener(runde2.getPunkteMinusSpieler4(),
				new isEmptyListener());

		this.runde2.setTextFieldListener(runde2.getTischNummer(),
				new isEmptyListener());
	}

	public int checksum(int plus1, int plus2, int plus3, int plus4, int minus1,
			int minus2, int minus3, int minus4) {
		Integer g1 = plus1 - minus1;
		Integer g2 = plus2 - minus2;
		Integer g3 = plus3 - minus3;
		Integer g4 = plus4 - minus4;

		runde2.getGesamt1().setText(g1.toString());
		runde2.getGesamt2().setText(g2.toString());
		runde2.getGesamt3().setText(g3.toString());
		runde2.getGesamt4().setText(g4.toString());

		int check = g1 + g2 + g3 + g4;
		return check;
	}

	// Listener

	class okPA1Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			spieler1 = Integer.parseInt(runde2.getSpielerNummer1().getText()) - 1;
			spieler2 = Integer.parseInt(runde2.getSpielerNummer2().getText()) - 1;
			spieler3 = Integer.parseInt(runde2.getSpielerNummer3().getText()) - 1;
			spieler4 = Integer.parseInt(runde2.getSpielerNummer4().getText()) - 1;

			daten[0][0] = Integer.parseInt(runde2.getSoli1().getText());
			daten[0][1] = Integer.parseInt(runde2.getSoli2().getText());
			daten[0][2] = Integer.parseInt(runde2.getSoli3().getText());
			daten[0][3] = Integer.parseInt(runde2.getSoli4().getText());

			daten[1][0] = Integer.parseInt(runde2.getPunktePlusSpieler1()
					.getText());
			daten[1][1] = Integer.parseInt(runde2.getPunktePlusSpieler2()
					.getText());
			daten[1][2] = Integer.parseInt(runde2.getPunktePlusSpieler3()
					.getText());
			daten[1][3] = Integer.parseInt(runde2.getPunktePlusSpieler4()
					.getText());

			daten[2][0] = Integer.parseInt(runde2.getPunkteMinusSpieler1()
					.getText());
			daten[2][1] = Integer.parseInt(runde2.getPunkteMinusSpieler2()
					.getText());
			daten[2][2] = Integer.parseInt(runde2.getPunkteMinusSpieler3()
					.getText());
			daten[2][3] = Integer.parseInt(runde2.getPunkteMinusSpieler4()
					.getText());

			daten[3][0] = daten[1][0] - daten[2][0];
			daten[3][1] = daten[1][1] - daten[2][1];
			daten[3][2] = daten[1][2] - daten[2][2];
			daten[3][3] = daten[1][3] - daten[2][3];

			daten[4][0] = Integer.parseInt(runde2.getTischNummer().getText());
			runde2.dispose();
		}

	}

	class cancelPA1Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			runde2.dispose();

		}

	}

	class isEmptyListener implements DocumentListener {

		Document doc;

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			try {
				int spielerNummer1 = runde2.getSpielerNummer1().getDocument()
						.getLength();
				int spielerNummer2 = runde2.getSpielerNummer2().getDocument()
						.getLength();
				int spielerNummer3 = runde2.getSpielerNummer3().getDocument()
						.getLength();
				int spielerNummer4 = runde2.getSpielerNummer4().getDocument()
						.getLength();

				int punktePlus1 = runde2.getPunktePlusSpieler1().getDocument()
						.getLength();
				int punktePlus2 = runde2.getPunktePlusSpieler2().getDocument()
						.getLength();
				int punktePlus3 = runde2.getPunktePlusSpieler3().getDocument()
						.getLength();
				int punktePlus4 = runde2.getPunktePlusSpieler4().getDocument()
						.getLength();

				int punkteMinus1 = runde2.getPunkteMinusSpieler1()
						.getDocument().getLength();
				int punkteMinus2 = runde2.getPunkteMinusSpieler2()
						.getDocument().getLength();
				int punkteMinus3 = runde2.getPunkteMinusSpieler3()
						.getDocument().getLength();
				int punkteMinus4 = runde2.getPunkteMinusSpieler4()
						.getDocument().getLength();

				int tischnummer = runde2.getTischNummer().getDocument()
						.getLength();

				int checking = checksum(Integer.parseInt(runde2
						.getPunktePlusSpieler1().getText()),
						Integer.parseInt(runde2.getPunktePlusSpieler2()
								.getText()), Integer.parseInt(runde2
								.getPunktePlusSpieler3().getText()),
						Integer.parseInt(runde2.getPunktePlusSpieler4()
								.getText()),

						Integer.parseInt(runde2.getPunkteMinusSpieler1()
								.getText()), Integer.parseInt(runde2
								.getPunkteMinusSpieler2().getText()),
						Integer.parseInt(runde2.getPunkteMinusSpieler3()
								.getText()), Integer.parseInt(runde2
								.getPunkteMinusSpieler4().getText())

				);

				if (spielerNummer1 > 0 && spielerNummer2 > 0
						&& spielerNummer3 > 0 && spielerNummer4 > 0
						&& punktePlus1 > 0 && punktePlus2 > 0
						&& punktePlus3 > 0 && punktePlus4 > 0
						&& punkteMinus1 > 0 && punkteMinus2 > 0
						&& punkteMinus3 > 0 && punkteMinus4 > 0
						&& tischnummer > 0) {
					if (checking == 0) {
						runde2.getLblWarning().setVisible(false);
						okPossible();
					} else {
						runde2.getLblWarning().setVisible(true);
					}

				} else {
					okNotPossible();
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				// normal
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

			try {
				int spielerNummer1 = runde2.getSpielerNummer1().getDocument()
						.getLength();
				int spielerNummer2 = runde2.getSpielerNummer2().getDocument()
						.getLength();
				int spielerNummer3 = runde2.getSpielerNummer3().getDocument()
						.getLength();
				int spielerNummer4 = runde2.getSpielerNummer4().getDocument()
						.getLength();

				int punktePlus1 = runde2.getPunktePlusSpieler1().getDocument()
						.getLength();
				int punktePlus2 = runde2.getPunktePlusSpieler2().getDocument()
						.getLength();
				int punktePlus3 = runde2.getPunktePlusSpieler3().getDocument()
						.getLength();
				int punktePlus4 = runde2.getPunktePlusSpieler4().getDocument()
						.getLength();

				int punkteMinus1 = runde2.getPunkteMinusSpieler1()
						.getDocument().getLength();
				int punkteMinus2 = runde2.getPunkteMinusSpieler2()
						.getDocument().getLength();
				int punkteMinus3 = runde2.getPunkteMinusSpieler3()
						.getDocument().getLength();
				int punkteMinus4 = runde2.getPunkteMinusSpieler4()
						.getDocument().getLength();

				int tischnummer = runde2.getTischNummer().getDocument()
						.getLength();

				if (spielerNummer1 <= 0 || spielerNummer2 <= 0
						|| spielerNummer3 <= 0 || spielerNummer4 <= 0
						|| punktePlus1 <= 0 || punktePlus2 <= 0
						|| punktePlus3 <= 0 || punktePlus4 <= 0
						|| punkteMinus1 <= 0 || punkteMinus2 <= 0
						|| punkteMinus3 <= 0 || punkteMinus4 <= 0
						|| tischnummer <= 0) {

					okNotPossible();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				// normal
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
