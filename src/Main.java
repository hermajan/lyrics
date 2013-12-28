/**
 *
 * @author DJohnny
 */
        
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lyrics l=new Lyrics("Coldplay","Fix you");
        
        System.out.println(l.fromLyricWiki());
        //System.out.println(l.fromMetroLyrics());
    }
    
}
