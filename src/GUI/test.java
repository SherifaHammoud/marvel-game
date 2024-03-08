package GUI;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class test extends JFrame {
	
	/*JPanel p;
	JPanel p2;
	JRadioButton r;
	JRadioButton r2;
	JRadioButton r3;
	JRadioButton r4;
	JRadioButton r5;
	JRadioButton r6;*/
	
	//HealthBar b;
	
	public test() {
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setLayout(null);
		
		
		JLabel l=new JLabel();
		this.setVisible(true);
		l.setBounds(100,100,100,100);
		ImageIcon i=new ImageIcon("Captain America.PNG");
		l.setIcon(i);
		this.add(l);
		
		
		/*b=new HealthBar(1000);
		b.setBounds(100,100,500,70);
		this.add(b);
		//double d=800;
		b.setValue((int) (800.0/1000.0*100));
		System.out.println((800/1000)*100);*/
		
		
		/*Dimension ss=Toolkit.getDefaultToolkit().getScreenSize();
		double width=ss.getWidth();
		double height=ss.getHeight();
		
		r= new JRadioButton();
		r2= new JRadioButton();
		r3= new JRadioButton();
		r4= new JRadioButton();
		r5= new JRadioButton();
		r6= new JRadioButton();
		
		p=new JPanel();
		p.setBackground(Color.orange);
		p.setLayout(null);
		p.setPreferredSize(new Dimension((int)(width/2), (int) (height/2)));
		p.add(r);
		p.add(r2);
		p.add(r3);
		r.setBounds(100, 300, 100, 100);
		r2.setBounds(250, 300, 100, 100);
		r3.setBounds(400, 300, 100, 100);
		this.add(p, BorderLayout.EAST);
		p2=new JPanel();
		p2.setBackground(Color.yellow);
		p2.setLayout(null);
		p2.setPreferredSize(new Dimension((int)(width/2), (int) (height/2)));
		p2.add(r4);
		p2.add(r5);
		p2.add(r6);
		r4.setBounds(100, 300, 100, 100);
		r5.setBounds(250, 300, 100, 100);
		r6.setBounds(400, 300, 100, 100);
		this.add(p2, BorderLayout.WEST);*/
		


		
		
		
		/*JButton b=new JButton("test");
		JButton b2=new JButton("test2");
		p2=new JPanel();
		this.add(p2, BorderLayout.NORTH);
		p2.add(b);
		p2.add(b2);
		b.addMouseListener(this);
		b2.addMouseListener(this);
		
		b.setBackground(Color.white);
		b.setOpaque(true);
		b2.setBackground(Color.white);
		b2.setOpaque(true);
		
		p.setBackground(Color.pink);
		p.setPreferredSize(new Dimension(1000,700));
		
		p.setLayout(new BorderLayout());
		JLabel l=new JLabel("hela");
		ImageIcon i=new ImageIcon("Hulk.jpeg");
		l.setIcon(i);
		l.setVisible(true);
		p.add(l, BorderLayout.CENTER);
		
		
		
		
		/*JLabel l= new JLabel("dddd");
		//l.setVisible(true);
		JProgressBar JB= new JProgressBar();
		JB.setStringPainted(true);
		JB.setValue(100);
		//l.add(JB);
		//this.add(l);
		JB.setVisible(true);
		//l.setPreferredSize(new Dimension(400,400));
		JB.setPreferredSize(new Dimension(150,150));
		
		JButton b=new JButton(); 
		this.add(b);
		b.add(JB);
		b.setLayout(null);
		JB.setBounds(900,100,150,150);*/
		/*JPanel p1=new JPanel();
		p1.setBackground(Color.black);
		this.add(p1,BorderLayout.WEST);
		p1.setPreferredSize(new Dimension(100,100));
		
		JPanel p2=new JPanel();
		p2.setBackground(Color.white);
		this.add(p2,BorderLayout.EAST);
		p1.setPreferredSize(new Dimension(100,100));
		
		JPanel p3=new JPanel();
		p3.setBackground(Color.magenta);
		this.add(p3,BorderLayout.NORTH);
		p1.setPreferredSize(new Dimension(100,100));
		
		JPanel p4=new JPanel();
		p4.setBackground(Color.green);
		this.add(p4,BorderLayout.SOUTH);
		p1.setPreferredSize(new Dimension(100,100));*/
		
		/*JButton b=new JButton("lol");
		this.add(b);
		b.setBounds(100,100,100,100);
		//JLabel l=new JLabel("s s s s s s s");
		//l.setBackground(Color.black);
		//l.setForeground(Color.white);
		//l.setLocation(, 700);
		//l.setVisible(true);
		//b.add(l);
		b.setToolTipText("s s s s  s"+"\n"+"\n"+"\n"+"\n"+"\n"+"s s s ss ");*/
		
	}


	/*public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==((JButton) p2.getComponent(0))) {
			JLabel l=new JLabel("test1");
			l.setBounds(100, 100, 200, 200);
			l.setVisible(true);
			p.add(l);
		} else if(e.getSource()==((JButton) p2.getComponent(1))) {
			JLabel l=new JLabel("test2");
			l.setBounds(100, 100, 200, 200);
			l.setVisible(true);
			p.add(l);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==((JButton) p2.getComponent(0))) {
			p.remove(p.getComponent(0));
		} else if(e.getSource()==((JButton) p2.getComponent(1))) {
			p.remove(p.getComponent(0));
		}
		
	}*/

}
