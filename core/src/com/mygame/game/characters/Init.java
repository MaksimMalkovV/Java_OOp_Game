package com.mygame.game.characters;

import com.mygame.game.characters.Class.BaseHero;
import com.mygame.game.characters.Interfase.Names;
import com.mygame.game.characters.Units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import static com.mygame.MyGdxGame.*;
import static com.mygame.game.Main.GANG_SIZE;

public class Init {

    public static void createTeams() {

        teamWhite = new ArrayList<>();
        for (int i = GANG_SIZE; i > 0; i--) {
            switch (new Random().nextInt(4)) {
                case 0: teamWhite.add(new Magician(getName(), 1, i)); break;
                case 1: teamWhite.add(new Crossbowman(getName(), 1, i)); break;
                case 2: teamWhite.add(new Spearman(getName(), 1, i)); break;
                default: teamWhite.add(new Peasant(getName(), 1, i));
            }
        }

        teamBlack = new ArrayList<>();
        for (int i = GANG_SIZE; i > 0; i--) {
            switch (new Random().nextInt(4)) {
                case 0:  teamBlack.add(new Priest(getName(), 10, i)); break;
                case 1:  teamBlack.add(new Sniper(getName(), 10, i)); break;
                case 2:  teamBlack.add(new Robber(getName(), 10, i)); break;
                default: teamBlack.add(new Peasant(getName(), 10, i));
            }
        }

    }

    public static void makeStep() {

        teamWhite.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                return o2.getSpeed() - o1.getSpeed();
            }
        });

        teamBlack.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                return o2.getSpeed() - o1.getSpeed();
            }
        });

        for (int i = 0; i < GANG_SIZE; i++) {
            teamWhite.get(i).step(teamWhite, teamBlack);
            teamBlack.get(i).step(teamBlack, teamWhite);
        }
    }

    private static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public static boolean teamIsAlive(ArrayList<BaseHero>team) {
        for (BaseHero unit:team) {
            if (unit.isAlive()) return true;
        }
        return false;
    }

}