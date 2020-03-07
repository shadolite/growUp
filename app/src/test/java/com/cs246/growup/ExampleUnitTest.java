package com.cs246.growup;

import android.content.Context;

import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.Goal;
import com.cs246.growup.Models.NoteItem;
import com.cs246.growup.Models.Storage;
import com.cs246.growup.Models.User;

import org.junit.Test;

import java.util.logging.FileHandler;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

public void TestUser(){
        User testUser = new User();
        Entry testEntry = new Entry();
        testEntry.add(new NoteItem("Test Item"));
        testUser.addEntry(testEntry);

        Storage storage = new Storage();

        storage.writeFile(testUser);


}
}