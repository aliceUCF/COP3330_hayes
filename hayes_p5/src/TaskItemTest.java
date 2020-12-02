import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void constructorFailsWithInvalidDueDate()
    {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Valid title.","Valid desc.","2000-22-NN"));
    }

    @Test
    public void constructorFailsWithInvalidTitle()
    {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("","Valid desc","2020-11-16"));
    }

    @Test
    public void constructorSucceedsWithValidDueDate()
    {
        TaskItem testTask = new TaskItem("Valid title", "Valid desc", "2020-11-16");

        assertEquals("2020-11-16", testTask.getDueDate());
    }

    @Test
    public void constructorSucceedsWithValidTitle()
    {
        TaskItem testTask = new TaskItem("Valid title", "Valid desc", "2020-11-16");

        assertEquals("Valid title", testTask.getTitle());
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD()
    {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Valid title.","Valid desc.","2001-01-04").setDueDate("2020-NN-NN"));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat()
    {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Valid title.","Valid desc.","2001-01-04").setDueDate("20201234"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue()
    {
        TaskItem testTask = new TaskItem("Valid title", "Valid desc", "2020-11-16");

        testTask.setDueDate("2001-01-04");
        assertEquals("2001-01-04", testTask.getDueDate());
    }

    @Test
    public void editingTitleFailsWithEmptyString()
    {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Valid title.","Valid desc.","2001-01-04").setTitle(""));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue()
    {
        TaskItem testTask = new TaskItem("Valid title", "Valid desc", "2020-11-16");

        testTask.setTitle("Another valid title right here");
        assertEquals("Another valid title right here", testTask.getTitle());
    }


}
