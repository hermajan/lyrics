package net.hermajan.lyrics.providers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import net.hermajan.lyrics.Library;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;

/**
 * Obtaining lyrics from the KaraokeTexty.
 * @see <a href="http://www.karaoketexty.cz">KaraokeTexty</a>
 */
public class KaraokeTexty extends Provider {
    public KaraokeTexty(String artist, String song) {
        super.setArtist(artist); super.setSong(song);
        this.makeURL();
    }
    
    @Override
    public void makeURL() {
        String query=super.getArtist()+" - "+super.getSong();
        String searchURL="";
        
        try {
            URI uri=new URI("http","www.karaoketexty.cz","/search","q="+super.getSong(),null);
            searchURL=uri.toASCIIString().replace("&","%26");
        } catch(URISyntaxException use) { System.err.println(use); }
        
        try {
            Document doc=Jsoup.connect(searchURL).get();
            Elements links=doc.select("#search > ul.title > li > a");
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            
            for(Element link:links) {
                String resultText=Library.replacing(link.text());
                if(resultText.equalsIgnoreCase(query)) {
                    super.setURL("http://www.karaoketexty.cz"+link.attr("href"));
                    return;
                }
                else if(resultText.contains(query)) {
                    super.setURL("http://www.karaoketexty.cz"+link.attr("href"));
                    return;
                }
            }
            super.setURL("http://www.karaoketexty.cz/search?q="+query);
        } catch(IOException ioe) { System.err.println(ioe); }
    }

    @Override
    public String parsing() {
        String output="";

        try {
            Document doc=Jsoup.connect(super.getURL()).get();
            Elements lyr=doc.select("p.text");
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            try {
                output=lyr.first().html();
            } catch(NullPointerException npe) { System.err.println(npe);}
            output=Library.replacing(output);
        } catch(IOException ioe) { System.err.println(ioe); }
        
        if(output.isEmpty()) { output+="Error: There are no lyrics for this artist and song in the database."; }
        return output;
    }

    @Override
    public String parsingText() {
		String output=parsing();
		output=output.replace("<br /> ",System.getProperty("line.separator"));
		return output;
    }

    @Override
    public String toString() {
        String ts=super.toString();
        return ts+", provider KaraokeTexty"+System.getProperty("line.separator")+parsingText();
    }
    
}
