package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Entity
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode(of = {"title", "price"})
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String title;
    int price;

    public Product() {
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
// Создайте модель Product со свойствами, которая будет представлять товар.
// У товара есть уникальный идентификатор, название title и цена price.
// Идентификатор должен генерироваться автоматически.
// Укажите аннотацию EqualsAndHashCode так, чтобы объект сравнивался по названию и цене.
// Если название и цена совпадает — значит товары одинаковые
// END
