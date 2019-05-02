import java.util.ArrayList;
import java.util.Calendar;

public class CarPark {
    /**
     * array list of all drivers currently active (parking,parked or collecting vehicles
     * once a driver has collected their vehicle and left the car park they are
     * removed from this array list
     */
    private ArrayList<Driver> drivers;
    /**
     * an ArrayList of all the attendants working at the car park, this allows us to check which attendants
     * are available easily by looping through them and seeing who is busy and who is not then assigning them
     * as busy if we give them a job to do
     */
    private ArrayList<Attendant> attendants;

    private long receiptNumbers[];

    private ArrayList<Zone> zones;

    /**
     * main setup function for our car park.
     */
    void setup() {
        setupZones();
    }

    /**
     * setup our different vehicle zones
     */
    void setupZones(){
        Zone zone1 = new Zone(30, ZoneType.ZONE_1);
        zone1.addAllowedVehicleType(VehicleType.STANDARD);
        zone1.addAllowedVehicleType(VehicleType.HIGH);
        zones.add(zone1);

        Zone zone2 = new Zone(15, ZoneType.ZONE_2);
        zone2.addAllowedVehicleType(VehicleType.LONG);
        zones.add(zone2);

        Zone zone3 = new Zone( 15, ZoneType.ZONE_3);
        zone3.addAllowedVehicleType(VehicleType.COACH);
        zones.add(zone3);

        Zone zone4 = new Zone( 15, ZoneType.ZONE_4);
        zone4.addAllowedVehicleType(VehicleType.STANDARD);
        zones.add(zone4);

        Zone zone5 = new Zone( 15, ZoneType.ZONE_5);
        zone5.addAllowedVehicleType(VehicleType.BIKE);
        zones.add(zone5);
    }

    Driver newDriver(){
        Driver newDriver = new Driver();
        drivers.add(newDriver);
        return newDriver;
    }
    void newAttendant(){
        Attendant newAttendant = new Attendant();
        attendants.add(newAttendant);
    }

    /**
    todo:
     need to properly handle if the vehicleType is invalid instead of just returning a null receipt...
     */

    Receipt pickUpVehicle(Receipt receipt){
        //attendant can't handle the picking up of these types of vehicles
        if(receipt.getVehicleType() == VehicleType.BIKE || receipt.getVehicleType()  == VehicleType.COACH){
            return null;
        }

        for(Attendant attendant : getAttendants()){
            if(!attendant.isBusy()) { //we have a non busy attendant to complete this job
                attendant.setBusy(true); //now doing a job so is busy.
                attendant.setReceipt(receipt);
                receipt.setEndTime(Calendar.getInstance());
            }
        }

        return null;
    }

    Receipt dropOffVehicle(VehicleType vehicleType, String vehicleRegistration) {

        //attendant can't handle the parking of these types of vehicles
        if(vehicleType == VehicleType.BIKE || vehicleType == VehicleType.COACH){
            return null;
        }

        for (Attendant attendant: getAttendants()) {
            if(!attendant.isBusy()) { //attendant is'nt busy therefore available to take the vehicle..
                attendant.setBusy(true); //attendant is now going to be busy till they have completed new job

                attendant.setVehicleType(vehicleType);
                attendant.setVehicleRegistration(vehicleRegistration);
                Zone validZone = fetchValidZone(attendant);
                Receipt newReceipt = new Receipt(attendant.getVehicleRegistration(),attendant.getVehicleType(), validZone.getZoneNumber(), validZone.findSpaceAndOccupy());
                newReceipt.setNumber(generateReceiptNumber(attendant));
                attendant.setReceipt(newReceipt);
                return newReceipt;
            }
        }
        return null;
    }

    long generateReceiptNumber(User user){
        CustomAlgorithm customAlgorithm = new CustomAlgorithm();
        return customAlgorithm.generateReceiptNumber(user.getReceipt());
    }

    Zone fetchValidZone(User user){
        Zone validZone = null;
        for (Zone z : getZones()) {
            if(z.spacesAvailable() > 0){ //there are actually spaces currently available for parking in this zone
                if(z.getAllowedVehicleTypes().contains(user.getVehicleType())){ //users vehicle type is allowed in this zone
                    validZone = z;
                    break;
                }
            }
        }
        return validZone;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<Attendant> getAttendants() {
        return attendants;
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }
}
