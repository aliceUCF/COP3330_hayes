import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);
    public void AppStart()
    {
        int choice = AppMainMenu();
        switch (choice)
        {
            case 1:
                TaskApp taskApp = new TaskApp();
                taskApp.Start();
                break;
            case 2:
                ContactApp contactApp = new ContactApp();
                contactApp.Start();
                break;
        }
    }

    public int AppMainMenu() {
        System.out.print("Select Your Application\n_______________________\n\n1) task list\n2) contact list\n3) quit\n\n> ");
        String response = in.nextLine();

        while (!(response.equals("1") || response.equals("2") || response.equals("3"))) {
            System.out.print("Please choose either '1','2', or '3'.\n\n> ");
            response = in.nextLine();
        }

        System.out.println("Rseponse was: " + response);

        if (response.equals("1")) {
            return 1;
        } else if (response.equals("2")) {
            return 2;
        } else if (response.equals("3")) {
            System.exit(0);
        }

        return 0;
    }

    public int MainMenu() {
        System.out.print("Main Menu\n_________\n\n1) create a new list\n2) load an existing list\n3) quit\n\n> ");
        String response = in.nextLine();

        while (!(response.equals("1") || response.equals("2") || response.equals("3"))) {
            System.out.print("Please choose either '1','2', or '3'.\n\n> ");
            response = in.nextLine();
        }

        if (response.equals("1")) {
            return 1;
        } else if (response.equals("2")) {
            return 2;
        } else if (response.equals("3")) {
            this.AppStart();
        }

        return 0;
    }
}
