//
  PROG5121 - POE Part 1
 Student: GB Ramokgola - ST10492431
 
  DEVELOPMENT NOTE: This project was fully coded and tested in NetBeans IDE.
  This GitHub repository (GB_RAMOKGOLA_ST10492431_PROG5121_POE) is a copy
  created solely to fulfill the POE requirement for GitHub submission.
 Original NetBeans project functionality remains unchanged.
 //
package javapoe.gomolemo.ramokgola.st10492431;

public class Login {
    private String firstName, lastName, username, password, cellNumber;

    
    public Login(String firstName, String lastName, String username, String password, String cellNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
    }
 

    public Login(String username, String password, String cellNumber) {
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
    }

    public boolean checkUserName(){
    

       
        return username.contains("_") && username.length() <= 5;
    }

    
  public boolean checkPasswordComplexity(){
    if(password.length() < 8){
        return false;
    }
    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;

    for(int i = 0; i < password.length(); i++){
        char c = password.charAt(i);
        if(Character.isUpperCase(c)){
            hasCapital = true;
        } else if(Character.isDigit(c)){
            hasNumber = true;
        } else if(!Character.isLetterOrDigit(c)){
            hasSpecial = true;
        }
    }
    return hasCapital && hasNumber && hasSpecial;
}


    public boolean checkCellPhoneNumber(){
      
     if(cellNumber.length() != 12) return false;
if(!cellNumber.startsWith("+27")) return false;

for(int i = 3; i < cellNumber.length(); i++){
    if(!Character.isDigit(cellNumber.charAt(i))){
        return false;
    }
}
return true;
    }

   
    public String registerUser(){
        if(!checkUserName()){
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if(!checkPasswordComplexity()){
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
        }
        if(!checkCellPhoneNumber()){
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "User registered successfully.";
    }

   
    public boolean loginUser(String enteredUsername, String enteredPassword){
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
    }


    public String returnLoginStatus(boolean isLoggedIn){
        if(isLoggedIn){
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
