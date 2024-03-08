package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartWindow extends JFrame implements ActionListener{
	JLayeredPane p;
	JLabel l;
	JTextField text1;
	JTextField text2;
	public StartWindow() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		p= new JLayeredPane();
		this.add(p,BorderLayout.CENTER);
		l= new JLabel();
		l.setVisible(true);
		ImageIcon i= new ImageIcon("Marvel.jpeg");
		p.setLayout(null);
		Dimension ss=Toolkit.getDefaultToolkit().getScreenSize();
		double width=ss.getWidth();
		double height=ss.getHeight();
		System.out.println(width+" "+ height);
		l.setBounds(0, 0,1440,900 );
		//p.add(l,JLayeredPane.DEFAULT_LAYER);
		l.setIcon(i);
		l.setPreferredSize(new Dimension((int) width,(int)height));
		
		//text1= new JTextField("Enter your name");
		//text2= new JTextField("Enter your name");
		//p.add(text1,JLayeredPane.PALETTE_LAYER);
		//p.setLayer(text1, 1);
		//p.setLayer(l, 0);
		
		//p.add(text1,JLayeredPane.PALETTE_LAYER);
		//text1.setVisible(true);
		
		//JOptionPane welcome= new JOptionPane();
		//this.add(welcome);
		
		this.validate();
		this.repaint();
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
