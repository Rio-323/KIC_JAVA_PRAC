import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupEx03 {

	public static void main(String[] args) {
		String html = "<html>"
				  + "<head><title>First parse</title></head>"
				  + "<body>"
				  
				  + "<a href = 'https://www.daum.net'>"
				  + "<img class ='c1' src = './daum.png'/>"
				  + "<div id = 'i1'>다음 바로가기</div>"
				  + "</a>"
				  
				  + "<a href = 'https://www.naver.com'>"
				  + "<img class ='c1' src = './naver.png'/>"
				  + "<div id = 'i2'>네이버 바로가기</div>"
				  + "</a>"
					 
				  + "<a href = 'https://www.google.com'>"
				  + "<img class ='c1' src = './google.png'/>"
				  + "<div id = 'i3'>구글 바로가기</div>"
				  + "</a>"
				  
				  + "</body>"
				  + "</html>";
		
		Document doc = Jsoup.parse(html);
		
		Elements divTags = doc.select("#i3");
		System.out.println(divTags.text());
		
		Elements imgTags = doc.select("img.c1");
		System.out.println(imgTags);
		for (Element e : imgTags) {
			System.out.println(e.attr("src"));
		}
		
		Elements imgTags2 = doc.select("img[src$=png]");
		System.out.println(imgTags2);
	}
}
