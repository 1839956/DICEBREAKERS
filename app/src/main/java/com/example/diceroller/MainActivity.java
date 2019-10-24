package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private int Points = 0;
    private TextView Pointsview;
    private TextView PointsCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.userInput);
        Pointsview = (TextView) findViewById(R.id.pv);
        PointsCounter = (TextView) findViewById(R.id.pc);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view){

        TextView tv = this.findViewById(R.id.numberTextView);
        Random rnd = new Random();
        int num = rnd.nextInt(6);

        tv.setText(Integer.toString(num));

        int n = Integer.parseInt(userInput.getText().toString());

            if (n < 1 || n > 6){
                Toast.makeText(this, "Please pick a number between 1-6", Toast.LENGTH_SHORT).show();
            }
            else if (n == num) {
                Toast.makeText(this, "Congratulations! You got it right!", Toast.LENGTH_SHORT).show();
                Points = Points + 1;
                Pointsview.setText(Integer.toString(Points));
            }

    }

}
