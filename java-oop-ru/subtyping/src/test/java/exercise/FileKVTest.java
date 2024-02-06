package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void fileKVTest() {
        var stringPath = String.valueOf(filepath);
        var map = new HashMap<>(Map.of("key", "value", "key2", "value2", "key3", "value3"));
        new FileKV(stringPath, map);

        var readFile = Utils.readFile(stringPath);
        var fileToMap = Utils.unserialize(readFile);

        assertThat(fileToMap.get("key1")).isEqualTo(map.get("key1"));
        assertThat(fileToMap.get("key2")).isEqualTo(map.get("key2"));
        assertThat(fileToMap.get("key5")).isEqualTo(map.get("key5"));
    }
    // END
}
