package com.apa.courseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class GenerateGridActivity extends AppCompatActivity {

//    public static boolean isSafe(int[][] board, int row, int col, int num) {
//        for (int d = 0; d < board.length; d++) {
//            if (board[row][d] == num) {
//                return false;
//            }
//        }
//
//        for (int r = 0; r < board.length; r++) {
//
//            if (board[r][col] == num) {
//                return false;
//            }
//        }
//
//        int sqrt = (int) Math.sqrt(board.length);
//        int boxRowStart = row - row % sqrt;
//        int boxColStart = col - col % sqrt;
//
//        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
//            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
//                if (board[r][d] == num) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static boolean solveSudoku(int[][] board, int n) {
//        int row = -1;
//        int col = -1;
//        boolean isEmpty = true;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j] == 0) {
//                    row = i;
//                    col = j;
//
//                    isEmpty = false;
//                    break;
//                }
//            }
//            if (!isEmpty) {
//                break;
//            }
//        }
//
//        if (isEmpty) {
//            return true;
//        }
//
//        for (int num = 1; num <= n; num++) {
//            if (isSafe(board, row, col, num)) {
//                board[row][col] = num;
//                if (solveSudoku(board, n)) {
//                    return true;
//                }
//                else {
//                    board[row][col] = 0;
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void print(int[][] board, int N) {
//
//        for (int r = 0; r < N; r++) {
//            for (int d = 0; d < N; d++) {
//                System.out.print(board[r][d]);
//                System.out.print(" ");
//            }
//            System.out.print("\n");
//
//            if ((r + 1) % (int)Math.sqrt(N) == 0) {
//                System.out.print("");
//            }
//        }
//    }
//
//    public static void generateGrid(int[][] board, int n) {
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = 0;
//            }
//        }
//
//        int max = 9, min = 1;
//        int range = max - min + 1;
//        board[0][0] = (int) (Math.random() * range);
////        board[0][1] = (int) (Math.random() * range);
//
//        solveSudoku(board,n);
//
//        int numberOfZeros = 0, i, j;
//
//        while (numberOfZeros < 70) {
//            i = (int) (Math.random() * range);
//            j = (int) (Math.random() * range);
//            board[i][j] = 0;
//            numberOfZeros++;
//        }
//
//        print(board, n);
//        System.out.println("\n");
//
//    }
//=============================================

    private GridView mGridView;
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private String selectedButton = "n1";
//    private Game mGame;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_grid);


    }
}