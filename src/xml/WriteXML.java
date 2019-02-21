package xml;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import code.Spieler;
import code.Turnier;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class WriteXML {

	public WriteXML() {

	}

	public String intParser(int i) {
		if (i == 0) {
			return "";
		} else {
			Integer b = i;
			String a = b.toString();
			return a;
		}
	}

	public String checkNull(String s) {
		if (s == null) {
			return "";
		} else {
			return s;
		}
	}

	public void createXMLDocument(File file, Turnier tun) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.setXmlVersion("1.0");

			Element turnier = document.createElement("Turnier");

			Element tuniername = document.createElement("turniername");
			Element veranstalter = document.createElement("veranstalter");
			Element plz = document.createElement("plz");
			Element ort = document.createElement("ort");
			Element datum = document.createElement("datum");
			Element tunierlisteSpieler = document
					.createElement("tunierlisteSpieler");

			tuniername.appendChild(document.createTextNode(checkNull(tun
					.getTurniername())));
			veranstalter.appendChild(document.createTextNode(checkNull(tun
					.getVeranstalter())));
			plz.appendChild(document.createTextNode(checkNull(tun.getPlz())));
			ort.appendChild(document.createTextNode(checkNull(tun.getOrt())));
			datum.appendChild(document.createTextNode(checkNull(tun.getDatum())));

			for (Spieler sp : tun.getTurnierlisteSpieler()) {

				Element spieler = document.createElement("spieler");

				Element nummer = document.createElement("nummer");
				Element vorname = document.createElement("vorname");
				Element nachname = document.createElement("nachname");

				Element adresseSp = document.createElement("adresse");
				Element plzSP = document.createElement("plz");
				Element ortSP = document.createElement("ort");
				Element email = document.createElement("email");
				Element runde1P = document.createElement("runde1P");
				Element runde1M = document.createElement("runde1M");
				Element runde1 = document.createElement("runde1");
				Element tischRunde1 = document.createElement("tischRunde1");
				Element runde2P = document.createElement("runde2P");
				Element runde2M = document.createElement("runde2M");
				Element runde2 = document.createElement("runde2");
				Element tischRunde2 = document.createElement("tischRunde2");
				Element gesamt = document.createElement("gesamt");
				Element gesamtM = document.createElement("gesamtM");
				Element gesamtP = document.createElement("gesamtP");
				Element soli = document.createElement("soli");

				nummer.appendChild(document.createTextNode(intParser(sp
						.getNummer())));
				vorname.appendChild(document.createTextNode(checkNull(sp
						.getVorname())));
				nachname.appendChild(document.createTextNode(checkNull(sp
						.getNachname())));

				adresseSp.appendChild(document.createTextNode(checkNull(sp
						.getAdresse())));
				plzSP.appendChild(document.createTextNode(checkNull(sp.getPlz())));
				ortSP.appendChild(document.createTextNode(checkNull(sp.getOrt())));
				email.appendChild(document.createTextNode(checkNull(sp
						.getEmail())));
				runde1P.appendChild(document.createTextNode(intParser(sp
						.getRundeP(0))));
				runde1M.appendChild(document.createTextNode(intParser(sp
						.getRundeM(0))));
				runde1.appendChild(document.createTextNode(intParser(sp
						.getRunde(0))));
				tischRunde1.appendChild(document.createTextNode(intParser(sp
						.getTischnummer(0))));
				runde2P.appendChild(document.createTextNode(intParser(sp
						.getRundeP(1))));
				runde2M.appendChild(document.createTextNode(intParser(sp
						.getRundeM(1))));
				runde2.appendChild(document.createTextNode(intParser(sp
						.getRunde(1))));
				tischRunde2.appendChild(document.createTextNode(intParser(sp
						.getTischnummer(1))));
				gesamt.appendChild(document.createTextNode(intParser(sp
						.getGesamt())));
				gesamtM.appendChild(document.createTextNode(intParser(sp
						.getGesamtM())));
				gesamtP.appendChild(document.createTextNode(intParser(sp
						.getGesamtP())));
				soli.appendChild(document.createTextNode(intParser(sp.getSoli())));

				spieler.appendChild(nummer);
				spieler.appendChild(vorname);
				spieler.appendChild(nachname);
				spieler.appendChild(adresseSp);
				spieler.appendChild(plzSP);
				spieler.appendChild(ortSP);
				spieler.appendChild(email);
				spieler.appendChild(runde1P);
				spieler.appendChild(runde1M);
				spieler.appendChild(runde1);
				spieler.appendChild(tischRunde1);
				spieler.appendChild(runde2P);
				spieler.appendChild(runde2M);
				spieler.appendChild(runde2);
				spieler.appendChild(tischRunde2);
				spieler.appendChild(gesamt);
				spieler.appendChild(gesamtM);
				spieler.appendChild(gesamtP);
				spieler.appendChild(soli);

				tunierlisteSpieler.appendChild(spieler);

			}

			turnier.appendChild(tuniername);
			turnier.appendChild(veranstalter);
			turnier.appendChild(plz);
			turnier.appendChild(ort);
			turnier.appendChild(datum);
			turnier.appendChild(tunierlisteSpieler);

			
			document.appendChild(turnier);

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
