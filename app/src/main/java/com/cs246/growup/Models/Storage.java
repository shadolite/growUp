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
    private Context context;

    public Storage(Context context)  {
        this.context = context;
    }

    public static void writeFile(String filename, String data){
        FileOutputStream outputStream;

        try {


            outputStream = filename.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readFile(Context context, User user) throws FileNotFoundException {
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
        String s = gson.toJson(user);
    }


    public String readFile(String s) {

    }
}
