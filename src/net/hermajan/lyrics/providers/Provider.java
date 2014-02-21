package net.hermajan.lyrics.providers;

/**
 * Handling and obtaining lyrics.
 * 
 * @author DJohnny
 */
abstract public class Provider {
    private String artist,track,url="";

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist=artist; }
    public String getTrack() { return track; }
    public void setTrack(String track) { this.track=track; }
    
    public String getURL() { return url; }
    public void setURL(String url) { this.url=url; }
    abstract public void makeURL();
    
    /**
     * 
     * @return Provider with HTML tags.
     */
    abstract public String parsing();
    /**
     * 
     * @return Provider as clean text (without HTML tags).
     */
    abstract public String parsingText();

    @Override
    public String toString() {
        return "Lyrics for "+artist+" - "+track+" from "+url;
    }
}
