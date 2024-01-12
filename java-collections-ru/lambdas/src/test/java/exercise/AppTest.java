package exercise;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testEnlargeArray() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"}
        };

        String[][] doubleImage = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };

        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = doubleImage;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlargeArray2() {
        String[][] image = {
                {"*", "*", "*", "*", "*", "*"},
                {"*", " ", " ", " ", " ", "*"},
                {"*", " ", " ", " ", " ", "*"},
                {"*", "*", "*", "*", "*", "*"}
        };

        String[][] doubleImage = {
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*"}
        };

        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = doubleImage;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlargeArray3() {
        String[][] image = {
        };

        String[][] doubleImage = {
        };

        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = doubleImage;
        assertThat(actual).isEqualTo(expected);
    }
}
// END
