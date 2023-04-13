import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupEx02 {

	public static void main(String[] args) {
		String html = "<html>"
				  + "<head><title>First parse</title></head>"
				  + "<body>"
				  + "<p id = 'i1' class = 'c1'>Parsed HTML into a doc.</p>"
				  + "<p id = 'i2' class = 'c2'>Parsed HTML into a doc.</p>"
				  + "<p id = 'i3' class = 'c3'>Parsed HTML into a doc.</p>"
				  + "<p id = 'i4' class = 'c4'>Parsed HTML into a doc.</p>"
				  + "</body>"
				  + "</html>";
		
		Document doc = Jsoup.parse(html);
		Element pTag = doc.getElementById("i1");
		System.out.println(pTag.text());
		
		Elements pTags = doc.getElementsByClass("c1");
		for(Element e : pTags) {
			System.out.println(e);
			System.out.println(e.text());
		}
		
	}
}
