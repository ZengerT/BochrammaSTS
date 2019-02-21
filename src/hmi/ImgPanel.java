package hmi;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class ImgPanel extends JPanel {

	private static final long serialVersionUID = 2L;

	private Image img;
	private JLabel imgLbl;
	private ImageIcon icon;

	// Getter&Setter

	public JLabel getImgLbl() {
		return imgLbl;
	}

	public void setImgLbl(JLabel imgLbl) {
		this.imgLbl = imgLbl;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public void getImg() {
		// TODO Auto-generated method stub

	}

	// Method

	public void setImage(String src) {

		imgLbl.setIcon(null);
		try {

			img = ImageIO.read(getClass().getResource(src));

		} catch (IllegalArgumentException i) {
			try {

				img = ImageIO.read(new File(src));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

		icon.setImage(img);

		if (icon.getIconHeight() > 220 || icon.getIconWidth() > 220) {
			icon.setImage(icon.getImage().getScaledInstance(200, -1,
					Image.SCALE_DEFAULT));

		}
		imgLbl.setIcon(icon);
		imgLbl.setHorizontalAlignment(SwingConstants.CENTER);

	}

	// Konstruktor

	public ImgPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		String init = "/img/def.png";

		imgLbl = new JLabel();
		icon = new ImageIcon();
		setImage(init);

		this.add(imgLbl, SwingConstants.CENTER);

	}

}
