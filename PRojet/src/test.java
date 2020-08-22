import java.awt.*;

import javax.swing.*;

public class test extends JFrame {

	test () {
		
		//JPanel p = new JPanel(new BorderLayout());
		
		JPanel pp = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		pp.add(new JLabel("Hello1..."));
//		pp.add(new JLabel("Hello2..."));
//		pp.add(new JLabel("Hello3..."));
//		pp.add(new JLabel("Hello4..."));
//		pp.add(new JLabel("Hello5..."));
		
		for ( int i = 0 ; i < 5 ; i++ )
			pp.add(new JLabel("Hello..."+i));
		
		JScrollPane d = new JScrollPane(pp);
		
	//	p.add(d, BorderLayout.CENTER);
		
		setSize(300, 300);
		getContentPane().add(d);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test f = new test();
	}

}
