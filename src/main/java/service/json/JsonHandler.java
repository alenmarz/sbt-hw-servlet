package service.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class JsonHandler {
    private static final String path = "/Users/alenamartsenyuk/IdeaProjects/pdris-course/servlet/credentials.json";
    private String json;
    private final Gson gson;
    private final Type collectionType;

    public JsonHandler() throws FileNotFoundException {
        this.json = new Scanner(new File(path)).useDelimiter("\\Z").next();
        this.gson = new Gson();
        this.collectionType = new TypeToken<ArrayList<User>>(){}.getType();
    }

    /**
     * @return collection of existing users
     */
    public Collection<User> getUsers() {
        return gson.fromJson(json, collectionType);
    }

    /**
     * @param user -- user to add
     * @return false if user's login belongs to existing user, true otherwise.
     * @throws IOException
     */
    public boolean addUser(User user) throws IOException {
        String login = user.getLogin();
        String pass = user.getPassword();

        Collection<User> users = getUsers();
        for (User u: users) {
            if (u.getLogin().equals(login)) {
                return false;
            }
        }

        users.add(new User(login, pass));
        json = gson.toJson(users, collectionType);

        FileWriter myWriter = new FileWriter(path);
        myWriter.write(json);
        myWriter.close();

        return true;
    }

    /**
     * @param user -- user to check
     * @return true if login and password are correct, false otherwise.
     */
    public boolean checkUser(User user) {
        String login = user.getLogin();
        String pass = user.getPassword();

        Collection<User> users = getUsers();
        for (User u: users) {
            if (u.getLogin().equals(login)) {
                return u.getPassword().equals(pass);
            }
        }

        return false;
    }
}
