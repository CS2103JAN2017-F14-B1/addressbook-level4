package seedu.onetwodo.model.task;

import java.util.Objects;

import seedu.onetwodo.model.tag.UniqueTagList;

/**
 * Represents a Task in the toDo list.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Task implements ReadOnlyTask {

    private Name name;
    private StartDate startDate;
    private EndDate endDate;
    private Description description;
    private UniqueTagList tags;
    
    private TaskType type;
    private boolean isDone;

    //@@author A0141138N
    /**
     * Every field must be present and not null.
     * Event
     */
    public Task(Name name, StartDate startDate, EndDate endDate, Description description, UniqueTagList tags) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.tags = new UniqueTagList(tags); // protect internal tags from changes in the arg list
        this.isDone = false;
        if (!startDate.hasDate() && !endDate.hasDate()) {
            this.type = TaskType.TODO;    
        } else if (!startDate.hasDate() && endDate.hasDate()) {
            this.type = TaskType.DEADLINE;
        } else if (startDate.hasDate() && endDate.hasDate()) {
            this.type = TaskType.EVENT;
        }
    }

    /**
     * Creates a copy of the given ReadOnlyTask.
     */
    public Task(ReadOnlyTask source) {
        this(source.getName(), source.getStartDate(), source.getEndDate(), source.getDescription(), source.getTags(), source.getDoneStatus());
    }
    
    public Task(Name name, StartDate startDate, EndDate endDate, Description description, UniqueTagList tags, boolean isDone) {
        this(name, startDate, endDate, description, tags);
        this.isDone = isDone;
    }

    // Getters
    @Override
    public Name getName() {
        return name;
    }

    @Override
    public StartDate getStartDate() {
        return startDate;
    }

    @Override
    public EndDate getEndDate() {
        return endDate;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public boolean getDoneStatus() {
        return isDone;
    }
    
    @Override
    public TaskType getTaskType() {
        return type;
    }
    
    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }
    
    // Setters
    public void setName(Name name) {
        assert name != null;
        this.name = name;
    }
    
    public void setStartDate(StartDate startDate) {
        assert startDate != null;
        this.startDate = startDate;
    }

    public void setEndDate(EndDate endDate) {
        assert endDate != null;
        this.endDate = endDate;
    }

    public void setDescription(Description description) {
        assert description != null;
        this.description = description;
    }
    
    public void setDone() {
        assert isDone == false;
        isDone = true;
    }

    public void setTaskType(TaskType type) {
        this.type = type;
    }
    
    /**
     * Replaces this task's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    /**
     * Updates this task with the details of {@code replacement}.
     */
    public void resetData(ReadOnlyTask replacement) {
        assert replacement != null;

        this.setName(replacement.getName());
        this.setStartDate(replacement.getStartDate());
        this.setEndDate(replacement.getEndDate());
        this.setDescription(replacement.getDescription());
        this.setTags(replacement.getTags());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyTask // instanceof handles nulls
                && this.isSameStateAs((ReadOnlyTask) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, startDate, endDate, description, tags);
    }

    @Override
    public String toString() {
        return getAsText();
    }
    
}
