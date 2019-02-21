package tableModels;

import java.util.ArrayList;
import java.util.List;
import code.Spieler;
import javax.swing.table.AbstractTableModel;

public class ModelRunde2 extends AbstractTableModel {

	private static final long serialVersionUID = 1124157892677952434L;
	private List<String> columnNames;
	private List<Spieler> listeRunde2;

	public ModelRunde2() {
		columnNames = new ArrayList<String>();
		columnNames.add("Startnummer");
		columnNames.add("Nachname");
		columnNames.add("Plus-Punkte");
		columnNames.add("Minus-Punkte");
		columnNames.add("Gesamtpunkte");
		columnNames.add("Tischnummer");

		this.listeRunde2 = new ArrayList<Spieler>();

	}

	public ModelRunde2(List<Spieler> daten) {
		columnNames = new ArrayList<String>();
		columnNames.add("Startnummer");
		columnNames.add("Nachname");
		columnNames.add("Plus-Punkte");
		columnNames.add("Minus-Punkte");
		columnNames.add("Gesamtpunkte");
		columnNames.add("Tischnummer");

		this.listeRunde2 = new ArrayList<Spieler>();

		for (Spieler spieler : daten) {
			listeRunde2.add(spieler);
		}
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeRunde2.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		  if (listeRunde2.isEmpty()) {
		        return Object.class;
		    }
		return getValueAt(0, columnIndex).getClass();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		Spieler daten = listeRunde2.get(rowIndex);

		if (daten != null) {
			switch (columnIndex) {
			case 0:
				return daten.getNummer();
			case 1:
				return daten.getNachname();
			case 2:
				return daten.getRundeP(1);
			case 3:
				return daten.getRundeM(1);
			case 4:
				return daten.getRunde(1);
			case 5:
				return daten.getTischnummer(1);
			}
		}
		return null;
	}

	public String getColumnName(int columIndex) {
		return columnNames.get(columIndex);
	}

	public void datenLoeschen() {
		listeRunde2.clear();
	}

	public void addData(List<Spieler> list) {
		for (Spieler spieler : list) {
			listeRunde2.add(spieler);
		}
		fireTableStructureChanged();
	}

}
