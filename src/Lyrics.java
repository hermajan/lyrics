
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;


/**
 * Handling and obtaining lyrics.
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
    
    public Lyrics(String artist, String track) {
        this.artist = artist;
        this.track = track;
    }
    
    public String fromLyricWiki() {
        try {
            String capitalizedTrack=Extensions.capitalizeFirstLetters(track);
            URI uri=new URI("http","lyrics.wikia.com","/"+artist+":"+capitalizedTrack,null,null);
            url=uri.toASCIIString();
        } catch(URISyntaxException use) { System.err.println(use); }
        
        String output="";
        try {
            Document doc=Jsoup.connect(url).get();
            doc.select(".rtMatcher").remove(); doc.select(".lyricsBreak").remove(); Extensions.removeComments(doc);
            Elements lyr=doc.select(".lyricbox");
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            output=lyr.html().replace("<br />","");
            output=Extensions.parsing(output);
        } catch(IOException ioe) { System.err.println(ioe); }
        
        if(output.contains("<span") && output.contains("title=\"Instrumental\"")) {
            output="This is instrumental song with no lyrics.";
        }
        if(output.equals("")) { output+="Error: There are no lyrics for this artist and track in the database."; }
        return output;
    }
    
    public String fromMetroLyrics() {
        try {
            URI uri=new URI("http","www.metrolyrics.com","/"+track+"-lyrics-"+artist+".html",null,null);
            url=uri.toASCIIString().replace("%20","-");
        } catch(URISyntaxException use) { System.err.println(use); }
        
        String output="";
        try {
            Document doc=Jsoup.connect(url).get();
            Elements lyr=doc.select("#lyrics-body-text");
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            output=lyr.html().replace("<p class=\"verse\">","");
            output=output.replace("<br /> ",System.getProperty("line.separator")).replace("</p>",System.getProperty( "line.separator"));
            output=Extensions.parsing(output);
        } catch(IOException ioe) { System.err.println(ioe); }
        
        if(output.equals("")) { output+="Error: There are no lyrics for this artist and track in the database."; }
        return output;
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
