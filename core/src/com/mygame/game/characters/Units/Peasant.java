package com.mygame.game.characters.Units;


import com.mygame.game.characters.Class.StaminClass;

public class Peasant extends StaminClass {

    public Peasant(String name, int x, int y) {
        super(1, 3, 1, 1, 1, 0, name, x, y);
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s \tARM %-3d\tHP %-3d%%\tDM %-3d\t %-3s\t      ", getName(), armor,
                (int) hp * 100 / maxHp, damage, ' ');
        return outStr;

    }

    @Override
    public String getName() {
        return "Peasant";
    }

}
