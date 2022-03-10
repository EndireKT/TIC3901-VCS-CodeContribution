/*

package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserManagement {
    // todo some private variables
    private HashMap<String, User> users;

//    public UserManagement(HashMap<String, User> contributors)
//    {
//        users = contributors;
//    }

    public UserManagement(){
        users = new HashMap<>();
    }

    public void addUser(ArrayList<String> infoFromGitBlame) {
        for (String str : infoFromGitBlame) {
            String[] info = str.split(" ");
            String userID = info[0];
            int count = 0;
            int lineNo = 0;
            try {
                count = Integer.parseInt(info[2]);
                lineNo = Integer.parseInt(info[1]);
            } catch (NumberFormatException e) {
                System.out.println("The info string '" + str + "' is invalid");
                continue;
            }
            if (isUserExist(info[0])) {
                User currentUser = users.get(info[0]);
                currentUser.newContribution(count, lineNo);
            } else {
                addUser(userID, count, lineNo);
            }
        }
    }

    public boolean isUserExist(String userId) {
        boolean isOldUser = users.containsKey(userId);
        return isOldUser;
    }


    public void addUser(String userId, int count, int lineNo) {
        User newUser = new User(userId, count, lineNo);
        users.put(userId, newUser);
    }

    public User getUser(String user){
        return users.get(user);
    }

    public HashMap<String, User> getUserList(){
        return users;
    }


}
