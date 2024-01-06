package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        Assertions.assertNotSame(App.take(list, list.size()), list);
        Assertions.assertEquals(App.take(list, 0), list.subList(0, 0));
        Assertions.assertEquals(App.take(list, 3), list.subList(0, 3));
        Assertions.assertEquals(App.take(list, 10), list.subList(0, 5));
        // END
    }
}
