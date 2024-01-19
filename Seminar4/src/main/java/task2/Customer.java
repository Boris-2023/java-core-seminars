package task2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    // Домашнее адание №1. В класс покупателя добавить перечисление с гендерами,
    // внедрить Lombok https://habr.com/ru/articles/345520/
    enum Gender {MALE, FEMALE, ANY}
    private String fio;
    private int age;
    private String phone;
    private Gender gender;
}
