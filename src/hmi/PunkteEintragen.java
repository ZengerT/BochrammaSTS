package hmi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PunkteEintragen extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JPanel fieldPanel;

	private JButton okButton;
	private JButton cancelButton;

	private JTextField spielerNummer1;
	private JTextField spielerNummer2;
	private JTextField spielerNummer3;
	private JTextField spielerNummer4;
	private JTextField punktePlusSpieler1;
	private JTextField punktePlusSpieler2;
	private JTextField punktePlusSpieler3;
	private JTextField punktePlusSpieler4;
	private JTextField punkteMinusSpieler1;
	private JTextField punkteMinusSpieler2;
	private JTextField punkteMinusSpieler3;
	private JTextField punkteMinusSpieler4;

	private JTextField soli1;
	private JTextField soli2;
	private JTextField soli3;
	private JTextField soli4;

	private JLabel gesamt1;
	private JLabel gesamt2;
	private JLabel gesamt3;
	private JLabel gesamt4;

	private JTextField tischNummer;
	private JLabel lblWarning;

	// Listener

	public void setTextFieldListener(JTextField feld, DocumentListener dl) {
		feld.getDocument().addDocumentListener(dl);
	}

	public void setokButtonListener(ActionListener al) {
		this.okButton.addActionListener(al);
	}

	public void setCancelButtonListener(ActionListener al) {
		this.cancelButton.addActionListener(al);
	}

	// Getter&Setter

	public JTextField getSoli1() {
		return soli1;
	}

	public void setSoli1(JTextField soli1) {
		this.soli1 = soli1;
	}

	public JTextField getSoli2() {
		return soli2;
	}

	public void setSoli2(JTextField soli2) {
		this.soli2 = soli2;
	}

	public JTextField getSoli3() {
		return soli3;
	}

	public void setSoli3(JTextField soli3) {
		this.soli3 = soli3;
	}

	public JTextField getSoli4() {
		return soli4;
	}

	public void setSoli4(JTextField soli4) {
		this.soli4 = soli4;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField getSpielerNummer1() {
		return spielerNummer1;
	}

	public JTextField getSpielerNummer2() {
		return spielerNummer2;
	}

	public JTextField getSpielerNummer3() {
		return spielerNummer3;
	}

	public JTextField getSpielerNummer4() {
		return spielerNummer4;
	}

	public JTextField getPunktePlusSpieler1() {
		return punktePlusSpieler1;
	}

	public JTextField getPunktePlusSpieler2() {
		return punktePlusSpieler2;
	}

	public JTextField getPunktePlusSpieler3() {
		return punktePlusSpieler3;
	}

	public JTextField getPunktePlusSpieler4() {
		return punktePlusSpieler4;
	}

	public JTextField getPunkteMinusSpieler1() {
		return punkteMinusSpieler1;
	}

	public JTextField getPunkteMinusSpieler2() {
		return punkteMinusSpieler2;
	}

	public JTextField getPunkteMinusSpieler3() {
		return punkteMinusSpieler3;
	}

	public JTextField getPunkteMinusSpieler4() {
		return punkteMinusSpieler4;
	}

	public JLabel getGesamt1() {
		return gesamt1;
	}

	public JLabel getGesamt2() {
		return gesamt2;
	}

	public JLabel getGesamt3() {
		return gesamt3;
	}

	public JLabel getGesamt4() {
		return gesamt4;
	}

	public JTextField getTischNummer() {
		return tischNummer;
	}

	public JLabel getLblWarning() {
		return lblWarning;
	}

	/**
	 * Create the dialog.
	 */
	public PunkteEintragen(JFrame main, String runde) {

		super(main, true);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setTitle("Punkte eintragen - " + runde);
		setBounds(100, 100, 684, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setResizable(false);

		// Buttons

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(583, 245, 81, 25);
		contentPanel.add(cancelButton);
		cancelButton.setActionCommand("Cancel");

		okButton = new JButton("OK");
		okButton.setBounds(490, 245, 81, 25);
		contentPanel.add(okButton);
		okButton.setActionCommand("OK");

		getRootPane().setDefaultButton(okButton);

		// Panel

		fieldPanel = new JPanel();
		fieldPanel.setBounds(10, 10, 654, 225);
		contentPanel.add(fieldPanel);
		fieldPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldPanel.setLayout(null);

		// Zeilenbeschriftung

		JLabel lblSpieler1 = new JLabel("Spieler 1");
		lblSpieler1.setBounds(12, 43, 70, 19);
		fieldPanel.add(lblSpieler1);
		lblSpieler1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSpieler2 = new JLabel("Spieler 2");
		lblSpieler2.setBounds(12, 74, 70, 19);
		fieldPanel.add(lblSpieler2);
		lblSpieler2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSpieler3 = new JLabel("Spieler 3");
		lblSpieler3.setBounds(12, 105, 70, 19);
		fieldPanel.add(lblSpieler3);
		lblSpieler3.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSpieler4 = new JLabel("Spieler 4");
		lblSpieler4.setBounds(12, 136, 70, 19);
		fieldPanel.add(lblSpieler4);
		lblSpieler4.setFont(new Font("Tahoma", Font.PLAIN, 12));

		// Spaltenbeschriftung

		JLabel lblSpielernummer = new JLabel("Spielernummer", JLabel.CENTER);
		lblSpielernummer.setBounds(94, 12, 100, 19);
		fieldPanel.add(lblSpielernummer);
		lblSpielernummer.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblPluspunkte = new JLabel("Pluspunkte", JLabel.CENTER);
		lblPluspunkte.setBounds(206, 12, 100, 19);
		fieldPanel.add(lblPluspunkte);
		lblPluspunkte.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblMinuspunkte = new JLabel("Minuspunkte", JLabel.CENTER);
		lblMinuspunkte.setBounds(318, 12, 100, 19);
		fieldPanel.add(lblMinuspunkte);
		lblMinuspunkte.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSoli = new JLabel("Gespielte Soli", JLabel.CENTER);
		lblSoli.setBounds(430, 12, 100, 19);
		fieldPanel.add(lblSoli);
		lblSoli.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblGesamtpunkte = new JLabel("Gesamtpunkte", JLabel.CENTER);
		lblGesamtpunkte.setBounds(542, 12, 100, 19);
		fieldPanel.add(lblGesamtpunkte);
		lblGesamtpunkte.setFont(new Font("Tahoma", Font.PLAIN, 12));

		
		// Spielernummer

		spielerNummer1 = new JTextField();
		spielerNummer1.setColumns(10);
		spielerNummer1.setBounds(124, 43, 40, 19);
		fieldPanel.add(spielerNummer1);

		spielerNummer2 = new JTextField();
		spielerNummer2.setColumns(10);
		spielerNummer2.setBounds(124, 74, 40, 19);
		fieldPanel.add(spielerNummer2);

		spielerNummer3 = new JTextField();
		spielerNummer3.setColumns(10);
		spielerNummer3.setBounds(124, 105, 40, 19);
		fieldPanel.add(spielerNummer3);

		spielerNummer4 = new JTextField();
		spielerNummer4.setColumns(10);
		spielerNummer4.setBounds(124, 136, 40, 19);
		fieldPanel.add(spielerNummer4);

		// Pluspunkte

		punktePlusSpieler1 = new JTextField();
		punktePlusSpieler1.setColumns(10);
		punktePlusSpieler1.setBounds(236, 43, 40, 19);
		fieldPanel.add(punktePlusSpieler1);

		punktePlusSpieler2 = new JTextField();
		punktePlusSpieler2.setColumns(10);
		punktePlusSpieler2.setBounds(236, 74, 40, 19);
		fieldPanel.add(punktePlusSpieler2);

		punktePlusSpieler3 = new JTextField();
		punktePlusSpieler3.setColumns(10);
		punktePlusSpieler3.setBounds(236, 105, 40, 19);
		fieldPanel.add(punktePlusSpieler3);

		punktePlusSpieler4 = new JTextField();
		punktePlusSpieler4.setColumns(10);
		punktePlusSpieler4.setBounds(236, 136, 40, 19);
		fieldPanel.add(punktePlusSpieler4);

		// Minuspunkte

		punkteMinusSpieler1 = new JTextField();
		punkteMinusSpieler1.setColumns(10);
		punkteMinusSpieler1.setBounds(348, 43, 40, 19);
		fieldPanel.add(punkteMinusSpieler1);

		punkteMinusSpieler2 = new JTextField();
		punkteMinusSpieler2.setColumns(10);
		punkteMinusSpieler2.setBounds(348, 74, 40, 19);
		fieldPanel.add(punkteMinusSpieler2);

		punkteMinusSpieler3 = new JTextField();
		punkteMinusSpieler3.setColumns(10);
		punkteMinusSpieler3.setBounds(348, 105, 40, 19);
		fieldPanel.add(punkteMinusSpieler3);

		punkteMinusSpieler4 = new JTextField();
		punkteMinusSpieler4.setColumns(10);
		punkteMinusSpieler4.setBounds(348, 136, 40, 19);
		fieldPanel.add(punkteMinusSpieler4);

		//Soli
		
		soli1 = new JTextField();
		soli1.setColumns(10);
		soli1.setBounds(460, 43, 40, 19);
		fieldPanel.add(soli1);
		
		soli2 = new JTextField();
		soli2.setColumns(10);
		soli2.setBounds(460, 74, 40, 19);
		fieldPanel.add(soli2);
		
		soli3 = new JTextField();
		soli3.setColumns(10);
		soli3.setBounds(460, 105, 40, 19);
		fieldPanel.add(soli3);
		
		soli4 = new JTextField();
		soli4.setColumns(10);
		soli4.setBounds(460, 136, 40, 19);
		fieldPanel.add(soli4);
		
		
		// Gesamtpunkte

		gesamt1 = new JLabel("ges.", JLabel.CENTER);
		gesamt1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gesamt1.setBounds(572, 43, 40, 19);
		fieldPanel.add(gesamt1);

		gesamt2 = new JLabel("ges.", JLabel.CENTER);
		gesamt2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gesamt2.setBounds(572, 74, 40, 19);
		fieldPanel.add(gesamt2);

		gesamt3 = new JLabel("ges.", JLabel.CENTER);
		gesamt3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gesamt3.setBounds(572, 105, 40, 19);
		fieldPanel.add(gesamt3);

		gesamt4 = new JLabel("ges.", JLabel.CENTER);
		gesamt4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gesamt4.setBounds(572, 136, 40, 19);
		fieldPanel.add(gesamt4);

		
		
		
		// Tischnummernfeld

		JPanel tischPanel = new JPanel();
		tischPanel.setBorder(new TitledBorder(null, "Tischnummer",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tischPanel.setBounds(12, 167, 182, 46);
		fieldPanel.add(tischPanel);
		tischPanel.setLayout(null);

		tischNummer = new JTextField();
		tischNummer.setBounds(120, 15, 40, 19);
		tischNummer.setColumns(10);
		tischPanel.add(tischNummer);

		// Punkte ungleich null

		lblWarning = new JLabel("Summe der Punkte ungleich Null!");
		lblWarning.setIcon(new ImageIcon(PunkteEintragen.class
				.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(318, 181, 294, 32);
		fieldPanel.add(lblWarning);
		lblWarning.setVisible(false);
	}
}
