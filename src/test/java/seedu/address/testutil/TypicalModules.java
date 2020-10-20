package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.ModuleList;
import seedu.address.model.Module;

/**
 * A utility class containing a list of {@code Module} objects to be used in tests.
 */
public class TypicalModules {
    public static final Module CS2100 = new Module("CS2100");
    public static final Module CS2103T = new Module("CS2103T");
    public static final Module CS2040 = new Module("CS2040");

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static ModuleList getTypicalModuleList() {
        ModuleList ab = new ModuleList();
        for (Module module: getTypicalModules()) {
            ab.addModule(module);
        }
        return ab;
    }

    public static List<Module> getTypicalModules() {
        return new ArrayList<>(Arrays.asList(CS2100, CS2103T, CS2040));
    }
}
