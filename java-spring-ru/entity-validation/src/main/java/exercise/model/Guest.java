package exercise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;




@Entity
@Table(name = "guests")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Guest {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    // BEGIN
    @NotBlank
    private String name;

    @Email
    private String email;

    @Column(unique = true)
    @Pattern(regexp = "\\+[0-9]{11,13}")
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}")
    private String clubCard;

    @Future
    private LocalDate cardValidUntil;
    // END

    @CreatedDate
    private LocalDate createdAt;
}
// Опираясь на интерфейс в классе `GuestDTO`, допишите модель, которая будет представлять в приложении гостя мероприятия. Добавьте необходимые аннотации для валидации полей модели.
//
//Валидация должна происходить по следующим правилам:
//
//* Имя пользователя *name* должно быть не пустым
//* Электронная почта *email* должна быть валидной
//* Номер телефона *phoneNumber* должен начинаться с символа *+* и содержать от 11 до 13 цифр
//* Номер клубной карты *clubCard* должен состоять ровно из четырех цифр
//* Срок действия клубной карты *cardValidUntil* должен быть еще не истекшим