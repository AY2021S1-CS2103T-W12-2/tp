package seedu.address.logic.commands;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TUTORIALGROUPS;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Module;

public class ListTutorialGroupCommand extends Command {
    public static final String COMMAND_WORD = "listTG";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Views all the modules.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_VIEWING_TUTORIALGROUPS_SUCCESS = "Viewing all tutorial groups of: %1$s";

    public ListTutorialGroupCommand() { }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if(model.isInModuleView()) {
            throw new CommandException("This command cannot be used in Module View, use viewTG MODULE_INDEX to specify which Module's" +
                "Tutorial Groups you would like to view.");
        }
        model.updateFilteredTutorialGroupList(PREDICATE_SHOW_ALL_TUTORIALGROUPS);
        Module mod = model.getCurrentModuleInView();
        return new CommandResult(String.format(MESSAGE_VIEWING_TUTORIALGROUPS_SUCCESS, mod),
                false, false, true, false, false);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListTutorialGroupCommand); // instanceof handles nulls
    }
}
