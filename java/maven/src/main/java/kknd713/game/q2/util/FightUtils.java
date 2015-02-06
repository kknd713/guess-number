package kknd713.game.q2.util;

import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import kknd713.game.q2.entity.Player;

public class FightUtils {
	private PrintStream out;
	public FightUtils(PrintStream out){
		this.out = out;
	}
	
	public void fight(Player attacker, Player defender){
		int harm = 0;
		Player temp = null;
		while(true){
			harm = attacker.attack(defender);
			int hp = defender.getHp();
			out.printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d",
					attacker.getName(), defender.getName(), harm, defender.getName(), hp);
	
			if (!defender.isAlive()) {
				out.println(defender.getName() + "被打败了!");
				break;
			}
			
			//交换
			temp = attacker;
			attacker = defender;
			defender = temp;
		}
	}
}
