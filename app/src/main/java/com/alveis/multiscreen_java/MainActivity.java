package com.alveis.multiscreen_java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView family =  findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openFamilyActivity = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(openFamilyActivity);
            }
        });

        //find the view that displays numbers
        TextView numbers =  findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openNumbersActivity = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(openNumbersActivity);
            }
        });

        TextView phrases =  findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent openPhrasesActivity = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(openPhrasesActivity);
            }
        });

        TextView colors =  findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent openColorsActivity = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(openColorsActivity);
            }
        });

//        TextView extra = (TextView) findViewById(R.id.extra);
//                extra.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        Intent startExtra = new Intent(MainActivity.this, ExtraActivity.class);
////                        startActivity(startExtra);
//                        //Toast.makeText(MainActivity.CONTEXT_IGNORE_SECURITY).LENGTH_SHORT.show();
//                    }
//                });

    }


//    public void startActivityTwo(){
//        Intent activityTwo = new Intent(MainActivity.this, SecondActivity.class);
//        startActivity(activityTwo);
//    }
}
