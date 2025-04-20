package ParkingLotDesign.Fee;

import java.time.Duration;
import java.time.LocalDateTime;

public class FourWheelerFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        long hours = Math.max(1, Duration.between(entryTime, exitTime).toHours());
        return hours * 20;
    }
}
