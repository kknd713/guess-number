package kknd713.game.q3.entity;

import kknd713.game.q3.entity.equip.Armor;
import kknd713.game.q3.entity.equip.Weapon;

public abstract class Sprite {
	protected String name;
	protected int ap;
	protected int hp;
	protected Weapon weapon;
	protected Armor armor;
	protected String jobName;
	
	public boolean isAlive() {
		return hp > 0;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	protected void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public Armor getArmor() {
		return armor;
	}
	protected void setArmor(Armor armor) {
		this.armor = armor;
	}
	public int getDp() {
		if (armor == null) {
			return 0;
		}
		return armor.getDp();
	}
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAp() {
		return ap;
	}
	public void setAp(int ap) {
		this.ap = ap;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String useWeapon(){
		return weapon == null ? "" : "用" + weapon.getName();
	}
	
	
	public Sprite(String name, int ap, int hp, Weapon weapon,
			Armor armor, String jobName) {
		super();
		this.name = name;
		this.ap = ap;
		this.hp = hp;
		this.weapon = weapon;
		this.armor = armor;
		this.jobName = jobName;
	}
	
	public int attack(Sprite other){
		int additionalAP = this.weapon == null ? 0 : this.weapon.getAp();
		int harm = this.ap + additionalAP - other.getDp();
		int hp = other.getHp() - harm;
		other.setHp(hp);
		if (hp < 0) {
			other.setHp(0);
		}
		/*
		if (hp <= 0) {
			hp = 0;
			other.setHp(hp);
			//out.println(other.getName() + "被打败了!");
		}else {
			//out.printf("%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
			//		jobName,this.name, 
			//		other.getJobName(),other.getName(), 
			//		other.getName(),harm, other.getName(), hp);
		}
		*/
		return harm;
	}
}
