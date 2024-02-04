package exercise;

import java.util.List;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> realEstate, int qty) {
        List<String> list = realEstate.stream()
                .sorted(Home::compareTo)
                .limit(qty)
                .map(Object::toString)
                .toList();

        return list;
    }
}
// END
