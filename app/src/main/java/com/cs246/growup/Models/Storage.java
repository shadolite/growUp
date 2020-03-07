package com.cs246.growup.Models;

import java.io.FileOutputStream;
import android.content.Context;
import com.google.gson.Gson;
import java.io.FileInputStream;

public class Storage {




    public void writeFile(Context context, User user){
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


}
