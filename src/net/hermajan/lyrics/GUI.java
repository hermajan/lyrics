package net.hermajan.lyrics;

import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.swing.text.html.HTMLDocument;
import net.hermajan.lyrics.providers.KaraokeTexty;
import net.hermajan.lyrics.providers.LyricWiki;
import net.hermajan.lyrics.providers.MetroLyrics;
import net.hermajan.lyrics.providers.Provider;

/**
 * GUI (Graphical user interface) for the application.
 */
public class GUI extends javax.swing.JFrame {
    private static final long serialVersionUID=1L;
    private final Properties prop=Settings.loadProperties();
	private Provider lyric;
    
    /**
     * Creates GUI.
	 * @param artist Artist.
	 * @param song Song.
     */
    public GUI(String artist, String song) {
        initComponents();
		usernameField.setText(prop.getProperty("username"));
		
		if(artist.isEmpty() && song.isEmpty()) {
			lastfmCheckBox.doClick();
		}
		else {
			artistField.setText(artist);
			songField.setText(song);
		}
		
		getLyricsButton.doClick();
    }

	public GUI() {
		this("","");
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        providers = new javax.swing.ButtonGroup();
        lyricTab = new javax.swing.JTabbedPane();
        lyricPanel = new javax.swing.JPanel();
        artistLabel = new javax.swing.JLabel();
        artistField = new javax.swing.JTextField();
        songLabel = new javax.swing.JLabel();
        songField = new javax.swing.JTextField();
        urlLabel = new javax.swing.JLabel();
        urlField = new javax.swing.JTextField();
        providerLabel = new javax.swing.JLabel();
        lyricWikiButton = new javax.swing.JRadioButton();
        metroLyricsButton = new javax.swing.JRadioButton();
        getLyricsButton = new javax.swing.JButton();
        lastfmCheckBox = new javax.swing.JCheckBox();
        textScrollPane = new javax.swing.JScrollPane();
        lyricsText = new javax.swing.JEditorPane();
        karaokeTextyButton = new javax.swing.JRadioButton();
        urlOpenButton = new javax.swing.JButton();
        gTranslateButton = new javax.swing.JButton();
        lastfmPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        lastfmUrlField = new javax.swing.JTextField();
        lastfmUrlLabel = new javax.swing.JLabel();
        lastfmUrlOpenButton = new javax.swing.JButton();
        openProfileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyrics");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(500, 600));
        setResizable(false);

        lyricTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        lyricTab.setToolTipText("");
        lyricTab.setPreferredSize(new java.awt.Dimension(495, 595));

        lyricPanel.setMaximumSize(new java.awt.Dimension(470, 580));
        lyricPanel.setPreferredSize(new java.awt.Dimension(470, 580));

        artistLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        artistLabel.setLabelFor(artistField);
        artistLabel.setText("Artist:");

        artistField.setToolTipText("Artist of the song.");
        artistField.setPreferredSize(new java.awt.Dimension(445, 20));

        songLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        songLabel.setLabelFor(songField);
        songLabel.setText("Song:");

        songField.setToolTipText("Name of the song.");
        songField.setPreferredSize(new java.awt.Dimension(445, 20));

        urlLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        urlLabel.setLabelFor(urlField);
        urlLabel.setText("URL:");
        urlLabel.setToolTipText("Uniform resource locator.");

        urlField.setEditable(false);
        urlField.setToolTipText("URL of the song on a selected provider website.");
        urlField.setDoubleBuffered(true);
        urlField.setMaximumSize(new java.awt.Dimension(380, 20));
        urlField.setPreferredSize(new java.awt.Dimension(445, 20));

        providerLabel.setText("Provider:");

        providers.add(lyricWikiButton);
        lyricWikiButton.setSelected(true);
        lyricWikiButton.setText("Lyric Wiki");

        providers.add(metroLyricsButton);
        metroLyricsButton.setText("MetroLyrics");
        metroLyricsButton.setMargin(new java.awt.Insets(0, 2, 0, 2));

        getLyricsButton.setText("Get lyrics");
        getLyricsButton.setToolTipText("Gets lyrics from a selected provider.");
        getLyricsButton.setPreferredSize(new java.awt.Dimension(105, 23));
        getLyricsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getLyricsButtonActionPerformed(evt);
            }
        });

        lastfmCheckBox.setText("Last.fm");

        textScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textScrollPane.setAutoscrolls(true);
        textScrollPane.setPreferredSize(new java.awt.Dimension(369, 462));

        lyricsText.setContentType("text/html"); // NOI18N
        lyricsText.setFont(lyricsText.getFont());
        lyricsText.setToolTipText("");
        lyricsText.setDoubleBuffered(true);
        lyricsText.setMaximumSize(new java.awt.Dimension(350, 440));
        lyricsText.setName(""); // NOI18N
        lyricsText.setPreferredSize(new java.awt.Dimension(350, 460));
        lyricsText.setVerifyInputWhenFocusTarget(false);
        textScrollPane.setViewportView(lyricsText);

        providers.add(karaokeTextyButton);
        karaokeTextyButton.setText("Karaoke texty");
        karaokeTextyButton.setMargin(new java.awt.Insets(0, 2, 0, 2));

        urlOpenButton.setText("Open");
        urlOpenButton.setToolTipText("Opens lyrics of the song in a browser.");
        urlOpenButton.setPreferredSize(new java.awt.Dimension(105, 23));
        urlOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlOpenButtonActionPerformed(evt);
            }
        });

        gTranslateButton.setText("<html>Google<br>Translate</html>");
        gTranslateButton.setToolTipText("Opens lyrics of the song in the Google Translate.");
        gTranslateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gTranslateButton.setPreferredSize(new java.awt.Dimension(105, 37));
        gTranslateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gTranslateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lyricPanelLayout = new javax.swing.GroupLayout(lyricPanel);
        lyricPanel.setLayout(lyricPanelLayout);
        lyricPanelLayout.setHorizontalGroup(
            lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyricPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lyricPanelLayout.createSequentialGroup()
                        .addComponent(textScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urlOpenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(metroLyricsButton)
                            .addComponent(lyricWikiButton)
                            .addComponent(karaokeTextyButton)
                            .addComponent(lastfmCheckBox)
                            .addComponent(providerLabel)
                            .addComponent(getLyricsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gTranslateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lyricPanelLayout.createSequentialGroup()
                        .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(urlLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(songLabel))
                            .addComponent(artistLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(2, 2, 2)
                        .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(songField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(urlField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(artistField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(5, 5, 5))
        );
        lyricPanelLayout.setVerticalGroup(
            lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyricPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistLabel)
                    .addComponent(artistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(songField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songLabel))
                .addGap(5, 5, 5)
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urlLabel))
                .addGap(5, 5, 5)
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(lyricPanelLayout.createSequentialGroup()
                        .addComponent(urlOpenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(providerLabel)
                        .addGap(0, 0, 0)
                        .addComponent(karaokeTextyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lyricWikiButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metroLyricsButton)
                        .addGap(15, 15, 15)
                        .addComponent(lastfmCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(getLyricsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gTranslateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        lyricTab.addTab("Lyric", lyricPanel);

        lastfmPanel.setPreferredSize(new java.awt.Dimension(470, 590));

        usernameLabel.setText("Username:");
        usernameLabel.setToolTipText("");

        usernameField.setToolTipText("Last.fm username.");
        usernameField.setPreferredSize(new java.awt.Dimension(340, 20));

        saveButton.setText("Save");
        saveButton.setToolTipText("Saves a Last.fm username.");
        saveButton.setPreferredSize(new java.awt.Dimension(70, 23));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        lastfmUrlField.setEditable(false);
        lastfmUrlField.setToolTipText("URL of the song on the Last.fm.");
        lastfmUrlField.setDoubleBuffered(true);
        lastfmUrlField.setMaximumSize(new java.awt.Dimension(450, 20));
        lastfmUrlField.setPreferredSize(new java.awt.Dimension(450, 20));

        lastfmUrlLabel.setLabelFor(urlField);
        lastfmUrlLabel.setText("URL of the song:");
        lastfmUrlLabel.setToolTipText("Uniform resource locator.");

        lastfmUrlOpenButton.setText("Open");
        lastfmUrlOpenButton.setToolTipText("Opens song on the Last.fm in a browser.");
        lastfmUrlOpenButton.setPreferredSize(new java.awt.Dimension(100, 23));
        lastfmUrlOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastfmUrlOpenButtonActionPerformed(evt);
            }
        });

        openProfileButton.setText("Open profile");
        openProfileButton.setToolTipText("Opens Last.fm user profile in a browser.");
        openProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProfileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lastfmPanelLayout = new javax.swing.GroupLayout(lastfmPanel);
        lastfmPanel.setLayout(lastfmPanelLayout);
        lastfmPanelLayout.setHorizontalGroup(
            lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lastfmPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastfmUrlField, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lastfmPanelLayout.createSequentialGroup()
                        .addComponent(lastfmUrlLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lastfmUrlOpenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lastfmPanelLayout.createSequentialGroup()
                        .addComponent(usernameLabel)
                        .addGap(5, 5, 5)
                        .addGroup(lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lastfmPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(openProfileButton))
                            .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(5, 5, 5))
        );
        lastfmPanelLayout.setVerticalGroup(
            lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lastfmPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addGap(5, 5, 5)
                .addGroup(lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openProfileButton))
                .addGap(20, 20, 20)
                .addGroup(lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastfmUrlLabel)
                    .addComponent(lastfmUrlOpenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lastfmUrlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(446, Short.MAX_VALUE))
        );

        lyricTab.addTab("Last.fm", lastfmPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lyricTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lyricTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getLyricsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getLyricsButtonActionPerformed
		if(lastfmCheckBox.isSelected()) {
			Lastfm lf=new Lastfm(usernameField.getText());
            artistField.setText(lf.getArtist()); songField.setText(lf.getSong());
			lastfmUrlField.setText(lf.getSongURL());
        } else {
			String artist=artistField.getText();
			String song=songField.getText();
			
			try {
				URI uri=new URI("http","www.last.fm","/music/"+artist+"/_/"+song,null,null);
				lastfmUrlField.setText(uri.toASCIIString().replace("%20", "+"));
			} catch(URISyntaxException use) { System.err.println(use); }
		}
        
        lyric=new LyricWiki(artistField.getText(),songField.getText());
        if(karaokeTextyButton.isSelected()==true) { 
            lyric=new KaraokeTexty(artistField.getText(),songField.getText());
        }
        if(lyricWikiButton.isSelected()==true) { 
            lyric=new LyricWiki(artistField.getText(),songField.getText());
        }
        if(metroLyricsButton.isSelected()==true) { 
            lyric=new MetroLyrics(artistField.getText(),songField.getText());
        }
        
        urlField.setText(lyric.getURL());
        lyricsText.setText(lyric.parsing());
        
        // Sets a default rendering font type.
        Font font=lyricsText.getFont();
        String settingFont="body { font-family: "+font.getFamily()+"; "+"font-size: "+font.getSize()+"pt; }";
        ((HTMLDocument)lyricsText.getDocument()).getStyleSheet().addRule(settingFont);
    }//GEN-LAST:event_getLyricsButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    	Settings.saveProperty("username",usernameField.getText());
        
        if(lastfmCheckBox.isSelected()==true) { getLyricsButton.doClick(); }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void urlOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlOpenButtonActionPerformed
        try {
            Desktop.getDesktop().browse(new URI(urlField.getText()));
        } catch(URISyntaxException|IOException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_urlOpenButtonActionPerformed

    private void lastfmUrlOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastfmUrlOpenButtonActionPerformed
        try {
            Desktop.getDesktop().browse(new URI(lastfmUrlField.getText()));
        } catch(URISyntaxException|IOException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_lastfmUrlOpenButtonActionPerformed

    private void openProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProfileButtonActionPerformed
        try {
			Lastfm lf=new Lastfm(usernameField.getText());
            Desktop.getDesktop().browse(new URI(lf.getUserURL()));
        } catch(URISyntaxException|IOException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_openProfileButtonActionPerformed

    private void gTranslateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gTranslateButtonActionPerformed
        String translate = lyric.parsingText().replace("<br />","");
		try {
			URI uri=new URI("https","translate.google.com","/",null,"auto/en/"+translate);			
			Desktop.getDesktop().browse(uri);
		} catch(URISyntaxException|IOException ex) { 
			System.err.println(ex); 
		}
    }//GEN-LAST:event_gTranslateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField artistField;
    private javax.swing.JLabel artistLabel;
    private javax.swing.JButton gTranslateButton;
    private javax.swing.JButton getLyricsButton;
    private javax.swing.JRadioButton karaokeTextyButton;
    private javax.swing.JCheckBox lastfmCheckBox;
    private javax.swing.JPanel lastfmPanel;
    private javax.swing.JTextField lastfmUrlField;
    private javax.swing.JLabel lastfmUrlLabel;
    private javax.swing.JButton lastfmUrlOpenButton;
    private javax.swing.JPanel lyricPanel;
    private javax.swing.JTabbedPane lyricTab;
    private javax.swing.JRadioButton lyricWikiButton;
    private javax.swing.JEditorPane lyricsText;
    private javax.swing.JRadioButton metroLyricsButton;
    private javax.swing.JButton openProfileButton;
    private javax.swing.JLabel providerLabel;
    private javax.swing.ButtonGroup providers;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField songField;
    private javax.swing.JLabel songLabel;
    private javax.swing.JScrollPane textScrollPane;
    private javax.swing.JTextField urlField;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JButton urlOpenButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
