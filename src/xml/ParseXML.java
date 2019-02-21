package xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import code.Spieler;
import code.Turnier;

public class ParseXML {

	public ParseXML() {

	}

	public int stringParser(String s) {
		if (s != "") {
			int i = Integer.valueOf(s);
			return i;
		} else {
			return 0;
		}
	}

	public Turnier readXML(String fileName) {

		Turnier tun = new Turnier();

		try {
			File file = new File(fileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			// factory.setValidating(true):
			DocumentBuilder builder = factory.newDocumentBuilder();

			// EntityResolver setzen (einlesen DTD)

			/*
			 * builder.setEntityResolver(new EntityResolver(){
			 * 
			 * });
			 */

			// einlesen XML-Datei

			Document doc = builder.parse(file);

			Element turnier = doc.getDocumentElement();

			Element turniername = (Element) turnier.getElementsByTagName(
					"turniername").item(0);
			tun.setTurniername(turniername.getTextContent());

			Element veranstalter = (Element) turnier.getElementsByTagName(
					"veranstalter").item(0);
			tun.setVeranstalter(veranstalter.getTextContent());

			Element plz = (Element) turnier.getElementsByTagName("plz").item(0);
			tun.setPlz(plz.getTextContent());

			Element ort = (Element) turnier.getElementsByTagName("ort").item(0);
			tun.setOrt(ort.getTextContent());

			Element datum = (Element) turnier.getElementsByTagName("datum")
					.item(0);
			tun.setDatum(datum.getTextContent());

			NodeList nodeList = (NodeList) turnier
					.getElementsByTagName("spieler");

			if (nodeList != null && nodeList.getLength() > 0) {

				for (int i = 0; i < nodeList.getLength(); i++) {
					if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
						Element spieler = (Element) nodeList.item(i);

						Element vorname = (Element) spieler
								.getElementsByTagName("vorname").item(0);
						Element nachname = (Element) spieler
								.getElementsByTagName("nachname").item(0);
						Element adresseSP = (Element) spieler
								.getElementsByTagName("adresse").item(0);
						Element plzSP = (Element) spieler.getElementsByTagName(
								"plz").item(0);
						Element ortSP = (Element) spieler.getElementsByTagName(
								"ort").item(0);
						Element email = (Element) spieler.getElementsByTagName(
								"email").item(0);
						Element runde1P = (Element) spieler
								.getElementsByTagName("runde1P").item(0);
						Element runde1M = (Element) spieler
								.getElementsByTagName("runde1M").item(0);
						Element runde1 = (Element) spieler
								.getElementsByTagName("runde1").item(0);
						Element tischRunde1 = (Element) spieler
								.getElementsByTagName("tischRunde1").item(0);
						Element runde2P = (Element) spieler
								.getElementsByTagName("runde2P").item(0);
						Element runde2M = (Element) spieler
								.getElementsByTagName("runde2M").item(0);
						Element runde2 = (Element) spieler
								.getElementsByTagName("runde2").item(0);
						Element tischRunde2 = (Element) spieler
								.getElementsByTagName("tischRunde2").item(0);
						Element gesamt = (Element) spieler
								.getElementsByTagName("gesamt").item(0);
						Element gesamtM = (Element) spieler
								.getElementsByTagName("gesamtM").item(0);
						Element gesamtP = (Element) spieler
								.getElementsByTagName("gesamtP").item(0);
						Element soli = (Element) spieler.getElementsByTagName(
								"soli").item(0);

						Spieler s = new Spieler(vorname.getTextContent(),
								nachname.getTextContent());

						s.setAdresse(adresseSP.getTextContent());
						s.setPlz(plzSP.getTextContent());
						s.setOrt(ortSP.getTextContent());
						s.setEmail(email.getTextContent());
						s.setRundeP(0, stringParser(runde1P.getTextContent()));
						s.setRundeM(0, stringParser(runde1M.getTextContent()));
						s.setRunde(0, stringParser(runde1.getTextContent()));
						s.setTischnummer(0, stringParser(tischRunde1
								.getTextContent()));
						s.setRundeP(1, stringParser(runde2P.getTextContent()));
						s.setRundeM(1, stringParser(runde2M.getTextContent()));
						s.setRunde(1, stringParser(runde2.getTextContent()));
						s.setTischnummer(1, stringParser(tischRunde2
								.getTextContent()));
						s.setGesamt(stringParser(gesamt.getTextContent()));
						s.setGesamtM(stringParser(gesamtM.getTextContent()));
						s.setGesamtP(stringParser(gesamtP.getTextContent()));
						s.setSoli(stringParser(soli.getTextContent()));

						tun.getTurnierlisteSpieler().add(s);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tun;
	}
}
