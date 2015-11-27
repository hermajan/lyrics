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
 * Obtaining lyrics from the MetroLyrics.
 * 
 * @author DJohnny
 * @see <a href="http://www.metrolyrics.com">http://www.metrolyrics.com</a>
 */
public class MetroLyrics extends Provider {
    public MetroLyrics(String artist, String song) {
        super.setArtist(artist); super.setSong(song);
        this.makeURL();
    }

    @Override
    public void makeURL() {
        try {
            String fixArtist=super.getArtist().replace("/","").replace("-","");
            URI uri=new URI("http","www.metrolyrics.com","/"+super.getSong()+"-lyrics-"+fixArtist+".html",null,null);
            super.setURL(uri.toASCIIString().replace("%20","-"));
        } catch(URISyntaxException use) { System.err.println(use); }
    }

    @Override
    public String parsing() {
        String output="";
        try {
            Document doc=Jsoup.connect(super.getURL()).get();
            Elements lyr=doc.select("#lyrics-body-text");
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            output=lyr.html().replace("<p class=\"verse\">","");
            output=output.replace("</p>","<br/><br/>");
            output=Library.replacing(output);
        } catch(IOException ioe) { System.err.println(ioe); }
        
        if(output.isEmpty()) { output+="Error: There are no lyrics for this artist and song in the database."; }
        return output;
    }

    @Override
    public String parsingText() {
        String output=parsing();
        output=output.replace("<br /> ",System.getProperty("line.separator")).replace("</p>",System.getProperty("line.separator"));
        return output;
    }

    @Override
    public String toString() {
        String ts=super.toString();
        return ts+", provider MetroLyrics"+System.getProperty("line.separator")+parsingText();
    }
    
}
