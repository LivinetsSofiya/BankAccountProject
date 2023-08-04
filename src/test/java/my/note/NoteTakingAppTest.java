package my.note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoteTakingAppTest {

    private NoteTakingApp app;

    @BeforeEach
    public void setUp() {
        app = new NoteTakingApp();
    }

    @Test
    public void testSaveNote() throws IOException {
        app.textArea.setText("Test save functionality");

        File tempFile = File.createTempFile("test", ".txt");
        String filePath = tempFile.getAbsolutePath();

        app.saveNote();

        assertTrue(tempFile.exists());
        String savedContent = Files.readString(tempFile.toPath());
        assertEquals("Test save functionality", savedContent.trim());
    }

    @Test
    public void testLoadNote() throws IOException {
        File tempFile = File.createTempFile("test", ".txt");
        String filePath = tempFile.getAbsolutePath();
        String fileContent = "Test is successful";
        Files.write(tempFile.toPath(), fileContent.getBytes());

        app.loadNote();

        assertEquals(fileContent, app.textArea.getText().trim());
    }
}
