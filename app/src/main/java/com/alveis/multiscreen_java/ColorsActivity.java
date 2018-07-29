package com.alveis.multiscreen_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "wetetti", R.drawable.ic_launcher_foreground));
        words.add(new Word("mustard yellow", "chiwiite"));
        words.add(new Word("dusty yellow", "topiise"));
        words.add(new Word("green", "chokokki"));
        words.add(new Word("brown", "takaaki"));
        words.add(new Word("grey", "topoppi"));
        words.add(new Word("black", "kululli"));
        words.add(new Word("white", "kelelli"));


        Log.v("NumbersActivity", "words is an array of numbers one to ten in an array");
//        LinearLayout numbersRootView = (LinearLayout) findViewById(R.id.numbers_root_view);
//
//        int index = 0;
//        while (index<words.size()){
//            TextView number = new TextView(this);
//            number.setText(words.get(index));
//            index++;
//        }

        WordAdapter itemsAdapter = new WordAdapter(this,  words);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
