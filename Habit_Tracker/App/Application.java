package App;

import User.User;

public class Application {
    private User[] users = new User[10];
    private int userCount;


    public User[] getUserByName(String name) {
        User[] ans = new User[10];
        int ansCount = 0;
        for (int i = 0; i < userCount; i++) {
            if (name.equals(users[i].getFullName())) {
                ans[ansCount] = users[i];
                ansCount++;
            }
        }

        return ans;
    }

    public void addUser(User user) {
        users[userCount] = user;
        userCount++;
    }

    public void addUser(String username, String password) {
        User user = new User(username, password, "def", "def", "sth@mail.com");
        users[userCount] = user;
        userCount++;
    }

    public void removeUser(User user) {
        int i = 0;
        for (i = 0; i < userCount; i++) {
            if (user.equals(users[i])) {
                break;
            }
        }

        i--;

        for (; i < userCount - 1; i++) {
            users[i] = users[i + 1];
        }
        users[userCount - 1] = null;

        userCount--;
    }

}
