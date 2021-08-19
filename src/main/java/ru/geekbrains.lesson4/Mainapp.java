package ru.geekbrains.lesson4;



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mainapp {

private static Scanner scanner;
private static Random random;
    private static char [][] map;
    private static final int SIZE = 4;

    private static final char MAP_ELEMENT_EMPTY = '_';
    private static final char MAP_ELEMENT_X = 'X';
    private static final char MAP_ELEMENT_O = 'O';



    public static void main(String[] args) {
scanner = new Scanner(System.in);
        random = new Random();

initMap();
printMap();
   while (true) {

       playerTurn();
       printMap();

       if (checkWin(MAP_ELEMENT_X)) {
           System.out.println("Игра окончена! Победил игрок!");
            break;

       }
if (isMapFull()) {
    System.out.println("Игра закончена! Ничья!");
    break;
}
        airTurn();
        printMap();

       if (checkWin(MAP_ELEMENT_O)) {
           System.out.println("Игра окончена! Победил Ai!");
           break;

       }

        if (isMapFull()) {
           System.out.println("Игра закончена! Ничья!");
           break;
       }


   }


    }

    public static boolean checkWin(char el) {
            int count, count1, count2, count3; // вводим счетчики ввода Х или О для всех направлений

        for (int i = 0; i < SIZE; i++) {
            count = 0;

            for (int j = 0; j < SIZE; j++) {

                if (map[i][j] == el) {
                    count = count + 1;

                    if (count == SIZE) {
                        return true;
                    }
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {

            count1 = 0;

            for (int j = 0; j < SIZE; j++) {

                if ( map[j][i] == el) {
                    count1 = count1 + 1;

                    if (count1 == SIZE) {
                        return true;
                    }
                }
            }
         }

        count2 = 0;
        for (int i = 0; i < SIZE; i++) {

            if ( map[i][i] == el) {
                    count2 = count2 + 1;

                if (count2 == SIZE) {
                        return true;
                }
            }

        }

        count3 = 0;
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                 if ( ((i + j) == (SIZE - 1)) && (map[i][j] == el) ) {
                count3 = count3 + 1;

                    System.out.println("count3 равно  = " + count3);

                    if (count3 == SIZE) {
                    return true;
                    }
                 }
            }
        }

        return false;
    }
    public static boolean isMapFull() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (map[i][j] == MAP_ELEMENT_EMPTY) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void playerTurn() {

        int x, y;


do {
    System.out.println("Введите коррдинаты Вашего хода (X, Y)" );
    x = scanner.nextInt() - 1;
    y = scanner.nextInt() - 1;

}
while (!isMoveValid(x, y ));
        map[x][y] = MAP_ELEMENT_X;

    }

    public static void airTurn() {

        int x, y;

        do {

            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);

        }
        while (!isMoveValid(x, y ));
        map[x][y] = MAP_ELEMENT_O;

        System.out.println(" AI походил в клетку " + (x + 1) +  ", " + (y + 1) + " ");

    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");

        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {

            System.out.print(( i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
               // System.out.print(( j + 1) + " ");
                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }

    }


public static void initMap() {

        map = new char [SIZE][SIZE];


    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {

            map[i][j] = MAP_ELEMENT_EMPTY;
            //System.out.println(map[i][j]);
        }
    }

}




public static  boolean isMoveValid(int x, int y) {

if (( x < 0 ) || ( y < 0 ) || (x >= SIZE) || (y >= SIZE)) {
    return false;
    }

    if (map[x][y] != MAP_ELEMENT_EMPTY ) {
return false;

    }
    return true;
}
// метод проверки последовательности расположения символов в массиве ar длиной x символов

    public static boolean isMassiveContinuous(char[] ar, int x, char el1) {
        int y = 1;

        for (int i = 0; i < ar.length - 1; i++) {

        if (ar[i] == el1)  {


            if (ar[i] == ar[i + 1] ) {

                y = y + 1;

                if (y >= x) {
                    System.out.println(y);
                    return true;

                }
            } else if (ar[i] != ar[i + 1]) {
                y = 1;
            }
                     }


        }

        return false;
    }
}
