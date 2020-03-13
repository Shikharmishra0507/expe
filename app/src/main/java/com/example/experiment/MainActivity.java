package com.example.experiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
String[] nameOfSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          ArrayList < File> file =new ArrayList<File> ();
         file=read_song(getExternalFilesDir(Environment.DIRECTORY_MUSIC));
        nameOfSong =new String[file.size()];
        for(int i=0;i<file.size();i++){
            nameOfSong[i]=file.get(i).getName().toString();
        }
        final ArrayList<File>list=new ArrayList<File>(file.size());
        Collections.copy(list,file);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,nameOfSong);

      ListView listView;
        listView=(ListView)findViewById(R.id.listview);
         listView.setAdapter(adapter);
       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent=new Intent(MainActivity.this,music.class);
               intent.putExtra("List",list);
               intent.putExtra("position",i);
               startActivity(intent);
               return false;
           }
       });


    }
    ArrayList<File> read_song(File root){
        ArrayList<File>arraylist=new ArrayList<File>();
        File []todo=root.listFiles();
        for(File y:todo){
            if(y.isDirectory()){

                arraylist.addAll(read_song(y));
            }
            else{
                if(y.getName().endsWith(".mp3")){
                    arraylist.add(y);
                }
            }
        }
        return arraylist;
    }
}
 