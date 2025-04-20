package ParkingLotDesign;

import ParkingLotDesign.Spot.FourWheelerSpot;
import ParkingLotDesign.Spot.TwoWheelerSpot;

public class ParkingSystem {

    public static void main(String[] arg) {
        ParkingLot lot = new ParkingLot();
        lot.addSpot(new TwoWheelerSpot("t1"));
        lot.addSpot(new TwoWheelerSpot("t2"));
        lot.addSpot(new FourWheelerSpot("f1"));
        lot.addSpot(new FourWheelerSpot("f2"));

        lot.showAvailableSpots();

        Vehicle car = new Vehicle("UP70CAR1", VehicleType.FOUR_WHEELER);
        Ticket ticket1 = lot.parkVehicle(car);

        lot.showAvailableSpots();

        lot.unParkVehicle(ticket1.getId());

        lot.showAvailableSpots();
    }
}
