import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupEx01 {
	public static void main(String[] args) {
		String html = "<html>"
				  + "<head><title>First parse</title></head>"
				  + "<body>"
				  + "<p>Parsed HTML into a doc.</p>"
				  + "<p>Parsed HTML into a doc.</p>"
				  + "</body>"
				  + "</html>";
		
		Document doc = Jsoup.parse(html);
		System.out.println(doc);
		System.out.println(doc.title());
		System.out.println(doc.body());
		System.out.println(doc.getElementsByTag("title"));
		
		Elements titles = doc.getElementsByTag("title");
		System.out.println(titles.text());
		
		Elements pTags = doc.getElementsByTag("p");
		System.out.println(pTags);
		for(int i = 0; i < pTags.size(); i++) {
			Element pTag = pTags.get(i);
			System.out.println(pTag);
			System.out.println(pTag.tagName());
			System.out.println(pTag.text());
		}
	}
	
}


