package tableModels;

import java.util.ArrayList;
import java.util.List;
import code.Spieler;
import javax.swing.table.AbstractTableModel;

public class ModelRunde1 extends AbstractTableModel {

	private static final long serialVersionUID = 1124157892677952434L;
	private List<String> columnNames;
	private List<Spieler> listeRunde1;

	public ModelRunde1() {
		columnNames = new ArrayList<String>();
		columnNames.add("Startnummer");
		columnNames.add("Nachname");
		columnNames.add("Plus-Punkte");
		columnNames.add("Minus-Punkte");
		columnNames.add("Gesamtpunkte");
		columnNames.add("Tischnummer");

		this.listeRunde1 = new ArrayList<Spieler>();
	}

	public ModelRunde1(List<Spieler> daten) {
		columnNames = new ArrayList<String>();
		columnNames.add("Startnummer");
		columnNames.add("Nachname");
		columnNames.add("Plus-Punkte");
		columnNames.add("Minus-Punkte");
		columnNames.add("Gesamtpunkte");
		columnNames.add("Tischnummer");

		this.listeRunde1 = new ArrayList<Spieler>();

		for (Spieler spieler : daten) {
			listeRunde1.add(spieler);
		}
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeRunde1.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		  if (listeRunde1.isEmpty()) {
		        return Object.class;
		    }
		return getValueAt(0, columnIndex).getClass();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		Spieler daten = listeRunde1.get(rowIndex);

		if (daten != null) {
			switch (columnIndex) {
			case 0:
				return daten.getNummer();
			case 1:
				return daten.getNachname();
			case 2:
				return daten.getRundeP(0);
			case 3:
				return daten.getRundeM(0);
			case 4:
				return daten.getRunde(0);
			case 5:
				return daten.getTischnummer(0);
			}
		}
		return null;
	}

	public String getColumnName(int columIndex) {
		return columnNames.get(columIndex);
	}

	public void datenLoeschen() {
		listeRunde1.clear();
	}

	public void addData(List<Spieler> list) {
		for (Spieler spieler : list) {
			listeRunde1.add(spieler);
		}
		fireTableStructureChanged();
	}

}
