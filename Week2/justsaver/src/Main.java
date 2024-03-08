import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    String adminMatrix[][];
    String userMatrix[][];
    int row;
    int col;
    int userRow;
    int userCol;
    int sum;


    void run(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a row value: ");
        row = input.nextInt();
        System.out.print("Enter a column value: ");
        col = input.nextInt();

        gameBoard();
        addMine();
        adminBoard();

        int gameWin = (row * col) - (int)(row * col) / 4;
        System.out.println("WELCOME TO MINESWEEPER! ENJOY!");

        while(gameWin > 0){

            sum = 0;

            for (int i = 0; i < row; i ++){
                for (int j = 0; j < col; j++){
                    System.out.print(userMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.print("Choose a row: ");
            userRow = input.nextInt() - 1;
            System.out.print("Choose a column: ");
            userCol = input.nextInt() - 1;

            if (row >= userRow && userRow >= 0 && col >= userCol && userCol >= 0){
                if (adminMatrix[userRow][userCol] == "*"){
                    System.out.println("You have stepped into MINE! You LOST! Game over.");
                    break;
                }
                else{
                    if (userRow - 1 >= 0){
                        if (adminMatrix[userRow-1][userCol] == "*"){
                            sum++;
                        }
                    }
                    if (userRow - 1 >= 0 && userCol + 1 < col){
                        if (adminMatrix[userRow -1][userCol + 1] == "*"){
                            sum++;
                        }
                    }
                    if (userCol + 1 < col){
                        if (adminMatrix[userRow][userCol + 1] == "*"){
                            sum++;
                        }
                    }
                    if (userRow + 1 < row && userCol + 1 < col){
                        if (adminMatrix[userRow + 1][userCol + 1] == "*"){
                            sum++;
                        }
                    }
                    if (userRow + 1 < row){
                        if (adminMatrix[userRow + 1][userCol] == "*"){
                            sum++;
                        }
                    }
                    if (userRow + 1 < row && userCol - 1 >= 0){
                        if (adminMatrix[userRow + 1][userCol - 1] == "*"){
                            sum++;
                        }
                    }
                    if (userCol - 1 >= 0 ){
                        if (adminMatrix[userRow][userCol -1] == "*"){
                            sum++;
                        }
                    }
                    if (userRow - 1 >= 0 && userCol - 1 >= 0){
                        if (adminMatrix[userRow - 1][userCol - 1] == "*"){
                            sum++;
                        }
                    }

                    userMatrix[userRow][userCol] = String.valueOf(sum);

                    System.out.println("=================================");

                    gameWin--;
                }

            }else {
                System.out.println("You have entered a wrong value!");
            }

            if (gameWin == 0){
                System.out.println("You Won! Game over!");

            }
        }

    }

    void gameBoard(){

        adminMatrix = new String[row][col];
        userMatrix  = new String[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                adminMatrix[i][j] = "-";
                userMatrix [i][j] = "-";
            }
        }
    }

    void addMine(){
        int mineNum = (int)(row * col) /4;

        for (int i = 0; i < mineNum; i++){
            int randomX =(int)(Math.random() * row);
            int randomY =(int)(Math.random() * col);

            if (adminMatrix[randomX][randomY] == "*"){
                mineNum++;
            }else{
                adminMatrix[randomX][randomY] = "*";
            }
        }
    }

    void adminBoard(){
        System.out.println("Mine locations: ");

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(adminMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
