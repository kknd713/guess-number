package kknd713.game.q1.util;

import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import kknd713.game.q1.entity.Player;

public class FightUtils {
	private PrintStream out;
	public FightUtils(PrintStream out){
		this.out = out;
	}
	
	public void fight(Player attacker, Player defender){
		while(true){
			attacker.attack(defender);
			if (!defender.isAlive()) {
				out.println(defender.getName() + "被打败了!");
				break;
			}
		}
	}
}
