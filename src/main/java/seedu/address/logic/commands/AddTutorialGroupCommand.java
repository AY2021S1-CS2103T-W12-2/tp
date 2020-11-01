package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GRP;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GRP_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GRP_END_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GRP_START_TIME;

import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tutorialgroup.TutorialGroup;


public class AddTutorialGroupCommand extends Command {

    public static final String COMMAND_WORD = "addTG";
    public static final String MESSAGE_SUCCESS = "Tutorial Group has been added";
    public static final String MESSAGE_DUPLICATE_TUTORIAL_GRP = "This Tutorial Group already exists";
    public static final String MESSAGE_IN_MODULE_VIEW = "You are currently in Module View. "
        + "Use viewTG MODULE_INDEX to view the Tutorial Groups of the Module you want";
    public static final String MESSAGE_NOT_IN_TUTORIAL_VIEW = "You are currently not in the Tutorial Group view. "
        + "Use listTG to go back to the tutorial group view.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a Tutorial Group to a Module. "
        + "Parameters: "
        + PREFIX_TUTORIAL_GRP + "TUTORIAL_GROUP_CODE "
        + PREFIX_TUTORIAL_GRP_DAY + "DAY_OF_WEEK "
        + PREFIX_TUTORIAL_GRP_START_TIME + "START_TIME "
        + PREFIX_TUTORIAL_GRP_END_TIME + "END_TIME ";

    private final TutorialGroup toAdd;

    /**
     * Main constructor, called by the AddTutorialGroupCommand Parser
     * @param tutorialGroup
     */
    public AddTutorialGroupCommand(TutorialGroup tutorialGroup) {
        requireNonNull(tutorialGroup);
        toAdd = tutorialGroup;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<TutorialGroup> lastShownList = model.getFilteredTutorialGroupList();

        if (model.isInModuleView()) {
            throw new CommandException(MESSAGE_IN_MODULE_VIEW);
        } else if (model.isInStudentView()) {
            throw new CommandException(MESSAGE_NOT_IN_TUTORIAL_VIEW);
        } else if (lastShownList.contains(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_TUTORIAL_GRP);
        }

        model.addTutorialGroup(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddTutorialGroupCommand // instanceof handles nulls
                && toAdd.equals(((AddTutorialGroupCommand) other).toAdd));
    }
}
