package kknd713.game.q3.entity.equip;

import java.util.HashSet;
import java.util.Set;


public class Weapon {
	private int ap;
	private String name;
	
	
	
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
	public Weapon(int ap, String name) {
		super();
		this.ap = ap;
		this.name = name;
	}
	public Weapon() {
		super();
	}
	
	
	
}
