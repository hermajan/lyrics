package net.hermajan.lyrics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Handling of settings.
 * 
 * @author DJohnny
 */
public class Settings {
    private static final String filename="lyrics.properties";
    
    /**
     * Loads a file with properties.
     * @return Properties.
     */
    public static Properties loadProperties() {
        Properties file=new Properties();
        try { file.load(new FileInputStream(filename));
        } catch (IOException ioe) { System.err.println(ioe); }
        return file;
    }
    
    /**
     * Saves a property to the file.
     * @param name
     * @param value
     */
    public static void saveProperty(String name,String value) {
        Properties file=Settings.loadProperties();
        try {
    		file.setProperty(name,value);
    		file.store(new FileOutputStream(filename),null);
    	} catch (IOException ioe) { System.err.println(ioe); }
    }
}
