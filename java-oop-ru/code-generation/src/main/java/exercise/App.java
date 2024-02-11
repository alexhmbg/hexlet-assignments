package exercise;

import lombok.SneakyThrows;

import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
class App {
    @SneakyThrows
    public static void save(Path path, Car car) {
        var serialized = car.serialize();
        var bytesOfString = serialized.getBytes();
        Files.write(path, bytesOfString);
    }
    @SneakyThrows
    public static Car extract(Path path) {
        var fileToString = new String(Files.readAllBytes(path));
        var stringToCar = Car.unserialize(fileToString);

        return stringToCar;
    }
}
// END
