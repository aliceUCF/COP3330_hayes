import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList testList = new TaskList();
        testList.addTask(new TaskItem("One", "Desc","2020-22-22"));
        assertEquals(1, testList.getTaskListSize());
        testList.addTask(new TaskItem("Two", "Desc","2020-22-22"));
        assertEquals(2, testList.getTaskListSize());
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        testList.markTaskCompleted(0);
        assertTrue(testTask.isCompleted());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertThrows(IllegalArgumentException.class, () -> testList.markTaskCompleted(1));
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskList testList = new TaskList();
        testList.addTask(new TaskItem("One", "Desc","2020-11-11"));

        testList.editTask(0, "Two", "Other description", "2020-22-22");

        assertNotEquals("One", testList.getTask(0).getTitle());
        assertNotEquals("Desc", testList.getTask(0).getDescription());
        assertNotEquals("2020-11-11", testList.getTask(0).getDueDate());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList testList = new TaskList();
        testList.addTask(new TaskItem("One", "Desc","2020-11-11"));
        testList.editTaskDescription(0, "Other description");
        assertEquals("Other description", testList.getTask(0).getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertThrows(IllegalArgumentException.class, () -> testList.editTaskDescription(1, "Other desc."));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList testList = new TaskList();
        testList.addTask(new TaskItem("One", "Desc","2020-11-11"));
        testList.editTaskDueDate(0, "2020-22-22");
        assertEquals("2020-22-22", testList.getTask(0).getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertThrows(IllegalArgumentException.class, () -> testList.editTaskDueDate(1, "2020-22-22"));
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList testList = new TaskList();
        testList.addTask(new TaskItem("Title One", "Desc","2020-11-11"));
        testList.editTaskTitle(0, "Title Two");
        assertEquals("Title Two", testList.getTask(0).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertThrows(IllegalArgumentException.class, () -> testList.editTaskTitle(1, "Other title."));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertThrows(IllegalArgumentException.class, () -> testList.getTask(1).getDescription());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertEquals("Complete this JUNIT test", testList.getTask(0).getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertThrows(IllegalArgumentException.class, () -> testList.getTask(1).getDueDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertEquals("2020-11-16", testList.getTask(0).getDueDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertThrows(IllegalArgumentException.class, () -> testList.getTask(1).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertEquals("One", testList.getTask(0).getTitle());
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList testList = new TaskList();
        assertEquals(0, testList.getTaskListSize());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList testList = new TaskList();
        testList.addTask(new TaskItem("One", "Desc","2020-22-22"));
        testList.addTask(new TaskItem("Two", "Desc","2020-22-22"));
        assertEquals(2, testList.getTaskListSize());
        testList.removeTask(1);
        assertEquals(1, testList.getTaskListSize());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        testList.addTask(new TaskItem("One", "Desc","2020-22-22"));
        testList.addTask(new TaskItem("Two", "Desc","2020-22-22"));
        assertThrows(IllegalArgumentException.class, () -> testList.removeTask(2));
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList testList = new TaskList();
        testList.addTask(new TaskItem("Test", "Test if you can load task list", "2020-11-16"));
        testList.saveList("JUNITTEST.txt");
        testList = new TaskList();
        testList.loadList("JUNITTEST.txt");
        assertEquals("Test", testList.getTask(0).getTitle());
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        testList.markTaskCompleted(0);
        assertTrue(testTask.isCompleted());
        testList.markTaskUncompleted(0);
        assertFalse(testTask.isCompleted());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList testList = new TaskList();
        TaskItem testTask = new TaskItem("One", "Complete this JUNIT test", "2020-11-16");
        testList.addTask(testTask);
        assertThrows(IllegalArgumentException.class, () -> testList.markTaskCompleted(1));
    }

}
