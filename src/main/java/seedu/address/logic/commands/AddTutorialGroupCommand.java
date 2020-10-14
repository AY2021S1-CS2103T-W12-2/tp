package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.TutorialGroup;


public class AddTutorialGroupCommand extends Command {

    public static final String COMMAND_WORD = "addTG";
    public static final String MESSAGE_SUCCESS = "Tutorial Group has been added";
    public static final String MESSAGE_DUPLICATE_TUTGRP = "This Tutorial Group already exists";
    public static final String MESSAGE_USAGE = "This is the message usage";


    private final TutorialGroup toAdd;

    /**
     * Main constructor, called by the AddTutorialGroupCommand Parser
     * @param tutorialGroup
     */
    public AddTutorialGroupCommand(TutorialGroup tutorialGroup) {
        requireNonNull(tutorialGroup);
        toAdd = tutorialGroup;
    }

    // todo Implement execution of TG Addition
    @Override
    public CommandResult execute(Model model) throws CommandException {
//        requireNonNull(model);
//
//        if (model.hasTutorialGroup(toAdd)) {
//            throw new CommandException(MESSAGE_DUPLICATE_TUTGRP);
//        }
//        System.out.println("after");
//
//        model.addTutorialGroup(toAdd);
//        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        return new CommandResult("NOT IMPLEMENTED YET");
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddTutorialGroupCommand) other).toAdd));
    }
}
