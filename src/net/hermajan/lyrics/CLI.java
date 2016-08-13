package net.hermajan.lyrics;

import java.util.Properties;
import net.hermajan.lyrics.providers.KaraokeTexty;
import net.hermajan.lyrics.providers.LyricWiki;
import net.hermajan.lyrics.providers.MetroLyrics;
import net.hermajan.lyrics.providers.Provider;

/**
 * CLI (Command-line interface) for the application.
 */
public class CLI {
	/**
	 * @param args The command-line arguments.
	 * args[0] is an artist, args[1] is a song, args[2] is a provider
	 */
	public static void main(String[] args) {
		Provider lyric;
		String artist = "", song = "", provider = "1";
		
		switch(args.length) {
			case 0:
				Properties prop = Settings.loadProperties();
				Lastfm lf = new Lastfm(prop.getProperty("username"));
				artist = lf.getArtist(); song = lf.getSong();
				break;
			case 1:
				if(args[0].equals("help") || args[0].equals("?")) {
					System.out.println("Use Lyrics with number of arguments:");
					System.out.println("0: Application obtains an artist and a song from your Last.fm account set in lyrics.properties file.");
					System.out.println("1: Argument \"help\" or \"?\" shows this help. Argument \"provider\" obtains an artist and a song from your Last.fm account set in lyrics.properties file and shows music lyrics from selected provider.");
					System.out.println("2: Arguments in format \"'artist' 'song'\" shows music lyrics.");
					System.out.println("3: Arguments in format \"'artist' 'song' 'provider'\" shows music lyrics from selected provider.");
					System.out.println("\nProviders are \"0\" for KaraokeTexty, \"1\" for LyricWiki, \"2\" for MetroLyrics.");
					System.out.println("\n");
				}
				
				if(args[0].matches("^[0-9]$")) {
					prop = Settings.loadProperties();
					lf = new Lastfm(prop.getProperty("username"));
					artist = lf.getArtist(); song = lf.getSong();
					provider = args[0];
				}
				break;
			case 2:
				artist = args[0]; song = args[1];
				break;
			case 3: default:
				artist = args[0]; song = args[1];
				provider = args[2];
				break;
		}
		
		switch(provider) {
			case "0":
				lyric = new KaraokeTexty(artist, song);
				break;
			case "1": default:
				lyric = new LyricWiki(artist, song);
				break;
			case "2":
				lyric = new MetroLyrics(artist, song);
				break;
		}

		System.out.println(lyric.parsingText());
	}
}
