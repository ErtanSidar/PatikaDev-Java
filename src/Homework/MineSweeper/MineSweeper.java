package Homework.MineSweeper;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
	
    int rowNumber, columnNumber;
    int [][] minedMap;  // Mayınlı Harita
    int [][] gameBoard; // Kullanıcının kullandığı oyun tahtası
    boolean game = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    public MineSweeper(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.minedMap = new int [rowNumber][columnNumber];
        this.gameBoard = new int [rowNumber][columnNumber];
    }

    public void run() {
        int success = 0;
        placingMines();

        System.out.println("MAYIN TARLASI OYUNUNA HOŞGELDİNİZ\nOynamak istediğiniz boyutu giriniz:");

        while (game) {

            print(gameBoard); //Boş oyun tahtası

            System.out.print("Satır Sayısı: ");
            int rowN= scan.nextInt();
            System.out.print("Sütun Sayısı: ");
            int columnN = scan.nextInt();

            if (rowN < 0 || rowN >= rowNumber) {
                System.out.println("Geçersiz bir sayı girdiniz.");
                continue;
            }
            if (columnN < 0 || columnN >= columnNumber) {
                System.out.println("Geçersiz bir sayı girdiniz.");
                continue;
            }

            if (minedMap[rowN][columnN] != -1) { //-1 = * mayın
                checkMines(rowN,columnN);
                success++;
                if (success== (rowNumber * columnNumber) - (rowNumber * columnNumber/4)) {
                    System.out.println("OYUNU KAZANDINIZ!!!");
                    print(minedMap);
                    break;
                }
            } else {
                game=false;
                System.out.println("OYUN BİTTİ! \nKAYBETTİNİZ");
                System.out.println("MAYINLARIN YERİ: ");
                print(minedMap);
            }
        }
    }

    public void checkMines(int r, int c) {
        if (minedMap[r][c]==0) {
            if (c< columnNumber-1 && minedMap[r][c+1]==-1) {//
                gameBoard[r][c]++;
            }
            if (r>0 && c< columnNumber-1 && minedMap[r-1][c+1]==-1) {
                gameBoard[r][c]++;
            }
            if (r>0 && minedMap[r-1][c]==-1) { //
                gameBoard[r][c]++;
            }
            if (r>0 && c>0  && minedMap[r-1][c-1]==-1) {
                gameBoard[r][c]++;
            }
            if (c>0 && minedMap[r][c-1]==-1) { //
                gameBoard[r][c]++;
            }
            if (c>0 && r< rowNumber-1 &&minedMap[r+1][c-1]==-1) {
                gameBoard[r][c]++;
            }
            if (r< rowNumber-1 && minedMap[r+1][c]==-1) { //
                gameBoard[r][c]++;
            }
            if (c< columnNumber-1 && r< rowNumber-1 && minedMap[r+1][c+1]==-1) {
                gameBoard[r][c]++;
            }
        }
    }

    public void placingMines() {
        int randRow, randCol,count=0;
        while (count != (rowNumber * columnNumber/4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(columnNumber);
            if (minedMap[randRow][randCol]!=-1) {
                minedMap[randRow][randCol]=-1;
                count++;
            }
        }
    }

    public void print(int[][] arr) {
       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < arr[0].length; j++) {
               if (arr[i][j] >= 0) {
                   System.out.print(" ");
               }
                System.out.print(arr[i][j] + "  ");
           }
           System.out.println();
       }
    }

}
