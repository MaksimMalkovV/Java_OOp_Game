package com.mygame.game.characters.Class;

import java.util.ArrayList;

public class StaminClass extends BaseHero {
    int stamina;

    public StaminClass(int hp, int speed, int damage, int armor,int attack, int stamina, String name, int x, int y) {
        super(hp, speed, damage, armor, attack, name, x, y);
        this.stamina = stamina;
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\tARM %-3d\tHP %-3d%%\tDM %-3d\tST %-3s\t      ", getName(), armor,
                (int) hp * 100 / maxHp, damage, stamina);
        return outStr;

    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> friends){
        if (this.stamina > 0 && this.hp > 0) {
    
            BaseHero target = null;
            double minDistance = Double.MAX_VALUE;

            for (BaseHero unit : team) {
                if(this.position.getDistance(unit)<minDistance && unit.hp>0){
                    minDistance = this.position.getDistance(unit);
                    target = unit;
                }

            }
            // System.out.printf("%s выбрал %s\n", this.getClass().getSimpleName(), target.getClass().getSimpleName());
            if(this.position.getDistance(target)>=2){
                this.position.direction(target.position, friends);
            }
            else if(target.hp > 0){
                this.attack(target, this.damage);
                this.stamina--;
            }



            for (BaseHero unit : friends) {
                if (unit.getName().equals("Peasant")) { 
                    this.stamina++;
                    break;
                }
            }
        }
    }
}
