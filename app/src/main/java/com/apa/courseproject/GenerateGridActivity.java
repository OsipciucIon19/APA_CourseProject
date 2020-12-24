package com.apa.courseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class GenerateGridActivity extends AppCompatActivity {

    long countNrOp = 0;

    public boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            countNrOp += 4;
            if (board[row][d] == num) {
                countNrOp += 2;
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            countNrOp += 4;
            if (board[r][col] == num) {
                countNrOp += 2;
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        countNrOp += 10;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            countNrOp += 5;
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                countNrOp += 5;
                if (board[r][d] == num) {
                    countNrOp += 2;
                    return false;
                }
            }
        }
        countNrOp++;
        return true;
    }

    public boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        countNrOp += 6;

        for (int i = 0; i < n; i++) {
            countNrOp += 4;
            for (int j = 0; j < n; j++) {
                countNrOp += 4;
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    isEmpty = false;
                    countNrOp += 4;
                    break;
                }
            }
            if (!isEmpty) {
                countNrOp++;
                break;
            }
        }

        if (isEmpty) {
            countNrOp++;
            return true;
        }

        for (int num = 1; num <= n; num++) {
            countNrOp += 4;
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                countNrOp += 2;
                if (solveSudoku(board, n)) {
                    countNrOp += 2;
                    return true;
                }
                else {
                    countNrOp++;
                    board[row][col] = 0;
                }
            }
        }
        countNrOp++;
        return false;
    }

    void generateGrid(int[][] board, int n) {

        int max = 9, min = 1;
        int range = max - min + 1;
        board[0][0] = (int) (Math.random() * range);
        board[2][4] = (int) (Math.random() * range);
        board[3][3] = (int) (Math.random() * range);
        board[1][7] = (int) (Math.random() * range);

        solveSudoku(board,n);

        int numberOfZeros = 0, i, j;

        while (numberOfZeros < 21) {
            i = (int) (Math.random() * range);
            j = (int) (Math.random() * range);
            board[i][j] = 0;
            numberOfZeros++;
        }
    }
//=============================================

    private class Cell {

        public int value, correctVal;
        boolean clicked = false;
        boolean fixed;
        Button bt,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
        LinearLayout linearLayout2;
        View v;
        TextView textViewError = findViewById(R.id.textViewError);

        void setNumber(String value) {
            bt.setText(value);
        }

        void verifyCorrect(int value, int cv) {
            if (value == cv) {
                bt.setTextColor(Color.GRAY);
                fixed = true;
                count++;
                if ( count == 81 ) {
                    Intent intent = new Intent(GenerateGridActivity.this,WinnerActivity.class);
                    startActivity(intent);
                    System.out.println("da");
                }
            } else {
                bt.setTextColor(Color.RED);
                errorCount++;
                textViewError.setText(String.valueOf(errorCount));
            }
        }


        public Cell(int initvalue, int correctValue, Context THIS) {

            value = initvalue;
            correctVal = correctValue;
            if (value != 0) {
                fixed = true;
            }
            else fixed = false;

            linearLayout2 = findViewById(R.id.linearLayout2);

            bt1 = findViewById(R.id.btn1);
            bt2 = findViewById(R.id.btn2);
            bt3 = findViewById(R.id.btn3);
            bt4 = findViewById(R.id.btn4);
            bt5 = findViewById(R.id.btn5);
            bt6 = findViewById(R.id.btn6);
            bt7 = findViewById(R.id.btn7);
            bt8 = findViewById(R.id.btn8);
            bt9 = findViewById(R.id.btn9);

            bt = new Button(THIS);
//            bt = findViewById(R.id.mybutton);
            bt.setBackgroundColor(View.INVISIBLE);
            bt.setPadding(0, -100, 10, -100);
            Typeface type = Typeface.createFromAsset(getAssets(),"FRADM.TTF");
            bt.setTypeface(type);

            if (fixed) bt.setText(String.valueOf(value));

            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clicked = true;
                    if (fixed) return;


                    System.out.println(count);
                    bt.setText("@");
                    bt.setTextColor(Color.parseColor("#009688"));
                    bt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("1");
                            value = 1;
                            verifyCorrect(value, correctVal);
                        }
                    });
                    bt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("2");
                            value = 2;
                            verifyCorrect(value, correctVal);
                            clicked = true;
                        }
                    });
                    bt3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("3");
                            value = 3;
                            verifyCorrect(value, correctVal);
                            clicked = true;
                        }
                    });
                    bt4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("4");
                            value = 4;
                            verifyCorrect(value, correctVal);
                            clicked = true;
                        }
                    });
                    bt5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("5");
                            value = 5;
                            verifyCorrect(value, correctVal);
                            clicked = true;
                        }
                    });
                    bt6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("6");
                            value = 6;
                            verifyCorrect(value, correctVal);
                            clicked = true;
                        }
                    });
                    bt7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("7");
                            value = 7;
                            verifyCorrect(value, correctVal);
                            clicked = true;
                        }
                    });
                    bt8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("8");
                            value = 8;
                            verifyCorrect(value, correctVal);
                            clicked = true;
                        }
                    });
                    bt9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setNumber("9");
                            value = 9;
                            verifyCorrect(value, correctVal);
                            clicked = true;
                        }
                    });

                    if ( count == 81 ) {
                        Intent intent = new Intent(GenerateGridActivity.this,WinnerActivity.class);
                        startActivity(intent);
                        System.out.println("da");
                    }
                }
            });
        }
    }

    private class SolvedCell {
        public int value, correctVal;
        boolean fixed;
        Button bt;
        LinearLayout linearLayout2;


        public SolvedCell(int initvalue, final int correctValue, Context THIS) {

            value = initvalue;
            correctVal = correctValue;
            if (value != 0) fixed = true;
            else fixed = false;



            bt = new Button(THIS);
            bt.setBackgroundColor(View.INVISIBLE);
            bt.setPadding(0, -100, 10, -100);
            Typeface type = Typeface.createFromAsset(getAssets(),"FRADM.TTF");
            bt.setTypeface(type);

            if (fixed) bt.setText(String.valueOf(value));
            else {
                bt.setText(String.valueOf(correctVal));
                bt.setTextColor(Color.parseColor("#009688"));
            }
        }
    }

    Cell[][] table;
    SolvedCell[][] table1;
    public int count = 0, errorCount = 0;
    int n = 9;
    public int[][] board = {{0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0}};
    public int[][] solvedBoard = {{0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0}};

    TableLayout tableLayout;
    TextView textView;
    TextView textViewNrOp;
    LinearLayout linearLayout;
    Button selfSolveButton;
    Button generateGridButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_grid);


        tableLayout = findViewById(R.id.tableLayout);

        generateGrid(board, n);


        table = new Cell[9][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solvedBoard[i][j] = board[i][j];
            }
        }

        solveSudoku(solvedBoard,n);

        for (int i = 0; i < 9; i++) {

            TableRow tableRow = new TableRow(this);
            tableRow.setPadding(15,10,0,-30);

            for (int j = 0; j < 9; j++) {

                table[i][j] = new Cell(board[i][j], solvedBoard[i][j], this);
                tableRow.addView(table[i][j].bt);
            }
            tableLayout.addView(tableRow);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (table[i][j].value == solvedBoard[i][j]) {
                    count++;
                }
            }
        }

        selfSolveButton = findViewById(R.id.selfSolve);

        selfSolveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.activity_self_solve);

                TableLayout tableLayout1 = findViewById(R.id.tableLayout1);

                table1 = new SolvedCell[9][9];

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        solvedBoard[i][j] = board[i][j];
                    }
                }

                countNrOp = 0;
                textViewNrOp = findViewById(R.id.textViewNrOpSolved);

                solveSudoku(solvedBoard,n);

                textViewNrOp.setText(String.valueOf(countNrOp));

                for (int i = 0; i < 9; i++) {

                    TableRow tableRow1 = new TableRow(GenerateGridActivity.this);
                    tableRow1.setPadding(15,10,0,-30);

                    for (int j = 0; j < 9; j++) {

                        table1[i][j] = new SolvedCell(board[i][j],solvedBoard[i][j], GenerateGridActivity.this);
                        tableRow1.addView(table1[i][j].bt);
                    }
                    tableLayout1.addView(tableRow1);
                }

                LinearLayout linearLayout1 = findViewById(R.id.linearLayout1);

                generateGridButton = findViewById(R.id.generateGrid);

                generateGridButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_generate_grid);
                        newGrid(v);
                    }
                });
            }
        });

        generateGridButton = findViewById(R.id.generateGrid);

        generateGridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_generate_grid);
                newGrid(v);
            }
        });

    }

    public void newGrid(View view) {
        Intent intent = new Intent(GenerateGridActivity.this,GenerateGridActivity.class);
        startActivity(intent);
    }
}