package net.hermajan.lyrics;

import org.jsoup.nodes.Node;

/**
 * Library for some useful methods.
 */
public class Library {
    
    /**
     * Removes HTML tags for comments.
     * @param node Node.
     */
    public static void removeComments(Node node) {
        for(int i=0;i<node.childNodes().size();) {
            Node child=node.childNode(i);
            if(child.nodeName().equals("#comment")) { child.remove(); }
            else { removeComments(child); i++; }
        }
    }
    
    /**
     * Replaces some bad strings when parsing a data.
     * @param text String where substrings could be replaced.
     * @return Replaced string.
     */
    public static String replacing(String text) {
        text=text.replace("&quot;","\"").replace("&apos;","'");
        text=text.replace("&amp;","&");
        return text;
    }
    
    /**
     * Capitalizes first letters of string.
     * @param text String which will method capitalize.
     * @return Capitalized string.
     */
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
