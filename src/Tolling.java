import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Tolling {
    private double zone1Charge;
    private double zone2Charge;
    private double zone3Charge;
    private double zone4Charge;
    private double zone5Charge;
    private boolean isDisabled;

    Tolling(String configFileName){
        try {
            loadConfig(configFileName);
        } catch (IOException e) {
            System.out.println("Failed to find defined config file...");
            e.printStackTrace();
        }
    }


    boolean pay(double amount){
        return false;
    }
    double amountToPay(Receipt receipt){
        double hourlyCharge;
        switch(receipt.getParkingZone()){
            case ZONE_2:
                hourlyCharge = getZone2Charge();
                break;
            case ZONE_3:
                hourlyCharge = getZone3Charge();
                break;
            case ZONE_4:
                hourlyCharge = getZone4Charge();
                break;
            case ZONE_5:
                hourlyCharge = getZone5Charge();
                break;
            case ZONE_1:
            default:
                hourlyCharge = getZone1Charge();
                break;
        }
        receipt.setEndTime(Calendar.getInstance());
        double timeSpentMillis = receipt.getEndTime().getTimeInMillis() - receipt.getStartTime().getTimeInMillis();
        double timeSpentHours = timeSpentMillis / 3600; //divide by 60 to get into minutes then 60 again to get into hours..
        //timeSpentHours will be a whole number so we need to round up by one hour since our ticketing system
        //works by rounding up to the nearest hour not down.
        timeSpentHours += 1;

        if(receipt.getVehicleType() != VehicleType.COACH && ( Calendar.SUNDAY == Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) ){   //if it's sunday and the vehicle is not a coach parking is free...
            return 0; //free
        }

        if(isDisabled()){ //if someone is disabled they get half price on parking....
            return ((timeSpentHours * hourlyCharge) / 2);
        }
        else {
            return (timeSpentHours * hourlyCharge);
        }
    }

    private boolean loadConfig(String fileName) throws IOException {
        if(fileName == null){
            throw new IllegalArgumentException("filename cannot be null...");
        }
        try(FileReader read = new FileReader(fileName); BufferedReader buffer = new BufferedReader(read); Scanner file = new Scanner(buffer)){
            file.useDelimiter("\r?\n|\r");
            while(file.hasNext()){ //has valid input
                setDisabled(file.nextBoolean());
                setZone1Charge(file.nextInt());
                setZone2Charge(file.nextInt());
                setZone3Charge(file.nextInt());
                setZone4Charge(file.nextInt());
                setZone5Charge(file.nextInt());
                return true;
            }
        }
        return false;
    }

    public double getZone1Charge() {
        return zone1Charge;
    }

    public void setZone1Charge(double zone1Charge) {
        this.zone1Charge = zone1Charge;
    }

    public double getZone2Charge() {
        return zone2Charge;
    }

    public void setZone2Charge(double zone2Charge) {
        this.zone2Charge = zone2Charge;
    }

    public double getZone3Charge() {
        return zone3Charge;
    }

    public void setZone3Charge(double zone3Charge) {
        this.zone3Charge = zone3Charge;
    }

    public double getZone4Charge() {
        return zone4Charge;
    }

    public void setZone4Charge(double zone4Charge) {
        this.zone4Charge = zone4Charge;
    }

    public double getZone5Charge() {
        return zone5Charge;
    }

    public void setZone5Charge(double zone5Charge) {
        this.zone5Charge = zone5Charge;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }


}
