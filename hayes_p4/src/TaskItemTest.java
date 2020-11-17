import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Valid title.","Valid desc.","2000-22-NN"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("","Valid desc","2020-11-16"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem testTask = new TaskItem("Valid title", "Valid desc", "2020-11-16");

        assertEquals("2020-11-16", testTask.getDueDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem testTask = new TaskItem("Valid title", "Valid desc", "2020-11-16");

        assertEquals("Valid title", testTask.getTitle());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Valid title.","Valid desc.","2001-01-04").setDueDate("2020-NN-NN"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem testTask = new TaskItem("Valid title", "Valid desc", "2020-11-16");

        testTask.setDueDate("2001-01-04");
        assertEquals("2001-01-04", testTask.getDueDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("Valid title.","Valid desc.","2001-01-04").setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem testTask = new TaskItem("Valid title", "Valid desc", "2020-11-16");

        testTask.setTitle("Another valid title right here");
        assertEquals("Another valid title right here", testTask.getTitle());
    }

}
