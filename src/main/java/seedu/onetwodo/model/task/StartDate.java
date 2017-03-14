package seedu.onetwodo.model.task;


import java.time.LocalDateTime;
import java.util.Optional;

import seedu.onetwodo.commons.exceptions.IllegalValueException;
import seedu.onetwodo.logic.parser.DateTimeParser;

/**
 * Represents a Task's start date in the toDo list.
 */
public class StartDate extends Date {
    
    /**
     * Create a start date.
     *
     * @throws IllegalValueException if given date toDo string is invalid.
     */
    public StartDate(String dateString) throws IllegalValueException {
        super(dateString);
        assert dateString != null;
        defaultDateTime.withHour(0).withMinute(0);
        String trimmedInput = dateString.trim();
        this.localDateTime = DateTimeParser.parseDateTime(trimmedInput, defaultDateTime);
        this.value = createDisplayValue(localDateTime);
    }
    
    /**
     * 
     * @param localDateTime input optional LocalDateTime
     * @return String to be displayed to user.
     */
    @Override
    public String createDisplayValue(Optional<LocalDateTime> localDateTime) {
        if(!localDateTime.isPresent()) {
            return "";
        } else {
            return "Start: " + localDateTime.get().toLocalDate().toString() 
                    + " " + localDateTime.get().toLocalTime().toString();
        }
    }
    
}
