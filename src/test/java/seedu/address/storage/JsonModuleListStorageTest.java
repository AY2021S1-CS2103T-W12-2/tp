package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.testutil.Assert.assertThrows;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyTrackr;
import seedu.address.model.Trackr;
import seedu.address.model.module.Module;

public class JsonModuleListStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonModuleStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readAddressBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readAddressBook(null));
    }

    private java.util.Optional<ReadOnlyTrackr<Module>> readAddressBook(String filePath) throws Exception {
        return new JsonModuleListStorage(Paths.get(filePath)).readModuleList(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readAddressBook("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readAddressBook("notJsonFormatModuleList.json"));
    }

    @Test
    public void readAddressBook_invalidPersonAddressBook_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readAddressBook("invalidModuleModuleList.json"));
    }

    @Test
    public void readAddressBook_invalidAndValidPersonAddressBook_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readAddressBook("invalidAndValidModuleModuleList.json"));
    }

    //    @Test
    //    public void readAndSaveAddressBook_allInOrder_success() throws Exception {
    //        Path filePath = testFolder.resolve("TempModuleList.json");
    //        UniqueStudentList original = getTypicalStudentList();
    //        JsonAddressBookStorage jsonAddressBookStorage = new JsonAddressBookStorage(filePath);
    //
    //        // Save in new file and read back
    //        jsonAddressBookStorage.saveAddressBook(original, filePath);
    //        ReadOnlyAddressBook readBack = jsonAddressBookStorage.readAddressBook(filePath).get();
    //        assertEquals(original, new AddressBook(readBack));
    //
    //        // Modify data, overwrite exiting file, and read back
    //        original.(BENG);
    //        original.removePerson(ALICE);
    //        jsonAddressBookStorage.saveAddressBook(original, filePath);
    //        readBack = jsonAddressBookStorage.readAddressBook(filePath).get();
    //        assertEquals(original, new AddressBook(readBack));
    //
    //        // Save and read without specifying file path
    //        original.addPerson(IDA);
    //        jsonAddressBookStorage.saveAddressBook(original); // file path not specified
    //        readBack = jsonAddressBookStorage.readAddressBook().get(); // file path not specified
    //        assertEquals(original, new AddressBook(readBack));
    //
    //    }

    @Test
    public void saveAddressBook_nullAddressBook_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveModuleList(null, "SomeFile.json"));
    }

    /**
     * Saves {@code addressBook} at the specified {@code filePath}.
     */
    private void saveModuleList(ReadOnlyTrackr<Module> moduleList, String filePath) {
        try {
            new JsonModuleListStorage(Paths.get(filePath))
                    .saveModuleList(moduleList, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveAddressBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveModuleList(new Trackr(), null));
    }
}
