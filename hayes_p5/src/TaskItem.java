public class TaskItem {
    String title;
    String description;
    String dueDate;
    boolean completed;

    public TaskItem(String title, String description, String dueDate)
    {
        this.setTitle(title);
        this.setDescription(description);
        this.setDueDate(dueDate);
        completed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() < 1) {
            throw new IllegalArgumentException("WARNING: Title must be at least 1 character in length. Task not created.");
        } else {
            this.title = title;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() < 0) {
            throw new IllegalArgumentException("WARNING: Description is somehow under 0 characters. Task not created.");
        } else {
            this.description = description;
        }
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate)
    {
        boolean isAllNumbers = true;
        if (dueDate.length() < 10)
        {
            throw new IllegalArgumentException("WARNING: Invalid due date. Task not created.");
        }
        for (int i = 0; i < dueDate.length(); i++)
        {
            if ((dueDate.charAt(i) < '0' || dueDate.charAt(i) > '9' ) && dueDate.charAt(i) != '-')
            {
                isAllNumbers = false;
            }
        }
        if (dueDate.charAt(4) != '-' || dueDate.charAt(7) != '-' || !isAllNumbers)
        {
            throw new IllegalArgumentException("WARNING: Invalid due date. Task not created.");
        }
        else
        {
            this.dueDate = dueDate;
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString()
    {
        String returnString = "";
        String completed = "";
        if (this.isCompleted())
        {
            completed = "***";
        }
        returnString = completed + "[" + this.dueDate + "] " + this.title + ": " + this.description + "\n";
        return returnString;
    }

    public String toStringBasic() {
        String returnString = "";
        returnString = "[" + this.dueDate + "] " + this.title + ": " + this.description + "\n";
        return returnString;
    }
}
