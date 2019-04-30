import java.util.ArrayList;
import java.util.Arrays;

public class Zone {
    /**
     * car park spaces in this zone
     */
    private Space spaces[];
    /**
     * the type of car park spaces in this zone
     */
    private ArrayList<VehicleType> allowedVehicleTypes;
    /**
     * the amount of spaces in the zone
     */
    private int amountOfSpaces;
    /**
     * the number of the zone, makes it easier to identify which zone is which (could use names instead)
     */
    private ZoneType zoneNumber;
    /**
     * @param amountOfSpaces sets the total amount of spaces the zone has
     * @param zoneNumber assigns the zone a number so we can identify it easier
     */
    public Zone(int amountOfSpaces, ZoneType zoneNumber){
        setZoneNumber(zoneNumber);
        setAmountOfSpaces(amountOfSpaces);

        //creating our array of spaces to the user defined amount.
        spaces = new Space[getAmountOfSpaces()];

        /*
        looping through the newly created array of spaces
        and setting all spaces to empty.
        */
        for (int i = 0; i < getAmountOfSpaces(); i++){
            spaces[i] = Space.EMPTY;
        }
    }
    /**
     * @return the vehicle type(s) allowed in this zone
     */
    public ArrayList<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }
    /**
     * @param allowedVehicleTypes sets the type(s) of vehicle allowed in the zone to the user input
     */
    public void setAllowedVehicleTypes(ArrayList<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }
    /**
     * @param vehicleType adds the user inputted VehicleType to the allowed VehicleTypes allowed in this zone's ArrayList.
     */
    public void addAllowedVehicleType(VehicleType vehicleType){
        allowedVehicleTypes.add(vehicleType);
    }
    /**
     * @return the amount of spaces in the zone (occupied or empty)
     */
    public int getAmountOfSpaces() {
        return amountOfSpaces;
    }
    /**
     * @param amountOfSpaces sets the total amount of spaces to the user input
     */
    public void setAmountOfSpaces(int amountOfSpaces) {
        this.amountOfSpaces = amountOfSpaces;
    }
    /**
     * @return the array of the spaces
     */
    public Space[] getSpaces() {
        return spaces;
    }

    /**
     * @return the first empty space it finds in the zone and sets it to occupied since we are going to park a vehicle there
     */
    public int findSpaceAndOccupy(){
        int spaceID = 0;
        for(Space space : getSpaces()){
            if(space.equals(Space.EMPTY)){
                setSpace(spaceID, Space.OCCUPIED);
                return spaceID;
            }
            spaceID++;
        }
        return spaceID;
    }
    /**
     * @param spaceID the space id of the space in this zone that should be set
     * @param space overrides a space with this using the space id the user gives in
     */
    public void setSpace(int spaceID, Space space) {
        //checks the spaceID is within our array's boundaries so we don't get an out of bounds error
        if(spaceID >= getAmountOfSpaces() || spaceID < 0){
            StringBuilder error = new StringBuilder("invalid space id, this zone only has ");
            error.append(getAmountOfSpaces());
            error.append(" spaces (0-");
            error.append((getAmountOfSpaces() - 1));
            error.append(")");
            System.out.println(error);
        }else {
            this.spaces[spaceID] = space;
        }
    }
    /**
     * @return the total amount of spaces that are currently available in the zone.
     */
    public int spacesAvailable(){
        int availableSpaces = 0;
        for(int i = 0; i < getAmountOfSpaces(); i++){
            if(spaces[i].equals(Space.EMPTY)){
                availableSpaces++;
            }
        }
        return availableSpaces;
    }
    boolean isVehicleTypeAllowed(VehicleType vehicleType){
        for (VehicleType v: getAllowedVehicleTypes()) {
            if(v.equals(vehicleType)){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Zone{" +
                "spaces=" + Arrays.toString(spaces) +
                ", allowedVehicleTypes=" + allowedVehicleTypes +
                ", amountOfSpaces=" + amountOfSpaces +
                '}';
    }

    /**
     * @return the zone's assigned number
     */
    public ZoneType getZoneNumber() {
        return zoneNumber;
    }

    /**
     * @param zoneNumber sets the zones number to input
     */
    public void setZoneNumber(ZoneType zoneNumber) {
        this.zoneNumber = zoneNumber;
    }
}
