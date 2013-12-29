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

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
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
        artistField = new javax.swing.JTextField();
        artistLabel = new javax.swing.JLabel();
        trackField = new javax.swing.JTextField();
        trackLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lyricsText = new javax.swing.JTextArea();
        lyricWikiButton = new javax.swing.JRadioButton();
        metroLyricsButton = new javax.swing.JRadioButton();
        getLyricsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        urlLabel = new javax.swing.JLabel();
        urlField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyrics");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(540, 600));
        setResizable(false);

        artistLabel.setText("Artist:");

        trackLabel.setText("Track:");

        lyricsText.setColumns(20);
        lyricsText.setRows(5);
        jScrollPane1.setViewportView(lyricsText);

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

        jLabel3.setText("Provider:");

        urlLabel.setText("URL:");

        urlField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(trackField)
                    .addComponent(artistField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(artistLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trackLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(metroLyricsButton)
                            .addComponent(lyricWikiButton)
                            .addComponent(getLyricsButton)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(urlLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urlField, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(artistLabel)
                .addGap(1, 1, 1)
                .addComponent(artistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trackLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trackField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlLabel)
                    .addComponent(urlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(lyricWikiButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metroLyricsButton)
                        .addGap(10, 10, 10)
                        .addComponent(getLyricsButton)
                        .addGap(0, 291, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getLyricsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getLyricsButtonActionPerformed
        Lyrics lyr=new Lyrics(artistField.getText(),trackField.getText());
        
        if(lyricWikiButton.isSelected()==true) { lyricsText.setText(lyr.fromLyricWiki()); }
        if(metroLyricsButton.isSelected()==true) { lyricsText.setText(lyr.fromMetroLyrics()); }
        
        urlField.setText(lyr.getUrl());
    }//GEN-LAST:event_getLyricsButtonActionPerformed

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
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField artistField;
    private javax.swing.JLabel artistLabel;
    private javax.swing.JButton getLyricsButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton lyricWikiButton;
    private javax.swing.JTextArea lyricsText;
    private javax.swing.JRadioButton metroLyricsButton;
    private javax.swing.ButtonGroup providers;
    private javax.swing.JTextField trackField;
    private javax.swing.JLabel trackLabel;
    private javax.swing.JTextField urlField;
    private javax.swing.JLabel urlLabel;
    // End of variables declaration//GEN-END:variables
}
