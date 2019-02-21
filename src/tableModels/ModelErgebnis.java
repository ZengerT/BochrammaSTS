package tableModels;

import java.util.ArrayList;
import java.util.List;
import code.Spieler;
import javax.swing.table.AbstractTableModel;

public class ModelErgebnis extends AbstractTableModel {

	private static final long serialVersionUID = 1124157892677952434L;

	private List<String> columnNames;
	private List<Spieler> listeErgebnis;

	public ModelErgebnis() {
		columnNames = new ArrayList<String>();
		columnNames.add("Startnummer");
		columnNames.add("Nachname");
		columnNames.add("Vorname");
		columnNames.add("Punkte Plus");
		columnNames.add("Punkte Minus");
		columnNames.add("Gesamtpunkte");
		columnNames.add("Soli");

		this.listeErgebnis = new ArrayList<Spieler>();

	}

	public ModelErgebnis(List<Spieler> daten) {
		columnNames = new ArrayList<String>();
		columnNames.add("Startnummer");
		columnNames.add("Nachname");
		columnNames.add("Vorname");
		columnNames.add("Punkte Runde 1");
		columnNames.add("Punkte Runde 2");
		columnNames.add("Gesamtpunkte");
		columnNames.add("Soli");

		this.listeErgebnis = new ArrayList<Spieler>();

		for (Spieler spieler : daten) {
			listeErgebnis.add(spieler);
		}
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeErgebnis.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (listeErgebnis.isEmpty()) {
			return Object.class;
		}
		return getValueAt(0, columnIndex).getClass();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		Spieler daten = listeErgebnis.get(rowIndex);

		if (daten != null) {
			switch (columnIndex) {
			case 0:
				return daten.getNummer();
			case 1:
				return daten.getNachname();
			case 2:
				return daten.getVorname();
			case 3:
				return daten.getGesamtP();
			case 4:
				return daten.getGesamtM();
			case 5:
				return daten.getGesamtP()-daten.getGesamtM();
			case 6:
				return daten.getSoli();
			}
		}
		return null;
	}

	public String getColumnName(int columIndex) {
		return columnNames.get(columIndex);
	}

	public void datenLoeschen() {
		listeErgebnis.clear();
	}

	public void addData(List<Spieler> list) {
		for (Spieler spieler : list) {
			listeErgebnis.add(spieler);
		}
		fireTableStructureChanged();
	}

}
