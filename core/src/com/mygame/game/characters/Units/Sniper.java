package com.mygame.game.characters.Units;


import com.mygame.game.characters.Class.ShooterClass;

public class Sniper extends ShooterClass {
    

    public Sniper(String name, int x, int y) {
        super(15, 9, 9, 10, 12, 32, name, x, y);
        
    }

    // @Override
    // public String getInfo() {
    //     return "Снайпер";
    // }

    @Override
    public String getName() {
        return "Sniper";
    }


}
