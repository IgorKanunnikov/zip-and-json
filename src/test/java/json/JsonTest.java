package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    ClassLoader classLoader = JsonTest.class.getClassLoader();

    @Test
    void jsonJackson() throws Exception {
        InputStream is = classLoader.getResourceAsStream("person.json");
        ObjectMapper objectMapper = new ObjectMapper();
        assert is != null;
        JsonNode jsonNode = objectMapper.readTree(new InputStreamReader(is, UTF_8));

        assertThat(jsonNode.get("motherMaidenName").asText()).isEqualTo("test");
        assertThat(jsonNode.findValue("name").findValue("surname").asText()).isEqualTo("Ivan");
        assertThat(jsonNode.withArray("email").findValue("isPreferredEmailAddress").asBoolean()).isEqualTo(true);
        assertThat(jsonNode.findValue("demographics").findValue("residenceDurationInYears").asInt()).isEqualTo(10);
    }
}