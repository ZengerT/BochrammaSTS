package hmi;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TitleImage extends JPanel {

	private static final long serialVersionUID = 1L;

	private ImageIcon icon;
	private Image image;
	private JLabel imgLabel;
	private String src;

	// Getter&Setter

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public JLabel getImgLabel() {
		return imgLabel;
	}

	public void setImgLabel(JLabel imgLabel) {
		this.imgLabel = imgLabel;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	// Konstruktor

	public TitleImage() {
		src = "/img/def.png";
		setTitleImg(src);

	}

	// Methode

	public void setTitleImg(String uri) {

		try {
			image = ImageIO.read(getClass().getResource(uri));
			icon = new ImageIcon(image);
			imgLabel = new JLabel(icon);
			imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
			imgLabel.setVerticalAlignment(SwingConstants.CENTER);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
