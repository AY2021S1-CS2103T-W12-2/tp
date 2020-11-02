package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GRP;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GRP_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GRP_END_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_GRP_START_TIME;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MODULES;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Module;
import seedu.address.model.student.UniqueStudentList;
import seedu.address.model.tutorialgroup.DayOfWeek;
import seedu.address.model.tutorialgroup.TimeOfDay;
import seedu.address.model.tutorialgroup.TutorialGroup;
import seedu.address.model.tutorialgroup.TutorialGroupId;

public class EditTutorialGroupCommand extends Command {

    public static final String COMMAND_WORD = "editTG";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the specifics of the Tutorial Group specified "
        + "by the index number used in the displayed Tutorial Group list. "
        + "\nExisting values will be overwritten by the input values.\n"
        + "Parameters: INDEX (must be a positive integer) "
        + "TUTORIAL_GROUP_INDEX "
        + "Example: " + COMMAND_WORD + " 1 "
        + PREFIX_TUTORIAL_GRP + "B015"
        + PREFIX_TUTORIAL_GRP_DAY + "DAY_OF_WEEK "
        + PREFIX_TUTORIAL_GRP_START_TIME + "START_TIME (24HR HH:MM FORMAT) "
        + PREFIX_TUTORIAL_GRP_END_TIME + "END_TIME (24HR HH:MM FORMAT) \n"
        + "Example: " + COMMAND_WORD + " "
        + PREFIX_TUTORIAL_GRP + "T03 "
        + PREFIX_TUTORIAL_GRP_DAY + "MON "
        + PREFIX_TUTORIAL_GRP_START_TIME + "11:00 "
        + PREFIX_TUTORIAL_GRP_END_TIME + "13:00";;

    public static final String MESSAGE_EDIT_TUTORIAL_SUCCESS = "Edited Tutorial Group: %1$s";
    public static final String MESSAGE_DUPLICATE_TUTORIAL = "This Tutorial Group already exists in this Module.";
    public static final String MESSAGE_NOT_IN_TUTORIAL_VIEW =
            "You are currently not in the Module view. Run listMod to go back to the module view.";

    private final Index index;
    private final TutorialGroupId tutorialGroupId;
    private final DayOfWeek dayOfWeek;
    private final TimeOfDay startTime;
    private final TimeOfDay endTime;

    /**
     * Edits the selected {@code TutorialGroup}
     */
    public EditTutorialGroupCommand(Index index, TutorialGroupId tutorialGroupId, DayOfWeek dayOfWeek,
                                    TimeOfDay startTime, TimeOfDay endTime) {
        requireNonNull(index);
        requireNonNull(tutorialGroupId);

        this.index = index;
        this.tutorialGroupId = tutorialGroupId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Module> lastShownList = model.getFilteredModuleList();

        if (!model.isInTutorialGroupView()) {
            throw new CommandException(MESSAGE_NOT_IN_TUTORIAL_VIEW);
        }

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TUTORIAL_GROUP_DISPLAYED_INDEX);
        }

        TutorialGroup tutorialGroupToEdit = model.getFilteredTutorialGroupList().get(index.getZeroBased());
        UniqueStudentList originalStudentList = tutorialGroupToEdit.getUniqueStudentList();
        TutorialGroup editedTutorialGroup = new TutorialGroup(tutorialGroupId,
            dayOfWeek, startTime, endTime, originalStudentList);

        model.updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);

        if (!tutorialGroupToEdit.isSame(editedTutorialGroup) && model.hasTutorialGroup(editedTutorialGroup)) {
            throw new CommandException(MESSAGE_DUPLICATE_TUTORIAL);
        }

        model.setTutorialGroup(tutorialGroupToEdit, editedTutorialGroup);
        model.updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);
        return new CommandResult(String.format(MESSAGE_EDIT_TUTORIAL_SUCCESS, editedTutorialGroup));
    }
}
