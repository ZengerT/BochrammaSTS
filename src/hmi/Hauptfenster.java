package hmi;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

import tableModels.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.border.TitledBorder;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import javax.swing.JSeparator;

import java.awt.Dimension;
import java.awt.Cursor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class IntegerComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if( o1 < o2 )
            return -1;
        else if( o1 > o2 )
            return 1;
        else
            return 0;
	}

	@Override
	public Comparator<Integer> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Integer> thenComparing(Comparator<? super Integer> other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> Comparator<Integer> thenComparing(
			Function<? super Integer, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U extends Comparable<? super U>> Comparator<Integer> thenComparing(
			Function<? super Integer, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Integer> thenComparingInt(
			ToIntFunction<? super Integer> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Integer> thenComparingLong(
			ToLongFunction<? super Integer> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Integer> thenComparingDouble(
			ToDoubleFunction<? super Integer> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static <T> Comparator<T> comparingInt(
			ToIntFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static <T> Comparator<T> comparingLong(
			ToLongFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


public class Hauptfenster {

	public JFrame frmBochrammaSchafkopf;
	private JTable spielerTable;
	private JTable ergebnisTable;
	private JTable runde1Table;
	private JTable runde2Table;
	private JButton runde1Btn;
	private JButton runde2Btn;
	private JButton spielerAnlegenBtn;
	private JButton speichernBtn;
	private JButton ladenBtn;
	private JButton exportBtn;
	private JButton editBtn;

	private JMenuItem mntmTurnierErstellen;
	private JMenuItem mntmberBochrammasts;

	private JLabel lblOrt;
	private JLabel lblVeranstalter;
	private JLabel lblDatum;
	private JLabel lblTurniername;

	private static ModelSpielerListe modelSpielerListe = new ModelSpielerListe();
	private static ModelRunde1 modelRunde1 = new ModelRunde1();
	private static ModelRunde2 modelRunde2 = new ModelRunde2();
	private static ModelErgebnis modelErgebnis = new ModelErgebnis();

	private TableRowSorter<ModelSpielerListe> spielerListeSort;
	private TableRowSorter<ModelRunde1> runde1Sort;
	private TableRowSorter<ModelRunde2> runde2Sort;
	private TableRowSorter<ModelErgebnis> ergebnisSort;

	private ImgPanel imgPanel;
	private JPanel statsPanel;
	private JLabel lblSpieler;
	private JLabel lblInsgesamtPlus;
	private JLabel lblInsgesamtMinus;
	private JLabel lblSoli;
	private JLabel lblMidl;
	private JLabel lblPlusMidl;
	private JLabel lblMinusMidl;
	private JLabel lblSpielerVal;
	private JLabel lblInsgesamtPlusVal;
	private JLabel lblInsgesamtMinusVal;
	private JLabel lblSoliVal;
	private JLabel lblMidlVal;
	private JLabel lblPlusMidlVal;
	private JLabel lblMinusMidlVal;

	// getter und setter

	public JLabel getLblSpielerVal() {
		return lblSpielerVal;
	}

	public void setLblSpielerVal(JLabel lblSpielerVal) {
		this.lblSpielerVal = lblSpielerVal;
	}

	public JLabel getLblInsgesamtPlusVal() {
		return lblInsgesamtPlusVal;
	}

	public void setLblInsgesamtPlusVal(JLabel lblInsgesamtPlusVal) {
		this.lblInsgesamtPlusVal = lblInsgesamtPlusVal;
	}

	public JLabel getLblInsgesamtMinusVal() {
		return lblInsgesamtMinusVal;
	}

	public void setLblInsgesamtMinusVal(JLabel lblInsgesamtMinusVal) {
		this.lblInsgesamtMinusVal = lblInsgesamtMinusVal;
	}

	public JLabel getLblSoliVal() {
		return lblSoliVal;
	}

	public void setLblSoliVal(JLabel lblSoliVal) {
		this.lblSoliVal = lblSoliVal;
	}

	public JLabel getLblMidlVal() {
		return lblMidlVal;
	}

	public void setLblMidlVal(JLabel lblMidlVal) {
		this.lblMidlVal = lblMidlVal;
	}

	public JLabel getLblPlusMidlVal() {
		return lblPlusMidlVal;
	}

	public void setLblPlusMidlVal(JLabel lblPlusMidlVal) {
		this.lblPlusMidlVal = lblPlusMidlVal;
	}

	public JLabel getLblMinusMidlVal() {
		return lblMinusMidlVal;
	}

	public void setLblMinusMidlVal(JLabel lblMinusMidlVal) {
		this.lblMinusMidlVal = lblMinusMidlVal;
	}

	public ImgPanel getImgPanel() {
		return imgPanel;
	}

	public JButton getEditBtn() {
		return editBtn;
	}

	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
	}

	public JTable getSpielerTable() {
		return spielerTable;
	}

	public JButton getExportBtn() {
		return exportBtn;
	}

	public JButton getRunde1Btn() {
		return runde1Btn;
	}

	public void setRunde1Btn(JButton runde1Btn) {
		this.runde1Btn = runde1Btn;
	}

	public JButton getRunde2Btn() {
		return runde2Btn;
	}

	public void setRunde2Btn(JButton runde2Btn) {
		this.runde2Btn = runde2Btn;
	}

	public JButton getSpielerAnlegenBtn() {
		return spielerAnlegenBtn;
	}

	public void setSpielerAnlegenBtn(JButton spielerAnlegenBtn) {
		this.spielerAnlegenBtn = spielerAnlegenBtn;
	}

	public JButton getSpeichernBtn() {
		return speichernBtn;
	}

	public void setSpeichernBtn(JButton speichernBtn) {
		this.speichernBtn = speichernBtn;
	}

	public JTable getErgebnisTable() {
		return ergebnisTable;
	}

	public JTable getRunde1Table() {
		return runde1Table;
	}

	public JTable getRunde2Table() {
		return runde2Table;
	}

	public ModelSpielerListe getModelSpielerListe() {
		return modelSpielerListe;
	}

	public ModelRunde1 getModelRunde1() {
		return modelRunde1;
	}

	public ModelRunde2 getModelRunde2() {
		return modelRunde2;
	}

	public ModelErgebnis getModelErgebnis() {
		return modelErgebnis;
	}

	/*
	 * public void setModelRunde1(ModelRunde1 modelRunde1) { this.modelRunde1 =
	 * modelRunde1; }
	 * 
	 * public void setModelSpielerListe(ModelSpielerListe modelSpielerListe) {
	 * this.modelSpielerListe = modelSpielerListe; }
	 * 
	 * public void setModelRunde2(ModelRunde2 modelRunde2) { this.modelRunde2 =
	 * modelRunde2; }
	 * 
	 * public void setModelErgebnis(ModelErgebnis modelErgebnis) {
	 * this.modelErgebnis = modelErgebnis; }
	 */

	public void setSpielerTable(JTable spielerTable) {
		this.spielerTable = spielerTable;
	}

	public void setErgebnisTable(JTable ergebnisTable) {
		this.ergebnisTable = ergebnisTable;
	}

	public void setRunde1Table(JTable runde1Table) {
		this.runde1Table = runde1Table;
	}

	public void setRunde2Table(JTable runde2Table) {
		this.runde2Table = runde2Table;
	}

	public void setRunde1(JButton punkteEintragen) {
		this.runde1Btn = punkteEintragen;
	}

	public void setRunde2(JButton punkteEintragen) {
		this.runde2Btn = punkteEintragen;
	}

	public void setLblOrt(String ort) {
		this.lblOrt.setText(ort);
	}

	public void setLblVeranstalter(String veranstalter) {
		this.lblVeranstalter.setText(veranstalter);
	}

	public void setLblDatum(String datum) {
		this.lblDatum.setText(datum);
	}

	public void setLblTurniername(String tuniername) {
		this.lblTurniername.setText(tuniername);
	}

	public void setImageListener(MouseListener ml) {
		this.imgPanel.addMouseListener(ml);
	}

	public void setSpielerAnlegenListener(ActionListener a1) {
		this.spielerAnlegenBtn.addActionListener(a1);
	}

	public void setAboutListener(ActionListener al) {
		this.mntmberBochrammasts.addActionListener(al);
	}

	public void setTurnierErstellenListener(ActionListener al) {
		this.mntmTurnierErstellen.addActionListener(al);
	}

	public void setSpielerBearbeitenListener(ActionListener al) {
		this.mntmTurnierErstellen.addActionListener(al);
	}

	public void setRunde1Listener(ActionListener al) {
		this.runde1Btn.addActionListener(al);
	}

	public void setRunde2Listener(ActionListener al) {
		this.runde2Btn.addActionListener(al);
	}

	// Methoden

	public void setTurnierSpeichernListener(ActionListener al) {
		this.speichernBtn.addActionListener(al);
	}

	public void setTurnierLadenListener(ActionListener al) {
		this.ladenBtn.addActionListener(al);
	}

	// Konstruktor und Methoden

	public Hauptfenster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// frame

		frmBochrammaSchafkopf = new JFrame();
		frmBochrammaSchafkopf.setTitle("BochrammaSTS");
		frmBochrammaSchafkopf.setBounds(100, 100, 1280, 720);
		frmBochrammaSchafkopf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// icon

		Image icon;
		try {
			icon = ImageIO.read(getClass().getResource("/img/icon.gif"));
			frmBochrammaSchafkopf.setIconImage(icon);
		} catch (IOException e) {
		}

		// panels

		JPanel tablePanel = new JPanel();
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablePanel.setBackground(Color.WHITE);

		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new TitledBorder(null, "Turnierinformationen",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		infoPanel.setBackground(UIManager.getColor("Button.background"));

		imgPanel = new ImgPanel();
		imgPanel.setToolTipText("Rechtsklick zum ändern");

		// Toolbar

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(new Rectangle(0, 0, 0, 46));
		toolBar.setAlignmentX(0.0f);

		// layout

		GroupLayout groupLayout = new GroupLayout(
				frmBochrammaSchafkopf.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(tablePanel,
												GroupLayout.DEFAULT_SIZE, 1024,
												Short.MAX_VALUE)
										.addGap(10)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																imgPanel,
																GroupLayout.PREFERRED_SIZE,
																220,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				infoPanel,
																				GroupLayout.PREFERRED_SIZE,
																				200,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(10)))
										.addContainerGap())
						.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1278,
								Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addComponent(toolBar,
												GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				imgPanel,
																				GroupLayout.PREFERRED_SIZE,
																				220,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(20)
																		.addComponent(
																				infoPanel,
																				GroupLayout.PREFERRED_SIZE,
																				125,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																tablePanel,
																GroupLayout.DEFAULT_SIZE,
																618,
																Short.MAX_VALUE))
										.addGap(10)));

		// Toolbar Schaltflächen
		toolBar.addSeparator(new Dimension(10, 0));
		spielerAnlegenBtn = new JButton();
		spielerAnlegenBtn.setBorderPainted(false);
		spielerAnlegenBtn.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		spielerAnlegenBtn.setOpaque(false);
		toolBar.add(spielerAnlegenBtn);
		spielerAnlegenBtn.setFocusPainted(false);
		spielerAnlegenBtn.setBorder(null);
		spielerAnlegenBtn.setHorizontalAlignment(SwingConstants.LEFT);
		spielerAnlegenBtn.setIcon(new ImageIcon(Hauptfenster.class
				.getResource("/icon/anlegenBtn.gif")));
		spielerAnlegenBtn.setToolTipText("Spieler anlegen");
		spielerAnlegenBtn.setAlignmentY(5.0f);
		spielerAnlegenBtn.setAlignmentX(5.0f);

		editBtn = new JButton();
		editBtn.setBorderPainted(false);
		editBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editBtn.setOpaque(false);
		toolBar.add(editBtn);
		editBtn.setFocusPainted(false);
		editBtn.setIcon(new ImageIcon(Hauptfenster.class
				.getResource("/icon/editBtn.gif")));
		editBtn.setToolTipText("Spieler bearbeiten");
		editBtn.setBorder(null);
		editBtn.setHorizontalAlignment(SwingConstants.LEFT);
		editBtn.setAlignmentY(5.0f);
		editBtn.setAlignmentX(5.0f);

		toolBar.addSeparator(new Dimension(10, 0));
		JSeparator separator = new JSeparator();
		separator.setMaximumSize(new Dimension(10, 32767));
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);

		speichernBtn = new JButton();
		speichernBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		speichernBtn.setOpaque(false);
		toolBar.add(speichernBtn);
		speichernBtn.setBorderPainted(false);
		speichernBtn.setFocusPainted(false);
		speichernBtn.setBorder(null);
		speichernBtn.setToolTipText("Speichern");
		speichernBtn.setIcon(new ImageIcon(Hauptfenster.class
				.getResource("/icon/sichernBtn.gif")));
		speichernBtn.setHorizontalAlignment(SwingConstants.LEFT);
		speichernBtn.setAlignmentY(5.0f);
		speichernBtn.setAlignmentX(5.0f);

		ladenBtn = new JButton();
		ladenBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ladenBtn.setOpaque(false);
		toolBar.add(ladenBtn);
		ladenBtn.setBorderPainted(false);
		ladenBtn.setFocusPainted(false);
		ladenBtn.setBorder(null);
		ladenBtn.setToolTipText("Laden");
		ladenBtn.setIcon(new ImageIcon(Hauptfenster.class
				.getResource("/icon/ladenBtn.gif")));
		ladenBtn.setHorizontalAlignment(SwingConstants.LEFT);
		ladenBtn.setAlignmentY(5.0f);
		ladenBtn.setAlignmentX(5.0f);

		toolBar.addSeparator(new Dimension(10, 0));
		JSeparator separator2 = new JSeparator();
		separator2.setMaximumSize(new Dimension(10, 32767));
		separator2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator2);

		runde1Btn = new JButton();
		runde1Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		runde1Btn.setOpaque(false);
		toolBar.add(runde1Btn);
		runde1Btn.setBorderPainted(false);
		runde1Btn.setFocusPainted(false);
		runde1Btn.setBorder(null);
		runde1Btn.setToolTipText("Runde 1");
		runde1Btn.setIcon(new ImageIcon(Hauptfenster.class
				.getResource("/icon/rundeBtn1.gif")));
		runde1Btn.setHorizontalAlignment(SwingConstants.LEFT);
		runde1Btn.setAlignmentY(5.0f);
		runde1Btn.setAlignmentX(5.0f);

		runde2Btn = new JButton();
		runde2Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		runde2Btn.setOpaque(false);
		toolBar.add(runde2Btn);
		runde2Btn.setBorderPainted(false);
		runde2Btn.setFocusPainted(false);
		runde2Btn.setBorder(null);
		runde2Btn.setToolTipText("Runde 2");
		runde2Btn.setIcon(new ImageIcon(Hauptfenster.class
				.getResource("/icon/rundeBtn2.gif")));
		runde2Btn.setHorizontalAlignment(SwingConstants.LEFT);
		runde2Btn.setAlignmentY(5.0f);
		runde2Btn.setAlignmentX(5.0f);

		toolBar.addSeparator(new Dimension(10, 0));

		JSeparator separator3 = new JSeparator();
		separator3.setMaximumSize(new Dimension(10, 32767));
		separator3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator3);

		exportBtn = new JButton();
		exportBtn.setOpaque(false);
		toolBar.add(exportBtn);
		exportBtn.setBorderPainted(false);
		exportBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportBtn.setFocusPainted(false);
		exportBtn.setBorder(null);
		exportBtn.setToolTipText("PDF Export");
		exportBtn.setIcon(new ImageIcon(Hauptfenster.class
				.getResource("/icon/pdfBtn.png")));
		exportBtn.setHorizontalAlignment(SwingConstants.LEFT);
		exportBtn.setAlignmentY(5.0f);
		exportBtn.setAlignmentX(5.0f);

		toolBar.setFloatable(false);

		// Tabellen

		DefaultTableCellRenderer renderer = new CenterCellRenderer();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JScrollPane scrollPane1 = new JScrollPane();
		JScrollPane scrollPane2 = new JScrollPane();
		JScrollPane scrollPane3 = new JScrollPane();
		JScrollPane scrollPane4 = new JScrollPane();

		tabbedPane.addTab("Spielerliste", null, scrollPane1, null);
		tabbedPane.addTab("Runde 1", null, scrollPane2, null);
		tabbedPane.addTab("Runde 2", null, scrollPane3, null);
		tabbedPane.addTab("Ergebnis", null, scrollPane4, null);

		// Spielertabelle

		spielerTable = new JTable(modelSpielerListe);
		scrollPane1.setViewportView(spielerTable);
		spielerListeSort = new TableRowSorter<ModelSpielerListe>();
		spielerTable.setRowSorter(spielerListeSort);
		spielerListeSort.setModel(modelSpielerListe);
		spielerTable.setDefaultRenderer(Integer.class, renderer);

		// Punktetabelle Runde 1

		runde1Table = new JTable(modelRunde1);
		scrollPane2.setViewportView(runde1Table);
		runde1Sort = new TableRowSorter<ModelRunde1>();
		runde1Table.setRowSorter(runde1Sort);
		runde1Sort.setModel(modelRunde1);
		runde1Table.setDefaultRenderer(Integer.class, renderer);

		// Punktetabelle Runde 2

		runde2Table = new JTable(modelRunde2);
		scrollPane3.setViewportView(runde2Table);
		runde2Sort = new TableRowSorter<ModelRunde2>();
		runde2Table.setRowSorter(runde2Sort);
		runde2Sort.setModel(modelRunde2);
		runde2Table.setDefaultRenderer(Integer.class, renderer);

		// Ergebnistabelle

		ergebnisTable = new JTable(modelErgebnis);
		scrollPane4.setViewportView(ergebnisTable);
		ergebnisSort = new TableRowSorter<ModelErgebnis>();
		ergebnisSort.setModel(modelErgebnis);
		ergebnisTable.setRowSorter(ergebnisSort);
		List <RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		sortKeys.add(new RowSorter.SortKey(5, SortOrder.DESCENDING));
		sortKeys.add(new RowSorter.SortKey(6, SortOrder.DESCENDING));
		ergebnisSort.setSortKeys(sortKeys);
		
		ergebnisTable.setDefaultRenderer(Integer.class, renderer);

		GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
		gl_tablePanel.setHorizontalGroup(gl_tablePanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_tablePanel
						.createSequentialGroup()
						.addGap(10)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								976, Short.MAX_VALUE).addGap(10)));
		gl_tablePanel.setVerticalGroup(gl_tablePanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_tablePanel
						.createSequentialGroup()
						.addGap(10)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								619, Short.MAX_VALUE).addGap(10)));

		statsPanel = new JPanel();
		tabbedPane.addTab("Statistik", null, statsPanel, null);

		lblSpieler = new JLabel("Anzahl Spieler");

		lblSpielerVal = new JLabel("");

		lblInsgesamtPlus = new JLabel("Pluspunkte insgesamt");

		lblInsgesamtPlusVal = new JLabel("");

		lblInsgesamtMinus = new JLabel("Minuspunkte insgesamt");

		lblInsgesamtMinusVal = new JLabel("");

		lblSoli = new JLabel("Soli insgesamt");

		lblSoliVal = new JLabel("");

		lblMidl = new JLabel("Punkte (Durchschnitt)");

		lblMidlVal = new JLabel("");

		lblPlusMidl = new JLabel("Pluspunkte (Durchschitt)");

		lblPlusMidlVal = new JLabel("");

		lblMinusMidl = new JLabel("Minuspunkte (Durchschnitt)");

		lblMinusMidlVal = new JLabel("");
		GroupLayout gl_statsPanel = new GroupLayout(statsPanel);
		gl_statsPanel
				.setHorizontalGroup(gl_statsPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_statsPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblSpieler,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblInsgesamtPlus,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblInsgesamtMinus,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblSoli,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMidl,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPlusMidl,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMinusMidl,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE))
										.addGap(50)
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblMinusMidlVal,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPlusMidlVal,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMidlVal,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblSoliVal,
																GroupLayout.PREFERRED_SIZE,
																250,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_statsPanel
																		.createParallelGroup(
																				Alignment.TRAILING)
																		.addComponent(
																				lblInsgesamtPlusVal,
																				GroupLayout.PREFERRED_SIZE,
																				250,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblSpielerVal,
																				GroupLayout.PREFERRED_SIZE,
																				250,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblInsgesamtMinusVal,
																				GroupLayout.PREFERRED_SIZE,
																				250,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(418, Short.MAX_VALUE)));
		gl_statsPanel
				.setVerticalGroup(gl_statsPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_statsPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblSpieler,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblSpielerVal,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblInsgesamtPlus,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblInsgesamtPlusVal,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblInsgesamtMinus,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblInsgesamtMinusVal,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblSoli,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblSoliVal,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblMidl,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMidlVal,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblPlusMidl,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPlusMidlVal,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_statsPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblMinusMidl,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMinusMidlVal,
																GroupLayout.PREFERRED_SIZE,
																35,
																GroupLayout.PREFERRED_SIZE))));
		statsPanel.setLayout(gl_statsPanel);

		tablePanel.setLayout(gl_tablePanel);

		// Label des Infopanels

		lblOrt = new JLabel("Ort");
		lblOrt.setBounds(12, 100, 170, 15);
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblVeranstalter = new JLabel("Veranstalter");
		lblVeranstalter.setBounds(12, 50, 170, 15);
		lblVeranstalter.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblDatum = new JLabel("Datum");
		lblDatum.setBounds(12, 75, 170, 15);
		lblDatum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.setLayout(null);

		lblTurniername = new JLabel("Turniername");
		lblTurniername.setBounds(12, 25, 170, 15);
		lblTurniername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoPanel.add(lblTurniername);
		infoPanel.add(lblVeranstalter);
		infoPanel.add(lblDatum);
		infoPanel.add(lblOrt);

		frmBochrammaSchafkopf.getContentPane().setLayout(groupLayout);

		// menubar

		JMenuBar menuBar = new JMenuBar();
		frmBochrammaSchafkopf.setJMenuBar(menuBar);

		JMenu mnMen = new JMenu("Men\u00FC");
		menuBar.add(mnMen);

		mntmTurnierErstellen = new JMenuItem("Turnier erstellen");
		mnMen.add(mntmTurnierErstellen);

		JMenu menu = new JMenu("?");
		menuBar.add(menu);

		mntmberBochrammasts = new JMenuItem("\u00FCber BochrammaSTS");
		menu.add(mntmberBochrammasts);

	}
}
