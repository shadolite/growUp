package com.cs246.growup.Models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.content.Context;
import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Storage {




    public static void writeFile(Context context, User user){
        String filename = "myfile.txt";


        Gson gson = new Gson();
        String s = gson.toJson(user);

        FileOutputStream outputStream;

        try {


            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(s.getBytes());
            outputStream.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readFile(Context context) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        String json = sb.toString();
        Gson gson = new Gson();
        String filename = "myfile.txt";

        FileInputStream fis;
        fis = context.openFileInput(filename);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);

        String line;
        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
                sb.append(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
