/**
 *
 * @author DJohnny
 */
        
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lastfm lf=new Lastfm("djohnny","468e0ae50dbce978240ce1e4e6031602");
        
        Lyrics l=new Lyrics(lf.getArtist(),lf.getTrack());
        //Lyrics l=new Lyrics("Coldplay","Fix you");
        
        System.out.println(l.getArtist()+" "+l.getTrack());
        //System.out.println(l.fromLyricWiki());
        //System.out.println(l.fromMetroLyrics());
        
        //GUI g=new GUI();
        //g.setVisible(true);
    }
    
}
