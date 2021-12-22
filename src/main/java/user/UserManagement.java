package user;

import java.util.Map;

public class UserManagement {
    // todo some private variables
    private Map<String, User> users; // todo this feels weird

    public UserManagement(){

    }

    public UserManagement(Map<String, User>  users) {
        // todo
        this.users = users;
    }

    public void run() {

        // todo update different user
    }

    public void addContribution(String id, int lineNo, int count) {
        boolean isNewUser = !users.containsKey(id);
        if (isNewUser) {
            User newUser = new User(id, count, lineNo);
            users.put(id, newUser);
        } else {
            User user = users.get(id);
            user.newContribution(count, lineNo);
        }
    }
}
