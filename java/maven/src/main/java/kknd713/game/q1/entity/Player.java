package kknd713.game.q1.entity;

import java.io.PrintStream;

public class Player {
	private String name;
	private int ap;
	private int hp;
	private boolean alive = true;
	
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
	
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
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
	
	
	public void attack(Player other){
		int hp = other.getHp() - this.ap;
		other.setHp(hp);
		if (hp < 0) {
			other.setHp(0);
		}
	}
}
