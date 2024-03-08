package GUI;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class ChampionChooserWindow extends JFrame implements MouseListener, ActionListener {
	
	JPanel p1;
	JPanel p2;
	JPanel champions;
	Controller controller;
	JPanel infoPanel;
	int counter=0;
	JButton next;
	ImageIcon hulk;
	
	String player1;
	String player2;
	
	//JPanel p;
	
	public ChampionChooserWindow(String s1,String s2, Controller c) {
		controller=c;
		
		p1=new JPanel();
		p2=new JPanel();
		champions=new JPanel();
		infoPanel=new JPanel();
		
		next=new JButton("Next");
		next.setEnabled(false);
		next.addActionListener(this);
		
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(next,BorderLayout.EAST);
		
		p1.setLayout(null);
		p2.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		this.add(p1,BorderLayout.WEST);
		p1.setBackground(Color.pink);
		p1.setPreferredSize(new Dimension(300,700));
		
		this.add(p2,BorderLayout.EAST);
		p2.setBackground(Color.pink);
		p2.setPreferredSize(new Dimension(300,700));
		
		this.add(champions,BorderLayout.CENTER);
		champions.setBackground(Color.white);
		champions.setPreferredSize(new Dimension(500,700));
		
		this.add(infoPanel,BorderLayout.SOUTH);
		infoPanel.setPreferredSize(new Dimension(1000,175));
		infoPanel.setBackground(Color.black);
		
		champions.setLayout(new FlowLayout());
		
		
		for(int i=0; i<15; i++) {
			JButton b= new JButton();
			b.setPreferredSize(new Dimension(250,125));
			b.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			champions.add(b);
			//b.setToolTipText(s);
			//JLabel info= new JLabel(s);
			//info.setBackground(Color.white);
			//info.setForeground(Color.black);
			//info.setVisible(false);
			//b.add(info);
			
			
			
			b.addActionListener(this);
			b.addMouseListener(this);
		}
		
		this.putChampionsOnButtons();
		player1= s1;
		player2= s2;
		
		
		JLabel l1=new JLabel(player1+ "'s Team:");
		l1.setVisible(true);
		p1.add(l1);
		l1.setBounds(70,30,200,70);
		
		JLabel l2=new JLabel(player2+ "'s Team:");
		l2.setVisible(true);
		p2.add(l2);
		l2.setBounds(70,30,200,70);
		
		JOptionPane j=new JOptionPane();
		j.showMessageDialog(null,  player1+" pick 3 champions for your team !", "Pick your champions !", JOptionPane.INFORMATION_MESSAGE);
		
		
		this.validate();
		this.repaint();
		
	}
	
	private void putChampionsOnButtons() {
		((JButton) champions.getComponent(0)).setText("Captain America");
		((JButton) champions.getComponent(0)).setIcon(new ImageIcon("Captain America.PNG"));
		((JButton) champions.getComponent(1)).setText("Deadpool");
		((JButton) champions.getComponent(1)).setIcon(new ImageIcon("Deadpool.PNG"));
		((JButton) champions.getComponent(2)).setText("Dr Strange");
		((JButton) champions.getComponent(2)).setIcon(new ImageIcon("Dr Strange.PNG"));
		((JButton) champions.getComponent(3)).setText("Electro");
		((JButton) champions.getComponent(3)).setIcon(new ImageIcon("Eelectro.PNG"));
		((JButton) champions.getComponent(4)).setText("Ghost Rider");
		((JButton) champions.getComponent(4)).setIcon(new ImageIcon("Ghost Rider.PNG"));
		((JButton) champions.getComponent(5)).setText("Hela");
		((JButton) champions.getComponent(5)).setIcon(new ImageIcon("Hela.PNG"));
		((JButton) champions.getComponent(6)).setText("Hulk");
		((JButton) champions.getComponent(6)).setIcon(new ImageIcon("Hulk.PNG"));
		((JButton) champions.getComponent(7)).setText("Iceman");
		((JButton) champions.getComponent(7)).setIcon(new ImageIcon("Iceman.PNG"));
		((JButton) champions.getComponent(8)).setText("Ironman");
		((JButton) champions.getComponent(8)).setIcon(new ImageIcon("Ironman.PNG"));
		((JButton) champions.getComponent(9)).setText("Loki");
		((JButton) champions.getComponent(9)).setIcon(new ImageIcon("Loki.PNG"));
		((JButton) champions.getComponent(10)).setText("Quicksilver");
		((JButton) champions.getComponent(10)).setIcon(new ImageIcon("Quicksilver.PNG"));
		((JButton) champions.getComponent(11)).setText("Spiderman");
		((JButton) champions.getComponent(11)).setIcon(new ImageIcon("Spider-man.PNG"));
		((JButton) champions.getComponent(12)).setText("Thor");
		((JButton) champions.getComponent(12)).setIcon(new ImageIcon("Thor.PNG"));
		((JButton) champions.getComponent(13)).setText("Venom");
		((JButton) champions.getComponent(13)).setIcon(new ImageIcon("Venom.PNG"));
		((JButton) champions.getComponent(14)).setText("Yellow Jacket");
		((JButton) champions.getComponent(14)).setIcon(new ImageIcon("YellowJacket.PNG"));
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
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
		for(int i=0;i<champions.getComponentCount();i++) {
			JButton b=(JButton)champions.getComponent(i);
			if(e.getSource()==b) {
				String s=controller.getInfoOnChampion(b.getText());
				JTextArea l=new JTextArea(s);
				infoPanel.add(l,BorderLayout.CENTER);
				l.setVisible(true);
				l.setForeground(Color.white);
				l.setOpaque(true);
				l.setBackground(Color.black);
				infoPanel.validate();
				infoPanel.repaint();
				
				
			}
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for(int i=0;i<champions.getComponentCount();i++) {
			JButton b=(JButton)champions.getComponent(i);
			if(e.getSource()==b) {
				Component c=infoPanel.getComponent(1);
				infoPanel.remove(c);
				infoPanel.validate();
				infoPanel.repaint();
				
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==next) {
			controller.setGame(); /////////////////////??????????????????????????
			//this.removeAll();
			new ChooseYourLeaderWindow(player1, player2,controller);
			//this.add(p);
			//new GameBoardWindow(controller);
			this.dispose();
			
		}
		
		if(counter==6) {
			return;
		}
		for(int i=0;i<champions.getComponentCount();i++) {
			JButton b=(JButton) champions.getComponent(i);
			if(e.getSource()==b) {
				counter++;
				controller.addToTeam(i,counter);
				b.setEnabled(false);
				JLabel l=new JLabel(b.getText());
				l.setBackground(Color.CYAN);
				l.setVisible(true);
				l.setPreferredSize(new Dimension(100,100));
				addToPanel(l);
				
				if(counter==3) {
					JOptionPane j=new JOptionPane();
					j.showMessageDialog(null,  player2+" pick 3 champions for your team !", "Pick your champions !", JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(counter==6) {
					//System.out.println("op");
					next.setEnabled(true);
				}
				
			}
			
		}
		
		
		
		
	}
	
	private void addToPanel(JLabel l) {
		switch(counter) {
		case 1: p1.add(l); l.setBounds(70,125,200,70); break;
		case 2: p1.add(l); l.setBounds(70,275,200,70); break;
		case 3: p1.add(l); l.setBounds(70,425,200,70); break;
		case 4: p2.add(l); l.setBounds(70,125,200,70); break;
		case 5: p2.add(l); l.setBounds(70,275,200,70); break;
		case 6: p2.add(l); l.setBounds(70,425,200,70); break;
		}
	}

}
