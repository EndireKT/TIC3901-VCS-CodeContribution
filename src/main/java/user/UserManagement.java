package user;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    // todo some private variables
    private List<User> users;

    public UserManagement() {
        users = new ArrayList<User>();
    }

    public void addUser(ArrayList<String> infoFromGitBlame) {
        for (String str : infoFromGitBlame) {
            String[] info = str.split(" ");

            if (isUserExist(info[0])) {
                // todo do something meaningful here
            } else {
                addUser(info[0]);
            }
        }
    }

    public boolean isUserExist(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(String userId) {
        users.add(new User(userId));
    }

    public List<User> getUsers (){
        return users;
    }
}
