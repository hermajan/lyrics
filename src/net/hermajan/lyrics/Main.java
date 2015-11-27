package net.hermajan.lyrics;

/**
 * Runnable file.
 * @author DJohnny
 */
        
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		GUI g;
		if(args.length==0) {
			g=new GUI();
		}
		else {
			// args[0] is an artist and args[1] is a song
			g=new GUI(args[0], args[1]);
		}
        g.setVisible(true);
    }
}
