package kknd713.game.q3.entity;

import java.io.PrintStream;

import kknd713.game.q3.entity.equip.Armor;
import kknd713.game.q3.entity.equip.Weapon;

public class Warrior extends Player{

	private Weapon equipment;
	private Armor armor;
	

	public Weapon getEquipment() {
		return equipment;
	}

	public void setEquipment(Weapon equipment) {
		this.equipment = equipment;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}


	public Warrior(String name, int ap, int hp, PrintStream out,
			Weapon equipment, Armor armor) {
		super(name, ap, hp, out);
		this.equipment = equipment;
		this.armor = armor;
	}

	public void attack(Player other) {
		
		
	}
	
	
}
