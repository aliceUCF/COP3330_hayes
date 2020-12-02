import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactList {
    List<ContactItem> contactList = new ArrayList<>();

    public ContactList() {
    }

    public void addContact(ContactItem contact)
    {
        this.contactList.add(contact);
    }

    public void editContact(int index, String firstName, String lastName, String phoneNumber, String email)
    {
        checkIndexNumber(index);
        this.contactList.get(index).editContact(firstName, lastName, phoneNumber, email);
    }

    public void editFirstName(int index, String firstName)
    {
        checkIndexNumber(index);
        this.contactList.get(index).setFirstName(firstName);
    }

    public void editLastName(int index, String lastName)
    {
        checkIndexNumber(index);
        this.contactList.get(index).setLastName(lastName);
    }

    public void editPhoneNumber(int index, String phoneNumber)
    {
        checkIndexNumber(index);
        this.contactList.get(index).setPhoneNumber(phoneNumber);
    }

    public void editEmail(int index, String email)
    {
        checkIndexNumber(index);
        this.contactList.get(index).setEmail(email);
    }

    public void removeContact(int indexNumber)
    {
        checkIndexNumber(indexNumber);
        this.contactList.remove(indexNumber);
    }

    public ContactItem getContact(int indexNumber)
    {
        checkIndexNumber(indexNumber);
        return this.contactList.get(indexNumber);
    }

    public int getContactListSize(){
        return this.contactList.size();
    }

    public void checkIndexNumber(int indexNumber) {
        if (indexNumber < 0 || indexNumber > this.getContactListSize() - 1)
        {
            throw new IllegalArgumentException("Contact Item index out of range.");
        }
    }
    public void saveList(String filename){
        try {
            FileWriter saveFilePlease = new FileWriter(filename);
            saveFilePlease.write(this.saveString());
            saveFilePlease.close();
        } catch (IOException e) {
            System.out.println("File saving was unsuccessful.");
            return;
        }
        System.out.println("Contacts saved successfully.");

    }

    public void loadList(String filename){
        this.contactList = new ArrayList<ContactItem>();
        List<String> fileContents = new ArrayList<>();
        try {
            FileReader taskListReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(taskListReader);

            String currentString;
            while ((currentString = bufferedReader.readLine()) !=  null) {
                fileContents.add(currentString);
            }

            taskListReader.close();
        } catch (IOException e) {
            System.out.println("File not found/could not be loaded.");
            return;
        }

        String fullFileContents = "";
        for (int i = 0; i < fileContents.size(); i++)
        {
            fullFileContents += fileContents.get(i);
        }

        if (fileContents.size() <= 2 || !fullFileContents.contains("###"))
        {
            throw new IllegalArgumentException("Data could not be loaded from file.");
        }

        String firstName = "", lastName = "", phoneNumber = "", email = "", tempContents = "";
        for(int i = 2; i < fileContents.size(); i++)
        {
            tempContents = fileContents.get(i);
            tempContents = tempContents.replace("###", "\n");
            firstName = tempContents.split("\n")[0].split(":")[1].trim();
            lastName = tempContents.split("\n")[1].split(":")[1].trim();
            phoneNumber = tempContents.split("\n")[2].split(":")[1].trim();
            email = tempContents.split("\n")[3].split(":")[1].trim();

            ContactItem newItem = new ContactItem(firstName, lastName, phoneNumber, email);
            this.addContact(newItem);
        }

        System.out.println("File loaded.\n");
    }

    @Override
    public String toString(){
        String returnString = "Current Contacts\n________________\n";
        for (int i = 0; i < this.contactList.size(); i++)
        {
            returnString += i + ") " + this.contactList.get(i).toString() + "\n";
        }
        return returnString;
    }

    public String saveString()
    {
        String returnString = "Current Contacts\n________________\n";
        for (int i = 0; i < this.contactList.size(); i++)
        {
            returnString += i + ") " + this.contactList.get(i).toString().replace("\n", "###") + "\n";
        }
        return returnString;
    }
}
