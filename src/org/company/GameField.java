package org.company;

import java.util.Random;

public class GameField {
    public static int SCREEN_HEIGHT = 20;
    public static int SCREEN_WIDTH = 20;

    Cell[][] gameScreen = new Cell[SCREEN_HEIGHT][SCREEN_WIDTH];

    public GameField() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                Random random = new Random();
                boolean isCellAlive = random.nextBoolean();
                gameScreen[i][j] = new Cell(i, j, isCellAlive);
            }
        }
    }

    void print() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                Cell current = gameScreen[i][j];
//                System.out.println(current.getPrintableChar());
                    System.out.print(current.getPrintableChar() + " ");
            }
            System.out.println();
        }
    }
}
