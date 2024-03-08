package GUI;

import javax.swing.*;

import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class GameBoardWindow extends JFrame implements ActionListener, MouseListener{
	JPanel board;
	
	JPanel player1Panel;
	JPanel player1Name;
	JPanel player1champion;
	
	JPanel player2Panel;
	JPanel player2Name;
	JPanel player2champion;
	
	JPanel turnOrderPanel;
	
	Controller controller;
	
	JPanel infoPanel;
	JPanel info;
	JPanel move;
	
	JLabel ch1; //player 1 champions
	JLabel ch2;
	JLabel ch3;
	
	JLabel ch4; //player 2 champions
	JLabel ch5;
	JLabel ch6;
	
	JLabel leaderAbilityLabel1;
	JLabel leaderAbilityLabel2;
	
	JLabel turnOrder;
	JLabel turn1;
	JLabel turn2;
	JLabel turn3;
	JLabel turn4;
	JLabel turn5;
	JLabel turn6;
	
	
	JButton attack1;
	JButton attack2;
	JLabel castAbility1;
	JLabel castAbility2;
	
	JButton ab1;
	JButton ab2;
	JButton ab3;
	JButton ab4;
	JButton ab5;
	JButton ab6;
	JButton lab1;
	JButton lab2;
	JButton punch1;
	JButton punch2;
	
	JButton endTurn1;
	JButton endTurn2;
	
	JButton up;
	JButton down;
	JButton left;
	JButton right;
	
	boolean attacking;
	boolean castingAbility;
	boolean singleTarget=false;
	String abilityChosen="";
	
	JButton newGame;
	
	
	public GameBoardWindow(Controller c) {
		controller=c;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.lightGray);
		
		board=new JPanel();
		player1Panel=new JPanel();
		player2Panel=new JPanel();
		turnOrderPanel=new JPanel();
		infoPanel= new JPanel();
		
		this.add(board,BorderLayout.CENTER);
		this.add(player1Panel, BorderLayout.WEST);
		this.add(player2Panel, BorderLayout.EAST);
		this.add(turnOrderPanel, BorderLayout.NORTH);
		this.add(infoPanel,BorderLayout.SOUTH);
		
		player1Panel.setPreferredSize(new Dimension(250,1000));
		player2Panel.setPreferredSize(new Dimension(250,1000));
		//board
		turnOrderPanel.setPreferredSize(new Dimension(200,80));
		infoPanel.setPreferredSize(new Dimension(100,170));
		
		//infoPanel.setBackground(Color.black);
		
		player1Panel.setLayout(null);
		player2Panel.setLayout(null);
		board.setLayout(new GridLayout(5,5));
		infoPanel.setLayout(new BorderLayout());
		turnOrderPanel.setLayout(null);
		
		for(int i=0; i<25; i++) {
			JButton b= new JButton();
			b.setLayout(new BorderLayout());
			b.setBackground(Color.white);
			b.setBorder(BorderFactory.createLineBorder(Color.black, 4));
			board.add(b);
			b.addActionListener(this);
			b.addMouseListener(this);
			b.setLayout(null);
		}
		
		
		
		
		
		
		
		player1Name=new JPanel();
		player1champion=new JPanel();
		player2Name=new JPanel();
		player2champion=new JPanel();
		
		player1Panel.add(player1Name);
		player1Panel.add(player1champion);
		player2Panel.add(player2Name);
		player2Panel.add(player2champion);
		
		JLabel player1= new JLabel(c.getFirstPlayer());
		player1.setVisible(true);
		JLabel player2= new JLabel(c.getSecondPlayer());
		player2.setVisible(true);
		player1Name.add(player1);
		player2Name.add(player2);
		
		//player1Name.setLayout(null);
		player1champion.setLayout(null);
		//player2Name.setLayout(null);
		player2champion.setLayout(null);
		
		player1Name.setBounds(0,0,250,50);
		player1champion.setBounds(0,50,250,580);
		player2Name.setBounds(0,0,250,50);
		player2champion.setBounds(0,50,250,580);
		
		
		player1Name.setBackground(Color.orange);
		player2Name.setBackground(Color.yellow);
		player1champion.setBackground(Color.orange);
		player2champion.setBackground(Color.yellow);
		infoPanel.setBackground(Color.black);
		
		attack1=new JButton("Attack");
		attack2=new JButton("Attack");
		attack1.setVisible(false);
		attack2.setVisible(false);
		attack1.setEnabled(false);
		attack1.setEnabled(false);
		player1champion.add(attack1);
		player2champion.add(attack2);
		attack1.setBounds(10,200,100,70);
		attack2.setBounds(10,200,100,70);
		
		castAbility1= new JLabel("Cast Ability:");
		castAbility2= new JLabel("Cast Ability:");
		castAbility1.setVisible(false);
		castAbility2.setVisible(false);
		player1champion.add(castAbility1);
		player2champion.add(castAbility2);
		castAbility1.setBounds(10,290,100,20);
		castAbility2.setBounds(10,290,100,20);
		
		ab1= new JButton();
		ab2= new JButton();
		ab3= new JButton();
		ab4= new JButton();
		ab5= new JButton();
		ab6= new JButton();
		lab1=new JButton("Use");
		lab1.addActionListener(this);
		lab2=new JButton("Use");
		lab2.addActionListener(this);
		ab1.setVisible(false);
		ab2.setVisible(false);
		ab3.setVisible(false);
		ab4.setVisible(false);
		ab5.setVisible(false);
		ab6.setVisible(false);
		ab1.setEnabled(false);
		ab2.setEnabled(false);
		ab3.setEnabled(false);
		ab4.setEnabled(false);
		ab5.setEnabled(false);
		ab6.setEnabled(false);
	    lab1.setVisible(false);
	    lab1.setEnabled(false);
		lab2.setVisible(false);
		lab2.setEnabled(false);
		player1champion.add(ab1);
		player1champion.add(ab2);
		player1champion.add(ab3);
		player1champion.add(lab1);
		ab1.setBounds(20, 320, 150, 25);
		ab1.addActionListener(this);
		ab2.setBounds(20, 350, 150, 25);
		ab2.addActionListener(this);
		ab3.setBounds(20, 380, 150, 25);
		ab3.addActionListener(this);
		lab1.setBounds(160, 5, 70, 25);
		player2champion.add(ab4);
		player2champion.add(ab5);
		player2champion.add(ab6);
		player2champion.add(lab2);
		ab4.setBounds(20, 320, 150, 25);
		ab4.addActionListener(this);
		ab5.setBounds(20, 350, 150, 25);
		ab5.addActionListener(this);
		ab6.setBounds(20, 380, 150, 25);
		ab6.addActionListener(this);
		lab2.setBounds(160, 5, 70, 25);
		
		
		punch1= new JButton("Punch");
		punch1.setBounds(20,410,150,25);
		player1champion.add(punch1);
		punch1.setVisible(false);
		punch1.addActionListener(this);
		punch2= new JButton("Punch");
		punch2.setBounds(20,410,150,25);
		player2champion.add(punch2);
		punch2.setVisible(false);
		punch2.addActionListener(this);
		
		
		endTurn1= new JButton("End Turn");
		endTurn2= new JButton("End Turn");
		endTurn1.setVisible(false);
		endTurn2.setVisible(false);
		endTurn1.setEnabled(false);
		endTurn2.setEnabled(false);
		player1champion.add(endTurn1);
		player2champion.add(endTurn2);
		endTurn1.setBounds(90, 510, 150, 50);
		endTurn2.setBounds(90, 510, 150, 50);
		endTurn1.addActionListener(this);
		endTurn2.addActionListener(this);
	

	
		leaderAbilityLabel1=new JLabel("Leader ability: not used");
		leaderAbilityLabel2=new JLabel("Leader ability: not used");
		leaderAbilityLabel1.setVisible(true);
		leaderAbilityLabel2.setVisible(true);
		player1champion.add(leaderAbilityLabel1);
		player2champion.add(leaderAbilityLabel2);
		leaderAbilityLabel1.setBounds(10,0,150,30);
		leaderAbilityLabel2.setBounds(10,0,150,30);
		
		
		
		
		
		
		
		
		turnOrderPanel.setLayout(null);
		
		turnOrder= new JLabel("Turn Order:");
		turn1= new JLabel("1");
		turn1.setOpaque(true);
		turn2= new JLabel("2");
		turn2.setOpaque(true);
		turn3= new JLabel("3");
		turn3.setOpaque(true);
		turn4= new JLabel("4");
		turn4.setOpaque(true);
		turn5= new JLabel("5");
		turn5.setOpaque(true);
		turn6= new JLabel("6");
		turn6.setOpaque(true);
		
		turnOrder.setVisible(true);
		turn1.setVisible(true);
		turn2.setVisible(true);
		turn3.setVisible(true);
		turn4.setVisible(true);
		turn5.setVisible(true);
		turn6.setVisible(true);
		
		turnOrderPanel.add(turnOrder);
		turnOrderPanel.add(turn1);	
		turnOrderPanel.add(turn2);
		turnOrderPanel.add(turn3);
		turnOrderPanel.add(turn4);
		turnOrderPanel.add(turn5);
		turnOrderPanel.add(turn6);
		
		turnOrder.setBounds(10, 20, 100 , 50);
		turn1.setBounds(120, 10, 150, 70);
		turn2.setBounds(330, 10, 150, 70);
		turn3.setBounds(540, 10, 150, 70);
		turn4.setBounds(750, 10, 150, 70);
		turn5.setBounds(960, 10, 150, 70);
		turn6.setBounds(1170, 10, 150, 70);
		
		
		
		
		
		
		info=new JPanel();
		move=new JPanel();
		
		infoPanel.add(info,BorderLayout.WEST);
		infoPanel.add(move,BorderLayout.EAST);
		
		info.setLayout(null);
		move.setLayout(null);
		
		info.setPreferredSize(new Dimension(1200,150));
		move.setPreferredSize(new Dimension(250,150));
		
		info.setBackground(Color.black);
		move.setBackground(Color.black);
		
		up= new JButton("Up");
		down= new JButton("Down");
		left= new JButton("Left");
		right= new JButton ("Right");
		move.add(up);
		move.add(down);
		move.add(left);
		move.add(right);
		up.addActionListener(this);
		down.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		up.setBounds(60, 10, 50, 50);
		left.setBounds(10, 50, 50, 50);
		right.setBounds(110, 50, 50, 50);
		down.setBounds(60, 100, 50, 50);
		
		
		attacking=false;
		castingAbility=false;
		attack1.addActionListener(this);
		attack2.addActionListener(this);
		
		
		setTurnOrderPanel();
		showCurrentChampionInfo();
		setBorder();
		if(controller.containsDisarm()) {
			if(controller.getFirstPlayerTeam().contains(controller.getCurrentChampion())){
				punch1.setVisible(true);
				attack1.setEnabled(false);
			}
			else {
				punch2.setVisible(true);
				attack2.setEnabled(false);
			}
		}
		
		
		/*newGame=new JButton("New Game");
		newGame.setVisible(true);
		newGame.setBounds(910, 50, 100, 150);
		newGame.addActionListener(this);
		info.add(newGame);*/
		
		
		
		String[] s= controller.getChampionsFromTeams(); //6 strings 
		putOnBoard(s);
		
		putCoversOnBoard();
		this.updateTurnOrderColor();
		
		//((JButton) board.getComponentAt(0,1)).setBackground(Color.black);
		//((JButton) board.getComponent(0)).setOpaque(true);
		
		
		JOptionPane j=new JOptionPane();
		j.showMessageDialog(null,  "How to play:"+ "\n"+"\n"+
				"Turn order is based on the champions' speed." + "\n"+"\n"+
				"You can move, attack, cast abilities."+ "\n"+"\n"+
				"The player who finishes off the other player's team first is the winner !"
				, "How to play", JOptionPane.INFORMATION_MESSAGE);
		
		
		this.validate();
		this.repaint();
	}

	
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(singleTarget==true) {
			JButton b=(JButton) e.getSource();
			int j=-1;
			for(int i=0; i<25; i++) {
				if(board.getComponent(i).equals(b)) {
					j=i;
				}
			}
			int[] xy= getCoordinateFromIndex(j);
			
			try {
				controller.castAbility(abilityChosen, xy[0], xy[1]);

			} catch (Exception exc) {
				JOptionPane x= new JOptionPane();
				x.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		    }
			
			this.removeCurrentChampionInfo();
			this.showCurrentChampionInfo();
			singleTarget=false;
			updateHPBars();
			checkDeadChampionsAndCovers();
			this.validate();
			this.repaint();
			return;
			
		}
		
		if(attacking==true) {
			if(e.getSource()== up) {
				try {
					controller.attack("Up");
				} catch(Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					//return;
				}
				this.removeCurrentChampionInfo();
				this.showCurrentChampionInfo();
				attacking=false;
				
			}else if(e.getSource()== down) {
				try {
					controller.attack("Down");
				} catch(Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					//return;
				}
				this.removeCurrentChampionInfo();
				this.showCurrentChampionInfo();
				attacking=false;
				
		   }else if(e.getSource()== left) {
				try {
					controller.attack("Left");
				} catch(Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					//return;
				}
				this.removeCurrentChampionInfo();
				this.showCurrentChampionInfo();
				attacking=false;
				
		   }else if(e.getSource()== right) {
				try {
					controller.attack("Right");
				} catch(Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					//return;
				}
				this.removeCurrentChampionInfo();
				this.showCurrentChampionInfo();
				attacking=false;
			}
			updateHPBars();
			checkDeadChampionsAndCovers();
			this.validate();
			this.repaint();
			return;
		}
		
		
		if(castingAbility==true) { //directional
			if(e.getSource()== up) {
				try {
					controller.castAbility(abilityChosen, "Up");
				} catch(Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
				this.removeCurrentChampionInfo();
				this.showCurrentChampionInfo();
				castingAbility=false;
				//return;
				
			}else if(e.getSource()== down) {
				try {
					controller.castAbility(abilityChosen, "Down");
				} catch(Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
				
				this.removeCurrentChampionInfo();
				this.showCurrentChampionInfo();
				castingAbility=false;
				//return;
				
		   }else if(e.getSource()== left) {
			   try {
					controller.castAbility(abilityChosen, "Left");
				} catch(Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
				
				this.removeCurrentChampionInfo();
				this.showCurrentChampionInfo();
				castingAbility=false;
				//return;
				
		   }else if(e.getSource()== right) {
			   try {
					controller.castAbility(abilityChosen, "Right");
				} catch(Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
				
				this.removeCurrentChampionInfo();
				this.showCurrentChampionInfo();
				castingAbility=false;
				//return;
		   }
			updateHPBars();
			checkDeadChampionsAndCovers();
			this.validate();
			this.repaint();
			return;
		}
		
		
		
		
		if(e.getSource()==lab1 || e.getSource()==lab2) {
			try {
				controller.useLeaderAbility();
			}catch(Exception exc) {
				JOptionPane j= new JOptionPane();
				j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
			
			if(e.getSource()==lab1) {
				lab1.setEnabled(false);
				leaderAbilityLabel1.setText("Leader ability: used");
			}else{
				lab2.setEnabled(false);
				leaderAbilityLabel2.setText("Leader ability: used");
			}
			
			this.removeCurrentChampionInfo();
			this.showCurrentChampionInfo();
			updateHPBars();
			checkDeadChampionsAndCovers();
			this.validate();
			this.repaint();
			return;
			
		}
		
		
		
		

		if(e.getSource()==endTurn1) {
			if(controller.containsDisarm()) {
				punch1.setVisible(false);
				attack1.setEnabled(true);
			}
			player1champion.remove(9);
			player1champion.remove(9);
			//colorChampion(controller.getCurrentChampion(),Color.black);
			controller.endTurn();
			attack1.setVisible(false);
			attack1.setEnabled(false);
			castAbility1.setVisible(false);
			ab1.setVisible(false);
			ab2.setVisible(false);
			ab3.setVisible(false);
			ab1.setEnabled(false);
			ab2.setEnabled(false);
			ab3.setEnabled(false);
			lab1.setVisible(false);
			lab1.setEnabled(false);
			endTurn1.setVisible(false);
			endTurn1.setEnabled(false);
			this.showCurrentChampionInfo();
			setBorder();
			updateTurnOrderColor();
			//this.setTurnOrderPanel();
			//checkDeadChampionsAndCovers();
			
		}else if(e.getSource()==endTurn2) {
			if(controller.containsDisarm()) {
				punch2.setVisible(false);
				attack2.setEnabled(true);
			}
			player2champion.remove(9);
			player2champion.remove(9);
			//colorChampion(controller.getCurrentChampion(),Color.black);
			controller.endTurn();
			attack2.setVisible(false);
			attack2.setEnabled(false);
			castAbility2.setVisible(false);
			ab4.setVisible(false);
			ab5.setVisible(false);
			ab6.setVisible(false);
			ab4.setEnabled(false);
			ab5.setEnabled(false);
			ab6.setEnabled(false);
			lab2.setVisible(false);
			lab2.setEnabled(false);
			endTurn2.setVisible(false);
			endTurn2.setEnabled(false);
			this.showCurrentChampionInfo();
			setBorder();
			updateTurnOrderColor();
			//this.setTurnOrderPanel();
			//checkDeadChampionsAndCovers();
			
		}
		
		
		//move
		String name=controller.getCurrentChampion();
		Point p=controller.getLocation(name);
		int before=this.getIndexFromCoordinate(p.x, p.y);
		if(e.getSource()==up) {
			try {
				controller.move("Up");
			} catch(Exception exc) {
				JOptionPane j= new JOptionPane();
				j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			moveChampion(0, before);
			this.removeCurrentChampionInfo();
			this.showCurrentChampionInfo();
			
		}else if(e.getSource()==down) {
			try {
				controller.move("Down");
			
			} catch(Exception exc) {
				JOptionPane j= new JOptionPane();
				j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			moveChampion(2, before);
			this.removeCurrentChampionInfo();
			this.showCurrentChampionInfo();
			
		}else if(e.getSource()==left) {
			try {
				controller.move("Left");
			
			} catch(Exception exc) {
				JOptionPane j= new JOptionPane();
				j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			moveChampion(3, before);
			this.removeCurrentChampionInfo();
			this.showCurrentChampionInfo();
			
		}else if(e.getSource()==right) {
			try {
				controller.move("Right");
			
			} catch(Exception exc) {
				JOptionPane j= new JOptionPane();
				j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			moveChampion(1, before);
			this.removeCurrentChampionInfo();
			this.showCurrentChampionInfo();
		}
		
		
		
		//attack
		if(e.getSource()==attack1) {
			attacking=true;
			JOptionPane j= new JOptionPane();
			j.showMessageDialog(this,  "Please choose a direction", "Direction", JOptionPane.INFORMATION_MESSAGE);
			return;
			
		}
		if(e.getSource()==attack2) {
			attacking=true;
			JOptionPane j= new JOptionPane();
			j.showMessageDialog(this,  "Please choose a direction", "Direction", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		
		

		//cast ability
		if(e.getSource()==ab1 || e.getSource()==ab2 || e.getSource()==ab3 || e.getSource()==ab4 || e.getSource()==ab5 || e.getSource()==ab6 || e.getSource()==punch1 || e.getSource()==punch2) {
			  String areaOfEffect;
			  String abilityName; //name
			  if(e.getSource()==ab1) {
				  areaOfEffect= controller.getAreaOfEffect(ab1.getText());
				  abilityName=ab1.getText();
				  
			  }else if(e.getSource()==ab2) {
				  areaOfEffect= controller.getAreaOfEffect(ab2.getText());
				  abilityName=ab2.getText();
				  
			  }else if(e.getSource()==ab3) {
				  areaOfEffect= controller.getAreaOfEffect(ab3.getText());
				  abilityName=ab3.getText();
				  
			  }else if(e.getSource()==ab4) {
				  areaOfEffect= controller.getAreaOfEffect(ab4.getText());
				  abilityName=ab4.getText();
				  
			  }else if(e.getSource()==ab5) {
				  areaOfEffect= controller.getAreaOfEffect(ab5.getText());
				  abilityName=ab5.getText();
				  
			  }else if(e.getSource()==ab6) {
				  areaOfEffect= controller.getAreaOfEffect(ab6.getText());
				  abilityName=ab6.getText();
				  
			  }else {
				  abilityName="Punch";
				  areaOfEffect="SINGLETARGET";
			  }
			  
			  
			  if(areaOfEffect.equals("DIRECTIONAL")) {
				  JOptionPane d= new JOptionPane();
				  d.showMessageDialog(this,  "Please choose a direction", "Direction", JOptionPane.INFORMATION_MESSAGE);
				  castingAbility=true;
				  abilityChosen=abilityName;
				  
					
			  }else if(areaOfEffect.equals("SINGLETARGET")){
				  
				  singleTarget=true;
				  abilityChosen=abilityName;
				  JOptionPane y= new JOptionPane();
				  y.showMessageDialog(this, "Please choose a champion or cover to cast this ability on","Single Target Ability", JOptionPane.INFORMATION_MESSAGE);
				  
				  /*JOptionPane x= new JOptionPane();
				  String x1=x.showInputDialog(this,"Please enter an accurate x coordinate", "X Coordinate");
				  JOptionPane y= new JOptionPane();
				  String y1=y.showInputDialog(this,"Please enter an accurate y coordinate", "Y Coordinate");
				  try {
					  System.out.println((int) Integer.parseInt(x1)+" "+(int)Integer.parseInt(y1));
					  controller.castAbility(abilityName, (int) Integer.parseInt(x1), (int)Integer.parseInt(y1));
	
				  } catch (Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				  }*/
				  
				  
				  
			  }else{
				  try {
					  controller.castAbility(abilityName);
				  } catch (Exception exc) {
					JOptionPane j= new JOptionPane();
					j.showMessageDialog(this, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				  }
			    
			  }
			  
			  updateHPBars();
			  this.checkDeadChampionsAndCovers();
			  this.removeCurrentChampionInfo();
			  this.showCurrentChampionInfo();
			  this.validate();
			  this.repaint();
			  
		}
		
		if(e.getSource()==newGame) {
			this.dispose();
		}
		
		this.validate();
		this.repaint();
	  
	}
	
	public void setBorder() {
		if(controller.getFirstPlayerTeam().contains(controller.getCurrentChampion())) {
			for(int i=0;i<controller.getFirstPlayerTeam().size();i++) {
				this.colorChampion(controller.getFirstPlayerTeam().get(i), new Color(0,153,76));
			}
			for(int i=0;i<controller.getSecondPlayerTeam().size();i++) {
				this.colorChampion(controller.getSecondPlayerTeam().get(i), new Color(204,0,0));
			}
		
		}else if(controller.getSecondPlayerTeam().contains(controller.getCurrentChampion())) {
			for(int i=0;i<controller.getSecondPlayerTeam().size();i++) {
				this.colorChampion(controller.getSecondPlayerTeam().get(i), new Color(0,153,76));
			}
			for(int i=0;i<controller.getFirstPlayerTeam().size();i++) {
				this.colorChampion(controller.getFirstPlayerTeam().get(i), new Color(204,0,0));
			}
		
		}
		
		this.colorChampion(controller.getCurrentChampion(), Color.GREEN);
	}
	
	
	
	
	public void colorChampion(String name, Color c){
		Point p=controller.getLocation(name);
		int i=this.getIndexFromCoordinate(p.x, p.y);
		JButton b=(JButton) board.getComponent(i);
		b.setBorder(BorderFactory.createLineBorder(c, 5));
	}
	
	
	public void moveChampion(int d, int beforeIndex) {

		String name=controller.getCurrentChampion();
		JLabel l=getLabelByNameChampionsOnBoard(name);
		Point p=controller.getLocation(name);
		int afterIndex=getIndexFromCoordinate(p.x,p.y);
		
		JButton beforeButton=(JButton) board.getComponent(beforeIndex);
		
		JButton afterButton=(JButton) board.getComponent(afterIndex);
		
		beforeButton.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		afterButton.setBorder(BorderFactory.createLineBorder(Color.green, 5));
		
		putObjectHere(l,afterIndex);

		beforeButton.remove(l);
		HealthBar pb=(HealthBar) beforeButton.getComponent(0);
		afterButton.add(pb);
		beforeButton.remove(pb);
		
		this.validate();
		this.repaint();
		
		
	}
	
	
	public void removeCurrentChampionInfo() {

		String current=controller.getCurrentChampion();
		if(controller.getFirstPlayerTeam().contains(current)) {
			player1champion.remove(9);
			player1champion.remove(9);
		}else {
			player2champion.remove(9);
			player2champion.remove(9);
		}
	}
	
	
	
	private void putOnBoard(String[] s) {
		ch1=new JLabel(s[0]);
		addIcon(ch1,21);
		ch1.setVisible(true);
		
		ch2=new JLabel(s[1]);
		addIcon(ch2,22);
		ch2.setVisible(true);
		
		ch3=new JLabel(s[2]);
		addIcon(ch3,23);
		ch3.setVisible(true);
		
		ch4=new JLabel(s[3]);
		addIcon(ch4,1);
		ch4.setVisible(true);
		
		ch5=new JLabel(s[4]);
		addIcon(ch5,2);
		ch5.setVisible(true);
		
		ch6=new JLabel(s[5]);
		addIcon(ch6,3);
		ch6.setVisible(true);
		
		
		/*ch1.setLocation(1,4);
		ch2.setLocation(2,4);
		ch3.setLocation(3,4);
		
		ch4.setLocation(1,0);
		ch5.setLocation(2,0);
		ch6.setLocation(3,0);*/
		ArrayList<Point> p=controller.pointsOfChampions();
		int p1=this.getIndexFromCoordinate(p.get(0).x, p.get(0).y);
		int p2=this.getIndexFromCoordinate(p.get(1).x, p.get(1).y);
		int p3=this.getIndexFromCoordinate(p.get(2).x, p.get(2).y);
		int p4=this.getIndexFromCoordinate(p.get(3).x, p.get(3).y);
		int p5=this.getIndexFromCoordinate(p.get(4).x, p.get(4).y);
		int p6=this.getIndexFromCoordinate(p.get(5).x, p.get(5).y);
		
		putObjectHere(ch1,p1);
		HealthBar hb1=new HealthBar(controller.getHP(0,1));
		((JButton) board.getComponent(p1)).add(hb1);
		
		putObjectHere(ch2,p2);
		HealthBar hb2=new HealthBar(controller.getHP(0,2));
		((JButton) board.getComponent(p2)).add(hb2);
		
		putObjectHere(ch3,p3);
		HealthBar hb3=new HealthBar(controller.getHP(0,3));
		((JButton) board.getComponent(p3)).add(hb3);
		
		putObjectHere(ch4,p4);
		HealthBar hb4=new HealthBar(controller.getHP(4,1));
		((JButton) board.getComponent(p4)).add(hb4);
		
		putObjectHere(ch5,p5);
		HealthBar hb5=new HealthBar(controller.getHP(4,2));
		((JButton) board.getComponent(p5)).add(hb5);
		
		putObjectHere(ch6,p6);
		HealthBar hb6=new HealthBar(controller.getHP(4,3));
		((JButton) board.getComponent(p6)).add(hb6);
	}
	
	private void putObjectHere(JLabel ch, int i) {
		((JButton) board.getComponent(i)).add(ch,BorderLayout.CENTER);
		ch.setBounds(50, 20, 200, 150);
		
		
	}
	
	public void addIcon(JLabel l,int i) {
		String name=l.getText();
		//l.setVisible(false);
		//l.setBounds(200,200,0,0);
		//JButton b=(JButton) board.getComponent(i);
		this.textthing(l);
		if(name.equals("Captain America")) {
			l.setIcon(new ImageIcon("Captain America.PNG"));
		}else if(name.equals("Deadpool")) {
			l.setIcon(new ImageIcon("Deadpool.PNG"));
		}else if(name.equals("Dr Strange")) {
			l.setIcon(new ImageIcon("Dr Strange.PNG"));
		}else if(name.equals("Electro")) {
			l.setIcon(new ImageIcon("Eelectro.PNG"));
		}else if(name.equals("Ghost Rider")) {
			l.setIcon(new ImageIcon("Ghost Rider.PNG"));
		}else if(name.equals("Hela")) {
			l.setIcon(new ImageIcon("Hela.PNG"));
		}else if(name.equals("Hulk")) {
			l.setIcon(new ImageIcon("Hulk.PNG"));
		}else if(name.equals("Iceman")) {
			l.setIcon(new ImageIcon("Iceman.PNG"));
		}else if(name.equals("Ironman")) {
			l.setIcon(new ImageIcon("Ironman.PNG"));
		}else if(name.equals("Loki")) {
			l.setIcon(new ImageIcon("Loki.PNG"));
		}else if(name.equals("Quicksilver")) {
			l.setIcon(new ImageIcon("Quicksilver.PNG"));
		}else if(name.equals("Spiderman")) {
			l.setIcon(new ImageIcon("Spider-man.PNG"));
		}else if(name.equals("Thor")) {
			l.setIcon(new ImageIcon("Thor.PNG"));
		}else if(name.equals("Venom")) {
			l.setIcon(new ImageIcon("Venom.PNG"));
		}else if(name.equals("Yellow Jacket")) {
			l.setIcon(new ImageIcon("YellowJacket.PNG"));
		}
	}
	
	private void putCoversOnBoard() {
		ArrayList<Point> points= controller.pointsOfCovers();
		for(int i=0;i<points.size();i++) {
			int j=getIndexFromCoordinate(points.get(i).x,points.get(i).y);
			JLabel cover=new JLabel("Cover");
			cover.setVisible(true);
			cover.setIcon(new ImageIcon("Cover.PNG"));
			((JButton) board.getComponent(j)).add(cover);
			HealthBar hb= new HealthBar(controller.getHP(points.get(i).x,points.get(i).y));
			((JButton) board.getComponent(j)).add(hb);
			cover.setBounds(40, 20, 100, 100);
			cover.setVerticalTextPosition(JLabel.BOTTOM);
			cover.setHorizontalTextPosition(JLabel.RIGHT);
			cover.setIconTextGap(0);
		}
	}
	
	public void textthing(JLabel l) {
		l.setVerticalTextPosition(JLabel.BOTTOM);
		l.setHorizontalTextPosition(JLabel.CENTER);
		l.setIconTextGap(0);
	}
	
	
	
	public static int getIndexFromCoordinate(int x, int y) { //
		return (20-(5*x)+y);
	}
	
	public static int[] getCoordinateFromIndex(int i) {
		int[] xy=new int[2];
		for(int j=0;j<5;j++) {
			for(int k=0;k<5;k++) {
				if(getIndexFromCoordinate(j,k)==i) {
					xy[0]=j;
					xy[1]=k;
				}
			}
		}
		return xy;
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
		for(int i=0;i<25;i++) {
			JButton b= (JButton)(board.getComponent(i));
			if(b.getComponentCount()!=0) {
				if(e.getSource()==b) {
					JLabel x=(JLabel) b.getComponent(0);
					String s;
					if(x.getText().equals("Cover")) {
						s=controller.getInfoOnCover(getCoordinateFromIndex(i));
					}else {
						s=controller.getInfoOnChampion(x.getText());
						String ae=controller.getAppliedEffects(x.getText());
						JTextArea aeT=new JTextArea(ae);
						info.add(aeT);
						aeT.setBounds(500,0,400,400);
						aeT.setVisible(true);
						aeT.setForeground(Color.white);
						aeT.setOpaque(true);
						aeT.setBackground(Color.black);
					}
					JTextArea l=new JTextArea(s);
					info.add(l);
					l.setBounds(0,0,500,400);
					l.setVisible(true);
					l.setForeground(Color.white);
					l.setOpaque(true);
					l.setBackground(Color.black);
					info.validate();
					info.repaint();
				}
			}
		}
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		for(int i=0;i<25;i++) {
			JButton b= (JButton)(board.getComponent(i));
			if(b.getComponentCount()!=0) {
				if(e.getSource()==b) {
					JLabel x=(JLabel) b.getComponent(0);
					Component component=info.getComponent(0);
					info.removeAll();
					info.validate();
					info.repaint();
				}
			}
		}
	}
	
	public void setTurnOrderPanel() {
		
		ArrayList<String> turnOrder=controller.returnTurnOrder();
		
		turn1.setText(turnOrder.get(0));
		turn1.setFont(new Font("Courier",Font.BOLD,18));
		turn2.setText(turnOrder.get(1));
		turn2.setFont(new Font("Courier",Font.BOLD,18));
		turn3.setText(turnOrder.get(2));
		turn3.setFont(new Font("Courier",Font.BOLD,18));
		turn4.setText(turnOrder.get(3));
		turn4.setFont(new Font("Courier",Font.BOLD,18));
		turn5.setText(turnOrder.get(4));
		turn5.setFont(new Font("Courier",Font.BOLD,18));
		turn6.setText(turnOrder.get(5));
		turn6.setFont(new Font("Courier",Font.BOLD,18));
		
		this.validate();
		this.repaint();
		
	}
	
	
	public void showCurrentChampionInfo() {
		String current=controller.getCurrentChampion();
		ArrayList<String> s=controller.getCurrentChampionInfo();
		if(controller.getFirstPlayerTeam().contains(current)) {
			if(controller.isLeader()) {
				lab1.setVisible(true);
				if(leaderAbilityLabel1.getText().equals("Leader ability: not used")) {
					lab1.setEnabled(true);
				}
			}
			attack1.setVisible(true);
			attack1.setEnabled(true);
			castAbility1.setVisible(true);
			ab1.setVisible(true);
			ab2.setVisible(true);
			ab3.setVisible(true);
			ab1.setEnabled(true);
			ab2.setEnabled(true);
			ab3.setEnabled(true);
			ab1.setText(s.get(2));
			ab2.setText(s.get(3));
			ab3.setText(s.get(4));
			ab1.setToolTipText(controller.getInfoOnAbility(ab1.getText()));
			ab2.setToolTipText(controller.getInfoOnAbility(ab2.getText()));
			ab3.setToolTipText(controller.getInfoOnAbility(ab3.getText()));
			endTurn1.setVisible(true);
			endTurn1.setEnabled(true);
			showCurrentChampionInfoHelper(player1champion,s);
			if(controller.containsDisarm()) {
				punch1.setVisible(true);
				attack1.setEnabled(false);
			}
			
			
		}else {
			if(controller.isLeader()) {
				lab2.setVisible(true);
				if(leaderAbilityLabel2.getText().equals("Leader ability: not used")) {
					lab2.setEnabled(true);
				}
			}
			attack2.setVisible(true);
			attack2.setEnabled(true);
			castAbility2.setVisible(true);
			ab4.setVisible(true);
			ab5.setVisible(true);
			ab6.setVisible(true);
			ab4.setEnabled(true);
			ab5.setEnabled(true);
			ab6.setEnabled(true);
			ab4.setText(s.get(2));
			ab5.setText(s.get(3));
			ab6.setText(s.get(4));
			ab4.setToolTipText(controller.getInfoOnAbility(ab4.getText()));
			ab5.setToolTipText(controller.getInfoOnAbility(ab5.getText()));
			ab6.setToolTipText(controller.getInfoOnAbility(ab6.getText()));
			endTurn2.setVisible(true);
			endTurn2.setEnabled(true);
			showCurrentChampionInfoHelper(player2champion,s);
			if(controller.containsDisarm()) {
				punch2.setVisible(true);
				attack2.setEnabled(false);
			}
			
			
		}
		this.validate();
		this.repaint();
		
	}
	
	public void showCurrentChampionInfoHelper(JPanel p,ArrayList<String> s) {
		JTextArea info =new JTextArea(s.get(0));
		JTextArea attackText =new JTextArea(s.get(1));
		p.add(info);
		info.setBounds(10,55,250,150);
		p.add(attackText);
		attackText.setBounds(110, 210, 150, 50);
		this.validate();
		this.repaint();
		
	}
	
	
	
	public JLabel getLabelByNameTurnOrder (String s) {
		if(s.equals(turn1.getText())) {
			return turn1;
		} else if(s.equals(turn2.getText())) {
			return turn2;
		} else if(s.equals(turn3.getText())) {
			return turn3;
		}else if(s.equals(turn4.getText())) {
			return turn4;
		} else if(s.equals(turn5.getText())) {
			return turn5;
		} else
			return turn6;
	}
	
	public JLabel getLabelByNameChampionsOnBoard(String s) {
		if(s.equals(ch1.getText())) {
			return ch1;
		} else if(s.equals(ch2.getText())) {
			return ch2;
		} else if(s.equals(ch3.getText())) {
			return ch3;
		}else if(s.equals(ch4.getText())) {
			return ch4;
		} else if(s.equals(ch5.getText())) {
			return ch5;
		} else
			return ch6;
	}
	
	public void checkDeadChampionsAndCovers() {
		ArrayList<Integer> indexes=controller.checkDeadChampionsAndCovers(board);
		ArrayList<String> names=new ArrayList<String>();
		
		for(int i=0;i<indexes.size();i++) {
			JButton b=(JButton) board.getComponent(indexes.get(i));
			String name=((JLabel) (b.getComponent(0))).getText();
			names.add(name);
			b.removeAll();
		}
		
		for(int i=0;i<names.size();i++) {
			
			
			
			if(!names.get(i).equals("Cover")) {
				if(names.get(i).equals(turn1.getText())) {
					turn1.setText("");
					//turn1.setBackground(Color.white);
					turn1.setIcon(null);
				}else if(names.get(i).equals(turn2.getText())) {
					turn2.setText("");
					//turn2.setBackground(Color.white);
					turn2.setIcon(null);
				}else if(names.get(i).equals(turn3.getText())) {
					turn3.setText("");
					//turn3.setBackground(Color.white);
					turn3.setIcon(null);
				}else if(names.get(i).equals(turn4.getText())) {
					turn4.setText("");
					//turn4.setBackground(Color.white);
					turn4.setIcon(null);
				}else if(names.get(i).equals(turn5.getText())) {
					turn5.setText("");
					//turn5.setBackground(Color.white);
					turn5.setIcon(null);
				}else {
					turn6.setText("");
					//turn6.setBackground(Color.white);
					turn6.setIcon(null);
				}
				
				this.colorChampion(names.get(i), Color.black);
			}
		}
		
		int gameOver=controller.checkGameOver();
		if(gameOver==0) {
			JOptionPane j= new JOptionPane();
			j.showMessageDialog(this, (String)controller.getFirstPlayer()+ " wins" ,"Game Winner", JOptionPane.INFORMATION_MESSAGE);
			//newGame.setVisible(true);
			this.dispose();
		}
		else if(gameOver==1) {
			JOptionPane j= new JOptionPane();
			j.showMessageDialog(this, (String)controller.getSecondPlayer()+ " wins" ,"Game Winner", JOptionPane.INFORMATION_MESSAGE);
			//newGame.setVisible(true);
			this.dispose();
		}
		
		this.validate();
		this.repaint();
		
	}
	
	public void updateTurnOrderColor() {
		if(turn1.getText().equals(controller.getCurrentChampion())) {
			turn1.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
			turn2.setBorder(BorderFactory.createEmptyBorder());
			turn3.setBorder(BorderFactory.createEmptyBorder());
			turn4.setBorder(BorderFactory.createEmptyBorder());
			turn5.setBorder(BorderFactory.createEmptyBorder());
			turn6.setBorder(BorderFactory.createEmptyBorder());
		}else if(turn2.getText().equals(controller.getCurrentChampion())) {
			turn2.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
			turn1.setBorder(BorderFactory.createEmptyBorder());
			turn3.setBorder(BorderFactory.createEmptyBorder());
			turn4.setBorder(BorderFactory.createEmptyBorder());
			turn5.setBorder(BorderFactory.createEmptyBorder());
			turn6.setBorder(BorderFactory.createEmptyBorder());
		}else if(turn3.getText().equals(controller.getCurrentChampion())) {
			turn3.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
			turn2.setBorder(BorderFactory.createEmptyBorder());
			turn1.setBorder(BorderFactory.createEmptyBorder());
			turn4.setBorder(BorderFactory.createEmptyBorder());
			turn5.setBorder(BorderFactory.createEmptyBorder());
			turn6.setBorder(BorderFactory.createEmptyBorder());
		}else if(turn4.getText().equals(controller.getCurrentChampion())) {
			turn4.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
			turn2.setBorder(BorderFactory.createEmptyBorder());
			turn3.setBorder(BorderFactory.createEmptyBorder());
			turn1.setBorder(BorderFactory.createEmptyBorder());
			turn5.setBorder(BorderFactory.createEmptyBorder());
			turn6.setBorder(BorderFactory.createEmptyBorder());
		} else if(turn5.getText().equals(controller.getCurrentChampion())) {
			turn5.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
			turn2.setBorder(BorderFactory.createEmptyBorder());
			turn3.setBorder(BorderFactory.createEmptyBorder());
			turn4.setBorder(BorderFactory.createEmptyBorder());
			turn1.setBorder(BorderFactory.createEmptyBorder());
			turn6.setBorder(BorderFactory.createEmptyBorder());
		}else {
			turn6.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
			turn2.setBorder(BorderFactory.createEmptyBorder());
			turn3.setBorder(BorderFactory.createEmptyBorder());
			turn4.setBorder(BorderFactory.createEmptyBorder());
			turn5.setBorder(BorderFactory.createEmptyBorder());
			turn1.setBorder(BorderFactory.createEmptyBorder());
		}
	}
	
	public void updateHPBars() {
		for(int i=0;i<25;i++) {
			JButton b=((JButton)board.getComponent(i));
			
			if(b.getComponentCount()!=0) {
				int[] xy=this.getCoordinateFromIndex(i);
				int hp=controller.getHP(xy[0],xy[1]);
				((HealthBar) b.getComponent(1)).updateHP(hp);
				/*if(hp==0) {
					b.remove(1);
				}else {
					((HealthBar) b.getComponent(1)).updateHP(hp);
				}*/
			}
		}
		this.validate();
		this.repaint();
	}
	
}
