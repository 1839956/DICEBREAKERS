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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private int Points = 0;
    private TextView Pointsview;
    private TextView PointsCounter;
    private TextView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.userInput);
        Pointsview =  findViewById(R.id.pv);
        PointsCounter =  findViewById(R.id.pc);
        ls = findViewById(R.id.ls);

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

    public int random_number()
    {
        Random rand = new Random();
        int number = rand.nextInt(6);
        return number;
    }


    public void on_button_click(View view){

        int num = random_number();

        TextView tv = this.findViewById(R.id.numberTextView);

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
     public void on_dice_breaker_click(View view)
     {
         Random random = new Random();
         String d = "";
         int element_number = 1;

         ArrayList<String> question = new ArrayList<>();

         question.add("1. If you could go anywhere in the world, where would you go?");
         question.add("2. If you were stranded on a desert island, what three things would you want to take with you?");
         question.add("3. If you could eat only one food for the rest of your life, what would it be?");
         question.add("4. If you won a million dollars, what is the first thing you would buy?");
         question.add("5. If you could spend the day with one fictional character, who would it be?");
         question.add("6. If you found a magic lantern and a genie gave you three wishes, what would you wish?");

         for(int i = 0; i < element_number ; i++)
         {
             int number = random.nextInt(question.size());
             String rndElement = question.get(number);
             ls.setText (rndElement);
         }

     }

}
