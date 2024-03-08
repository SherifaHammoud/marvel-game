package model.effects;

import model.world.Champion;

public class Shock extends Effect {

	public Shock(int duration) {
		super("Shock", duration, EffectType.DEBUFF);
		
	}

	@Override
	public void apply(Champion c) {
		c.setSpeed((int) (c.getSpeed()*0.9));
		c.setAttackDamage((int) (c.getAttackDamage()*0.9));
		c.setCurrentActionPoints(c.getCurrentActionPoints()-1);
		c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn()-1);
		
		//quiz
		/*int newMana=(int) (c.getMana()-20);
		c.setMana(newMana);
		c.setSpeed((int) (c.getSpeed()*0.7));
		c.setAttackDamage((int) (c.getAttackDamage()*0.85));
		*/
	}

	@Override
	public void remove(Champion c) {
		c.setSpeed((int) (c.getSpeed()/0.9));
		c.setAttackDamage((int) (c.getAttackDamage()/0.9));
		c.setCurrentActionPoints(c.getCurrentActionPoints()+1);
		c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn()+1);
		
		//quiz
		/*c.setSpeed((int) (c.getSpeed()/0.7));
		c.setAttackDamage((int) (c.getAttackDamage()/0.85));*/
	}

}
