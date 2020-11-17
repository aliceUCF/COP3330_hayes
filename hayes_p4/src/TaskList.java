import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<TaskItem> taskList = new ArrayList<TaskItem>();

    public TaskList () {
    }

    public void addTask(TaskItem task)
    {
        this.taskList.add(task);
    }

    public void setTask(int index, TaskItem task)
    {
        checkIndexNumber(index);
        this.taskList.set(index, task);
    }

    public void editTask(int index, String title, String description, String dueDate)
    {
        checkIndexNumber(index);
        this.taskList.get(index).setTitle(title);
        this.taskList.get(index).setDescription(description);
        this.taskList.get(index).setDueDate(dueDate);
    }

    public void editTaskTitle(int index, String title)
    {
        checkIndexNumber(index);
        this.taskList.get(index).setTitle(title);
    }

    public void editTaskDescription(int index, String description)
    {
        checkIndexNumber(index);
        this.taskList.get(index).setDescription(description);
    }

    public void editTaskDueDate(int index, String dueDate)
    {
        checkIndexNumber(index);
        this.taskList.get(index).setDueDate(dueDate);
    }

    public void removeTask(int indexNumber)
    {
        checkIndexNumber(indexNumber);
        this.taskList.remove(indexNumber);
    }

    public TaskItem getTask(int indexNumber)
    {
        checkIndexNumber(indexNumber);
        return this.taskList.get(indexNumber);
    }

    public void markTaskCompleted(int indexNumber)
    {
        checkIndexNumber(indexNumber);
        this.taskList.get(indexNumber).setCompleted(true);
    }

    public void markTaskUncompleted(int indexNumber)
    {
        checkIndexNumber(indexNumber);
        this.taskList.get(indexNumber).setCompleted(false);
    }

    public int getTaskListSize(){
        return this.taskList.size();
    }

    public void checkIndexNumber(int indexNumber) {
        if (indexNumber < 0 || indexNumber > this.getTaskListSize() - 1)
        {
            throw new IllegalArgumentException("Task Item index out of range.");
        }
    }
    public int uncompletedTasks(){
        String returnString = "Uncompleted Tasks\n_________________\n";
        int uncompletedTaskCount = 0;
        for (int i = 0; i < this.taskList.size(); i++)
        {
            TaskItem indexAt = this.taskList.get(i);
            if (!indexAt.isCompleted())
            {
                returnString += uncompletedTaskCount + ") " + this.taskList.get(i).toString();
                uncompletedTaskCount++;
            }
        }
        System.out.println(returnString);
        return uncompletedTaskCount;
    }

    public int completedTasks(){
        String returnString = "Completed Tasks\n_________________\n";
        int completedTaskCount = 0;
        for (int i = 0; i < this.taskList.size(); i++)
        {
            TaskItem indexAt = this.taskList.get(i);
            if (indexAt.isCompleted())
            {
                returnString += completedTaskCount + ") " + this.taskList.get(i).toString();
                completedTaskCount++;
            }
        }
        System.out.println(returnString);
        return completedTaskCount;
    }

    public void saveList(String filename){
        try {
            FileWriter saveFilePlease = new FileWriter(filename);
            saveFilePlease.write(this.toString());
            saveFilePlease.close();
        } catch (IOException e) {
            System.out.println("File saving was unsuccessful.");
            return;
        }
        System.out.println("Tasks saved successfully.");

    }
    public void loadList(String filename){
        this.taskList = new ArrayList<TaskItem>();
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
        String title = "", description = "", dueDate = "";
        for(int i = 2; i < fileContents.size(); i++)
        {
            int datePos = fileContents.get(i).indexOf('[');
            dueDate = fileContents.get(i).substring(datePos + 1, datePos+11);
            title = fileContents.get(i).split(" ")[2];
            title = title.substring(0, title.length()-1);

            int descPos = fileContents.get(i).indexOf(':');
            description = fileContents.get(i).substring(descPos + 2);
            description.trim();
            TaskItem newItem = new TaskItem(title, description, dueDate);
            if (fileContents.get(i).contains("*")) {
                newItem.setCompleted(true);
            }
            this.addTask(newItem);
        }

        System.out.println("File loaded.");
    }

    @Override
    public String toString(){
        String returnString = "Current Tasks\n_____________\n";
        for (int i = 0; i < this.taskList.size(); i++)
        {
            returnString += i + ") " + this.taskList.get(i).toString();
        }
        return returnString;
    }
}
