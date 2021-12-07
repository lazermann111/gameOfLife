package org.company;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class GameField {
    public static int SCREEN_HEIGHT = 20;
    //todo change width to ensure it works OK
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

    void simulateNextStep() {
        //for each cell:
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                Cell current = gameScreen[i][j];

                // calculate count of alive neigbours
                long aliveNeigb = calculateNeibours(current, gameScreen);

                // if cell is dead and neigbours = 3 -> alive
                // if cell is alive and neigbours = 2/3 -> alive
                // else dead

                if (!current.alive && aliveNeigb == 3) {
                    current.alive = true;
                }
                else if (current.alive && (aliveNeigb == 2 || aliveNeigb == 3)) {
                    current.alive = true;
                }
                else {
                    current.alive = false;
                }
            }
        }


    }

    private long calculateNeibours(Cell cell, Cell[][] gameScreen) {
        int x = cell.x;
        int y = cell.y;

        var a = getCellByCoords(x - 1, y - 1, gameScreen);
        var b = getCellByCoords(x, y - 1, gameScreen);
        var c = getCellByCoords(x + 1, y - 1, gameScreen);

        var d = getCellByCoords(x - 1, y, gameScreen);
        var e = getCellByCoords(x + 1, y, gameScreen);

        var f = getCellByCoords(x - 1, y + 1, gameScreen);
        var g = getCellByCoords(x, y + 1, gameScreen);
        var h = getCellByCoords(x + 1, y + 1, gameScreen);

        return Stream.of(a, b, c, d, e, f, g, h)
                .filter(cc -> cc != null)
                .filter(cc -> cc.alive)
                .count();
    }



    private Cell getCellByCoords(int x, int y, Cell[][] gameScreen) {
        if (x < 0 || y < 0) return null;
        if (x >= SCREEN_WIDTH || y >= SCREEN_HEIGHT) return null;
        return gameScreen[x][y];
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
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");

    }
}
