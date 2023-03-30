package com.mygame.game.characters.Interfase;

import com.mygame.game.characters.Class.BaseHero;

import java.util.ArrayList;



public interface BaseInterfase {
    void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2);
    String getInfo();
}
