import java.sql.Time;
import java.time.LocalTime;/**
    * the receipt is used to give the customers a way to pay for their car to be parked and then leave the car park
    */
public class Receipt {
    /**
     * * the vehicle registration number
     */
    private String vehicleRegistration;
    /**
     * the type of vehicle of the customer
     */
    private VehicleType vehicleType;
    /**
     * the vehicles parking zone (where the space is located)
     */
    private int parkingZone;
    /**
     * the vehicles parking space
     */
    private int parkingSpace;
    /**
     * the receipt number, this is used to pay for the parking and leave
     */
    private int number;

    /**
     * the start time, time the vehicle was parked
     */
    private Time startTime;
    /**
     * the end time, time the payment was being made...
     */
    private Time endTime;
    /**
     * @param vehicleRegistration the registration number of the vehicle
     * @param vehicleType the type of vehicle, used to assign a correct space.
     * @param parkingZone the zone the parking space of the vehicle is in
     * @param parkingSpace the parking space of the vehicle
     */
    public Receipt(String vehicleRegistration, VehicleType vehicleType,int parkingZone, int parkingSpace) {
       setVehicleRegistration(vehicleRegistration);
       setVehicleType(vehicleType);
       setParkingZone(parkingZone);
       setParkingSpace(parkingSpace);

       //set the initial parking time to when we create the receipt...
        setStartTime(Time.valueOf(LocalTime.now()));
    }
    /**
     * @return the vehicle registration number
     */
    public String getVehicleRegistration() {
        return vehicleRegistration;
    }
    /**
     * @param vehicleRegistration sets the vehicles registration number
     */
    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }
    /**
     * @return the type of vehicle
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    /**
     * @param vehicleType sets the vehicles type
     */
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    /**
     * @return the receipt number
     */
    public int getNumber() {
        return number;
    }
    /**
     * @param number sets the receipt number
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * @return the time the vehicle was parked initially
     */
    public Time getStartTime() {
        return startTime;
    }
    /**
     * @param startTime sets the time the vehicle was parked initially
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    /**
     * @return gets the time the car was retrieved from the car park so we can calculate how much it will cost
     */
    public Time getEndTime() {
        return endTime;
    }
    /**
     * @param endTime sets the end time (so when car was retrieved/ they are paying for the parking)
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the vehicles current parking space
     */
    public int getParkingSpace() {
        return parkingSpace;
    }
    /**
     * @param parkingSpace sets the vehicles parking space
     */
    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    /**
     * @return the zone the vehicle is parked in
     */
    public int getParkingZone() {
        return parkingZone;
    }

    /**
     * @param parkingZone sets the zone the vehicle is parked in to user input
     */
    public void setParkingZone(int parkingZone) {
        this.parkingZone = parkingZone;
    }
}
