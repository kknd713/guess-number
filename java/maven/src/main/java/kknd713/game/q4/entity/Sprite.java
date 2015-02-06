package kknd713.game.q4.entity;

import kknd713.game.q4.entity.debuff.Debuff;
import kknd713.game.q4.entity.effect.Effect;
import kknd713.game.q4.entity.equip.Armor;
import kknd713.game.q4.entity.equip.Weapon;

public abstract class Sprite {
	protected String name;
	protected int ap;
	protected int hp;
	protected Weapon weapon;
	protected Armor armor;
	protected String jobName;
	protected Debuff debuff;
	
	public Debuff getDebuff() {
		return debuff;
	}

	public void setDebuff(Debuff debuff) {
		this.debuff = debuff;
	}

	public boolean isAlive() {
		return hp > 0;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	protected void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	protected void setArmor(Armor armor) {
		this.armor = armor;
	}
	public int getDp() {
		if (armor == null) {
			return 0;
		}
		return armor.getDp();
	}
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
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
	
	public String useWeapon(){
		return weapon == null ? "" : "用" + weapon.getName();
	}
	
	
	public Sprite(String name, int ap, int hp, Weapon weapon,
			Armor armor, String jobName) {
		super();
		this.name = name;
		this.ap = ap;
		this.hp = hp;
		this.weapon = weapon;
		this.armor = armor;
		this.jobName = jobName;
	}
	
	/**
	 * 攻击对方
	 * @param other
	 * @return int 表示对方受到的伤害,返回-1表示自己暂停一轮
	 */
	public int attack(Sprite other){
		//判断debuff
		if (debuff != null && debuff.getCount() > 0) {
			boolean canAttack = debuff.handle(this);
			if (!canAttack) {
				return -1;
			}
		}
		
		//武器触发效果
		if (this.weapon != null) {
			Effect effect = this.weapon.trigger();
			if (effect != null) {
				//判断是否是debuff型
				if (effect.getDebuff() != null) {
					//获取对方的debuff
					Debuff currDebuff = other.getDebuff();
					//有debuff的,替换或叠加
					if (currDebuff != null) {
						currDebuff.accumulate(effect.getDebuff());
					}else {
						//新增debuff
						other.setDebuff(effect.getDebuff());
					}
				}else {
					//触发了特效,使用特效的攻击逻辑
					return effect.handle(this,other);
				}
			}
		}
		
		//没有触发武器效果,使用自身逻辑
		int additionalAP = this.weapon == null ? 0 : this.weapon.getAp();
		int harm = this.ap + additionalAP - other.getDp();
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
