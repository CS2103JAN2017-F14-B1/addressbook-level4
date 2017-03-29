package seedu.onetwodo.logic.parser;

import static seedu.onetwodo.logic.parser.CliSyntax.PREFIX_AFTER;
import static seedu.onetwodo.logic.parser.CliSyntax.PREFIX_BEFORE;
import static seedu.onetwodo.logic.parser.CliSyntax.PREFIX_PRIORITY;
import static seedu.onetwodo.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Optional;
import java.util.Set;

import seedu.onetwodo.commons.exceptions.IllegalValueException;
import seedu.onetwodo.logic.commands.Command;
import seedu.onetwodo.logic.commands.IncorrectCommand;
import seedu.onetwodo.logic.commands.ListCommand;
import seedu.onetwodo.model.DoneStatus;

//@@author A0135739W
/**
 * Parses input arguments and creates a new ListCommand object
 */
public class ListCommandParser {

    private static final String TODAY = "today";
    private static final String NOW = "now";
    private static final String TOMORROW = "tomorrow";

    /**
     * Parses the given {@code String} of arguments in the context of the ListCommand
     * and returns an ListCommand object for execution.
     */
    public Command parse(String args) {
        ArgumentTokenizer argsTokenizer = new ArgumentTokenizer(
                PREFIX_BEFORE, PREFIX_AFTER, PREFIX_PRIORITY, PREFIX_TAG);
        argsTokenizer.tokenize(args);
        Optional<String> preamble = argsTokenizer.getPreamble();
        String beforeDate = argsTokenizer.getValue(PREFIX_BEFORE).orElse("");
        String afterDate = argsTokenizer.getValue(PREFIX_AFTER).orElse("");
        String priority = argsTokenizer.getValue(PREFIX_PRIORITY).orElse("");
        Set<String> tags = ParserUtil.toSet(argsTokenizer.getAllValues(PREFIX_TAG));

        try {
            if (!preamble.isPresent()) {
                return new ListCommand(DoneStatus.UNDONE_STRING, beforeDate, afterDate, priority, tags);
            }
            switch (preamble.get().toLowerCase()) {
            case DoneStatus.DONE_STRING:
                return new ListCommand(DoneStatus.DONE_STRING, beforeDate, afterDate, priority, tags);
            case DoneStatus.ALL_STRING:
                return new ListCommand(DoneStatus.ALL_STRING, beforeDate, afterDate, priority, tags);
            case DoneStatus.UNDONE_STRING:
            case "":
                return new ListCommand(DoneStatus.UNDONE_STRING, beforeDate, afterDate, priority, tags);
            case TODAY:
                return new ListCommand(DoneStatus.UNDONE_STRING, TOMORROW, NOW, priority, tags);
            default:
                return new IncorrectCommand("Invalid list command");
            }
        } catch (IllegalValueException ive) {
            return new IncorrectCommand(ive.getMessage());
        }
    }
}
