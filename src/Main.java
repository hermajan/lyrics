/**
 *
 * @author DJohnny
 */

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
        
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://lyrics.wikia.com/Coldplay:Fix%20you?useskin=wikiamobile").get();        
            Elements lyr = doc.select(".lyricbox");
            System.out.println(lyr);
        } catch(IOException ioe) { System.out.println(ioe); }
    }
    
}
