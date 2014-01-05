
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author DJohnny
 */
public class Lastfm {
    private String username,apikey="468e0ae50dbce978240ce1e4e6031602";

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getApikey() { return apikey; }
    public void setApikey(String apikey) { this.apikey = apikey; }

    public Lastfm(String username) {
        this.username = username;
    }

    public String getArtist() {
        String url="";
        try {
            URI uri=new URI("http","ws.audioscrobbler.com","/2.0/","method=user.getrecenttracks&user="+username+"&api_key="+apikey+"&limit=1",null);
            url=uri.toASCIIString();
        } catch(URISyntaxException use) { System.err.println(use); }
        
        String output="";
        try {
            Document doc=Jsoup.connect(url).get();
            Elements lyr=doc.select("artist");
            output=lyr.first().html().replace("&amp;","&");
        } catch(IOException ioe) { System.err.println(ioe); }
        
        if(output.equals("")) { System.err.println("Bad artist."); }
        return output;
    }
    
    public String getTrack() {
        String url="";
        try {
            URI uri=new URI("http","ws.audioscrobbler.com","/2.0/","method=user.getrecenttracks&user="+username+"&api_key="+apikey+"&limit=1",null);
            url=uri.toASCIIString();
        } catch(URISyntaxException use) { System.err.println(use); }
        
        String output="";
        try {
            Document doc=Jsoup.connect(url).get();
            Elements lyr=doc.select("name");
            output=lyr.first().html();
        } catch(IOException ioe) { System.err.println(ioe); }
        
        if(output.equals("")) { System.err.println("Bad track."); }
        return output;
    }
    
    @Override
    public String toString() {
        return "Lastfm{" + "username=" + username + "}";
    }
}
