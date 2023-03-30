//package com.mygame.game;
//
//import com.mygame.game.characters.Class.BaseHero;
//import com.mygame.game.characters.Units.*;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Program {
//
//    public static final int GANG_SIZE = 10;
//    public static ArrayList<BaseHero> whiteSide = new ArrayList<>();
//    public static ArrayList<BaseHero> darkSide = new ArrayList<>();
//
//    public static void main(String[] args) {
//        try (Scanner sc = new Scanner(System.in)) {
//            Init();
//
//            while (true) {
//                ConsoleView.view();
//                sc.nextLine();
//                makeStep();
//            }
//        }
//
//    }
//
//    public static void Init() {
//        for (int i = 1; i < GANG_SIZE + 1; i++) {
//
//            switch (new Random().nextInt(4)) {
//                case 0:
//                    whiteSide.add(new Crossbowman(BaseHero.assignName(), 5, i));
//                    break;
//                case 1:
//                    whiteSide.add(new Magician(BaseHero.assignName(), 5, i));
//                    break;
//                case 2:
//                    whiteSide.add(new Spearman(BaseHero.assignName(), 5, i));
//                    break;
//                default:
//                    whiteSide.add(new Peasant(BaseHero.assignName(), 5, i));
//                    break;
//            }
//            switch (new Random().nextInt(4)) {
//                case 0:
//                    darkSide.add(new Robber(BaseHero.assignName(), 10, i));
//                    break;
//                case 1:
//                    darkSide.add(new Sniper(BaseHero.assignName(), 10, i));
//                    break;
//                case 2:
//                    darkSide.add(new Priest(BaseHero.assignName(), 10, i));
//                    break;
//                default:
//                    darkSide.add(new Peasant(BaseHero.assignName(), 10, i));
//                    break;
//            }
//        }
//    }
//
//    public static void makeStep() {
//        ArrayList<BaseHero> list = new ArrayList<>();
//
//        list.addAll(darkSide);
//        list.addAll(whiteSide);
//        list.sort(new Comparator<BaseHero>() {
//            @Override
//            public int compare(BaseHero u1, BaseHero u2) {
//                if (u1.getSpeed() == u2.getSpeed()) {
//                    return 0;
//                } else if (u1.getSpeed() > u2.getSpeed()) {
//                    return 1;
//                } else
//                    return -1;
//            }
//        });
//
//        for (BaseHero unit : list) {
//            if (darkSide.contains(unit)) {
//                unit.step(whiteSide, darkSide);
//            } else
//                unit.step(darkSide, whiteSide);
//        }
//    }
//}

package com.mygame.game;


import com.mygame.game.characters.Class.BaseHero;
import com.mygame.game.characters.Init;


import java.util.*;

public class Main {

    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> teamWhite;
    public static ArrayList<BaseHero> teamBlack;

    public static void main(String[] args) {

        Init.createTeams();

        Scanner scanner = new Scanner(System.in);
        while (Init.teamIsAlive(teamWhite) && Init.teamIsAlive(teamBlack)) {
            ConsoleView.view();
            Init.makeStep();
            scanner.nextLine();
        }
        ConsoleView.view();

    }

}
