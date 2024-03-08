package GUI;

import java.awt.Color;



import javax.swing.*;

public class HealthBar extends JProgressBar{
	
	int maxHP;
	
	
	public HealthBar(int maxHP){
		//this.setMaximum(maxHP);
		//this.setStringPainted(true);
		//UIManager.put("JProgressBar.selectionBackground", Color.green);
		//UIManager.put("JProgressBar.selectionForeground", Color.white);
		this.setValue(100);
		//this.setBackground(Color.green);
		this.setOpaque(true);
		this.setBounds(10,10,50,10);
		this.setStringPainted(true);
		this.setForeground(Color.black);
		this.maxHP=maxHP;
		this.setString(maxHP+"");
		
		//this.setOpaque(true);
	}
	
	public void updateHP(int hp) {
		this.setString(""+hp);
		double x=(double) hp;
		double y=(double) maxHP;
		double newValue=(x/y)*100.0;
		
		this.setValue((int)newValue);
		
	}

}
