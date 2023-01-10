import classesfortests.Player;
import classesfortests.Weapon;
import com.google.gson.Gson;

public class App {

    public static void main(String... args) throws IllegalAccessException {

        Weapon weapon = new Weapon("Sword", 30);
        Player player = new Player(1000, 100, "Player1", weapon);

        Gson gson = new Gson();
        String jsonString = gson.toJson(player);
        System.out.println(jsonString);

        FileJsonObjectWriter jsonWriter = FileJsonObjectWriter.newFileJsonObjectWriter();
        jsonWriter.writeJson(player);

    }

}
