package com.mygame.game.characters.Class;

import java.util.ArrayList;

public class MagClass extends BaseHero {

    int mana;

    public int getMana() {
        return mana;
    }

    public MagClass(int hp, int speed, int damage, int armor, int attack, int mana, String name, int x, int y) {
        super(hp, speed, damage, attack, armor, name, x, y);
        this.mana = mana;
    }

    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> friends) {
        if (this.mana > 0 && this.hp > 0) {

            BaseHero target = null;
            double minDistance = Double.MAX_VALUE;

            for (BaseHero unit : team) {
                if (this.position.getDistance(unit) < minDistance) {
                    minDistance = this.position.getDistance(unit);
                    target = unit;
                }
            }

            this.attack(target, this.damage);
            this.mana--;
        }
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\tARM %-3d\tHP %-3d%%\tDM %-3d\tMN %-3s\t      ", getName(), armor,
                (int) hp * 100 / maxHp, damage, mana);
        return outStr;

    }
}
