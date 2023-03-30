package com.mygame.game.characters.Units;


import com.mygame.game.characters.Class.StaminClass;

public class Spearman extends StaminClass {

    public Spearman(String name, int x, int y) {
        super(10, 4, 3, 5, 4, 12, name, x, y);

    }

    // @Override
    // public String getInfo() {
    //     return "Копейщик";
    // }

    @Override
    public String getName() {
        return "Spearman";
    }

}
