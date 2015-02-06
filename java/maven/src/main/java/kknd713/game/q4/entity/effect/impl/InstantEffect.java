package kknd713.game.q4.entity.effect.impl;

import kknd713.game.q4.entity.Sprite;
import kknd713.game.q4.entity.effect.Effect;

/**
 * 即时伤害特效,3倍效果
 * @author root
 *
 */
public class InstantEffect extends Effect{

	public InstantEffect(double triggerRate) {
		super(null, triggerRate);
	}

	public int handle(Sprite self, Sprite other) {
		int additionalAP =  self.getWeapon() == null ? 0 :  self.getWeapon().getAp();
		int harm = self.getAp() + additionalAP - other.getDp();
		//3倍伤害效果
		harm *= 3;
		if (harm < 0) {
			harm = 0;
		}
		
		int hp = other.getHp() - harm;
		other.setHp(hp);
		if (hp < 0) {
			other.setHp(0);
		}
		
		
		return harm;
	}

}
