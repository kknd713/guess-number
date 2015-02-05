package kknd713.game.q3.entity.equip;

public class Armor {
	private int dp;
	private String name;
	public int getDp() {
		return dp;
	}
	public void setDp(int dp) {
		this.dp = dp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Armor(int dp, String name) {
		super();
		this.dp = dp;
		this.name = name;
	}
	public Armor() {
		super();
	}
	
	
}
