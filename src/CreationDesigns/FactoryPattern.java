package CreationDesigns;

interface Vehicle{
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("CreationDesigns.Car");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("CreationDesigns.Bike");
    }
}


public class FactoryPattern {

    public static Vehicle createVehicle(String type) {
        return switch (type.toLowerCase()) {
            case "car" -> new Car();
            case "bike" -> new Bike();
            default -> throw new IllegalArgumentException();
        };
    }
}
