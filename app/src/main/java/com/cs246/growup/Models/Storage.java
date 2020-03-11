package com.cs246.growup.Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.content.Context;
import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Storage {
    private Context context;

    public Storage(Context context)  {
        this.context = context;
    }

    public boolean writeFile(String filename, String data){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE)));
            writer.write(data);
            writer.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
        return null;
    }
}
