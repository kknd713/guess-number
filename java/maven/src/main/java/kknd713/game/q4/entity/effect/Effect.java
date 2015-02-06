package kknd713.game.q4.entity.effect;

import kknd713.game.q4.entity.Sprite;
import kknd713.game.q4.entity.debuff.Debuff;

public abstract class Effect {
	//负面状态
	protected Debuff debuff;
	//效果触发几率
	protected double triggerRate;
	
	public double getTriggerRate() {
		return triggerRate;
	}
	
	

	public Debuff getDebuff() {
		return debuff;
	}



	public Effect(Debuff debuff,double triggerRate){
		this.debuff = debuff;
		this.triggerRate = triggerRate;
	}
	

	/**
	 * 由即时伤害武器特效子类重写,表示各特效攻击的方式
	 * @param self Sprite 自己,攻击者
	 * @param other Sprite 对方,被攻击者
	 * @return int 攻击后对方受到的伤害,返回-1表示暂停一轮
	 */
	public abstract int handle(Sprite self, Sprite other);
	
}
