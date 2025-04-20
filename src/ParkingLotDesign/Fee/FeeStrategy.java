package ParkingLotDesign.Fee;

import java.time.LocalDateTime;

public interface FeeStrategy {
    double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime);
}
