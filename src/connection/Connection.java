/**
 * 
 */
package connection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.Normalizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*import org.w3c.dom.Document;
import org.w3c.dom.Element;
*/
/**
 * @author adriana
 *
 */
public class Connection {
	private static final String localDbFileName = "casmb_med_familie.csv";
	private static final String casSite = "http://www.cnas.ro/cas";
	private static final String searchString = "Lista cabinete";
	private static final String mfParse = "/category/medici-de-familie.html";
	
	private String county = "mb";
	private String officesLink;
	
	public Connection() {}

	/**
	 * 
	 */
	public Connection(String county) {
		this.county = county; 
	}
	
	private void helperFindKeyword(Document doc ) {
		
	}
	
	
	
	public void getMap() throws IOException {
		String url = casSite + this.county + mfParse;
		System.out.println("URL " + url);
		String fileFamilyDoctors;
		String hrefLink = "href";
		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("body a");
		Document officesLinkDoc = null;
		
	}
	public void getCountyMFLink() throws IOException {
		String url = casSite + this.county + mfParse;
		System.out.println("URL " + url);
		String fileFamilyDoctors;
		String hrefLink = "href";
		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("body a");
		Document officesLinkDoc = null;
		
		for (Element link : links) {
//			System.out.println("Elem data " + link.data() + " ownText " + link.ownText()
//			+ " " + link.tagName()  + " text " + link.text() + " tag " + link.tag() + 
//			" Whole text " + link.wholeText());
			String normalizedText = Normalizer.normalize(link.text(), Normalizer.Form.NFD);
			if (normalizedText.contains(searchString)) {
				// Found "Lista cabinete"
				System.out.println(link.baseUri() );
//				officesLinkDoc = (Document) Jsoup.connect(link.baseUri());
				
				// get the new url; can be relative to parent
				// eg "/casmb/page/lista-cabinete-medicina-de-familie.html"
				doc = Jsoup.connect(new URL(link.absUrl(hrefLink))).get();	
				
				// find "Fișiere atașate"
				String attachedFileString = "Fisiere atasate";
				normalizedText = Normalizer.normalize(attachedFileString, Normalizer.Form.NFD);
				Elements attachedFiles = doc.select(":contains("+normalizedText + ")");
				
				for (Element elem : attachedFiles) {
					Elements linkss = elem.getElementsByAttribute("href");
					
				
				URL urlListOfDoctors = new URL(link.absUrl(hrefLink));
				int fileNameIndexStart = urlListOfDoctors.toString().lastIndexOf("/");
				int fileNameIndexEnd   = urlListOfDoctors.toString().length() - 5; // - ".html"
				fileFamilyDoctors = urlListOfDoctors.toString().substring(fileNameIndexStart, fileNameIndexEnd);
				ReadableByteChannel readChannel = Channels.newChannel(urlListOfDoctors.openStream()); 
				FileOutputStream fileOS = new FileOutputStream(fileFamilyDoctors);  
				FileChannel writeChannel = fileOS.getChannel();  
				break;
			}
		}
		if (officesLinkDoc == null) {
			System.err.println("There is a problem with the link structure. Revise it");
			return;
		}
		links = officesLinkDoc.select("a[href]");
		for (Element link : links) {
			System.out.println("Elem data " + link.data() + " ownText " + link.ownText()
			+ " " + link.tagName()  + " text " + link.text() + " tag " + link.tag() + 
			" Whole text " + link.wholeText());
			if (link.text().contains(searchString)) {
				System.out.println(link.baseUri() );
				officesLinkDoc = (Document) Jsoup.connect(link.baseUri());
				break;
			}
		}
		if (officesLinkDoc == null ) {
			System.err.println("There is a problem with the link structure. Revise it");
			return;
		}
		links = officesLinkDoc.select("a[href]");
		for (Element link : links) {
			System.out.println("Elem data " + link.data() + " ownText " + link.ownText()
			+ " " + link.tagName()  + " text " + link.text() + " tag " + link.tag() + 
			" Whole text " + link.wholeText());
			if (link.text().contains(searchString)) {
				System.out.println(link.baseUri() );
				officesLinkDoc = (Document) Jsoup.connect(link.baseUri());
				break;
			}
		}
	}

	public void getLatestData() {
		
	}
}
