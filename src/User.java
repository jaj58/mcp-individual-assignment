public class User {
    /**
     * the users receipt, used to pay for the parking
     * and to exit the car park once payment is complete
     */
    private Receipt receipt;
    /**
     * the users vehicle type
     */
    private VehicleType vehicleType;
    /**
     * the users vehicle registration plate
     */
    private String vehicleRegistration;
    /**
     * @return the users receipt
     */
    public Receipt getReceipt() {
        return receipt;
    }
    /**
     * @param receipt sets the users receipt to the input given
     */
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    /**
     * @return the users vehicle type
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * @param vehicleType sets the users vehicle type
     */
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * @return the users vehicles registration number
     */
    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    /**
     * @param vehicleRegistration sets the users vehicles registration number to the given input
     */
    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }
}
