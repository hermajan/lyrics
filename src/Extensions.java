
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.jsoup.nodes.Node;


/**
 *
 * @author DJohnny
 */
public class Extensions {
    
    //Properties handling
    public static void setProperty(Properties prop,String name,String value) {
        try {
    		prop.setProperty(name,value);
    		prop.store(new FileOutputStream("lyrics.properties"),null);
    	} catch (IOException ioe) { System.err.println(ioe); }
    }
    
    // Jsoup extension
    public static void removeComments(Node node) {
        for (int i = 0; i < node.childNodes().size();) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#comment")) { child.remove(); }
            else { removeComments(child); i++; }
        }
    }
}
