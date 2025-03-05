package com.kcar.debug;

import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Honda", "Accord", "Red"),
                new Car("Toyota", "Camry", "Blue"),
                new Car("Ford", "F-150", "Black"),
                new Car("Chevrolet", "Malibu", "White"),
                new Car("Nissan", "Altima", "Silver"),
                new Car("Tesla", "Model 3", "Red"),
                new Car("BMW", "X5", "Gray"),
                new Car("Audi", "A4", "Black"),
                new Car("Mercedes-Benz", "C-Class", "Blue"),
                new Car("Hyundai", "Elantra", "Green"),
                new Car("Kia", "Sorento", "Orange"),
                new Car("Mazda", "CX-5", "White"),
                new Car("Volkswagen", "Passat", "Blue"),
                new Car("Subaru", "Impreza", "Silver"),
                new Car("Volvo", "XC90", "Black"),
                new Car("Jeep", "Wrangler", "Green"),
                new Car("Dodge", "Charger", "Red"),
                new Car("Lexus", "RX", "Black"),
                new Car("Jaguar", "XF", "White"),
                new Car("Porsche", "911", "Yellow")
        );

        cars.stream().filter(car -> car.color.equals("Black"))
                .map(car -> car.brand + " " + car.model)
                .forEach(System.out::println);

        cars.forEach(System.out::println);
    }

    record Car(String brand, String model, String color) {
    }
}
