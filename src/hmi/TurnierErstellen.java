package hmi;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.util.Date;

public class TurnierErstellen extends JDialog {

	private static final long serialVersionUID = 3L;
	private final JPanel contentPanel = new JPanel();
	private JTextField inputName;
	private JTextField inputVeranstalter;
	private JFormattedTextField inputDatum;
	private JTextField inputPLZ;
	private JTextField inputOrt;
	public JButton okButton;
	private JButton cancelButton;
	
	// Listener

	public void setTextFieldListener(JTextField feld, DocumentListener dl) {
		feld.getDocument().addDocumentListener(dl);
	}

	public void setKeyListener(KeyListener kl) {
		inputName.addKeyListener(kl);
	}

	public void setokButtonListener(ActionListener al) {
		this.okButton.addActionListener(al);
	}

	public void setCancelButtonListener(ActionListener al) {
		this.cancelButton.addActionListener(al);
	}

	// Getter&Setter

	public JTextField getInputName() {
		return inputName;
	}

	public JTextField getInputVeranstalter() {
		return inputVeranstalter;
	}

	public JTextField getInputDatum() {
		return inputDatum;
	}

	public JTextField getInputPLZ() {
		return inputPLZ;
	}

	public JTextField getInputOrt() {
		return inputOrt;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	/**
	 * Create the dialog.
	 */
	public TurnierErstellen(JFrame main) {

		super(main, true);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setTitle("Turnier erstellen");
		setBounds(100, 100, 326, 211);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setResizable(false);

		JPanel fieldPanel = new JPanel();
		fieldPanel.setBounds(10, 10, 296, 136);
		fieldPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		// Zeilenbeschriftung

		JLabel lblName = new JLabel("Turniername");
		lblName.setBounds(12, 12, 100, 19);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldPanel.add(lblName);

		JLabel lblVeranstalter = new JLabel("Veranstalter");
		lblVeranstalter.setBounds(12, 43, 100, 19);
		lblVeranstalter.setHorizontalAlignment(SwingConstants.LEFT);
		lblVeranstalter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldPanel.add(lblVeranstalter);

		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(12, 74, 100, 19);
		lblDatum.setHorizontalAlignment(SwingConstants.LEFT);
		lblDatum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldPanel.add(lblDatum);

		JLabel lblOrt = new JLabel("PLZ & Ort");
		lblOrt.setBounds(12, 100, 100, 19);
		lblOrt.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldPanel.add(lblOrt);

		// Eingabefelder

		inputName = new JTextField();
		inputName.setBounds(124, 12, 160, 19);
		inputName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputName.setColumns(10);

		inputVeranstalter = new JTextField();
		inputVeranstalter.setBounds(124, 43, 160, 19);
		inputVeranstalter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputVeranstalter.setColumns(10);

		inputDatum = new JFormattedTextField(new Date());
		inputDatum.setBounds(124, 74, 160, 19);
		inputDatum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputDatum.setColumns(10);

		inputPLZ = new JTextField();
		inputPLZ.setBounds(124, 105, 50, 19);
		inputPLZ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputPLZ.setColumns(10);

		inputOrt = new JTextField();
		inputOrt.setBounds(184, 105, 100, 19);
		inputOrt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputOrt.setColumns(10);

		// Buttons

		okButton = new JButton("OK");
		okButton.setBounds(134, 156, 81, 25);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(225, 156, 81, 25);

		// hinzufügen von Komponenten und Layout

		contentPanel.setLayout(null);
		contentPanel.add(okButton);
		contentPanel.add(cancelButton);
		contentPanel.add(fieldPanel);

		fieldPanel.setLayout(null);
		fieldPanel.add(inputDatum);
		fieldPanel.add(inputVeranstalter);
		fieldPanel.add(inputName);
		fieldPanel.add(inputOrt);
		fieldPanel.add(inputPLZ);
	}

}
