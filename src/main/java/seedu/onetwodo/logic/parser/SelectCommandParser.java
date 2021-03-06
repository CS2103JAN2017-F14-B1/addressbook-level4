package seedu.onetwodo.logic.parser;

import static seedu.onetwodo.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Optional;

import seedu.onetwodo.logic.commands.Command;
import seedu.onetwodo.logic.commands.IncorrectCommand;
import seedu.onetwodo.logic.commands.SelectCommand;

/**
 * Parses input arguments and creates a new SelectCommand object
 */
public class SelectCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the SelectCommand
     * and returns an SelectCommand object for execution.
     */
    public Command parse(String args) {
        String argsTrimmed = args.trim();
        char taskType = argsTrimmed.charAt(0);
        Optional<Integer> index = ParserUtil.parseIndex(argsTrimmed.substring(1));
        if (!index.isPresent()) {
            return new IncorrectCommand(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SelectCommand.MESSAGE_USAGE));
        }

        return new SelectCommand(index.get(), taskType);
    }

}
