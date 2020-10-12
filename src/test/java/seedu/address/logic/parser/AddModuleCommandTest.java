package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddModuleCommand;
import seedu.address.model.person.Module;

public class AddModuleCommandTest {

    private AddModuleCommandParser parser = new AddModuleCommandParser();

    @Test
    public void parse_validArgs_returnsAddModuleCommand() {
        //TODO change this to use TypicalModule.CS2100
        assertParseSuccess(parser, "CS2100", new AddModuleCommand(new Module("CS2100")));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, " ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddModuleCommand.MESSAGE_USAGE));
    }
}
