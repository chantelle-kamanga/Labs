/**
 * Lab 4 - Intermediate exercise: multilevel inheritance (Vehicle -> Car -> ElectricCar).
 * Trace the order of constructor calls.
 *
 * EXPLAIN: when we create an ElectricCar, the constructors run from the TOP down:
 *   Vehicle first, then Car, then ElectricCar.
 * Each constructor calls super(...) as its first line, and that call runs the parent first.
 */
class Vehicle {
    Vehicle() {
        System.out.println("1. Vehicle constructor");
    }
}

class Car extends Vehicle {
    Car() {
        super();   // Java adds this line for us if we leave it out
        System.out.println("2. Car constructor");
    }
}

class ElectricCar extends Car {
    ElectricCar() {
        super();
        System.out.println("3. ElectricCar constructor");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar...");
        new ElectricCar();
    }
}
