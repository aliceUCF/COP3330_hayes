import org.junit.platform.commons.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);
    TaskList activeTaskList;
    public void Start()
    {
        activeTaskList = null;
        int choice = MainMenu();
        switch (choice)
        {
            case 1:
                activeTaskList = new TaskList();
                System.out.println("new task list has been created");
                ListMenu();
                break;
            case 2:
                activeTaskList = new TaskList();
                OpenList();
                ListMenu();
                break;
        }
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
            System.exit(0);
        }

        return 0;
    }

    public void ListMenu(){
        boolean exited = false;

        do {
            System.out.print("List Operation Menu\n_________\n\n" +
                    "1) view the list\n" +
                    "2) add an item\n" +
                    "3) edit an item\n" +
                    "4) remove an item\n" +
                    "5) mark an item as completed\n" +
                    "6) unmark an item as completed\n" +
                    "7) save the current list\n" +
                    "8) quit to the main menu\n\n> ");
            String response = in.nextLine();
            while (!response.equals("1") && !response.equals("2") && !response.equals("3") && !response.equals("4") &&
                    !response.equals("5") && !response.equals("6") && !response.equals("7") && !response.equals("8")) {
                System.out.print("Please choose a valid integer 1-8.\n\n> ");
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
                MarkItemComplete();
            } else if (response.equals("6")) {
                MarkItemUncomplete();
            } else if (response.equals("7")) {
                SaveList();
            } else if (response.equals("8")) {
                exited = true;
                activeTaskList = null;
            }

        } while (!exited);

        Start();
    }

    public void ViewList(){
        System.out.println(this.activeTaskList.toString());
    }

    public void CreateItem(){
        String title, description, date;
        System.out.print("Task title: ");
        title = in.nextLine();

        System.out.print("Task description: ");
        description = in.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        date = in.nextLine();

        TaskItem newItem = new TaskItem(title, description, date);
        this.activeTaskList.addTask(newItem);
    }

    public void EditItem() {
        String title, description, date;
        System.out.print(this.activeTaskList.toString() + "\nWhich task will you edit?\n> ");
        int response = 0;
        if (in.hasNextInt())
        {
            response = in.nextInt();
        }
        else
        {
            while(!in.hasNextInt())
            {
                System.out.print("Please input a valid integer response.\n\n> ");
            }
        }

        if (response < 0 || response > this.activeTaskList.getTaskListSize() - 1)
        {
            throw new IllegalArgumentException("Choice is outside of valid task bounds.");
        }

        System.out.print("Enter a new task title for for task number " + response + ": ");
        title = in.nextLine();

        System.out.print("Enter a new task description for task number " + response + ": ");
        description = in.nextLine();

        System.out.print("Enter a new task due date (YYYY-MM-DD) for task number " + response + ": ");
        date = in.nextLine();

        this.activeTaskList.editTask(response, title, description, date);
    }

    public void RemoveItem() {
        System.out.print(this.activeTaskList.toString() + "\nWhich task will you remove?\n> ");
        int response = 0;
        if (in.hasNextInt())
        {
            response = in.nextInt();
        }
        else
        {
            while(!in.hasNextInt())
            {
                System.out.print("Please input a valid integer response.\n\n> ");
            }
        }

        if (response < 0 || response > this.activeTaskList.getTaskListSize() - 1)
        {
            throw new IllegalArgumentException("Choice is outside of valid task bounds.");
        }

        this.activeTaskList.removeTask(response);
        System.out.print(this.activeTaskList.toString() + "\n");
    }

    public void MarkItemComplete() {
        int maxOption = this.activeTaskList.uncompletedTasks();

        System.out.print(this.activeTaskList.toString() + "\nWhich task will you mark complete?\n> ");
        int response = 0;
        if (in.hasNextInt())
        {
            response = in.nextInt();
        }
        else
        {
            while(!in.hasNextInt())
            {
                System.out.print("Please input a valid integer response.\n\n> ");
            }
        }

        if (response < 0 || response > maxOption)
        {
            throw new IllegalArgumentException("Task completion choice is outside of valid task bounds.");
        }

        this.activeTaskList.markTaskCompleted(response);
    }

    public void MarkItemUncomplete() {
        int maxOption = this.activeTaskList.completedTasks();

        System.out.print(this.activeTaskList.toString() + "\nWhich task will you unmark as complete?\n> ");
        int response = 0;
        if (in.hasNextInt())
        {
            response = in.nextInt();
        }
        else
        {
            while(!in.hasNextInt())
            {
                System.out.print("Please input a valid integer response.\n\n> ");
            }
        }

        if (response < 0 || response > maxOption)
        {
            throw new IllegalArgumentException("Task unmarking choice is outside of valid task bounds.");
        }

        this.activeTaskList.markTaskUncompleted(response);
    }

    public void SaveList() {
        System.out.print("Enter the filename to save as: ");
        String filename = in.nextLine();
        this.activeTaskList.saveList(filename);
    }

    public void OpenList() {
        System.out.print("Enter the filename to load: ");
        String filename = in.nextLine();
        this.activeTaskList.loadList(filename);
    }
}
