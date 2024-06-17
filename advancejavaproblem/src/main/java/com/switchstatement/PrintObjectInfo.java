package com.switchstatement;

record Person(String name, int age) {
}

record Car(String name, String color) {

}

public class PrintObjectInfo
{
    public static void main(String... args)
    {
        System.out.println(getObjectInfo(new Person("joe", 30)));
        System.out.println(getObjectInfo(new Car("Civic", "White")));
    }

    public static String getObjectInfo(Object object)
    {
        return switch (object)
        {
            case Person person -> "Name: %s and Age: %d".formatted(person.name(), person.age());
            case Car car -> "Name: %s and Color: %s".formatted(car.name(), car.color());
            default -> "This is default Object";
        };
    }

}
