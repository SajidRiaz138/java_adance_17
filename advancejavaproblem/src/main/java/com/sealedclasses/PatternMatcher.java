package com.sealedclasses;

public class PatternMatcher
{
    public static void main(String... args)
    {
        Vehicle car = new Car("SampleCar");
        Vehicle truck = new Truck("Truck");

        displayVehicleName(car);
        displayVehicleName(truck);
        displayVehicleName(new Vehicle("Vehicle"));

    }

    public static void displayVehicleName(Vehicle type)
    {
        if (type instanceof Car c)
        {
            System.out.println(type.getName());
        }
        else if (type instanceof Truck t)
        {
            System.out.println(type.getName());
        }
        else
        {
            System.out.println("Unknown instance of Vehicle");
        }
    }

}
