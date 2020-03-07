package com.cs246.growup.Models;

import java.io.FileOutputStream;
import android.content.Context;
import com.google.gson.Gson;
import java.io.FileInputStream;

public class Storage {




    public void writeFile(User user){
        String filename = "myfile.txt";
        Context context = null;
        Gson gson = new Gson();
        String s = gson.toJson(user);

        FileOutputStream outputStream;

        try {

            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(s.getBytes());
            outputStream.close();
            System.out.println(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
