import classesfortests.Player;
import classesfortests.Weapon;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FileJsonObjectWriterTest {

    private FileJsonObjectWriter fileJsonObjectWriter;
    private StringBuilder jsonString;

    @Before
    public void setUp() throws Exception {
        fileJsonObjectWriter = FileJsonObjectWriter.newFileJsonObjectWriter();
    }

    @Test
    public void newFileJsonObjectWriter() {
        FileJsonObjectWriter newFileJsonObjectWriter = FileJsonObjectWriter.newFileJsonObjectWriter();
        Class expected = FileJsonObjectWriter.class;

        assertNotNull(newFileJsonObjectWriter);
        assertThat(newFileJsonObjectWriter.getClass(), is(equalTo(expected)));
    }

    @Test
    public void writeJson() {
        Weapon weapon = new Weapon("Sword", 30);
        Player player = new Player(1000, 100, "Player1", weapon);
        String path = "d:/test.json";

        Gson gson = new Gson();
        String expected = gson.toJson(player);

        try {
            fileJsonObjectWriter.writeJson(player, path);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        File file = new File(path);

        assertTrue(file.exists());
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            String result = new String(bytes);
            assertThat(result, equalTo(expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}