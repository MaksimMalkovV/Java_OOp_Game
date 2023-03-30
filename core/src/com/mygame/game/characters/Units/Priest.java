package com.mygame.game.characters.Units;


import com.mygame.game.characters.Class.MagClass;

public class Priest extends MagClass {

    public Priest(String name, int x, int y) {
        super(30, 5, 4, 7, 12, 10, name, x, y);
    }

    // @Override
    // public String getInfo() {
    //     return "Монах";
    // }

    @Override
    public String getName() {
        return "Priest";
    }


}
