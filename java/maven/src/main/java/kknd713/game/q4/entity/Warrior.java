package kknd713.game.q4.entity;

import java.io.PrintStream;

import kknd713.game.q3.entity.equip.Armor;
import kknd713.game.q3.entity.equip.Weapon;

public class Warrior extends Sprite{
	
	
	
	public void setWeapon(Weapon weapon) {
		super.setWeapon(weapon);
	}

	public void setArmor(Armor armor) {
		super.setArmor(armor);
	}

	public Warrior(String name, int ap, int hp, Weapon weapon, Armor armor){
		super(name, ap, hp, weapon, armor, "战士");
	}
	
}
