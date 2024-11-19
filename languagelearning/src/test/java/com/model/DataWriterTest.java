package com.model;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {

    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();
    private static final String TEST_FILE_PATH = "data/user.json";

    @BeforeEach
    public void setup() {
        DataWriter.clearUserFile(TEST_FILE_PATH); 
        userList.getUsers().clear();
        assertEquals(0, DataLoader.loadUsersFromResource(TEST_FILE_PATH).size(), 
                     "Expected user.json to start empty in setup.");
        User user = new User("TestUser", "SecurePass123", "testuser@example.com");  
        userList.getUsers().add(user);
        DataWriter.saveUsers(userList.getUsers(), TEST_FILE_PATH);
    }

    @AfterEach
    public void tearDown() {
        userList.getUsers().clear();
        DataWriter.clearUserFile(TEST_FILE_PATH);

        ArrayList<User> loadedUsers = DataLoader.loadUsersFromResource(TEST_FILE_PATH);
        assertEquals(0, loadedUsers.size(), "Expected user.json to be cleared in tearDown.");
    }

    @Test
    public void testSaveUsers() {
        ArrayList<User> loadedUsers = DataLoader.loadUsersFromResource(TEST_FILE_PATH);

        assertNotNull(loadedUsers, "Loaded users should not be null.");
        assertEquals(1, loadedUsers.size(), "Loaded users size should be 1.");

        User savedUser = loadedUsers.get(0);
        assertEquals("TestUser", savedUser.getUserName(), "Username should match 'TestUser'.");
        assertEquals("SecurePass123", savedUser.getPassword(), "Password should match 'SecurePass123'.");
        assertEquals("testuser@example.com", savedUser.getEmail(), "Email should match 'testuser@example.com'.");
    }
}
