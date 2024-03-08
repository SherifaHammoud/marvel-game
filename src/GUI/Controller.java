package GUI;

import javax.swing.*;

import engine.*;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.*;
import model.world.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
	Game g;

	public Controller(String s1, String s2) {

		g = new Game(new Player(s1), new Player(s2));

		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
		} catch (IOException e) {

		}

	}

	public void addToTeam(int i, int counter) {
		Champion c = g.getAvailableChampions().get(i);
		if (counter < 4) {
			g.getFirstPlayer().getTeam().add(c);
			return;
		}
		g.getSecondPlayer().getTeam().add(c);
	}

	public String getInfoOnChampion(String name) {
		// Champion c=g.getAvailableChampions().get(i);

		// if(name.equals("Punch")

		Champion c = championByName(name);
		if (c == null) {
			return "";
		}
		
		if(c.getCurrentHP()==0) {
			return "Name: " + c.getName()+"\n"
					+"HP: 0"+"\n"
					+"Dead";
		}
		
		
		String type = "";
		if (c instanceof Hero) {
			type = "Hero";
		} else if (c instanceof AntiHero) {
			type = "AntiHero";
		} else {
			type = "Villain";
		}
		String s = "Name: " + c.getName() + "\n" + "Type: " + type + "\n" + "MaxHP: " + c.getMaxHP() + "\n"
				+ "CurrentHP: " + c.getCurrentHP() + "\n" + "Mana: " + c.getMana() + "\n" + "Action points per turn: "
				+ c.getMaxActionPointsPerTurn() + "\n" + "Attack range: " + c.getAttackRange() + "\n"
				+ "Attack damage: " + c.getAttackDamage() + "\n" + "Speed: " + c.getSpeed() + "\n" + "Abilities: "
				+ c.getAbilities().get(0).getName() + ", " + c.getAbilities().get(1).getName() + ", "
				+ c.getAbilities().get(2).getName();
		return s;

	}

	public String getInfoOnCover(int[] xy) {
		Object[][] b = g.getBoard();
		if(b[xy[0]][xy[1]]==null) {
			return "HP: 0";
		}
		Cover c = (Cover) b[xy[0]][xy[1]];
		return "HP: " + c.getCurrentHP();
	}

	public String getInfoOnAbility(String name) {
		Ability a = g.findAbilityByName(name);

		String type;
		String amount = "";
		if (a instanceof HealingAbility) {
			type = "Healing Ability";
			amount += "Heal Amount: " + ((HealingAbility) a).getHealAmount();
		} else if (a instanceof DamagingAbility) {
			type = "Damaging Ablity";
			amount += "Damage Amount: " + ((DamagingAbility) a).getDamageAmount();
		} else {
			type = "Crowd Control Ability";
			amount += "<html><p Height=\"500\">" + "Effect: " + ((CrowdControlAbility) a).getEffect().getName() + "<br>"
					+ "Effect Duration: " + ((CrowdControlAbility) a).getEffect().getDuration() + "<br>"
					+ "Effect Type: " + ((CrowdControlAbility) a).getEffect().getType().name();
		}
		String s = "<html><p Height=\"500\">" + "Type: " + type + "<br>" + "Area Of Effect: " + a.getCastArea() + "<br>"
				+ "Cast Range: " + a.getCastRange() + "<br>" + "Mana: " + a.getManaCost() + "<br>" + "Action Cost: "
				+ a.getRequiredActionPoints() + "<br>" + "Base Cooldown: " + a.getBaseCooldown() + "<br>"
				+ "Current Cooldown: " + a.getCurrentCooldown() + "<br>" + amount;

		return s;
	}

	public boolean isLeader() {
		Champion c = g.getCurrentChampion();
		if (g.getFirstPlayer().getLeader().equals(c) || g.getSecondPlayer().getLeader().equals(c)) {
			return true;
		}
		return false;
	}

	public String getAppliedEffects(String name) {
		Champion c = championByName(name);
		if (c == null) {
			return "";
		}
		String ae = "Applied Effects: ";
		for (int i = 0; i < c.getAppliedEffects().size(); i++) {
			ae += c.getAppliedEffects().get(i).getName() + " for " + c.getAppliedEffects().get(i).getDuration()
					+ " rounds" + "\n";
		}
		return ae;
	}

	public String[] getChampionsFromTeams() {
		String[] champions = new String[6];
		int counter = 0;
		for (int i = 0; i < g.getFirstPlayer().getTeam().size(); i++) {
			champions[counter] = g.getFirstPlayer().getTeam().get(i).getName();
			counter++;
		}
		for (int i = 0; i < g.getSecondPlayer().getTeam().size(); i++) {
			champions[counter] = g.getSecondPlayer().getTeam().get(i).getName();
			counter++;
		}

		return champions;
	}

	public ArrayList<Point> pointsOfCovers() {
		Object[][] boardtmp = g.getBoard();
		ArrayList<Point> points = new ArrayList<Point>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (boardtmp[i][j] instanceof Cover) {
					points.add(((Cover) boardtmp[i][j]).getLocation());
				}
			}
		}
		return points;
	}
	
	
	
	public ArrayList<Point> pointsOfChampions(){
		Object[][] boardtmp = g.getBoard();
		ArrayList<Point> points = new ArrayList<Point>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (boardtmp[i][j] instanceof Champion) {
					points.add(((Champion) boardtmp[i][j]).getLocation());
				}
			}
		}
		return points;
	}
	

	public void setGame() {
		g.placeChampions();
		g.prepareChampionTurns();
	}

	public Point getLocation(String name) { //champions only
		Champion c = championByName(name);
		if(c==null) {
			return null;
		}
		Point p=c.getLocation();
		return p;
	}

	public ArrayList<String> getFirstPlayerTeam() {
		ArrayList<String> firstPlayerTeam = new ArrayList<String>();
		for (int i = 0; i < g.getFirstPlayer().getTeam().size(); i++) {
			firstPlayerTeam.add(g.getFirstPlayer().getTeam().get(i).getName());
		}
		return firstPlayerTeam;
	}

	public ArrayList<String> getSecondPlayerTeam() {
		ArrayList<String> secondPlayerTeam = new ArrayList<String>();
		for (int i = 0; i < g.getSecondPlayer().getTeam().size(); i++) {
			secondPlayerTeam.add(g.getSecondPlayer().getTeam().get(i).getName());
		}
		return secondPlayerTeam;
	}

	public Champion championByName(String name) {
		for (int i = 0; i < g.getAvailableChampions().size(); i++) {
			if (g.getAvailableChampions().get(i).getName().equals(name)) {
				return g.getAvailableChampions().get(i);
			}
		}
		/*
		 * for(int i=0; i<g.getFirstPlayer().getTeam().size(); i++) {
		 * if(g.getFirstPlayer().getTeam().get(i).getName().equals(name)) { return
		 * g.getFirstPlayer().getTeam().get(i); } } for(int i=0;
		 * i<g.getSecondPlayer().getTeam().size(); i++) {
		 * if(g.getSecondPlayer().getTeam().get(i).getName().equals(name)) { return
		 * g.getSecondPlayer().getTeam().get(i); } }
		 */
		return null;
	}

	public ArrayList<String> getCurrentChampionInfo() {
		Champion c = g.getCurrentChampion();
		ArrayList<String> l = new ArrayList<String>();
		String type = "";
		if (c instanceof Hero) {
			type = "Hero";
		} else if (c instanceof AntiHero) {
			type = "AntiHero";
		} else {
			type = "Villain";
		}
		String s1 = c.getName() + " ( " + type + " ) " + "\n" + "HP: " + c.getCurrentHP() + "\n" + "Mana: "
				+ c.getMana() + "\n" + "Action Points: " + c.getCurrentActionPoints() + "\n" +
				"Applied Effects: ";
		for (int i = 0; i < c.getAppliedEffects().size(); i++) {
			s1 += c.getAppliedEffects().get(i).getName() + " ("
					+ c.getAppliedEffects().get(i).getDuration() + " )";
			if (i + 1 != c.getAppliedEffects().size()) {
				s1 += ", ";
			}
		}

		String s2 = "Attack Damage: " + c.getAttackDamage() + "\n" + "Attack Range: " + c.getAttackRange();

		String ab1 = c.getAbilities().get(0).getName();
		String ab2 = c.getAbilities().get(1).getName();
		String ab3 = c.getAbilities().get(2).getName();

		l.add(s1);
		l.add(s2);
		l.add(ab1);
		l.add(ab2);
		l.add(ab3);

		return l;

	}

	public void setLeaders(String firstLeader, String secondLeader) {
		g.getFirstPlayer().setLeader(championByName(firstLeader));
		g.getSecondPlayer().setLeader(championByName(secondLeader));

	}

	public String getFirstPlayer() {
		return g.getFirstPlayer().getName();
	}

	public String getSecondPlayer() {
		return g.getSecondPlayer().getName();
	}

	public String getCurrentChampion() {
		return g.getCurrentChampion().getName();
	}

	public void endTurn() {
		g.endTurn();
	}

	public void move(String s) throws NotEnoughResourcesException, UnallowedMovementException {
		if (s.equals("Up")) {
			g.move(Direction.UP);
		} else if (s.equals("Down")) {
			g.move(Direction.DOWN);
		} else if (s.equals("Left")) {
			g.move(Direction.LEFT);
		} else {
			g.move(Direction.RIGHT);
		}
	}

	public void attack(String s) throws NotEnoughResourcesException, ChampionDisarmedException, InvalidTargetException {
		if (s.equals("Up")) {
			g.attack(Direction.UP);
		} else if (s.equals("Down")) {
			g.attack(Direction.DOWN);
		} else if (s.equals("Left")) {
			g.attack(Direction.LEFT);
		} else {
			g.attack(Direction.RIGHT);
		}

	}

	public String getAreaOfEffect(String a) {
		if (a.equals("Punch")) {
			return "SINGLETARGET";
		}
		Ability ab = g.findAbilityByName(a);
		String s = ab.getCastArea().toString();
		return s;
	}

	public void castAbility(String a)
			throws NotEnoughResourcesException, AbilityUseException, CloneNotSupportedException {
		Ability ab = g.findAbilityByName(a);
		g.castAbility(ab);
	}

	public void castAbility(String a, String s)
			throws NotEnoughResourcesException, AbilityUseException, CloneNotSupportedException {
		Ability ab = g.findAbilityByName(a);
		if (s.equals("Up")) {
			g.castAbility(ab, Direction.UP);
		} else if (s.equals("Down")) {
			g.castAbility(ab, Direction.DOWN);
		} else if (s.equals("Left")) {
			g.castAbility(ab, Direction.LEFT);
		} else {
			g.castAbility(ab, Direction.RIGHT);
		}
	}

	public void castAbility(String a, int x, int y) throws NotEnoughResourcesException, AbilityUseException,
			InvalidTargetException, CloneNotSupportedException {
		Ability ab;
		if(a.equals("Punch")) {
			ab=g.getCurrentChampion().getAbilities().get(3);
			
		}else {
			ab = g.findAbilityByName(a);
		}
		g.castAbility(ab, x, y);

	}

	public void useLeaderAbility() throws LeaderNotCurrentException, LeaderAbilityAlreadyUsedException {
		g.useLeaderAbility();
	}

	public boolean containsDisarm() {
		if (g.hasEffect(g.getCurrentChampion(),"Disarm")) {
			return true;
		}
		return false;
	}
	
	
	
	
	public ArrayList<Integer> checkDeadChampionsAndCovers(JPanel p) {
		Object[][] board=g.getBoard();
		ArrayList<Integer> indexes=new ArrayList<Integer>();
		//int count=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				JButton b=(JButton) p.getComponent(GameBoardWindow.getIndexFromCoordinate(i,j));
				if(board[i][j]==null && b.getComponentCount()!=0) {
					indexes.add(GameBoardWindow.getIndexFromCoordinate(i, j));
					//count++;
				}
			}
		}
		return indexes;
	}
	
	
	public ArrayList<String> returnTurnOrder() {
		ArrayList<String> names=new ArrayList<String>();
		
		PriorityQueue temp=new PriorityQueue(6);
		PriorityQueue turnOrder=g.getTurnOrder();
		
		while(!turnOrder.isEmpty()) {
			names.add(((Champion) turnOrder.peekMin()).getName());
			temp.insert(turnOrder.remove());
		}
		while(!temp.isEmpty()) {
			turnOrder.insert(temp.remove());
		}
		
		return names;
	}
	
	public int checkGameOver() {
		if(g.checkGameOver()==null) {
			return -1;
		}
		else if(g.checkGameOver().getName().equals(this.getFirstPlayer())){
			return 0;
		}
		else {
			return 1;
		}
	}
	
	
	public int getHP(int x, int y) {
		Object[][] board=g.getBoard();
		if(board[x][y]==null) {
			return 0;
		}
		Damageable d=(Damageable)board[x][y];
		return d.getCurrentHP();
	}


}
