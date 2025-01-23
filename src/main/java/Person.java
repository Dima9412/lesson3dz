import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;

    // Конструкторы
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Сериализация объекта в файл
    public static void serializeToFile(Person person, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
            System.out.println("Объект успешно сериализован в файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Десериализация объекта из файла
    public static Person deserializeFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        Person person = new Person("Максим", 20);
        String filePath = "person.ser";

        // Сериализация
        serializeToFile(person, filePath);

        // Десериализация
        Person deserializedPerson = deserializeFromFile(filePath);
        System.out.println("Десериализованный объект: " + deserializedPerson);
    }
}
