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
 * @see <a href="http://lyrics.wikia.com/wiki/Lyrics_Wiki">LyricWiki</a>
 */
public class LyricWiki extends Provider {
    public LyricWiki(String artist, String song) {
        super.setArtist(artist); super.setSong(song);
        this.makeURL();
    }
    
    @Override
    public void makeURL() { 
        try {
            String capitalizedSong=Library.capitalizeFirstLetters(super.getSong());
            URI uri=new URI("http","lyrics.wikia.com","/wiki/"+super.getArtist()+":"+capitalizedSong,null,null);
            super.setURL(uri.toASCIIString().replace("%20","_"));
        } catch(URISyntaxException use) { System.err.println(use); }
    }
    
    @Override
    public String parsing() {
        String output="";
        try {
            Document doc=Jsoup.connect(super.getURL()).get();
            doc.select(".rtMatcher").remove(); doc.select(".lyricsBreak").remove(); 
			doc.select("script").remove(); Library.removeComments(doc);
            Elements lyr=doc.select(".lyricbox");
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            output=lyr.html();
            output=Library.replacing(output);
        } catch(IOException ioe) { System.err.println(ioe); }
        
        if(output.contains("<span") && output.contains("title=\"Instrumental\"")) {
            output="This is an instrumental song with no lyrics.";
        }
        if(output.isEmpty()) { output+="Error: There are no lyrics for this artist and song in the database."; }
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
