package kknd713.game.q4.entity.equip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import kknd713.game.q4.entity.effect.Effect;

public class Weapon {
	
	//空对象设计方法
	public static final Weapon NULL_WEAPON = new Weapon(){
		public String useWeapon(){
			return "";
		}
	};
	
	public String useWeapon(){
		return "用" + getName();
	}
	
	
	
	private int ap;
	private String name;
	private List<Effect> effects = new ArrayList<Effect>();
	
	public void addEffect(Effect effect){
		effects.add(effect);
	}
	
	public int getAp() {
		return ap;
	}
	
	public void setAp(int ap) {
		this.ap = ap;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Weapon(int ap, String name,List<Effect> effects) {
		super();
		this.ap = ap;
		this.name = name;
		this.effects = effects;
	}
	public Weapon() {
		super();
	}

	/**
	 * 一定几率触发武器特效
	 * @return
	 */
	public Effect trigger() {
		Collections.shuffle(effects);
		for (Effect effect : effects) {
			if(effect.getTriggerRate() <= getRandom()){
				return effect;
			}
		}
		return null;
	}

	private double getRandom() {
		return new Random().nextDouble();
	}
	
}
