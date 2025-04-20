package ParkingLotDesign;

import ParkingLotDesign.Fee.FeeStrategy;
import ParkingLotDesign.Fee.FourWheelerFeeStrategy;
import ParkingLotDesign.Fee.TwoWheelerFeeStrategy;
import ParkingLotDesign.Spot.ParkingSpot;
import ParkingLotDesign.Spot.SpotType;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {

    private Map<SpotType, List<ParkingSpot>> spotMap = new HashMap<>();
    private Map<String, Ticket> activeTickets = new HashMap<>();
    private Map<VehicleType, FeeStrategy> feeStrategyMap = new HashMap<>();

    public ParkingLot() {
        spotMap.put(SpotType.TWO_WHEELER, new ArrayList<>());
        spotMap.put(SpotType.FOUR_WHEELER, new ArrayList<>());
        feeStrategyMap.put(VehicleType.TWO_WHEELER, new TwoWheelerFeeStrategy());
        feeStrategyMap.put(VehicleType.FOUR_WHEELER, new FourWheelerFeeStrategy());
    }

    public void addSpot(ParkingSpot spot) {
        spotMap.get(spot.getSpotType()).add(spot);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        SpotType spotType = SpotType.valueOf(vehicle.getType().name());

        for (ParkingSpot spot : spotMap.get(spotType)) {
            if(spot.isFree()) {
                spot.assignVehicle(vehicle);
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket(ticketId, vehicle, spot);
                activeTickets.put(ticketId, ticket);
                System.out.println("Vehicle parked at spot: "+spot.getId());
                return ticket;
            }
        }

        System.out.println("No spot available for Vehicle type: "+ vehicle.getType());
        return null;
    }

    public void unParkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if(ticket != null) {
            LocalDateTime exitTime = LocalDateTime.now();
            FeeStrategy feeStrategy = feeStrategyMap.get(ticket.getVehicle().getType());
            double fee = feeStrategy.calculateFee(ticket.getEntryTime(), exitTime);

            ticket.getSpot().removeVehicle();
            activeTickets.remove(ticketId);
            System.out.println("vehicle unparked from spot: "+ ticket.getSpot().getId());
            System.out.println("Total fee: Rs"+fee);
        } else {
            System.out.println("Invalid ticket");
        }
    }

    public void showAvailableSpots() {
        for (SpotType type : spotMap.keySet()) {
            long count = spotMap.get(type).stream().filter(ParkingSpot::isFree).count();
            System.out.println(type+": "+count+" spots free");
        }
    }
}
