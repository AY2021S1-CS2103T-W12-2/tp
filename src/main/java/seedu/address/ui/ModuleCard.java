package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.Showable;
import seedu.address.model.TutorialGroup;
import seedu.address.model.person.Module;

public class ModuleCard extends UiPart<Region> {
    private static final String FXML = "ModuleListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Showable module;

    @FXML
    private HBox cardPane;
    @FXML
    private Label moduleId;
    @FXML
    private Label id;
    @FXML
    private Label totalStudents;
    @FXML
    private Label totalGroups;
    //    @FXML
    //    private FlowPane tags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public ModuleCard(Showable showable, int displayedIndex) {
        super(FXML);
        this.module = showable;

        if (showable instanceof Module) {
            Module module = (Module) showable;
            id.setText(displayedIndex + ". ");
            moduleId.setText(module.getModuleId());
            totalStudents.setText("Total Students: " + module.getTotalStudents());
            totalGroups.setText("Total Groups: " + module.getTotalGroups());
            //        person.getTags().stream()
            //                .sorted(Comparator.comparing(tag -> tag.tagName))
            //                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        } else if (showable instanceof TutorialGroup) {
            TutorialGroup tg = (TutorialGroup) showable;
            id.setText(displayedIndex + ". ");
            moduleId.setText(tg.getId());
        } else {
            moduleId.setText("FOR STUDENT");
        }

    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModuleCard)) {
            return false;
        }

        // state check
        ModuleCard card = (ModuleCard) other;
        return id.getText().equals(card.id.getText())
                && module.equals(card.module);
    }
}
