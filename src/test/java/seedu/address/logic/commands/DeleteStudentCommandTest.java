package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showStudentAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalModulesPopulatedWithTutorialGroups.CS2103T;
import static seedu.address.testutil.TypicalModulesPopulatedWithTutorialGroups.getTypicalTrackr;
import static seedu.address.testutil.TypicalTutorialGroups.T05;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.Trackr;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Module;
import seedu.address.model.student.Student;
import seedu.address.model.tutorialgroup.TutorialGroup;

public class DeleteStudentCommandTest {

    private Model model = new ModelManager(getTypicalTrackr(), new UserPrefs());
    private Module moduleInView = CS2103T;
    private TutorialGroup tgInView = T05;

    @Test
    public void execute_validIndexUnfilteredList_success() {
        model.setViewToTutorialGroup(moduleInView);
        model.setViewToStudent(tgInView);
        Student studentToDelete = model.getFilteredStudentList().get(INDEX_FIRST_PERSON.getZeroBased());
        DeleteStudentCommand deleteStudentCommand = new DeleteStudentCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(DeleteStudentCommand.MESSAGE_DELETE_STUDENT_SUCCESS, studentToDelete);
        ModelManager expectedModel = new ModelManager(new Trackr(model.getModuleList()), new UserPrefs());
        expectedModel.setViewToTutorialGroup(moduleInView);
        expectedModel.setViewToStudent(tgInView);

        assertCommandSuccess(deleteStudentCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        model.setViewToTutorialGroup(moduleInView);
        model.setViewToStudent(tgInView);
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredStudentList().size() + 1);
        DeleteStudentCommand deleteStudentCommand = new DeleteStudentCommand(outOfBoundIndex);

        assertCommandFailure(deleteStudentCommand, model, Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
    }

    // todo: fix test case
    //    @Test
    //    public void execute_validIndexFilteredList_success() {
    //        showStudentAtIndex(model, INDEX_FIRST_PERSON, moduleInView, tgInView);
    //
    //        Student studentToDelete = model.getFilteredStudentList().get(INDEX_FIRST_PERSON.getZeroBased());
    //        DeleteStudentCommand deleteStudentCommand = new DeleteStudentCommand(INDEX_FIRST_PERSON);
    //
    //        String expectedMessage = String.format(DeleteStudentCommand.MESSAGE_DELETE_STUDENT_SUCCESS, studentToDelete);
    //        ModelManager expectedModel = new ModelManager(model.getModuleList(), new UserPrefs());
    //        expectedModel.setViewToTutorialGroup(moduleInView);
    //        expectedModel.setViewToStudent(tgInView);
    //        showNoStudent(expectedModel);
    //
    //        assertCommandSuccess(deleteStudentCommand, model, expectedMessage, expectedModel);
    //    }

    // todo: fix test case
    //    @Test
    //    public void execute_invalidIndexFilteredList_throwsCommandException() {
    //        showStudentAtIndex(model, INDEX_FIRST_PERSON, moduleInView, tgInView);
    //        Index outOfBoundIndex = INDEX_SECOND_PERSON;
    //        // ensures than outOfBoundIndex is still in bounds of student list
    //        assertTrue(outOfBoundIndex.getZeroBased()
    //                < model.getModuleList().getStudentList(moduleInView, tgInView).size());
    //        DeleteStudentCommand deleteStudentCommand = new DeleteStudentCommand(outOfBoundIndex);
    //        assertCommandFailure(deleteStudentCommand, model, Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
    //    }

    @Test
    public void equals() {
        DeleteStudentCommand deleteFirstCommand = new DeleteStudentCommand(INDEX_FIRST_PERSON);
        DeleteStudentCommand deleteSecondCommand = new DeleteStudentCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        //same values -> returns true
        DeleteStudentCommand deleteFirstCommandCopy = new DeleteStudentCommand(INDEX_FIRST_PERSON);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    /**
     * Updates {@code model}'s filtered list to show no student.
     */
    private void showNoStudent(Model model) {
        model.updateFilteredStudentList(student -> false);
        assertTrue(model.getFilteredStudentList().isEmpty());
    }
}
