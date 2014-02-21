package net.hermajan.lyrics.providers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import net.hermajan.lyrics.Library;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;

/**
 * Obtaining lyrics from the LyricWiki.
 * 
 * @author DJohnny
 * @see http://lyrics.wikia.com/Lyrics_Wiki
 */
public class LyricWiki extends Provider {
    public LyricWiki(String artist, String track) {
        super.setArtist(artist); super.setTrack(track);
        this.makeURL();
    }
    
    @Override
    public void makeURL() { 
        try {
            String capitalizedTrack=Library.capitalizeFirstLetters(super.getTrack());
            URI uri=new URI("http","lyrics.wikia.com","/"+super.getArtist()+":"+capitalizedTrack,null,null);
            super.setURL(uri.toASCIIString());
        } catch(URISyntaxException use) { System.err.println(use); }
    }
    
    @Override
    public String parsing() {
        String output="";
        try {
            Document doc=Jsoup.connect(super.getURL()).get();
            doc.select(".rtMatcher").remove(); doc.select(".lyricsBreak").remove(); Library.removeComments(doc);
            Elements lyr=doc.select(".lyricbox");
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            output=lyr.html();
            output=Library.replacing(output);
        } catch(IOException ioe) { System.err.println(ioe); }
        
        if(output.contains("<span") && output.contains("title=\"Instrumental\"")) {
            output="This is instrumental song with no lyrics.";
        }
        if(output.equals("")) { output+="Error: There are no lyrics for this artist and track in the database."; }
        return output;
    }
    
    @Override
    public String parsingText() {
        String output=parsing();
        output.replace("<br />","");
        output.replace("<b>","").replace("</b>","");
        output.replace("<i>","").replace("</i>","");
        return output;
    }

    @Override
    public String toString() {
        String ts=super.toString();
        return ts+", provider LyricWiki"+System.getProperty("line.separator")+parsingText();
    }
}
