import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues()
    {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "444-555-6789", "");
        assertEquals("N/A", testContact.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        ContactItem testContact = new ContactItem("", "Shmoe", "444-555-6789", "joe@google.com");
        assertEquals("N/A", testContact.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        ContactItem testContact = new ContactItem("Joe", "", "444-555-6789", "joe@google.com");
        assertEquals("N/A", testContact.getLastName());
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "", "joe@google.com");
        assertEquals("N/A", testContact.getPhoneNumber());
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        assertEquals("Joe", testContact.getFirstName());
        assertEquals("Shmoe", testContact.getLastName());
        assertEquals("404-404-1234", testContact.getPhoneNumber());
        assertEquals("joe@google.com", testContact.getEmail());

    }

    @Test
    public void editingFailsWithAllBlankValues()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        assertThrows(IllegalArgumentException.class, () -> testContact.editContact("","","",""));
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testContact.setEmail("");
        assertEquals("N/A", testContact.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testContact.setFirstName("");
        assertEquals("N/A", testContact.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testContact.setLastName("");
        assertEquals("N/A", testContact.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testContact.setPhoneNumber("");
        assertEquals("N/A", testContact.getPhoneNumber());
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testContact.editContact("Moe", "Bhroe", "123-123-4040", "google@facebook.net");
        assertEquals("Moe", testContact.getFirstName());
        assertEquals("Bhroe", testContact.getLastName());
        assertEquals("123-123-4040", testContact.getPhoneNumber());
        assertEquals("google@facebook.net", testContact.getEmail());
    }

    @Test
    public void testToString()
    {
        ContactItem testContact = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        assertEquals("First Name: Joe\nLast Name: Shmoe\nPhone: 404-404-1234\nEmail: joe@google.com\n", testContact.toString());
    }
}
