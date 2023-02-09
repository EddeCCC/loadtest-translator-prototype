package dq.dqlang;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class APISchemaTest {

    private final String file = "apiSchema.json";

    @Test
    void objectMapperDoesNotThrowException() throws IOException {
        String apiSchemaJSON = this.loadSchema(file);
        ObjectMapper objectMapper = new ObjectMapper();

        assertDoesNotThrow(() -> objectMapper.readValue(apiSchemaJSON, APISchema.class));
    }

    private String loadSchema(String filePath) throws IOException {
        String resources = this.getResources();
        String absolutePath = resources + filePath;
        return Files.readString(Paths.get(absolutePath));
    }

    private String getResources() {
        String resources = new File("src/test/resources").getAbsolutePath();
        return resources + "/dqlang/";
    }
}