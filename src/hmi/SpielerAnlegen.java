package hmi;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;

import java.awt.Color;

public class SpielerAnlegen extends JDialog {

	private static final long serialVersionUID = 3L;
	private final JPanel contentPanel = new JPanel();
	private JPanel fieldPanel;
	
	private JTextField inputVorname;
	private JTextField inputNachname;
	private JTextField inputAdresse;
	private JTextField inputPLZ;
	private JTextField inputOrt;
	private JTextField inputMail;
	
	private JButton okButton;
	private JButton cancelButton;
	
	// Listener
	
	public void setTextFieldListener (JTextField feld, DocumentListener dl){
		feld.getDocument().addDocumentListener(dl);
	}

	public void setokButtonListener(ActionListener al) {
		this.okButton.addActionListener(al);
	}

	public void setCancelButtonListener(ActionListener al) {
		this.cancelButton.addActionListener(al);
	}

	// Getter & Setter
	
	public JButton getOkButton(){
		return okButton;
	}

	public JTextField getInputVorname() {
		return inputVorname;
	}

	public JTextField getInputNachname() {
		return inputNachname;
	}

	public JTextField getInputAdresse() {
		return inputAdresse;
	}

	public JTextField getInputPLZ() {
		return inputPLZ;
	}

	public JTextField getInputMail() {
		return inputMail;
	}

	public JTextField getInputOrt() {
		return inputOrt;
	}

	/**
	 * Create the dialog.
	 */
	public SpielerAnlegen(JFrame main) {
		super(main, true);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setTitle("Spieler eintragen");
		setBounds(100, 100, 290, 242);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setResizable(false);

		// Buttons

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(189, 187, 81, 25);
		contentPanel.add(cancelButton);

		okButton = new JButton("OK");
		okButton.setBounds(98, 187, 81, 25);
		contentPanel.add(okButton);

		getRootPane().setDefaultButton(okButton);

		// Panel

		fieldPanel = new JPanel();
		fieldPanel.setBounds(10, 10, 260, 167);
		contentPanel.add(fieldPanel);
		fieldPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fieldPanel.setLayout(null);

		// Zeilenbeschriftung

		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(12, 12, 100, 19);
		fieldPanel.add(lblNachname);
		lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(12, 43, 100, 19);
		fieldPanel.add(lblVorname);
		lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(12, 74, 100, 19);
		fieldPanel.add(lblAdresse);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblPlz = new JLabel("PLZ & Ort");
		lblPlz.setBounds(12, 105, 100, 19);
		fieldPanel.add(lblPlz);
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setBounds(12, 136, 100, 19);
		fieldPanel.add(lblMail);
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 12));

		// Textfelder

		inputVorname = new JTextField();
		inputVorname.setBounds(100, 43, 144, 19);
		fieldPanel.add(inputVorname);
		inputVorname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputVorname.setColumns(10);

		inputNachname = new JTextField();
		inputNachname.setBounds(100, 12, 144, 19);
		fieldPanel.add(inputNachname);
		inputNachname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputNachname.setColumns(10);

		inputAdresse = new JTextField();
		inputAdresse.setBounds(100, 74, 144, 19);
		fieldPanel.add(inputAdresse);
		inputAdresse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputAdresse.setColumns(10);

		inputPLZ = new JTextField();
		inputPLZ.setBounds(100, 105, 47, 19);
		fieldPanel.add(inputPLZ);
		inputPLZ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputPLZ.setColumns(10);

		inputOrt = new JTextField();
		inputOrt.setBounds(159, 105, 85, 19);
		fieldPanel.add(inputOrt);
		inputOrt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputOrt.setColumns(10);

		inputMail = new JTextField();
		inputMail.setBounds(100, 136, 144, 19);
		fieldPanel.add(inputMail);
		inputMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputMail.setColumns(10);

	}
}
