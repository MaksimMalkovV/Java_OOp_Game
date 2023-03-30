package com.mygame.game.characters.Units;


import com.mygame.game.characters.Class.MagClass;

public class Magician extends MagClass {

    public Magician(String name, int x, int y) {
        super(30, 9, 5, 12, 17, 10, name, x, y);
    }

    // @Override
    // public String getInfo() {
    //     return "Колдун";
    // }

    @Override
    public String getName() {
        return "Magician";
    }
}