package com.alveis.multiscreen_java;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "wetetti", R.drawable.ic_launcher_foreground, R.raw.jason_derulo_stupid_love));
        words.add(new Word("mustard yellow", "chiwiite", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("dusty yellow", "topiise", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("green", "chokokki", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("brown", "takaaki", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("grey", "topoppi", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("black", "kululli", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("white", "kelelli", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));


        Log.v("NumbersActivity", "words is an array of numbers one to ten in an array");
//        LinearLayout numbersRootView = (LinearLayout) findViewById(R.id.numbers_root_view);
//
//        int index = 0;
//        while (index<words.size()){
//            TextView number = new TextView(this);
//            number.setText(words.get(index));
//            index++;
//        }

        WordAdapter itemsAdapter = new WordAdapter(this,  words, R.color.category_colors);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,  word.getAudioResourceId());
                mMediaPlayer.start();
                //Toast.makeText(NumbersActivity.this, "play", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
