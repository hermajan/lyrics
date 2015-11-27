package net.hermajan.lyrics;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;

/**
 * Getting information from the Last.fm through their API.
 * 
 * @author DJohnny
 * @see <a href="http://www.last.fm/api/intro">http://www.last.fm/api/intro</a>
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

	/**
	 * Creates API request URL.
	 * @param method Requested method.
	 * @return Request URL.
	 */
	public String createAPIrequestURL(String method) {
		String url="";
        try {
            URI uri=new URI("http","ws.audioscrobbler.com","/2.0/","method="+method+"&user="+username+"&api_key="+apikey+"&limit=1",null);
            url=uri.toASCIIString();
        } catch(URISyntaxException use) { System.err.println(use); }
        return url;
	}
	
    /**
     * Obtains information.
	 * @param method Method which is needed to call.
	 * @param info Information which is needed to obtain.
     * @return Information.
     */
    public String obtainInformation(String method,String info) {
        String url=createAPIrequestURL(method);
        String output="";
        try {
            Document doc=Jsoup.connect(url).get();
            Elements lyr=doc.select(info);
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            output=lyr.first().html();
            output=Library.replacing(output);
        } catch(IOException ioe) { System.err.println(ioe); }
        
        return output;
    }
	
    public String getArtist() {
        String output=obtainInformation("user.getrecenttracks","artist");
        
        if(output.isEmpty()) { output+="Error: Can't get artist from the Last.fm."; }
        return output;
    }
    public String getSong() {
        String output=obtainInformation("user.getrecenttracks","name");
		
        if(output.isEmpty()) { output+="Error: Can't get the song from the Last.fm."; }
        return output;
    }
	public String getSongURL() {
		String output=obtainInformation("user.getrecenttracks","url");
        
        if(output.isEmpty()) { output+="Error: Can't get URL of song from the Last.fm."; }
        return output;
	} 
	public String getUserURL() {
		String output=obtainInformation("user.getinfo","url");
        
        if(output.isEmpty()) { output+="Error: Can't get profile URL from the Last.fm."; }
        return output;
	}
	
    @Override
    public String toString() {
        return "Last.fm" + " username is " + username + ".";
    }
}
