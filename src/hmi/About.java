package hmi;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class About extends JDialog {

	private static final long serialVersionUID = -5651385238323511361L;

	private final JPanel contentPanel = new JPanel();

	private Image aboutImg;
	private JLabel aboutImgLbl;
	private ImageIcon aboutIcon;

	public About(JFrame main) {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setTitle("Über BochrammaSTS");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 448, 275);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		// Text

		JLabel nameLbl = new JLabel("Bochramma - Schafkopf Turnier Software");
		nameLbl.setBounds(12, 12, 300, 15);
		contentPanel.add(nameLbl);

		JLabel descripLbl = new JLabel("Version:");
		descripLbl.setBounds(12, 39, 70, 15);
		contentPanel.add(descripLbl);

		JLabel versionLbl = new JLabel("0.50dev");
		versionLbl.setBounds(111, 39, 70, 15);
		contentPanel.add(versionLbl);

		JLabel devLbl = new JLabel("Thomas Zenger 2015");
		devLbl.setBounds(47, 66, 150, 15);
		contentPanel.add(devLbl);

		JLabel contactLbl = new JLabel("t.zenger@mail.de");
		contactLbl.setBounds(47, 93, 150, 15);
		contentPanel.add(contactLbl);

		JLabel cLbl = new JLabel("(c)");
		cLbl.setBounds(12, 66, 20, 15);
		contentPanel.add(cLbl);

		// Image
		aboutImgLbl = new JLabel();
		aboutImgLbl.setBounds(216, 39, 220, 220);
		aboutIcon = new ImageIcon();

		try {
			aboutImg = ImageIO.read(getClass().getResource("/img/def.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		aboutIcon.setImage(aboutImg);
		aboutImgLbl.setIcon(aboutIcon);
		contentPanel.add(aboutImgLbl);

		this.setVisible(true);
	}
}
