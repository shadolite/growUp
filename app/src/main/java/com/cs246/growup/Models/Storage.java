package com.cs246.growup.Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import android.content.Context;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Storage class
 */
public class Storage {

    private Context context;

    /**
     * Non-default constructor.
     * @param context Context using the Storage class.
     */
    public Storage(Context context)  {
        this.context = context;
    }

    /**
     * Writes string data to a local file.
     * @param filename Name of the file to write to.
     * @param data String data to write.
     * @return Returns true if successful; else returns false.
     */
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

    /**
     * Reads from a file, and returns the contents as a string.
     * @param filename Name of the file to read.
     * @return Returns the file contents as a String.
     */
    public String readFile(String filename){

        String line = "";
        try {
        StringBuilder sb = new StringBuilder();
        FileInputStream fis;
            fis = context.openFileInput(filename);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);

        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
                sb.append(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            return line;
        }
    }
}
