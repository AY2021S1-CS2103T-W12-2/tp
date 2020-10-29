package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleId;

import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class ModuleBuilder {

    public static final String DEFAULT_MODULE_ID = "CS2100";

    private ModuleId moduleId;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public ModuleBuilder() {
        moduleId = new ModuleId(DEFAULT_MODULE_ID);
    }

    /**
     * Initializes the ModuleBuilder with the data of {@code moduleToCopy}.
     */
    public ModuleBuilder(Module moduleToCopy) {
        moduleId = moduleToCopy.getModuleId();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public ModuleBuilder withModuleId(String moduleId) {
        this.moduleId = new ModuleId(moduleId);
        return this;
    }

    public Module build() {
        return new Module(moduleId);
    }

}

