package com.alveis.multiscreen_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);


        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("where are you going", "minto wuksus"));
        words.add(new Word("what is your name", "tinne oyaase'na"));
        words.add(new Word("my name is...", "oyaaseti"));
        words.add(new Word("how are you feeling", "michekses?"));
        words.add(new Word("i am feeling good.", "kuchi achit"));
        words.add(new Word("are you coming?", "eenes'aa?"));
        words.add(new Word("yes i'm coming", "hee' eenem"));
        words.add(new Word("i'm coming.", "eenem"));
        words.add(new Word("Let's go.", "yoowutis"));
        words.add(new Word("come here.", "enni'nem"));


        Log.v("NumbersActivity", "words is an array of numbers one to ten in an array");
//        LinearLayout numbersRootView = (LinearLayout) findViewById(R.id.numbers_root_view);
//
//        int index = 0;
//        while (index<words.size()){
//            TextView number = new TextView(this);
//            number.setText(words.get(index));
//            index++;
//        }

        WordAdapter itemsAdapter = new WordAdapter(this,  words, R.color.category_phrases);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}


