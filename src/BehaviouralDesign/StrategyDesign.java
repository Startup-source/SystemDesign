package BehaviouralDesign;


interface VehicleDrive{
    public void drive();
}

class NormalDrive implements VehicleDrive {
    @Override
    public void drive() {
        System.out.println("Normal Drive");
    }
}


class SportDrive implements VehicleDrive {
    @Override
    public void drive() {
        System.out.println("Sport Drive");
    }
}

class OffRoadDrive implements VehicleDrive {
    @Override
    public void drive() {
        System.out.println("Off road driving");
    }
}

class Vehicles {
    private VehicleDrive vehicleDrive;
    public Vehicles(VehicleDrive vehicleDrive) {
        this.vehicleDrive = vehicleDrive;
    }

    public void performDrive(){
        vehicleDrive.drive();
    }

    public void setVehicleDrive(VehicleDrive vehicleDrive) {
        this.vehicleDrive = vehicleDrive;
    }
}

class SportVehicle extends Vehicles {
   public SportVehicle(VehicleDrive vehicleDrive) {
        super(vehicleDrive);
    }

    public void testingDrive(){
        performDrive();
    }
}

public class StrategyDesign {
    public static void main(String[] arg) {
        SportVehicle sportVehicle = new SportVehicle(new SportDrive());
        sportVehicle.testingDrive();

        sportVehicle.setVehicleDrive(new OffRoadDrive());
        sportVehicle.testingDrive();
    }
}
