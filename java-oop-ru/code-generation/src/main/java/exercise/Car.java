package exercise;

import lombok.SneakyThrows;
import lombok.Value;

import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {

    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(this);
    }

@SneakyThrows
    public static Car unserialize(String string) {
         ObjectMapper mapper = new ObjectMapper();
         Car car = mapper.readValue(string, Car.class);

         return car;
    }
    // END
}
