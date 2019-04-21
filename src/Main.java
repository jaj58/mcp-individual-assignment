import java.sql.Time;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
       // CarPark carPark = new CarPark();
        CustomAlgorithm test = new CustomAlgorithm();
        System.out.println(test.generateReceiptNumber("0X65 AWD",VehicleType.STANDARD, Time.valueOf(LocalTime.now()), 5,19));
        System.out.println(test.generateReceiptNumber("2222 RXP",VehicleType.STANDARD, Time.valueOf(LocalTime.now()), 5,18));
    }
}
