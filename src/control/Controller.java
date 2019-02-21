package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import xml.ParseXML;
import xml.WriteXML;
import code.Spieler;
import code.Stats;
import code.Turnier;
import hmi.About;
import hmi.Hauptfenster;

public class Controller {

	private Turnier currentTurnier;

	private Hauptfenster currentWindow;

	private Stats currentStats;

	// Konstruktor

	public Controller() {

		this.currentWindow = new Hauptfenster();
		this.currentTurnier = new Turnier();
		this.currentStats = new Stats();
		this.currentTurnier.setTurniername("default");
		addListener();
		actionDisable();
		this.currentWindow.frmBochrammaSchafkopf.setVisible(true);

	}

	// Getter&Setter

	public Turnier getCurrentTurnier() {
		return currentTurnier;
	}

	public Stats getCurrentStats() {
		return currentStats;
	}

	public void setCurrentStats(Stats currentStats) {
		this.currentStats = currentStats;
	}

	public void setCurrentWindow(Hauptfenster currentWindow) {
		this.currentWindow = currentWindow;
	}

	public void setCurrentTurnier(Turnier currentTurnier) {
		this.currentTurnier = currentTurnier;

	}

	public Hauptfenster getCurrentWindow() {
		return currentWindow;
	}

	// Methoden

	public void updateStats() {
		currentStats.calStats(currentTurnier);

		currentWindow.getLblInsgesamtMinusVal().setText(
				String.valueOf(currentStats.getInsgesamtMinusVal()));
		currentWindow.getLblInsgesamtPlusVal().setText(
				String.valueOf(currentStats.getInsgesamtPlusVal()));
		currentWindow.getLblMidlVal().setText(
				String.valueOf(currentStats.getMidlVal()));
		currentWindow.getLblMinusMidlVal().setText(
				String.valueOf(currentStats.getMinusMidlVal()));
		currentWindow.getLblPlusMidlVal().setText(
				String.valueOf(currentStats.getPlusMidlVal()));
		currentWindow.getLblSoliVal().setText(
				String.valueOf(currentStats.getSoliVal()));
		currentWindow.getLblSpielerVal().setText(
				String.valueOf(currentStats.getSpielerVal()));
	}

	public Spieler search(int startnummer) {
		int index = startnummer - 1;
		Spieler searched = currentTurnier.getTurnierlisteSpieler().get(index);
		return searched;
	}

	public void updateTurnierInfo(Turnier tun) {
		currentWindow.setLblTurniername(tun.getTurniername());
		currentWindow.setLblVeranstalter(tun.getVeranstalter());
		currentWindow.setLblDatum(tun.getDatum());
		currentWindow.setLblOrt(tun.getPlz() + " " + tun.getOrt());
	}

	public void createTurnier(String name, String veranst, String date,
			String ort, String plz) {
		currentTurnier.setTurniername(name);
		currentTurnier.setVeranstalter(veranst);
		currentTurnier.setDatum(date);
		currentTurnier.setOrt(ort);
		currentTurnier.setPlz(plz);
		currentWindow.setLblTurniername(name);
		currentWindow.setLblVeranstalter(veranst);
		currentWindow.setLblDatum(date);
		currentWindow.setLblOrt(plz + " " + ort);
	}

	public void updateSpielerListe(Spieler spieler) {
		currentTurnier.getTurnierlisteSpieler().add(spieler);
	}

	public void updatePunkte(int r, int a, int b, int c, int d, int[][] daten) {
		currentTurnier.getTurnierlisteSpieler().get(a)
				.setRundeP(r, daten[1][0]);
		currentTurnier.getTurnierlisteSpieler().get(a)
				.setRundeM(r, daten[2][0]);
		currentTurnier.getTurnierlisteSpieler().get(a).setRunde(r, daten[3][0]);
		currentTurnier.getTurnierlisteSpieler().get(a)
				.setTischnummer(r, daten[4][0]);
		currentTurnier.getTurnierlisteSpieler().get(a).setSolo(r, daten[0][0]);

		currentTurnier.getTurnierlisteSpieler().get(b)
				.setRundeP(r, daten[1][1]);
		currentTurnier.getTurnierlisteSpieler().get(b)
				.setRundeM(r, daten[2][1]);
		currentTurnier.getTurnierlisteSpieler().get(b).setRunde(r, daten[3][1]);
		currentTurnier.getTurnierlisteSpieler().get(b)
				.setTischnummer(r, daten[4][0]);
		currentTurnier.getTurnierlisteSpieler().get(b).setSolo(r, daten[0][1]);

		currentTurnier.getTurnierlisteSpieler().get(c)
				.setRundeP(r, daten[1][2]);
		currentTurnier.getTurnierlisteSpieler().get(c)
				.setRundeM(r, daten[2][2]);
		currentTurnier.getTurnierlisteSpieler().get(c).setRunde(r, daten[3][2]);
		currentTurnier.getTurnierlisteSpieler().get(c)
				.setTischnummer(r, daten[4][0]);
		currentTurnier.getTurnierlisteSpieler().get(c).setSolo(r, daten[0][2]);

		currentTurnier.getTurnierlisteSpieler().get(d)
				.setRundeP(r, daten[1][3]);
		currentTurnier.getTurnierlisteSpieler().get(d)
				.setRundeM(r, daten[2][3]);
		currentTurnier.getTurnierlisteSpieler().get(d).setRunde(r, daten[3][3]);
		currentTurnier.getTurnierlisteSpieler().get(d)
				.setTischnummer(r, daten[4][0]);
		currentTurnier.getTurnierlisteSpieler().get(d).setSolo(r, daten[0][3]);

		// Ergebnis berechnen Spieler 1

		currentTurnier
				.getTurnierlisteSpieler()
				.get(a)
				.setGesamtP(
						currentTurnier.getTurnierlisteSpieler().get(a)
								.getRundeP(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(a).getRundeP(1));
		currentTurnier
				.getTurnierlisteSpieler()
				.get(a)
				.setGesamtM(
						currentTurnier.getTurnierlisteSpieler().get(a)
								.getRundeM(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(a).getRundeM(1));
		currentTurnier
				.getTurnierlisteSpieler()
				.get(a)
				.setGesamt(
						currentTurnier.getTurnierlisteSpieler().get(a)
								.getGesamtP()
								- currentTurnier.getTurnierlisteSpieler()
										.get(a).getGesamtM());

		currentTurnier
				.getTurnierlisteSpieler()
				.get(a)
				.setSoli(
						currentTurnier.getTurnierlisteSpieler().get(a)
								.getSolo(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(a).getSolo(1));

		// Ergebnis berechnen Spieler 2

		currentTurnier
				.getTurnierlisteSpieler()
				.get(b)
				.setGesamtP(
						currentTurnier.getTurnierlisteSpieler().get(b)
								.getRundeP(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(b).getRundeP(1));
		currentTurnier
				.getTurnierlisteSpieler()
				.get(b)
				.setGesamtM(
						currentTurnier.getTurnierlisteSpieler().get(b)
								.getRundeM(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(b).getRundeM(1));

		currentTurnier
				.getTurnierlisteSpieler()
				.get(b)
				.setGesamt(
						currentTurnier.getTurnierlisteSpieler().get(b)
								.getGesamtP()
								- currentTurnier.getTurnierlisteSpieler()
										.get(b).getGesamtM());

		currentTurnier
				.getTurnierlisteSpieler()
				.get(b)
				.setSoli(
						currentTurnier.getTurnierlisteSpieler().get(b)
								.getSolo(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(b).getSolo(1));

		// Ergebnis berechnen Spieler 3

		currentTurnier
				.getTurnierlisteSpieler()
				.get(c)
				.setGesamtP(
						currentTurnier.getTurnierlisteSpieler().get(c)
								.getRundeP(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(c).getRundeP(1));
		currentTurnier
				.getTurnierlisteSpieler()
				.get(c)
				.setGesamtM(
						currentTurnier.getTurnierlisteSpieler().get(c)
								.getRundeM(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(c).getRundeM(1));

		currentTurnier
				.getTurnierlisteSpieler()
				.get(c)
				.setGesamt(
						currentTurnier.getTurnierlisteSpieler().get(c)
								.getGesamtP()
								- currentTurnier.getTurnierlisteSpieler()
										.get(c).getGesamtM());

		currentTurnier
				.getTurnierlisteSpieler()
				.get(c)
				.setSoli(
						currentTurnier.getTurnierlisteSpieler().get(c)
								.getSolo(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(c).getSolo(1));

		// Ergebnis berechnen Spieler 4

		currentTurnier
				.getTurnierlisteSpieler()
				.get(d)
				.setGesamtP(
						currentTurnier.getTurnierlisteSpieler().get(d)
								.getRundeP(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(d).getRundeP(1));
		currentTurnier
				.getTurnierlisteSpieler()
				.get(d)
				.setGesamtM(
						currentTurnier.getTurnierlisteSpieler().get(d)
								.getRundeM(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(d).getRundeM(1));

		currentTurnier
				.getTurnierlisteSpieler()
				.get(d)
				.setGesamt(
						currentTurnier.getTurnierlisteSpieler().get(d)
								.getGesamtP()
								- currentTurnier.getTurnierlisteSpieler()
										.get(d).getGesamtM());

		currentTurnier
				.getTurnierlisteSpieler()
				.get(d)
				.setSoli(
						currentTurnier.getTurnierlisteSpieler().get(d)
								.getSolo(0)
								+ currentTurnier.getTurnierlisteSpieler()
										.get(d).getSolo(1));

	}

	public void addListener() {
		this.currentWindow.setImageListener(new ImageChangeListener());
		this.currentWindow
				.setSpielerAnlegenListener(new SpielerAnlegenListener());
		this.currentWindow
				.setTurnierErstellenListener(new TurnierErstellenListener());
		this.currentWindow.setRunde1Listener(new Runde1Listener());
		this.currentWindow.setRunde2Listener(new Runde2Listener());
		this.currentWindow
				.setTurnierSpeichernListener(new TurnierSpeichernListener());
		this.currentWindow.setTurnierLadenListener(new TurnierLadenListener());
		this.currentWindow.setAboutListener(new AboutListener());
	}

	public void refresh() {

		currentWindow.getModelSpielerListe().datenLoeschen();
		currentWindow.getModelErgebnis().datenLoeschen();
		currentWindow.getModelRunde1().datenLoeschen();
		currentWindow.getModelRunde2().datenLoeschen();

		currentWindow.getModelSpielerListe().addData(
				currentTurnier.getTurnierlisteSpieler());
		currentWindow.getModelErgebnis().addData(
				currentTurnier.getTurnierlisteSpieler());
		currentWindow.getModelRunde1().addData(
				currentTurnier.getTurnierlisteSpieler());
		currentWindow.getModelRunde2().addData(
				currentTurnier.getTurnierlisteSpieler());
		updateStats();
	}

	public void actionDisable() {
		currentWindow.getSpielerAnlegenBtn().setEnabled(false);
		currentWindow.getEditBtn().setEnabled(false);
		currentWindow.getRunde1Btn().setEnabled(false);
		currentWindow.getRunde2Btn().setEnabled(false);
		currentWindow.getSpeichernBtn().setEnabled(false);
		currentWindow.getExportBtn().setEnabled(false);
	}

	public void actionEnable() {
		currentWindow.getSpielerAnlegenBtn().setEnabled(true);
		currentWindow.getEditBtn().setEnabled(true);
		currentWindow.getRunde1Btn().setEnabled(true);
		currentWindow.getRunde2Btn().setEnabled(true);
		currentWindow.getSpeichernBtn().setEnabled(true);
		currentWindow.getExportBtn().setEnabled(true);
	}

	// Listener

	class ImageChangeListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			if (e.getButton() == MouseEvent.BUTTON3) {

				JFileChooser choser = new JFileChooser();

				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Img Files", "png", "jpg", "gif", "bmp");
				choser.setFileFilter(filter);

				int returnVal = choser
						.showOpenDialog(currentWindow.frmBochrammaSchafkopf);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String s = choser.getSelectedFile().getAbsolutePath();

					currentWindow.getImgPanel().setImage(s);
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class TurnierErstellenListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				ControllerTurnierErstellen b = new ControllerTurnierErstellen(
						currentWindow.frmBochrammaSchafkopf);
				if (b.getName() != null) {
					createTurnier(b.getName(), b.getVeranstalter(),
							b.getDatum(), b.getOrt(), b.getPlz());
					actionEnable();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	class SpielerAnlegenListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				ControllerSpielerAnlegen creationDialog = new ControllerSpielerAnlegen(
						currentWindow.frmBochrammaSchafkopf);
				if (creationDialog.getNeu() != null) {
					updateSpielerListe(creationDialog.getNeu());
					refresh();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	class Runde1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				ControllerPunkteRnd1Eintragen entryDialog = new ControllerPunkteRnd1Eintragen(
						currentWindow.frmBochrammaSchafkopf);
				updatePunkte(0, entryDialog.getSpieler1(),
						entryDialog.getSpieler2(), entryDialog.getSpieler3(),
						entryDialog.getSpieler4(), entryDialog.getDaten());
				refresh();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	class Runde2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				ControllerPunkteRnd2Eintragen entryDialog = new ControllerPunkteRnd2Eintragen(
						currentWindow.frmBochrammaSchafkopf);
				updatePunkte(1, entryDialog.getSpieler1(),
						entryDialog.getSpieler2(), entryDialog.getSpieler3(),
						entryDialog.getSpieler4(), entryDialog.getDaten());
				refresh();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	class TurnierSpeichernListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser save = new JFileChooser();
			File file;
			save.setSelectedFile(new File(currentTurnier.getDatum() + " - "
					+ currentTurnier.getTurniername() + ".xml"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"XML Files", "xml");
			save.setFileFilter(filter);
			int returnVal = save
					.showSaveDialog(currentWindow.frmBochrammaSchafkopf);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = save.getSelectedFile();
				try {
					WriteXML b = new WriteXML();
					b.createXMLDocument(file, currentTurnier);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class AboutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			@SuppressWarnings("unused")
			About about = new About(currentWindow.frmBochrammaSchafkopf);
		}
	}

	class TurnierLadenListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser open = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"XML Files", "xml");
			open.setFileFilter(filter);
			int returnVal = open
					.showOpenDialog(currentWindow.frmBochrammaSchafkopf);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String s = open.getSelectedFile().getAbsolutePath();
				try {
					ParseXML b = new ParseXML();
					currentTurnier = b.readXML(s);
					updateTurnierInfo(currentTurnier);
					refresh();
					actionEnable();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}