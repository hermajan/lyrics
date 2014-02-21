
import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTMLDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DJohnny
 */
public class GUI extends javax.swing.JFrame {
    Properties prop=new Properties();
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        
        try { prop.load(new FileInputStream("lyrics.properties"));
        } catch (IOException ioe) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ioe);
            System.err.println(ioe);
        }
        
        usernameField.setText(prop.getProperty("username"));
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
        trackLabel = new javax.swing.JLabel();
        trackField = new javax.swing.JTextField();
        urlLabel = new javax.swing.JLabel();
        urlField = new javax.swing.JTextField();
        providerLabel = new javax.swing.JLabel();
        lyricWikiButton = new javax.swing.JRadioButton();
        metroLyricsButton = new javax.swing.JRadioButton();
        getLyricsButton = new javax.swing.JButton();
        lastfmCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        lyricsText = new javax.swing.JEditorPane();
        lastfmPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyrics");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lyricPanel.setPreferredSize(new java.awt.Dimension(530, 400));

        artistLabel.setText("Artist:");

        trackLabel.setText("Track:");

        urlLabel.setText("URL:");

        urlField.setEditable(false);

        providerLabel.setText("Provider:");

        providers.add(lyricWikiButton);
        lyricWikiButton.setSelected(true);
        lyricWikiButton.setText("Lyric Wiki");

        providers.add(metroLyricsButton);
        metroLyricsButton.setText("MetroLyrics");

        getLyricsButton.setText("Get lyrics");
        getLyricsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getLyricsButtonActionPerformed(evt);
            }
        });

        lastfmCheckBox.setText("Last.fm");

        lyricsText.setContentType("text/html"); // NOI18N
        lyricsText.setFont(lyricsText.getFont());
        lyricsText.setToolTipText("");
        lyricsText.setPreferredSize(new java.awt.Dimension(104, 64));
        jScrollPane1.setViewportView(lyricsText);

        javax.swing.GroupLayout lyricPanelLayout = new javax.swing.GroupLayout(lyricPanel);
        lyricPanel.setLayout(lyricPanelLayout);
        lyricPanelLayout.setHorizontalGroup(
            lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lyricPanelLayout.createSequentialGroup()
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lyricPanelLayout.createSequentialGroup()
                        .addComponent(trackLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trackField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lyricPanelLayout.createSequentialGroup()
                        .addComponent(artistLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(artistField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lyricPanelLayout.createSequentialGroup()
                        .addComponent(urlLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(urlField))
                    .addGroup(lyricPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lyricPanelLayout.createSequentialGroup()
                                .addComponent(providerLabel)
                                .addGap(0, 71, Short.MAX_VALUE))
                            .addComponent(metroLyricsButton)
                            .addComponent(lyricWikiButton)
                            .addComponent(getLyricsButton)
                            .addComponent(lastfmCheckBox))))
                .addContainerGap())
        );
        lyricPanelLayout.setVerticalGroup(
            lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyricPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistLabel)
                    .addComponent(artistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trackLabel)
                    .addComponent(trackField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlLabel)
                    .addComponent(urlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lyricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lyricPanelLayout.createSequentialGroup()
                        .addComponent(providerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lyricWikiButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(metroLyricsButton)
                        .addGap(10, 10, 10)
                        .addComponent(lastfmCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getLyricsButton)
                        .addGap(0, 239, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        lyricTab.addTab("Lyric", lyricPanel);

        lastfmPanel.setPreferredSize(new java.awt.Dimension(530, 467));

        usernameLabel.setText("Username:");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lastfmPanelLayout = new javax.swing.GroupLayout(lastfmPanel);
        lastfmPanel.setLayout(lastfmPanelLayout);
        lastfmPanelLayout.setHorizontalGroup(
            lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lastfmPanelLayout.createSequentialGroup()
                .addComponent(usernameLabel)
                .addGap(11, 11, 11)
                .addGroup(lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lastfmPanelLayout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(lastfmPanelLayout.createSequentialGroup()
                        .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
        );
        lastfmPanelLayout.setVerticalGroup(
            lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lastfmPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(lastfmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lastfmPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(usernameLabel))
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addContainerGap(403, Short.MAX_VALUE))
        );

        lyricTab.addTab("Last.fm", lastfmPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lyricTab, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lyricTab)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getLyricsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getLyricsButtonActionPerformed
        if(lastfmCheckBox.isSelected()) {
            Lastfm lf=new Lastfm(usernameField.getText());
            artistField.setText(lf.getArtist()); trackField.setText(lf.getTrack());
        }
        
        Lyrics lyr=new Lyrics(artistField.getText(),trackField.getText());

        if(lyricWikiButton.isSelected()==true) { lyricsText.setText(lyr.fromLyricWiki()); }
        if(metroLyricsButton.isSelected()==true) { lyricsText.setText(lyr.fromMetroLyrics()); }
        
        // Sets default rendering font type.
        Font font=lyricsText.getFont();
        String settingFont="body { font-family: "+font.getFamily()+"; "+"font-size: "+font.getSize()+"pt; }";
        ((HTMLDocument)lyricsText.getDocument()).getStyleSheet().addRule(settingFont);
        
        urlField.setText(lyr.getUrl());
    }//GEN-LAST:event_getLyricsButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    	Extensions.setProperty(prop,"username",usernameField.getText());
        
        if(lastfmCheckBox.isSelected()==true) { getLyricsButton.doClick(); }
    }//GEN-LAST:event_saveButtonActionPerformed

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
    private javax.swing.JButton getLyricsButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox lastfmCheckBox;
    private javax.swing.JPanel lastfmPanel;
    private javax.swing.JPanel lyricPanel;
    private javax.swing.JTabbedPane lyricTab;
    private javax.swing.JRadioButton lyricWikiButton;
    private javax.swing.JEditorPane lyricsText;
    private javax.swing.JRadioButton metroLyricsButton;
    private javax.swing.JLabel providerLabel;
    private javax.swing.ButtonGroup providers;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField trackField;
    private javax.swing.JLabel trackLabel;
    private javax.swing.JTextField urlField;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}