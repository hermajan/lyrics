
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 *
 * @author DJohnny
 */
public class Lyrics {
    private String artist,track,url="";

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public String getTrack() { return track; }
    public void setTrack(String track) { this.track = track; }
    public String getUrl() { return url; }
    public final void setUrl() {
        try {
            URI uri=new URI("http","lyrics.wikia.com","/"+artist+":"+track,"useskin=wikiamobile",null);
            url=uri.toASCIIString();
        } catch(URISyntaxException use) { System.out.println(use); }        
    }
    
    public Lyrics(String artist, String track) {
        this.artist = artist;
        this.track = track;
        setUrl();
    }
    
    public String getLyrics() {
        Elements lyr=new Elements();
        try {
            Document doc=Jsoup.connect(url).get();
            doc.select(".rtMatcher").remove();
            lyr=doc.select(".lyricbox");
        } catch(IOException ioe) { System.out.println(ioe); }
        
        return lyr.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.artist);
        hash = 71 * hash + Objects.hashCode(this.track);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lyrics other = (Lyrics) obj;
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        if (!Objects.equals(this.track, other.track)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lyrics {"+"artist="+artist+", track="+track+", url="+url+"}";
    }
}
