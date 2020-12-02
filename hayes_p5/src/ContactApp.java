import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp extends App{
    Scanner in = null;
    ContactList activeContactList;

    public ContactApp() {
    }

    public void Start()
    {
        in = new Scanner(System.in);
        activeContactList = null;
        int choice = MainMenu();
        switch (choice)
        {
            case 1:
                activeContactList = new ContactList();
                System.out.println("new contact list has been created");
                ListMenu();
                break;
            case 2:
                activeContactList = new ContactList();
                OpenList();
                ListMenu();
                break;
        }
    }

    public void ListMenu()
    {
        boolean exited = false;

        do {
            System.out.print("List Operation Menu\n_________\n\n" +
                    "1) view the list\n" +
                    "2) add an item\n" +
                    "3) edit an item\n" +
                    "4) remove an item\n" +
                    "5) save the current list\n" +
                    "6) quit to the main menu\n\n> ");
            String response = in.nextLine();
            while (!response.equals("1") && !response.equals("2") && !response.equals("3") && !response.equals("4") &&
                    !response.equals("5") && !response.equals("6")) {
                System.out.print("Please choose a valid integer 1-6.\n\n> ");
                response = in.nextLine();
            }

            if (response.equals("1")) {
                ViewList();
            } else if (response.equals("2")) {
                CreateItem();
            } else if (response.equals("3")) {
                EditItem();
            } else if (response.equals("4")) {
                RemoveItem();
            } else if (response.equals("5")) {
                SaveList();
            } else if (response.equals("6")) {
                exited = true;
                activeContactList = null;
            }

        } while (!exited);

        Start();
    }

    public void ViewList()
    {
        System.out.println(this.activeContactList.toString());
    }

    public void CreateItem()
    {
        String firstName, lastName, phoneNumber, email;
        System.out.print("Contact's first name: ");
        firstName = in.nextLine();

        System.out.print("Contact's last name: ");
        lastName = in.nextLine();

        System.out.print("Contact's phone number: ");
        phoneNumber = in.nextLine();

        System.out.print("Contact's email: ");
        email = in.nextLine();

        try{
            ContactItem newItem = new ContactItem(firstName, lastName, phoneNumber, email);
            this.activeContactList.addContact(newItem);
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void EditItem()
    {
        String firstName, lastName, phoneNumber, email;
        System.out.print(this.activeContactList.toString() + "\nWhich contact will you edit?\n> ");
        int response = -1;

        if (in.hasNextInt())
        {
            response = in.nextInt();
        }
        else
        {
            while(!in.hasNextInt())
            {
                System.out.print("Please input a valid integer response.\n\n> ");
                try{
                    response = in.nextInt();
                }
                catch(InputMismatchException e)
                {
                    in.nextLine();
                }
            }
        }

        try{
            this.activeContactList.getContact(response);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        in.nextLine();

        System.out.print("Enter a new first name for for contact " + response + ": ");
        firstName = in.nextLine();

        System.out.print("Enter a new last name for for contact " + response + ": ");
        lastName = in.nextLine();

        System.out.print("Enter a new phone number (xxx-xxx-xxxx) for for contact " + response + ": ");
        phoneNumber = in.nextLine();

        System.out.print("Enter a new email address (x@y.z) for for contact " + response + ": ");
        email = in.nextLine();

        try{
            this.activeContactList.editContact(response, firstName, lastName, phoneNumber, email);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void RemoveItem()
    {
        System.out.print(this.activeContactList.toString() + "\nWhich contact will you remove?\n> ");
        int response = -1;
        if (in.hasNextInt())
        {
            response = in.nextInt();
        }
        else
        {
            while(!in.hasNextInt())
            {
                System.out.print("Please input a valid integer response.\n\n> ");
                try{
                    response = in.nextInt();
                }
                catch(InputMismatchException e)
                {
                    in.nextLine();
                }
            }
        }

        try{
            this.activeContactList.removeContact(response);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            return;
        }
        System.out.print(this.activeContactList.toString() + "\n");
    }

    public void SaveList()
    {
        System.out.print("Enter the filename to save as: ");
        String filename = in.nextLine();
        this.activeContactList.saveList(filename);
    }

    public void OpenList()
    {
        System.out.print("Enter the filename to load: ");
        String filename = in.nextLine();
        this.activeContactList.loadList(filename);
    }



}
