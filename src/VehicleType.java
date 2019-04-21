/**
 * this enum is used to determine the type of vehicle is parked/being parked/ the type of space...
 */

public enum VehicleType {
    /**
     * standard vehicle type, 0-2 metres high, 0-5metres length
     * car or small van
     */
    STANDARD,
    /**
     * 2-3 metres high, 0-5 metres length
     * tall short wheel-based vans
     */
    HIGH,
    /**
     * 0-3metres high, 5.1-6 metres length
     * long wheel-based vans
     */
    LONG,
    /**
     * any height, 0-15 metres length
     */
    COACH,
    /**
     * motorbikes....
     */
    BIKE
}
