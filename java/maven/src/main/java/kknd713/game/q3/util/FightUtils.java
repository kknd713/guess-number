package kknd713.game.q3.util;

import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import kknd713.game.q2.entity.Player;
import kknd713.game.q3.entity.Sprite;

public class FightUtils {
	private PrintStream out;
	public FightUtils(PrintStream out){
		this.out = out;
	}
	
	public void fight(Sprite attacker, Sprite defender){
		int harm = 0;
		Sprite temp = null;
		while(true){
			harm = attacker.attack(defender);
			int hp = defender.getHp();
			//战士张三用优质木棒攻击了普通人李四,李四受到了8点伤害,李四剩余生命：12
			out.printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
					attacker.getJobName(),attacker.getName(),
					attacker.useWeapon(),defender.getJobName(),
					defender.getName(), defender.getName(),harm,
					defender.getName(), hp);
			
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
