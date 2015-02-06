package kknd713.game.q2.entity;

import java.io.PrintStream;

public class Player {
	private String name;
	private int ap;
	private int hp;
	private boolean alive = true;
	
	
	public boolean isAlive() {
		alive = hp > 0;
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
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
	public Player(String name, int ap, int hp) {
		super();
		this.name = name;
		this.ap = ap;
		this.hp = hp;
	}
	
	public Player() {
		super();
	}
	
	
	public int attack(Player other){
		int harm = this.ap;
		int hp = other.getHp() - harm;
		other.setHp(hp);
		if (hp < 0) {
			other.setHp(0);
		}
		return harm;
	}
}
