package kknd713.game.q2.entity;

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
		int harm = this.ap;
		int hp = other.getHp() - harm;
		other.setHp(hp);
		if (hp <= 0) {
			hp = 0;
			other.setHp(hp);
			out.println(other.getName() + "被打败了!");
		}else {
			System.out.printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d",
					this.name, other.getName(), harm, other.getName(), hp);
			out.printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d",
					this.name, other.getName(), harm, other.getName(), hp);
		}
	}
}
