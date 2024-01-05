package exercise;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// BEGIN
class App {
    public static <T, E> List<Map<T, E>> findWhere(List<Map<T, E>> books, Map<T, E> where) {
        var resultBooks = new ArrayList<Map<T, E>>();

        for (var book : books) {
            if (book.entrySet().containsAll(where.entrySet())) {
                resultBooks.add(book);
            }
        }

        return resultBooks;
    }
}
//END
