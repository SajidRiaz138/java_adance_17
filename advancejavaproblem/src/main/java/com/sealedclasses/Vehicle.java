package com.sealedclasses;

public sealed class Vehicle permits Car, Truck
{
    private String name;

    Vehicle(String name)
    {
        this.name = name;
    }

    public static void main(String... args)
    {
        System.out.println(new Vehicle("Generic Vehicle").getName());
        System.out.println(new Car("Tesla").getName());
        System.out.println(new Truck("FourWheeler").getName());
    }

    public String getName()
    {
        return name;
    }
}

final class Car extends Vehicle
{
    Car(String name)
    {
        super(name);
    }
}

final class Truck extends Vehicle
{
    Truck(String name)
    {
        super(name);
    }
}
