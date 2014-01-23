
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.jsoup.nodes.Node;

/**
 * Library for some useful methods.
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
    
    public static String parsing(String text) {
        text=text.replace("&quot;","\"").replace("&apos;","'");
        text=text.replace("&amp;","&");
        text=text.replace("<i>","").replace("</i>","");
        return text;
    }
    
    public static String capitalizeFirstLetters(String text) {
        if(text.length()==0) { return ""; }
        String[] array=text.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String word:array) {
            sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }          
        return sb.toString().trim();
    }
}
