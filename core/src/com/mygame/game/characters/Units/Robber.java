package com.mygame.game.characters.Units;


import com.mygame.game.characters.Class.StaminClass;

public class Robber extends StaminClass {

    public Robber(String name, int x, int y) {
        super(10, 6, 4, 3, 8, 10, name, x, y);
    }

    // @Override
    // public String getInfo() {
    //     return "Разбойник";
    // }

    @Override
    public String getName() {
        return "Robber";
    }


}
