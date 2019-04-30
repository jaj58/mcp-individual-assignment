import java.util.Calendar;

public class Tolling {
    private double zone1Charge;
    private double zone2Charge;
    private double zone3Charge;
    private double zone4Charge;
    private double zone5Charge;
    private boolean isDisabled;


    boolean pay(int amount){

    }
    int amountToPay(Receipt receipt){

        /**
         * todo:
         * need to implement loading the hourly charge's for zones out of a file that the admin can change easily...
         */

        double hourlyCharge;
        switch(receipt.getParkingZone()){
            case ZONE_1:
                hourlyCharge = zone1Charge;
                break;
            case ZONE_2:
                hourlyCharge = zone2Charge;
                break;
            case ZONE_3:
                hourlyCharge = zone3Charge;
                break;
            case ZONE_4:
                hourlyCharge = zone4Charge;
                break;
            case ZONE_5:
                hourlyCharge = zone5Charge;
                break;
            default:
                hourlyCharge = 1;
        }
        receipt.setEndTime(Calendar.getInstance());
        double timeSpentInCarParkMillis = receipt.getEndTime().getTimeInMillis() - receipt.getStartTime().getTimeInMillis();

        if(receipt.getVehicleType() != VehicleType.COACH && ( 7 == Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) ){   //if it's sunday and the vehicle is not a coach parking is free...
            return 0;
        }


        if(isDisabled){ //if someone is disabled they get half price on parking....
            return 0 / 2;
        }
        else {
            return 0;
        }
    }
    /* WhY cAnT jAvA jUsT hAvE gLoBaL vArIaBlEs
     */
    boolean loadConfig(String fileName){
        if(fileName == null){
            throw new IllegalArgumentException("filename cannot be null...");
        }



    }


}
