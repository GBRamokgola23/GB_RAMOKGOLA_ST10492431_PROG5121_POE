 PROG5121 POE - QuickChat Application
Student:** Gomolemo Ramokgola  
Student Number:** ST10492431  
Module:** Programming 1A - PROG5121  
Institution:** IIE Rosebank College  
Repository:QuickChat - From Registration to Full Messaging System

📖 Project Overview
This project is a console and GUI-based messaging application that was built in 3 parts for the Portfolio of Evidence (POE).

- **Part 1:** Secure user registration and login system with validation.
- **Part 2:** Single message creation, validation, and storage logic.
- **Part 3:** Multiple message handling using arrays, searching, deleting, and full reporting with JSON persistence.

The final application uses `JOptionPane` for user interaction and `JUnit 5` for automated testing as required by the brief.

 Features Implementation
Part 1 - Registration & Login
Files: `Registration.java`, `Login.java`

- Username validation: Must contain `_` and be <= 5 characters (e.g., `kyl_1`)
- Password complexity: Min 8 chars, 1 Capital, 1 Number, 1 Special character (e.g., `Ch&&sec@ke99!`)
- Cellphone validation: Must start with `+27` and be 12 characters (e.g., `+27831234567`)
- Login verifies against stored credentials and returns welcome message.

Test Credentials (for marking):**
- Username: `kyl_1`
- Password: `Ch&&sec@ke99!`
- Cellphone: `+27831234567`

Part 2 - Message Logic (Single Message)
Files: `Message.java`

- `checkMessageID()` - Ensures ID is <= 10 characters
- `checkRecipientCell()` - Validates recipient number format
- `createMessageHash()` - Generates hash like `00:0:TEST`
- Send options: Send, Store, Disregard
- Message length check: <= 250 characters

Part 3 - Message Management (Multiple Messages)
File: `QuickChatApp.java` (Main)

Populated with 5 test messages from POE brief:
1. Developer: +27834557896 - "Welcome to QuickChat"
2. Mike: +27838884567 - "Hey Mike, are we still on for tonight?"
3. Developer: +27834484567 - "Don't forget to test your code"
4. Keegan: 0838884567 - "The message was flagged"
5. Mike: +27838884567 - "Where are you? You are late! I have waited..."

Menu Features (JOptionPane):
1. Display all senders and recipients - Loops through arrays to show sender/recipient list
2. Display longest sent message - Finds message with max character count
3. Search for message ID - e.g., Search `ID002` returns Mike's message
4. Search messages by recipient - e.g., Search `+27838884567` returns 2 messages
5. Delete message by hash - Removes message from ArrayLists and updates `messages.json`
6. Display full report - Shows all messages: ID, Hash, Sender, Recipient, Content, Flag
7. Quit - Saves all messages to `messages.json` and exits

 🛠️ Tech Stack
- Language: Java (JDK 17+)
- IDE: NetBeans 19
- UI: `javax.swing.JOptionPane`
- Testing: JUnit 5
- Storage: `messages.json` (created on quit)
- Version Control: Git & GitHub

How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/YOUR_USERNAME/PROG-POE-ST10492431.git
## 📚 References

To avoid plagiarism and for transparency, the following resources were used and adapted for this POE:

1. Horstmann, C.S., 2022. *Core Java Volume I - Fundamentals*. 12th ed. Pearson Education.
   - Used for understanding Java class structure, constructors, and validation methods for Part 1 registration logic.

2. Deitel, P. and Deitel, H., 2021. *Java: How to Program, Early Objects*. 11th ed. Pearson.
   - Referenced for JOptionPane input dialogs and menu-driven application design in Part 3.

3. Oracle, 2024. *Java Platform, Standard Edition Documentation - javax.swing.JOptionPane*. [online] Oracle Docs. Available at: https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JOptionPane.html [Accessed 10 May 2026].
   - Used for implementing GUI popups for login and menu options.

4. Oracle, 2024. *Java ArrayList Class Documentation*. [online] Oracle Docs. Available at: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html [Accessed 10 May 2026].
   - Used for storing multiple messages dynamically in Part 3.

5. Gamma, E. et al., 2023. *JUnit 5 User Guide*. [online] JUnit Team. Available at: https://junit.org/junit5/docs/current/user-guide/ [Accessed 10 May 2026].
   - Used for creating unit tests in MessageTest.java for Part 2 and Part 3 validation.

6. Chacon, S. and Straub, B., 2022. *Pro Git*. 2nd ed. Apress.
   - Referenced for structuring Git commits and pushing project to GitHub repository.

7. W3Schools, 2024. *Java Strings and Regular Expressions*. [online] Available at: https://www.w3schools.com/java/java_regex.asp [Accessed 10 May 2026].
   - Adapted for password complexity checks using matches(".*[A-Z].*") and similar regex patterns.

8. IIE, 2026. *PROG5121 Programming 1A - POE Brief and Rubric*. The Independent Institute of Education.
   - Primary brief that defines test data, message hash format, and required Part 3 features (display senders, longest message, search, delete, report).
