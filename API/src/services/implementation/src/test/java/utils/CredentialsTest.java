package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ucab.cmcapp.implementation.utils.Credentials;

public class CredentialsTest {

    @Test
    public void testConstructorAndGetters() {
        String username = "john.doe";
        String password = "password123";
        Credentials credentials = new Credentials(username, password);

        Assertions.assertEquals(username, credentials.getUsername());
        Assertions.assertEquals(password, credentials.getPassword());
    }

    @Test
    public void testSetters() {
        String username = "john.doe";
        String password = "password123";
        Credentials credentials = new Credentials();

        credentials.setUsername(username);
        credentials.setPassword(password);

        Assertions.assertEquals(username, credentials.getUsername());
        Assertions.assertEquals(password, credentials.getPassword());
    }

    @Test
    public void testToString() {
        String username = "john.doe";
        String password = "password123";
        Credentials credentials = new Credentials(username, password);

        String expectedString = "Credentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';

        Assertions.assertEquals(expectedString, credentials.toString());
    }
}