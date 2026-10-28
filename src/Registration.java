package javapoe.gomolemo.ramokgola.st10492431;

public class Registration {
    public static String storedUsername = "kyl_1";
    public static String storedPassword = "Ch&&sec@ke99!";
    public static String storedCellphone = "+27831234567";
    public static String storedFirstName = "Gomolemo";
    public static String storedLastName = "Ramokgola";

    public String registerUser(String username, String password, String cellphone) {
        if(username.contains("_") && username.length() <= 5) {
            if(password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[^a-zA-Z0-9].*")) {
                if(cellphone.startsWith("+27") && cellphone.length() == 12) {
                    storedUsername = username;
                    storedPassword = password;
                    storedCellphone = cellphone;
                    return "User registered successfully";
                }
            }
        }
        return "Registration failed";
    }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[^a-zA-Z0-9].*");
    }
    
    public boolean checkCellPhoneNumber(String cellphone) {
        return cellphone.startsWith("+27") && cellphone.length() <= 13;
    }
}