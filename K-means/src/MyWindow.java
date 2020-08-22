import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyWindow extends JFrame {

	protected JButton selectionner= new JButton("selectionner");
	protected static String data_chemin;
	protected ArrayList<String> chemins=new ArrayList<String>();
	protected Panel pane;
	protected JPanel panel=new JPanel();
	protected JFrame frame=new JFrame();
	
    public MyWindow() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidename = new javax.swing.JPanel();
        RecupererClasse = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SelectionImage = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        text = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        classificationImageBarre = new javax.swing.JPanel();
        classificationImageTitre = new javax.swing.JLabel();
        fermer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        sidename.setBackground(new java.awt.Color(54, 33, 89));
        //sidename.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RecupererClasse.setBackground(new java.awt.Color(64, 43, 100));

        jButton2.setBackground(new java.awt.Color(64, 43, 100));
        jButton2.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("+");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Récupérer tous les classes");

        javax.swing.GroupLayout RecupererClasseLayout = new javax.swing.GroupLayout(RecupererClasse);
        RecupererClasse.setLayout(RecupererClasseLayout);
        RecupererClasseLayout.setHorizontalGroup(
            RecupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecupererClasseLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        RecupererClasseLayout.setVerticalGroup(
            RecupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecupererClasseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(RecupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidename.add(RecupererClasse);//, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 240, 50));

        SelectionImage.setBackground(new java.awt.Color(85, 65, 118));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Sélectionner une image");

        jButton1.setBackground(new java.awt.Color(85, 65, 118));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("-");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SelectionImageLayout = new javax.swing.GroupLayout(SelectionImage);
        SelectionImage.setLayout(SelectionImageLayout);
        SelectionImageLayout.setHorizontalGroup(
            SelectionImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectionImageLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        SelectionImageLayout.setVerticalGroup(
            SelectionImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectionImageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidename.add(SelectionImage);//, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 240, 50));

        text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        text.setForeground(new java.awt.Color(204, 204, 204));
        text.setText("Menu");
        sidename.add(text);//, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 60, 20));
        sidename.add(jSeparator1);//, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 190, 20));

        classificationImageBarre.setBackground(new java.awt.Color(110, 89, 222));

        classificationImageTitre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        classificationImageTitre.setForeground(new java.awt.Color(204, 204, 204));
        classificationImageTitre.setText("La classification des images");

        javax.swing.GroupLayout classificationImageBarreLayout = new javax.swing.GroupLayout(classificationImageBarre);
        classificationImageBarre.setLayout(classificationImageBarreLayout);
        classificationImageBarreLayout.setHorizontalGroup(
            classificationImageBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classificationImageBarreLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(classificationImageTitre)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        classificationImageBarreLayout.setVerticalGroup(
            classificationImageBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classificationImageBarreLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(classificationImageTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        fermer.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        fermer.setText("x");
        fermer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fermerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sidename, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(classificationImageBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fermer)
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidename, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(classificationImageBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
	    chooser.setFileFilter(filter);
	    if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
	          try {
	            data_chemin=new String("E:/java/color  hist/img/"+chooser.getSelectedFile().getName());
				chemins=this.rechercher(data_chemin);
				pane=new Panel(chemins);
				panel.add(pane);
				panel.setLayout(new GridLayout(10, 0));
				frame.setContentPane(panel);
				frame.setSize(500, 500);
				frame.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    }      
    public ArrayList<String> rechercher(String chemin) throws IOException{
		Algokmeans kmeans=new Algokmeans();
		Cluster cluster=new Cluster();
		 ArrayList<Data> dataSet=kmeans.dataSet;
		 ArrayList<String> path=new ArrayList<String>();
		 for(Data data:dataSet) {
			 if(chemin.equals(data.getchemin())) {
				 cluster=data.getCluster();
			 }
		 }
		 for(Data data:cluster.dataSet) {
			 path.add(data.getchemin());
		 }
		 return path;
	 }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void fermerMousePressed(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        System.exit(0);
    }                                   

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
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel RecupererClasse;
    private javax.swing.JPanel SelectionImage;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel classificationImageBarre;
    private javax.swing.JLabel classificationImageTitre;
    private javax.swing.JLabel fermer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel sidename;
    private javax.swing.JLabel text;
    // End of variables declaration                   
}