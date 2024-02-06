package exercise;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        for (var entry : storage.toMap().entrySet()) {
            String tempKey = entry.getKey();
            String tempValue = entry.getValue();
            storage.set(tempValue, tempKey);
            storage.unset(tempKey);
        }
    }
}
// END
