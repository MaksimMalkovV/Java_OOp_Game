package com.mygame.game.characters.Class;

import java.util.ArrayList;

public class ShooterClass extends BaseHero {

    int ammo;

    public ShooterClass(int hp, int speed, int damage, int armor, int attack, int ammo, String name, int x, int y) {

        super(hp, speed, damage, armor, attack, name, x, y);
        this.ammo = ammo;
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> friends) {
        if (this.ammo > 0 && this.hp > 0) {

            BaseHero target = null;
            double minDistance = Double.MAX_VALUE;

            for (BaseHero unit : team) {
                if (this.position.getDistance(unit) < minDistance) {
                    minDistance = this.position.getDistance(unit);
                    target = unit;
                }
            }

            this.attack(target, this.damage);
            this.ammo--;
        }

        for (BaseHero unit : friends) {
            if (unit.getName().equals("Peasant")) { 
                this.ammo++;
                break;
            }
        }
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\tARM %-3d\tHP %-3d%%\tDM %-3d\tAM %-3s\t      ", getName(), armor,
                (int) hp * 100 / maxHp, damage, ammo);
        return outStr;

    }

}
