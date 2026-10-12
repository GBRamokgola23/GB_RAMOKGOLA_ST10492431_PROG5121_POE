GB_RAMOKGOLA_ST10492431_PROG5121_POE - QuickChatApp

## Project Overview
This project is for PROG5121 POE Part 2. It extends Part 1 Login/Registration system with QuickChat messaging functionality. The application allows users to register, login, send messages, store messages in JSON, and view sent messages.

Part 1 focused on user authentication (Registration.java and Login.java).
Part 2 focuses on QuickChat message handling (Message.java and QuickChatApp.java).

## Student Information
- *Name:* Gomolemo Ramokgola
- *Student Number:* ST10492431
- *Module:* PROG5121 - Programming 1A
- *POE Part:* Part 2

## Features - Part 1 (Registration & Login)
- Registration.java: Validates username (must contain underscore and <=5 chars), password (8 chars, capital letter, number, special character), cellphone number (international code + length check)
- Login.java: loginUser(username, password) and returnLoginStatus(boolean) methods
- JOptionPane dialogs for user interaction

## Features - Part 2 (QuickChat)
### Message.java
- generateMessageID(): Generates random 10-digit ID
- checkRecipientCell(): Validates cell number starts with +, <=13 chars, only digits after +
- createMessageHash(): Format first2digits:totalMessages:FIRSTwordLASTword
- SentMessage(): Handles 3 options - Send Message, Disregard Message, Store Message to send later
- storeMessage(): Writes message as JSON to storedMessages.json
- printMessages(): Returns all sent messages with ID, Hash, Recipient, Text
- returnTotalMessagess(): Returns total count of sent messages

### QuickChatApp.java (Main)
- Connects Part 1 Registration -> Login -> Part 2 Menu
- Menu Options:
    1. Send Messages - prompts for number of messages, recipient, and text
    2. Show recently sent messages - displays sentMessages list
    3. Quit - shows total sent and exits
- Uses JOptionPane for full GUI flow as per specification

## How to Run the Application
1. Clone repository: https://github.com/YourUsername/GB_RAMOKGOLA_ST10492431_PROG5121_POE.git
2. Open in VS Code or NetBeans
3. Ensure org.json library is added (json-20240303.jar)
4. Run QuickChatApp.java as main file
5. Follow dialogs: Register -> Login -> QuickChat Menu
6. For testing: Run MessageTest.java with JUnit 5

## JUnit Tests - Part 2
Located in src/MessageTest.java
Tests include:
- testCheckRecipientCell_Valid() and Invalid cases (no +, too long)
- testCreateMessageHash_Format() checks hash contains : and first/last words
- testMessageID_Length() ensures 10-digit ID
- testMessageLength_Valid() and testReturnTotalMessages()

All tests use JUnit 5 assertions.

## Technologies Used
- Java JDK 17+
- JOptionPane (Swing)
- org.json library for JSON storage
- JUnit 5 for unit testing
- Git & GitHub with GitHub Desktop for version control

## GitHub Actions & CI
GitHub Actions runs JUnit tests on every push to ensure code compiles and tests pass.

## Repository Structure
## References

Farrell, J. 2023. Java Programming. 10th ed. Boston: Cengage Learning.

IIE. 2025. PROG5121 Programming 1A - POE Part 2 Specification. Johannesburg: The Independent Institute of Education.

JSON.org. 2024. Introduction to JSON. [Online]. Available at: https://www.json.org/json-en.html [Accessed: 12 May 2026].

JUnit. 2024. JUnit 5 User Guide. [Online]. Available at: https://junit.org/junit5/docs/current/user-guide/ [Accessed: 12 May 2026].

Oracle. 2024. Class JOptionPane - Java SE 21 Documentation. [Online]. Available at: https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JOptionPane.html [Accessed: 12 May 2026].

Oracle. 2024. Lesson: Using JSON in Java. [Online]. Available at: https://docs.oracle.com/en-us/iaas/developer-tutorials/tutorials/json-in-java/ [Accessed: 12 May 2026]
- IIE PROG5121 POE Part 2 Specification 2025
- Oracle Java Documentation