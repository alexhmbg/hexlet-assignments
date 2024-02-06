package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private final Map<String, String> map;
    public FileKV(String path, Map<String, String> map) {
        this.map = new HashMap<>(map);

        var stringMap = Utils.serialize(map);
        Utils.writeFile(path, stringMap);
    }

    public void readMap() {

    }
    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return map;
    }
}
// END
