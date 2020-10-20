package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.Model;
import seedu.address.model.Module;
import seedu.address.model.ModuleList;
import seedu.address.model.ReadOnlyModuleList;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.TutorialGroup;

public class AddCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    //    @Test
    //    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
    //        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
    //        Person validPerson = new PersonBuilder().build();
    //
    //        CommandResult commandResult = new AddCommand(validPerson).execute(modelStub);
    //
    //        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validPerson), commandResult.getFeedbackToUser());
    //        assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
    //    }
    //
    //    @Test
    //    public void execute_duplicatePerson_throwsCommandException() {
    //        Person validPerson = new PersonBuilder().build();
    //        AddCommand addCommand = new AddCommand(validPerson);
    //        ModelStub modelStub = new ModelStubWithPerson(validPerson);
    //
    //        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON,
    //        () -> addCommand.execute(modelStub));
    //    }
    //
    //    @Test
    //    public void equals() {
    //        Person alice = new PersonBuilder().withName("Alice").build();
    //        Person bob = new PersonBuilder().withName("Bob").build();
    //        AddCommand addAliceCommand = new AddCommand(alice);
    //        AddCommand addBobCommand = new AddCommand(bob);
    //
    //        // same object -> returns true
    //        assertTrue(addAliceCommand.equals(addAliceCommand));
    //
    //        // same values -> returns true
    //        AddCommand addAliceCommandCopy = new AddCommand(alice);
    //        assertTrue(addAliceCommand.equals(addAliceCommandCopy));
    //
    //        // different types -> returns false
    //        assertFalse(addAliceCommand.equals(1));
    //
    //        // null -> returns false
    //        assertFalse(addAliceCommand.equals(null));
    //
    //        // different person -> returns false
    //        assertFalse(addAliceCommand.equals(addBobCommand));
    //    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getModuleListFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setModuleListFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addModule(Module module) {
            throw new AssertionError("This method should not be called.");
        }

        //        @Override
        //        public void addTutorialGroup(TutorialGroup tutorialGroup) {
        //            throw new AssertionError("This method should not be called.");
        //        }
        //
        //        @Override
        //        public boolean hasTutorialGroup(TutorialGroup tutorialGroup) {
        //            throw new AssertionError("This method should not be called.");
        //        }

        @Override
        public void setModuleList(ReadOnlyModuleList newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyModuleList getModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasModule(Module module) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteModule(Module module) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setModule(Module target, Module editedModule) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Module> getFilteredModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredModuleList(Predicate<Module> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithModule extends ModelStub {
        private final Module module;

        ModelStubWithModule(Module module) {
            requireNonNull(module);
            this.module = module;
        }

        @Override
        public boolean hasModule(Module module) {
            requireNonNull(module);
            return this.module.isSameModule(module);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingModuleAdded extends ModelStub {
        final ArrayList<Module> modulesAdded = new ArrayList<>();
        final ArrayList<TutorialGroup> tutorialGroupsAdded = new ArrayList<>();

        public boolean hasTutorialGroup(TutorialGroup tutorialGroup) {
            requireNonNull(tutorialGroup);
            return tutorialGroupsAdded.stream().anyMatch(tutorialGroup::isSameTutorialGroup);
        }

        //        @Override
        //        public void addTutorialGroup(TutorialGroup tutorialGroup) {
        //            requireNonNull(tutorialGroup);
        //            tutorialGroupsAdded.add(tutorialGroup);
        //        }

        @Override
        public boolean hasModule(Module module) {
            requireNonNull(module);
            return modulesAdded.stream().anyMatch(module::isSameModule);
        }

        @Override
        public void addModule(Module module) {
            requireNonNull(module);
            modulesAdded.add(module);
        }

        @Override
        public ReadOnlyModuleList getModuleList() {
            return new ModuleList();
        }
    }

}
