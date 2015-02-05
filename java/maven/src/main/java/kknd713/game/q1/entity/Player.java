package kknd713.game.q1.entity;

import java.io.PrintStream;

public class Player {
	private String name;
	private int ap;
	private int hp;
	private PrintStream out;
	
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
	public Player(String name, int ap, int hp, PrintStream out) {
		super();
		this.name = name;
		this.ap = ap;
		this.hp = hp;
		this.out = out;
	}
	
	public Player() {
		super();
	}
	
	
	public void attack(Player other){
		int hp = other.getHp() - this.ap;
		System.out.println(hp);
		other.setHp(hp);
		if (hp <= 0) {
			hp = 0;
			other.setHp(hp);
			out.println(other.getName() + "被打败了!");
		}
	}
}
