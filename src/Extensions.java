
import org.jsoup.nodes.Node;


/**
 *
 * @author DJohnny
 */
public class Extensions {
    // Jsoup extension
    public static void removeComments(Node node) {
        for (int i = 0; i < node.childNodes().size();) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#comment")) { child.remove(); }
            else { removeComments(child); i++; }
        }
    }
}
