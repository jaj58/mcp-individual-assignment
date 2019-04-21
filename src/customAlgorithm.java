import java.sql.Time;

public class customAlgorithm {
    String vehicleRegistration;
    VehicleType vehicleType;
    Time startTime;
    int parkingZone;
    int parkingSpace;

    private final long max_length = 1000000000;

    public customAlgorithm() {
        this.vehicleRegistration = null;
        this.vehicleType = null;
        this.startTime = null;
        this.parkingZone = 0;
        this.parkingSpace = 0;
    }

    long generateReceiptNumber(String vehicleRegistration, VehicleType vehicleType, Time startTime, int parkingZone, int parkingSpace){
        long result = convertStringToInt(vehicleRegistration);
        int multiplier = 1;
        switch(vehicleType){
            case STANDARD:
                multiplier = 1000000;
                break;
            case HIGH:
                multiplier = 1100000;
                break;
            case LONG:
                multiplier = 1200000;
                break;
            case COACH:
                multiplier = 1300000;
                break;
            case BIKE:
                multiplier = 1400000;
                break;
        }
        result = (result * (multiplier + parkingSpace + parkingSpace));


        //we want consistent 9 digit receipt number so let's clamp it....
        while(result > max_length){
            result = result / 10;
        }

        if(result < 99999999){

        }


        return result;
    }

    int convertStringToInt(String str){
        int result = 0;
        for(int i = 0; i <= str.length(); i++){
            str.toLowerCase(); //saves on switch statements...
            switch(str.charAt(i)) {
                case 0:
                    result += 0;
                    break;
                case 1:
                    result += 1;
                    break;
                case 2:
                    result += 2;
                    break;
                case 3:
                    result += 3;
                    break;
                case 4:
                    result += 4;
                    break;
                case 5:
                    result += 5;
                    break;
                case 6:
                    result += 6;
                    break;
                case 7:
                    result += 7;
                    break;
                case 8:
                    result += 8;
                    break;
                case 9:
                    result += 9;
                    break;
                case 'a':
                    result += 10;
                    break;
                case 'b':
                    result += 11;
                    break;
                case 'c':
                    result += 12;
                    break;
                case 'd':
                    result += 13;
                    break;
                case 'e':
                    result += 14;
                    break;
                case 'f':
                    result += 15;
                    break;
                case 'g':
                    result += 16;
                    break;
                case 'h':
                    result += 17;
                    break;
                case 'i':
                    result += 18;
                    break;
                case 'j':
                    result += 19;
                    break;
                case 'k':
                    result += 20;
                    break;
                case 'l':
                    result += 21;
                    break;
                case 'm':
                    result += 22;
                    break;
                case 'n':
                    result += 23;
                    break;
                case 'o':
                    result += 24;
                    break;
                case 'p':
                    result += 25;
                    break;
                case 'q':
                    result += 26;
                    break;
                case 'r':
                    result += 27;
                    break;
                case 's':
                    result += 28;
                    break;
                case 't':
                    result += 29;
                    break;
                case 'u':
                    result += 30;
                    break;
                case 'v':
                    result += 31;
                    break;
                case 'w':
                    result += 32;
                    break;
                case 'x':
                    result += 33;
                    break;
                case 'y':
                    result += 34;
                    break;
                case 'z':
                    result += 35;
                    break;
            }
        }
        return result;
    }

}
