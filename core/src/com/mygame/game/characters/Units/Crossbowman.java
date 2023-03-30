package com.mygame.game.characters.Units;


import com.mygame.game.characters.Class.ShooterClass;

public class Crossbowman extends ShooterClass {

    public Crossbowman(String name, int x, int y) {
        super(10, 4, 3, 3, 6, 16, name, x, y);
    }

    // @Override
    // public String getInfo() {
    //     return "Арбалетчик";
    // }

    @Override
    public String getName() {
        return "Crossbowman";
    }

}
