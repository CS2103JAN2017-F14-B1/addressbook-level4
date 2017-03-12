package seedu.onetwodo.model.task;

//@@author A0141138N
public enum TaskType {
    TODO('T'), 
    DEADLINE('D'), 
    EVENT('E');
    
    private final char prefix;
    
    TaskType(char prefix) {
        this.prefix = prefix;
    }

    public char getPrefix() {
        return prefix;
    }
    
    public static char[] getAllPrefixes() {
        return new char[] {TODO.prefix, DEADLINE.prefix, EVENT.prefix};
    }
    
    public static TaskType getTaskTypeFromChar(char taskType) {
        char taskTypeCap = Character.toUpperCase(taskType);
        if (taskTypeCap == TODO.prefix) {
            return TODO;
        } else if (taskTypeCap == DEADLINE.prefix) {
            return DEADLINE;
        } else if (taskTypeCap == EVENT.prefix) {
            return EVENT;
        }
        return null;
    }
}
