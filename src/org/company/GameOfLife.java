package org.company;

public class GameOfLife {

    public static void main(String[] args) throws InterruptedException {
        GameField g = new GameField();
        g.gameScreen[0][0].alive = true;
        g.gameScreen[0][1].alive = true;
        g.gameScreen[1][0].alive = true;
        g.gameScreen[1][1].alive = true;
        g.gameScreen[12][11].alive = true;
        g.gameScreen[11][11].alive = true;
        g.gameScreen[1][1].alive = true;

        g.gameScreen[13][13].alive = true;
        g.gameScreen[14][14].alive = true;
        g.gameScreen[14][15].alive = true;
        g.gameScreen[15][14].alive = true;
        g.gameScreen[15][15].alive = true;

        g.gameScreen[1][1].alive = true;
        g.gameScreen[1][1].alive = true;

        while (true) {
             g.print();
            g.simulateNextStep();
            Thread.sleep(1500);
        }


    }
}
