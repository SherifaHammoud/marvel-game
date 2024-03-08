package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class ChooseYourLeaderWindow extends JFrame implements ActionListener{
	JPanel p;
	JPanel p2;
	JRadioButton r;
	JRadioButton r2;
	JRadioButton r3;
	JRadioButton r4;
	JRadioButton r5;
	JRadioButton r6;
	JButton start;
	Controller c;
	String firstLeader;
	String secondLeader;
	
	boolean f1=false;
	boolean f2=false;
	
	public ChooseYourLeaderWindow(String s1,String s2, Controller c) {
		
		this.c=c;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		firstLeader=null;
		secondLeader=null;
		
		
		Dimension ss=Toolkit.getDefaultToolkit().getScreenSize();
		double width=ss.getWidth();
		double height=ss.getHeight();
		
		ArrayList<String> firstPlayerTeam= c.getFirstPlayerTeam();
		ArrayList<String> secondPlayerTeam= c.getSecondPlayerTeam();
		
		r= new JRadioButton(firstPlayerTeam.get(0));
		r2= new JRadioButton(firstPlayerTeam.get(1));
		r3= new JRadioButton(firstPlayerTeam.get(2));
		r4= new JRadioButton(secondPlayerTeam.get(0));
		r5= new JRadioButton(secondPlayerTeam.get(1));
		r6= new JRadioButton(secondPlayerTeam.get(2));
		
		r.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		r5.addActionListener(this);
		r6.addActionListener(this);
	
		JLabel l= new JLabel(s1 + ", please choose your leader");
		l.setBounds(200, 250, 300, 50);
		p=new JPanel();
		p.setBackground(Color.orange);
		p.setLayout(null);
		p.setPreferredSize(new Dimension((int)(width/2), (int) (height/2)));
		p.add(r);
		p.add(r2);
		p.add(r3);
		p.add(l);
		r.setBounds(100, 400, 150, 100);
		r2.setBounds(300, 400, 150, 100);
		r3.setBounds(500, 400, 150, 100);
		this.add(p, BorderLayout.WEST);
		
		JLabel l2= new JLabel(s2+ ", please choose your leader");
		l2.setBounds(200, 250, 300, 50);
		start= new JButton("Start Game");
		start.setBounds(500, 700, 200,100);
		start.addActionListener(this);
		p2=new JPanel();
		p2.setBackground(Color.yellow);
		p2.setLayout(null);
		p2.setPreferredSize(new Dimension((int)(width/2), (int) (height/2)));
		p2.add(r4);
		p2.add(r5);
		p2.add(r6);
		p2.add(l2);
		p2.add(start);
		r4.setBounds(100, 400, 150, 100);
		r5.setBounds(300, 400, 150, 100);
		r6.setBounds(500, 400, 150, 100);
		this.add(p2, BorderLayout.EAST);
		
		JOptionPane.showMessageDialog(null, "Now choose your team's leader !"+ "\n"+"\n"+
				"Leader Abilities are not the same for all types of champions." + "\n"+"\n"+
						"Hero: Removes all negative effects from the player’s entire team and adds an Embrace effect to them which lasts for 2 turns." + "\n"+"\n"+
				"Villain: Immediately eliminates (knocks out) all enemy champions with less than 30% health points."+ "\n"+"\n"+
						"AntiHero: All champions on the board except for the leaders of each team will be stunned for 2 turns.", "Pick your champions !", JOptionPane.INFORMATION_MESSAGE);
				
		
		start.setEnabled(false);
		
		this.validate();
		this.repaint();
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//int counter;
		if(e.getSource()==r || e.getSource()==r2|| e.getSource()==r3) {
			for(int i=0; i<3; i++) {
				JRadioButton b= (JRadioButton)(p.getComponent(i));
				if(e.getSource()!=b) {
					b.setEnabled(false);
				}
				
			}
			firstLeader=((JRadioButton) e.getSource()).getText();
			f1=true;
		}
		if(e.getSource()==r4 || e.getSource()==r5|| e.getSource()==r6) {
			for(int i=0; i<3; i++) {
				JRadioButton b= (JRadioButton)(p2.getComponent(i));
				if(e.getSource()!=b) {
					b.setEnabled(false);
				}
				
			}
			secondLeader=((JRadioButton) e.getSource()).getText();
			f2=true;
		}
		
		if(f1 && f2) {
			start.setEnabled(true);
		}
		
		if(e.getSource()== start) {
			c.setLeaders(firstLeader,secondLeader);
			new GameBoardWindow(c);
			this.dispose();
		}
		
	}

}
