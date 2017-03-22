package seedu.onetwodo.model.util;

import seedu.onetwodo.commons.exceptions.IllegalValueException;
import seedu.onetwodo.model.ReadOnlyToDoList;
import seedu.onetwodo.model.ToDoList;
import seedu.onetwodo.model.tag.UniqueTagList;
import seedu.onetwodo.model.task.Description;
import seedu.onetwodo.model.task.EndDate;
import seedu.onetwodo.model.task.Name;
import seedu.onetwodo.model.task.Priority;
import seedu.onetwodo.model.task.StartDate;
import seedu.onetwodo.model.task.Task;
import seedu.onetwodo.model.task.UniqueTaskList.DuplicateTaskException;

public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        try {
            return new Task[] {
                    new Task(new Name("guard duty"), new StartDate("15/12/2018 7am"), new EndDate("16/12/2018 11pm"),
                            new Priority("l"), new Description("bring weapon"), new UniqueTagList("army", "work")),
                    new Task(new Name("study at home"), new StartDate("10 Mar 2018"), new EndDate("13 mar 2018"),
                            new Priority("high"), new Description(""), new UniqueTagList("work", "school")),
                    new Task(new Name("meet boss"), new StartDate("10 Mar 2018 08:00"),
                            new EndDate("10 mar 2018 12:00"), new Priority("h"), new Description(""),
                            new UniqueTagList("")),
                    new Task(new Name("submit cs2101 reflection"), new StartDate(""), new EndDate("13-05-2018 23:30"),
                            new Priority("m"), new Description("use the 7 C"), new UniqueTagList("school")),
                    new Task(new Name("complete 2103 tutorial"), new StartDate(""), new EndDate("tomorrow"),
                            new Priority("l"), new Description("bring laptop"),
                            new UniqueTagList("school", "favourite")),
                    new Task(new Name("finish assignments"), new StartDate(""), new EndDate("11pm"),
                            new Priority("medium"), new Description(""), new UniqueTagList("")),
                    new Task(new Name("buy new bag"), new StartDate(""), new EndDate(""), new Priority("low"),
                            new Description("find cheap ones"), new UniqueTagList("shopping", "favourite", "hobby")),
                    new Task(new Name("change shirt"), new StartDate(""), new EndDate(""), new Priority("LOW"),
                            new Description(""), new UniqueTagList("habit", "favourite", "hobby")),
                    new Task(new Name("change pants"), new StartDate(""), new EndDate(""), new Priority("l"),
                            new Description(""), new UniqueTagList("")), };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyToDoList getSampleToDoList() {
        try {
            ToDoList sampleAB = new ToDoList();
            for (Task sampleTask : getSampleTasks()) {
                sampleAB.addTask(sampleTask);
            }
            return sampleAB;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate tasks", e);
        }
    }
}
