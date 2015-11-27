package net.hermajan.lyrics.providers;

/**
 * Handling and obtaining lyrics.
 * 
 * @author DJohnny
 */
abstract public class Provider {
    private String artist, song, url="";

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist=artist; }
    public String getSong() { return song; }
    public void setSong(String song) { this.song=song; }
    
    public String getURL() { return url; }
    public void setURL(String url) { this.url=url; }
    abstract public void makeURL();
    
    /**
     * 
     * @return Lyrics with HTML tags.
     */
    abstract public String parsing();
    /**
     * 
     * @return Lyrics as clean text (without HTML tags).
     */
    abstract public String parsingText();

    @Override
    public String toString() {
        return "Lyrics for "+artist+" - "+song+" from "+url;
    }
}
