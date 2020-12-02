import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize()
    {
        ContactList testList = new ContactList();
        assertEquals(0, testList.getContactListSize());
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals(1, testList.getContactListSize());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editContact(0, "", "", "", ""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editContact(0, "", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals("Joe", testList.getContact(0).getFirstName());
        testList.editFirstName(0, "");
        assertEquals("N/A", testList.getContact(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals("Shmoe", testList.getContact(0).getLastName());
        testList.editLastName(0, "");
        assertEquals("N/A", testList.getContact(0).getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals("404-404-1234", testList.getContact(0).getPhoneNumber());
        testList.editPhoneNumber(0, "");
        assertEquals("N/A", testList.getContact(0).getPhoneNumber());
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals("joe@google.com", testList.getContact(0).getEmail());
        testList.editEmail(0, "");
        assertEquals("N/A", testList.getContact(0).getEmail());
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        testList.editContact(0, "Moe", "Bhroe", "123-123-4040", "mark@facebook.net");
        assertEquals("Moe", testList.getContact(0).getFirstName());
        assertEquals("Bhroe", testList.getContact(0).getLastName());
        assertEquals("123-123-4040", testList.getContact(0).getPhoneNumber());
        assertEquals("mark@facebook.net", testList.getContact(0).getEmail());
    }

    @Test
    public void editingItemsFailsWithInvalidEmailAt()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editEmail(0, "joe@@@google.com"));
    }

    @Test
    public void editingItemsFailsWithInvalidEmailFormat()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editEmail(0, "Google.com"));
    }

    @Test
    public void editingItemsFailsWithInvalidPhoneDigits()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editPhoneNumber(0, "ABC-404-4046"));
    }

    @Test
    public void editingItemsFailsWithInvalidPhoneNumberFormat()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editPhoneNumber(0, "4044041234"));
    }

    @Test
    public void editingFirstNameSucceedsWithValidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        testList.editFirstName(0, "Moe");
        assertEquals("Moe", testList.getContact(0).getFirstName());
    }

    @Test
    public void editingFirstNameFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editFirstName(1, "Moe"));
    }

    @Test
    public void editingLastNameSucceedsWithValidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        testList.editLastName(0, "Bhroe");
        assertEquals("Bhroe", testList.getContact(0).getLastName());
    }

    @Test
    public void editingLastNameFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editLastName(1, "Bhroe"));
    }

    @Test
    public void editingPhoneNumberSucceedsWithValidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        testList.editPhoneNumber(0, "123-404-4040");
        assertEquals("123-404-4040", testList.getContact(0).getPhoneNumber());
    }

    @Test
    public void editingPhoneNumberFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editPhoneNumber(1, "123-404-4040"));
    }

    @Test
    public void editingEmailSucceedsWithValidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        testList.editEmail(0, "mark@facebook.net");
        assertEquals("mark@facebook.net", testList.getContact(0).getEmail());
    }

    @Test
    public void editingEmailFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.editEmail(1, "poggers@twitch.tv"));
    }

    @Test
    public void gettingFirstNameFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.getContact(1).getFirstName());
    }

    @Test
    public void gettingFirstNameSucceedsWithValidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals("Joe", testList.getContact(0).getFirstName());
    }

    @Test
    public void gettingLastNameFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.getContact(1).getLastName());
    }

    @Test
    public void gettingLastNameSucceedsWithValidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals("Shmoe", testList.getContact(0).getLastName());
    }

    @Test
    public void gettingPhoneNumberFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.getContact(1).getPhoneNumber());
    }

    @Test
    public void gettingPhoneNumberSucceedsWithValidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals("404-404-1234", testList.getContact(0).getPhoneNumber());
    }

    @Test
    public void gettingEmailFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertThrows(IllegalArgumentException.class, () -> testList.getContact(1).getEmail());
    }

    @Test
    public void gettingEmailSucceedsWithValidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals("joe@google.com", testList.getContact(0).getEmail());
    }

    @Test
    public void newListIsEmpty()
    {
        ContactList testList = new ContactList();
        assertEquals(0, testList.getContactListSize());
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals(1, testList.getContactListSize());
        testList.removeContact(0);
        assertEquals(0, testList.getContactListSize());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("Joe", "Shmoe", "404-404-1234", "joe@google.com");
        testList.addContact(testItem);
        assertEquals(1, testList.getContactListSize());
        assertThrows(IllegalArgumentException.class, () -> testList.removeContact(1));
    }

    @Test
    public void savedContactListCanBeLoaded()
    {
        ContactList testList = new ContactList();
        ContactItem testItem = new ContactItem("File", "Saved", "123-456-7890", "saved@toafile.txt");
        testList.addContact(testItem);
        testList.addContact(testItem);
        testList.saveList("JUNITTestSave.txt");
        ContactList testList2 = new ContactList();
        testList2.loadList("JUNITTestSave.txt");
    }

    @Test
    public void loadingInvalidFilePromptsMessage()
    {
        ContactList testList = new ContactList();
        testList.saveList("emptyfile.txt");
        ContactList testList2 = new ContactList();
        assertThrows(IllegalArgumentException.class, () -> testList2.loadList("emptyfile.txt"));
    }
}
