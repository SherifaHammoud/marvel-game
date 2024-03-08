package GUI;

import javax.swing.*;

import engine.*;

import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame implements ActionListener{
	
	JButton startGameButton;
	JTextField p1;
	JTextField p2;
	ImageIcon background;
	
	public GameWindow(){
		this.setTitle("Marvel Game");
		//this.getContentPane().setBackground(Color.black);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		background= new ImageIcon("Marvel.jpeg");
		
		p1=new JTextField("Enter your name");
		p1.setFont(new Font("MV Boli", Font.ITALIC, 12));
		p2=new JTextField("Enter your name");
		p2.setFont(new Font("MV Boli", Font.ITALIC, 12));
		this.add(p1);
		this.add(p2);
		JLabel l1=new JLabel("Player 1");
		l1.setFont(new Font("MV Boli", Font.BOLD, 17));
		l1.setVisible(true);
		l1.setBounds(500,75,300,100);
		p1.setBounds(500,150,300,100);
		JLabel l2=new JLabel("Player 2");
		l2.setFont(new Font("MV Boli", Font.BOLD, 17));
		l2.setVisible(true);
		l2.setBounds(500,225,300,100);
		p2.setBounds(500,300,300,100);
		
		this.add(l1);
		this.add(l2);
		startGameButton= new JButton("New Game");
		startGameButton.setFont(new Font("MV Boli", Font.BOLD, 19));
		startGameButton.addActionListener(this);
		//startGameButton.setPreferredSize(new Dimension(300,100));
		//startGameButton.setVerticalAlignment(FlowLayout.CENTER);
		//startGameButton.setHorizontalAlignment(FlowLayout.CENTER);
		startGameButton.setBounds(500, 450, 300, 100);
		//startGameButton.setBounds(0, 0, 420, 420);
		this.add(startGameButton);
		//startGameButton.setVisible(true);
		
		this.validate();
		this.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startGameButton) {
			Controller c=new Controller(p1.getText(),p2.getText());
			new ChampionChooserWindow(p1.getText(),p2.getText(),c);
			//Game g=new Game(new Player(p1.getText()),new Player(p2.getText()));
			//new GameBoardWindow(g);
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(background.getImage(),0, 0, this);
		
	}
	
}
