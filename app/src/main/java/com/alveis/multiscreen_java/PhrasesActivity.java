package com.alveis.multiscreen_java;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("where are you going", "minto wuksus", R.raw.jason_derulo_stupid_love));
        words.add(new Word("what is your name", "tinne oyaase'na", R.raw.jason_derulo_stupid_love));
        words.add(new Word("my name is...", "oyaaseti", R.raw.jason_derulo_stupid_love));
        words.add(new Word("how are you feeling", "michekses?", R.raw.jason_derulo_stupid_love));
        words.add(new Word("i am feeling good.", "kuchi achit", R.raw.jason_derulo_stupid_love));
        words.add(new Word("are you coming?", "eenes'aa?", R.raw.jason_derulo_stupid_love));
        words.add(new Word("yes i'm coming", "hee' eenem", R.raw.jason_derulo_stupid_love));
        words.add(new Word("i'm coming.", "eenem", R.raw.jason_derulo_stupid_love));
        words.add(new Word("Let's go.", "yoowutis", R.raw.jason_derulo_stupid_love));
        words.add(new Word("come here.", "enni'nem", R.raw.jason_derulo_stupid_love));


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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,  word.getAudioResourceId());
                mMediaPlayer.start();
                //Toast.makeText(NumbersActivity.this, "play", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


