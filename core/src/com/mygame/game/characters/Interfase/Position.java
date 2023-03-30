package com.mygame.game.characters.Interfase;

import com.mygame.game.characters.Class.BaseHero;

import java.util.ArrayList;


public class Position {
    protected int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistance(BaseHero unit) {
        return Math.sqrt(Math.pow(x - unit.position.x, 2) + Math.pow(y - unit.position.y, 2));
    }

    public boolean isEquals(Position position) {
        return this.x == position.getX() && this.y == position.getY();
    }


    public void direction(Position position, ArrayList<BaseHero> friends) {
        boolean[] temp = checkPos(friends);
        float dx = Math.abs(this.x - position.x);
        float dy = Math.abs(this.y - position.y);
        if ((dx > dy)) {
            if (this.x < position.x && !temp[0] && this.x + 1 != 11) {
                this.x += 1;
                System.out.printf("1 %s\n", this.getClass().getSimpleName());
                return;
            } else if (this.x > position.x && !temp[1] && this.x - 1 != 0) {
                this.x -= 1;
                System.out.printf("2 %s\n", this.getClass().getSimpleName());
                return;
            }
            if (this.y <= position.y && !temp[2]&& this.y + 1 != 11) {
                this.y += 1;
                System.out.printf("3 %s\n", this.getClass().getSimpleName());
                return;
            } else if (this.y >= position.y && !temp[3]&& this.y - 1 != 0) {
                this.y -= 1;
                System.out.printf("4 %n", this.getClass().getSimpleName());
                return;
            }
        } else {
            if (this.y < position.y && !temp[2] && this.y + 1 != 11) {
                this.y += 1;
                System.out.printf("1.1 %s\n", this.getClass().getSimpleName());
                return;
            } else if (this.y > position.y && !temp[3] && this.x - 1 != 0) {
                this.y -= 1;
                System.out.printf("1.2 %s\n", this.getClass().getSimpleName());
                return;
            }
            if (this.x <= position.x && !temp[0]&& this.x + 1 != 11) {
                this.x += 1;
                System.out.printf("1.3 %s\n", this.getClass().getSimpleName());
                return;
            } else if (this.x >= position.x && !temp[1]&& this.x - 1 != 0) {
                this.x -= 1;
                System.out.printf("1.4 %s\n", this.getClass().getSimpleName());
                return;
            }
        }
    }

    public boolean[] checkPos(ArrayList<BaseHero> friends) {
        boolean[] temp = new boolean[4];
        for (BaseHero u : friends) {
            if ((u.position.x == this.x + 1) && (u.position.y == this.y))
                temp[0] = true;
            if ((u.position.x == this.x - 1) && (u.position.y == this.y))
                temp[1] = true;
            if ((u.position.x == this.x) && (u.position.y == this.y + 1))
                temp[2] = true;
            if ((u.position.x == this.x) && (u.position.y == this.y - 1))
                temp[3] = true;
        }
        return temp;
    }
}
