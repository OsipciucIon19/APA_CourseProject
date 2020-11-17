package com.apa.courseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static final String tag = "DemoSudoku";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Wire up the button to do stuff
        Button startButton = (Button) findViewById(R.id.generate_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame(v);
            }
        });

    }

//    public void openActivity2() {
//        Intent intent = new Intent(this, GenerateGridActivity.class);
//        startActivity(intent);
//    }

    public void newGame(View view) {
        Intent intent = new Intent(HomeActivity.this,GenerateGridActivity.class);
        startActivity(intent);
    }
}