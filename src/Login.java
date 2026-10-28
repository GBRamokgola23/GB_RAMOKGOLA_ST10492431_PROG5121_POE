package javapoe.gomolemo.ramokgola.st10492431;

public class Login {
    
    public boolean loginUser(String username, String password) {
        return username.equals(Registration.storedUsername) && password.equals(Registration.storedPassword);
    }
    
    public String returnLoginStatus(String username, String password) {
        if(loginUser(username, password)) {
            return "Welcome " + Registration.storedFirstName + " " + Registration.storedLastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    // For console version with attempts
    public static boolean checkLogin(String username, String password) {
        return username.equals("kyl_1") && password.equals("Ch&&sec@ke99!");
    }
}