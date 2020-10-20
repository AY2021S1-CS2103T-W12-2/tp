package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.Showable;
import seedu.address.model.person.Module;

import java.util.logging.Logger;

public class ShowablePanel extends UiPart<Region> {
    private static final String FXML = "ShowableListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ModuleListPanel.class);

    @FXML
    private ListView<Showable> showableListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public ShowablePanel(ObservableList<Showable> showableList) {
        super(FXML);

        showableListView.setItems(showableList);
        showableListView.setCellFactory(listView -> new ShowableListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class ShowableListViewCell extends ListCell<Showable> {
        @Override
        protected void updateItem(Showable module, boolean empty) {
            super.updateItem(module, empty);

            if (empty || module == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ModuleCard(module, getIndex() + 1).getRoot());
            }
        }
    }

}
