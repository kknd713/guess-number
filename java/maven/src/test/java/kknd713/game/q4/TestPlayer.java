package kknd713.game.q4;

import static org.mockito.Mockito.*;

import java.io.PrintStream;

import kknd713.game.q3.entity.Player;
import kknd713.game.q3.entity.Warrior;
import kknd713.game.q3.entity.equip.Armor;
import kknd713.game.q3.entity.equip.Weapon;
import kknd713.game.q3.util.FightUtils;

import org.junit.Test;
import org.mockito.InOrder;

/**
 * 
	武器有特性，产生各种效果：
	毒性伤害，每轮损血，属于延时伤害
	火焰伤害，每轮损血，属于延时伤害
	冰冻伤害，每两轮无法攻击一轮，属于延时伤害
	击晕伤害，两轮无法攻击，属于延时伤害
	全力一击，三倍伤害，是伤害乘以3，不是攻击力。
	有的武器有特性，有的武器没有，一个武器只有一个特性
	
	效果触发是随机的。不同的武器有不同的触发几率。
	
	发动时要打印受了xx伤害
	延时伤害结算在每局受到延时伤害的人攻击前，发动时打印伤害。
	延时伤害都有伤害效果发动的次数，不同的武器造成的伤害发动的次数不同，次数归零就不再伤害，状态也会消失。除了眩晕伤害之外，其他的不显示还剩几轮。
	每种延时伤害都可以跟自己累加，一个人中了两次同一种延时伤害，其效果会累加。冰冻或眩晕各自累加的是发动次数，毒性或火焰各自累加的是伤害值和发动次数。
	第三问的需求依然有效。
 * @author root
 *
 */
public class TestPlayer {
	
	/**
	 * 攻击要输出职业+名字
	 */
	@Test
	public void print_job_and_name_when_attack(){
		PrintStream out = mock(PrintStream.class);
		
		Weapon weapon = new Weapon(5, "青龙偃月刀");
		Armor armor = new Armor(2,"轻甲");
		
		Player p1 = new Player("张三",3,10);
		Warrior p2 = new Warrior("李四", 4, 10, weapon, armor);
		
		new FightUtils(out).fight(p1, p2);
		
		InOrder order = inOrder(out);
		
		order.verify(out).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"普通人","张三","","战士","李四","李四",1,"李四",9);
		order.verify(out).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"战士","李四","用青龙偃月刀","普通人","张三","张三",9,"张三",1);

		order.verify(out).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"普通人","张三","","战士","李四","李四",1,"李四",8);
		order.verify(out).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"战士","李四","用青龙偃月刀","普通人","张三","张三",9,"张三",0);

		order.verify(out).println("张三被打败了!");
		
		order.verify(out,never()).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"普通人","张三","","战士","李四","李四",1,"李四",7);
	}
}	
