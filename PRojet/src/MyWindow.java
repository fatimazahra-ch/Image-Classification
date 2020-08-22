import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyWindow extends JFrame {
	/*** fonctionnement****/
	protected AlgoKMeans kMeans;
	protected ArrayList<Float> errors=new ArrayList<Float>();
	protected static String data_chemin;
	protected ArrayList<String> chemins=new ArrayList<String>();
	
	/*** interface *****/
	protected JButton selectionner= new JButton("selectionner");
	protected JFrame frame = new JFrame();
    protected JScrollPane lesClassesDimages = new JScrollPane();
    
    protected JPanel sideBarre = new JPanel();
    protected JPanel recupererClasse = new JPanel();
    protected JPanel SelectionnerImage = new JPanel();
    protected JPanel TauxErrors = new JPanel();
    private javax.swing.JPanel bg;
    private javax.swing.JPanel classificationImageBarre;
    private javax.swing.JLabel classificationImageTitre;
    private javax.swing.JLabel fermer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    
    public MyWindow() {
        initComponents();
    }
                            
    private void initComponents() {

    	 bg = new JPanel();
         classificationImageBarre = new JPanel();
         classificationImageTitre = new JLabel();

         jButton1 = new JButton();
         jLabel1 = new JLabel();
         
         jButton2 = new JButton();
         jLabel2 = new JLabel();
         
         jButton3 = new JButton();
         jLabel3 = new JLabel();
         
         JLabel Menu = new JLabel();
         jSeparator1 = new JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        bg.setBackground(new Color(255, 255, 255));
   
        lesClassesDimages.setBackground(new java.awt.Color(255, 255, 255));
        lesClassesDimages.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        lesClassesDimages.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        sideBarre.setBackground(new Color(40, 24, 50));
        /******** Selectionner Image****/
        SelectionnerImage.setBackground(new Color(64, 43, 100));

        jButton1.setBackground(new Color(64, 43, 100));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText(">");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
                //jButton1.setBackground(new java.awt.Color(85, 65, 118));
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Sélectionner une image");

        javax.swing.GroupLayout SelectionnerImageLayout = new javax.swing.GroupLayout(SelectionnerImage);
        SelectionnerImage.setLayout(SelectionnerImageLayout);
        SelectionnerImageLayout.setHorizontalGroup(
            SelectionnerImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectionnerImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SelectionnerImageLayout.setVerticalGroup(
            SelectionnerImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectionnerImageLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jButton1.getAccessibleContext().setAccessibleName("");
        /********* recuperer Classe *****/
        recupererClasse.setBackground(new java.awt.Color(85, 65, 118)); //new java.awt.Color(85, 65, 118)

        jButton2.setBackground(new java.awt.Color(85, 65, 118));
        jButton2.setFont(new Font("Segoe UI", 1, 20)); 
        jButton2.setForeground(new Color(204, 204, 204));
        jButton2.setText(">");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jButton2MouseClicked(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Récuperer toutes les classes");

        javax.swing.GroupLayout recupererClasseLayout = new javax.swing.GroupLayout(recupererClasse);
        recupererClasse.setLayout(recupererClasseLayout);
        recupererClasseLayout.setHorizontalGroup(
            recupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        recupererClasseLayout.setVerticalGroup(
            recupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        /***** Taux Errors******/
        TauxErrors.setBackground(new Color(64, 43, 100));

        jButton3.setBackground(new Color(64, 43, 100));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 20)); 
        jButton3.setForeground(new Color(204, 204, 204));
        jButton3.setText(">");
        jButton3.setBorder(null);
//        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                try {
//					jButton3MouseClicked(evt);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//            }
//        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("TauxErrors");

        javax.swing.GroupLayout TauxErrorsClasseLayout = new javax.swing.GroupLayout(TauxErrors);
        TauxErrors.setLayout(TauxErrorsClasseLayout);
        TauxErrorsClasseLayout.setHorizontalGroup(
        		TauxErrorsClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TauxErrorsClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        TauxErrorsClasseLayout.setVerticalGroup(
        		TauxErrorsClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TauxErrorsClasseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(TauxErrorsClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        Menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Menu.setForeground(new java.awt.Color(204, 204, 204));
        Menu.setText("Menu");

        javax.swing.GroupLayout sideBarreLayout = new javax.swing.GroupLayout(sideBarre);
        sideBarre.setLayout(sideBarreLayout);
        sideBarreLayout.setHorizontalGroup(
            sideBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recupererClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SelectionnerImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TauxErrors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sideBarreLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Menu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        sideBarreLayout.setVerticalGroup(
            sideBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarreLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(recupererClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SelectionnerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TauxErrors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        SelectionnerImage.getAccessibleContext().setAccessibleName("jButton1");
        
        /******* la barre du classification**********/
        classificationImageBarre.setBackground(new Color(110, 89, 222));

        classificationImageTitre.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        classificationImageTitre.setForeground(new Color(204, 204, 204));
        classificationImageTitre.setText("La classification des images");

        GroupLayout classificationImageBarreLayout = new GroupLayout(classificationImageBarre);
        classificationImageBarre.setLayout(classificationImageBarreLayout);
        classificationImageBarreLayout.setHorizontalGroup(
            classificationImageBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classificationImageBarreLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(classificationImageTitre)
                .addContainerGap(893, Short.MAX_VALUE))
        );
        classificationImageBarreLayout.setVerticalGroup(
            classificationImageBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classificationImageBarreLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(classificationImageTitre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        
        /*******le layout du contentPane global*****/
        GroupLayout bgLayout = new GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sideBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                		.addComponent(classificationImageBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 1000,javax.swing.GroupLayout.DEFAULT_SIZE)
                		.addComponent(lesClassesDimages, javax.swing.GroupLayout.PREFERRED_SIZE, 1000,javax.swing.GroupLayout.DEFAULT_SIZE)
                    ))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(20, 20, 20) //43
                .addComponent(classificationImageBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lesClassesDimages))
            .addComponent(sideBarre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        /***le layout du frame********/
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        setSize(500, 500);
        pack();
    }                      

    private void jButton1MouseClicked(MouseEvent evt) { 
    	JPanel panel = new JPanel();
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
	    chooser.setFileFilter(filter);
	    panel.setLayout(new FlowLayout());
	    if( chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ) 
	          try {
	            data_chemin = new String("C:/fatimazahra CHARJANE/S3/JAVA Dev/Classification images/K-means/img/"+chooser.getSelectedFile().getName());
				chemins = this.rechercher(data_chemin);
				Image[] img = new Image[1000];
				JLabel[] pimg = new JLabel[1000];
				ImageIcon imageicon;
				
				for ( int i = 0 ; i < chemins.size() ; i++ ) {
					imageicon = new ImageIcon(chemins.get(i));
		         	pimg[i] = new JLabel();
                    pimg[i].setIcon(imageicon);
         			panel.add(pimg[i]);
				}
				lesClassesDimages.setViewportView(panel);
				
		        lesClassesDimages.setBackground(new java.awt.Color(255, 255, 255));
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    }      

    private void  jButton2MouseClicked(MouseEvent evt) throws IOException {                                         
    	JPanel panel = new JPanel();
    	AlgoKMeans kmeans = new AlgoKMeans();
    	JLabel[] classes = new JLabel[kmeans.clusters.size()];
    	//panel.setLayout(new GridLayout(20,0));
    	panel.setLayout(new GridLayout(10,0));
    	
    	JPanel[] folowImages = new JPanel[kmeans.clusters.size()];
    	JPanel[] folowImages1 = new JPanel[kmeans.clusters.size()];
    	
		JLabel[] pimg = new JLabel[kMeans.dataSet.size()];
		ImageIcon imageicon;
		ArrayList<String> path ;
		int i = 0;
		
    	for(Cluster cluster : kmeans.clusters) {
    		classes[i] = new JLabel("Classe " + i);
    		classes[i].setBackground(new Color(255, 255, 255));
    		classes[i].setPreferredSize(new Dimension(100,100));
    		classes[i].setFont(new java.awt.Font("Segoe UI", 1, 14));
    		
    		//panel.add(classes[i]);
    		path = new ArrayList<String>();
    		for(Data data:cluster.dataSet) {
    			 path.add(data.getchemin());
    		}
    		
    		
    		folowImages1[i] = new JPanel(new BorderLayout());
    		
    		folowImages[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
    		
    		for ( int j = 0 ; j < path.size() ; j++ ) {
				imageicon = new ImageIcon(path.get(j));
			    pimg[j] = new JLabel();
	            pimg[j].setIcon(imageicon);
	            folowImages[i].add(pimg[j]);
			}
    		
    		folowImages1[i].add(classes[i], BorderLayout.NORTH);
    		folowImages1[i].add(folowImages[i], BorderLayout.CENTER);
    		
    		panel.add(folowImages1[i]);
    		i++;
    	}
    	lesClassesDimages.setViewportView(panel);
        lesClassesDimages.setBackground(new java.awt.Color(255, 255, 255));
    } 
    
    public ArrayList<String> rechercher(String chemin) throws IOException{
    	kMeans = new AlgoKMeans();
		Cluster cluster = new Cluster();
		 ArrayList<Data> dataSet = kMeans.dataSet;
		 ArrayList<String> path = new ArrayList<String>();
		 for(Data data:dataSet) {
			 if(chemin.equals(data.getchemin())) {
				 cluster = data.getCluster();
			 }
		 }
		 for(Data data:cluster.dataSet) {
			 path.add(data.getchemin());
		 }
		 return path;
	 }
  /*  private void jButton3MouseClicked(MouseEvent evt) throws IOException { 
    	kMeans = new AlgoKMeans();
    	errors=kMeans.errors;
		ArrayList<String> l1 = new ArrayList<String>();
		ArrayList<String> l2 = new ArrayList<String>();
		l2.add("");
		l1.add("Classe1");
		l1.add("Classe2");
		l1.add("Classe3");
		l1.add("Classe4");
		l1.add("Classe5");
		l1.add("Classe6");
		l1.add("Classe7");
		l1.add("Classe8");
		l1.add("Classe9");
		l1.add("Classe10");
		freechart free = new freechart("Taux d'erreur", "x", "y", Color.white, l2, l1, true,errors);

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(10,10,900,700);
		f.add(free);
		f.setVisible(true);
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
                if ("Windows".equals(info.getName())) {
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
   
    // End of variables declaration                   
}










/*import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyWindow extends JFrame {

	protected JButton selectionner= new JButton("selectionner");
	protected static String data_chemin;
	protected ArrayList<String> chemins=new ArrayList<String>();
	protected Panel pane;
	protected JPanel panel = new JPanel();
	protected JFrame frame = new JFrame();
    protected JScrollPane lesClassesDimages = new JScrollPane();
    protected JScrollBar vjsp = lesClassesDimages.getVerticalScrollBar();
    protected JScrollBar hjsp = lesClassesDimages.getHorizontalScrollBar();
    protected JPanel sideBarre = new JPanel();
    protected JPanel recupererClasse = new JPanel();
    
    public MyWindow() {
        initComponents();
    }
                            
    private void initComponents() {

    	 bg = new JPanel();
         classificationImageBarre = new JPanel();
         classificationImageTitre = new JLabel();
         jButton2 = new JButton();
         jLabel2 = new JLabel();
         JPanel SelectionnerImage = new JPanel();
         jButton1 = new JButton();
         jLabel1 = new JLabel();
         JLabel Menu = new JLabel();
         jSeparator1 = new JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        bg.setBackground(new Color(255, 255, 255));
   
        lesClassesDimages.setBackground(new java.awt.Color(255, 255, 255));
        lesClassesDimages.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        lesClassesDimages.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        panel.setBackground(new java.awt.Color(255, 255, 255));
        GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        
        sideBarre.setBackground(new Color(40, 24, 50));

        recupererClasse.setBackground(new Color(64, 43, 100));

        jButton2.setBackground(new Color(64, 43, 100));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 30)); 
        jButton2.setForeground(new Color(204, 204, 204));
        jButton2.setText("+");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jButton2MouseClicked(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Récuperer une image");

        javax.swing.GroupLayout recupererClasseLayout = new javax.swing.GroupLayout(recupererClasse);
        recupererClasse.setLayout(recupererClasseLayout);
        recupererClasseLayout.setHorizontalGroup(
            recupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        recupererClasseLayout.setVerticalGroup(
            recupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        SelectionnerImage.setBackground(new java.awt.Color(85, 65, 118));

        jButton1.setBackground(new java.awt.Color(85, 65, 118));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("-");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Sélectionner une image");

        javax.swing.GroupLayout SelectionnerImageLayout = new javax.swing.GroupLayout(SelectionnerImage);
        SelectionnerImage.setLayout(SelectionnerImageLayout);
        SelectionnerImageLayout.setHorizontalGroup(
            SelectionnerImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectionnerImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SelectionnerImageLayout.setVerticalGroup(
            SelectionnerImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectionnerImageLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jButton1.getAccessibleContext().setAccessibleName("");

        Menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Menu.setForeground(new java.awt.Color(204, 204, 204));
        Menu.setText("Menu");

        javax.swing.GroupLayout sideBarreLayout = new javax.swing.GroupLayout(sideBarre);
        sideBarre.setLayout(sideBarreLayout);
        sideBarreLayout.setHorizontalGroup(
            sideBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recupererClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SelectionnerImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sideBarreLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Menu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        sideBarreLayout.setVerticalGroup(
            sideBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarreLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(recupererClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SelectionnerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        SelectionnerImage.getAccessibleContext().setAccessibleName("jButton1");

        classificationImageBarre.setBackground(new Color(110, 89, 222));

        classificationImageTitre.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        classificationImageTitre.setForeground(new Color(204, 204, 204));
        classificationImageTitre.setText("La classification des images");

        GroupLayout classificationImageBarreLayout = new GroupLayout(classificationImageBarre);
        classificationImageBarre.setLayout(classificationImageBarreLayout);
        classificationImageBarreLayout.setHorizontalGroup(
            classificationImageBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classificationImageBarreLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(classificationImageTitre)
                .addContainerGap(893, Short.MAX_VALUE))
        );
        classificationImageBarreLayout.setVerticalGroup(
            classificationImageBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classificationImageBarreLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(classificationImageTitre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        
        GroupLayout bgLayout = new GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sideBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(classificationImageBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(lesClassesDimages)))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(43, 43, 43) //43
                .addComponent(classificationImageBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lesClassesDimages))
            .addComponent(sideBarre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      

    private void jButton1MouseClicked(MouseEvent evt) {                                         
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
	    chooser.setFileFilter(filter);
	    panel.setLayout(new FlowLayout());
	    if( chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ) 
	          try {
	            data_chemin = new String("E:/JAVA Dev/Classification images/K-means/img/"+chooser.getSelectedFile().getName());
				chemins = this.rechercher(data_chemin);
				Image[] img = new Image[1000];
				JLabel[] pimg = new JLabel[1000];
				ImageIcon imageicon;
				
				for ( int i = 0 ; i < chemins.size() ; i++ ) {
					imageicon = new ImageIcon(chemins.get(i));
		         	pimg[i] = new JLabel();
                    pimg[i].setIcon(imageicon);
         			panel.add(pimg[i]);
				}
				lesClassesDimages.setViewportView(panel);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    }      

    private void  jButton2MouseClicked(MouseEvent evt) throws IOException {                                         
        
    	AlgoKMeans kmeans = new AlgoKMeans();
    	JLabel[] classes = new JLabel[kmeans.clusters.size()];
    	//panel.setLayout(new GridLayout(20,0));
    	panel.setLayout(new GridLayout(10,0));
    	
    	JPanel[] folowImages = new JPanel[10];
    	JPanel[] folowImages1 = new JPanel[10];
    	
		JLabel[] pimg = new JLabel[1000];
		ImageIcon imageicon;
		ArrayList<String> path ;//= new ArrayList<String>();
		int i = 0;
		
    	for(Cluster cluster : kmeans.clusters) {
    		classes[i] = new JLabel("Classe " + i);
    		classes[i].setBackground(new Color(255, 255, 255));
    		classes[i].setPreferredSize(new Dimension(100,100));
    		classes[i].setFont(new java.awt.Font("Segoe UI", 1, 14));
    		
    		//panel.add(classes[i]);
    		path = new ArrayList<String>();
    		for(Data data:cluster.dataSet) {
    			 path.add(data.getchemin());
    		}
    		
    		
    		folowImages1[i] = new JPanel(new BorderLayout());
    		
    		folowImages[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
    		
    		for ( int j = 0 ; j < path.size() ; j++ ) {
				imageicon = new ImageIcon(path.get(j));
			    pimg[j] = new JLabel();
	            pimg[j].setIcon(imageicon);
	            folowImages[i].add(pimg[j]);
			}
    		
    		folowImages1[i].add(classes[i], BorderLayout.NORTH);
    		folowImages1[i].add(folowImages[i], BorderLayout.CENTER);
    		
    		panel.add(folowImages1[i]);
    		i++;
    	}
    	lesClassesDimages.setViewportView(panel);
    } 
    
    public ArrayList<String> rechercher(String chemin) throws IOException{
		AlgoKMeans kmeans = new AlgoKMeans();
		Cluster cluster = new Cluster();
		 ArrayList<Data> dataSet = kmeans.dataSet;
		 ArrayList<String> path = new ArrayList<String>();
		 for(Data data:dataSet) {
			 if(chemin.equals(data.getchemin())) {
				 cluster = data.getCluster();
			 }
		 }
		 for(Data data:cluster.dataSet) {
			 path.add(data.getchemin());
		 }
		 return path;
	 }

//    private void fermerMousePressed(java.awt.event.MouseEvent evt) {                                    
//        // TODO add your handling code here:
//        System.exit(0);
//    }                                   

    /**
     * @param args the command line arguments
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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

        /* Create and display the form 
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
}*/
