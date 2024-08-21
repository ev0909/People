import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: Укажите ваше имя");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: Укажите вашу фамилию");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0 && age < 120) {
            this.age = OptionalInt.of(age);
        } else {
            throw new IllegalArgumentException("Некорректно введён возраст !");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null || name.isEmpty() || surname.isEmpty()) {
            throw new IllegalStateException("Данные указаны не полностью !");
            } else if (age.isPresent()) {
            return new Person(name, surname, age.getAsInt(), address);
        } else {
            return new Person(name, surname, address);
        }
    }

}
