package com.cs246.growup.Models;

import java.io.FileOutputStream;
import android.content.Context;
import com.google.gson.Gson;
import java.io.FileInputStream;

public class Storage {
    String Entry;
    String Goals;
    public void createFile(){}
    public void readFile(){}

    public Storage(String entry) {
        Entry = entry;
    }

    public void writeFile(String goalEntry){
        String filename = "myfile.txt";


        Gson gson = new Gson();
        String s = gson.toJson(goalEntry);

        FileOutputStream outputStream;

        try {

            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }}


}
