package tableModels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import code.Spieler;

public class ModelSpielerListe extends AbstractTableModel {

	private static final long serialVersionUID = 1124157892737952434L;

	private List<String> columnNames;
	private List<Spieler> listeSpieler;

	public ModelSpielerListe() {
		columnNames = new ArrayList<String>();
		columnNames.add("Startnummer");
		columnNames.add("Nachname");
		columnNames.add("Vorname");
		columnNames.add("Adresse");
		columnNames.add("PLZ");
		columnNames.add("Ort");
		columnNames.add("E-Mail");

		this.listeSpieler = new ArrayList<Spieler>();

	}

	public ModelSpielerListe(List<Spieler> daten) {
		columnNames = new ArrayList<String>();
		columnNames.add("Startnummer");
		columnNames.add("Nachname");
		columnNames.add("Vorname");
		columnNames.add("Adresse");
		columnNames.add("PLZ");
		columnNames.add("Ort");
		columnNames.add("E-Mail");

		this.listeSpieler = new ArrayList<Spieler>();

		for (Spieler spieler : daten) {
			listeSpieler.add(spieler);
		}
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeSpieler.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		Spieler daten = listeSpieler.get(rowIndex);

		if (daten != null) {
			switch (columnIndex) {
			case 0:
				return daten.getNummer();
			case 1:
				return daten.getNachname();
			case 2:
				return daten.getVorname();
			case 3:
				return daten.getAdresse();
			case 4:
				return daten.getPlz();
			case 5:
				return daten.getOrt();
			case 6:
				return daten.getEmail();
			}
		}
		return null;
	}

	public String getColumnName(int columIndex) {
		return columnNames.get(columIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		  if (listeSpieler.isEmpty()) {
		        return Object.class;
		    }
		return getValueAt(0, columnIndex).getClass();
	}
	
	public void datenLoeschen() {
		listeSpieler.clear();
	}

	public void addData(List<Spieler> list) {
		for (Spieler spieler : list) {
			listeSpieler.add(spieler);
		}
		fireTableStructureChanged();
	}

}
