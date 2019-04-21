import java.sql.Time;

public class CustomAlgorithm {
    private final long max_length = 1000000000;
    private final long min_length = 100000000;

    public CustomAlgorithm() {
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
        result = (result * (multiplier + parkingSpace + parkingZone));


        //we want consistent 9 digit receipt number so let's clamp it....
        while(result < min_length){
            result = result * 10;
        }

        while(result > max_length){
            result = result / 10;
        }
        return result;
    }

    int convertStringToInt(String str){
        int result = 0;
        str.toLowerCase(); //saves switch statements...
        str.replace(" ", ""); //remove whitespaces...
        for(int i = 0; i < str.length(); i++){
            switch(str.charAt(i)) {
                case '0':
                    result += (i* 0);
                    break;
                case '1':
                    result += (i* 1);
                    break;
                case '2':
                    result += (i* 2);
                    break;
                case '3':
                    result += (i* 3);
                    break;
                case '4':
                    result += (i* 4);
                    break;
                case '5':
                    result += (i* 5);
                    break;
                case '6':
                    result += (i* 6);
                    break;
                case '7':
                    result += (i* 7);
                    break;
                case '8':
                    result += (i* 8);
                    break;
                case '9':
                    result += (i* 9);
                    break;
                case 'a':
                    result += (i* 10);
                    break;
                case 'b':
                    result += (i* 11);
                    break;
                case 'c':
                    result += (i* 12);
                    break;
                case 'd':
                    result += (i* 13);
                    break;
                case 'e':
                    result += (i* 14);
                    break;
                case 'f':
                    result += (i* 15);
                    break;
                case 'g':
                    result += (i* 16);
                    break;
                case 'h':
                    result += (i* 17);
                    break;
                case 'i':
                    result += (i* 18);
                    break;
                case 'j':
                    result += (i* 19);
                    break;
                case 'k':
                    result += (i* 20);
                    break;
                case 'l':
                    result += (i* 21);
                    break;
                case 'm':
                    result += (i* 22);
                    break;
                case 'n':
                    result += (i* 23);
                    break;
                case 'o':
                    result += (i* 24);
                    break;
                case 'p':
                    result += (i* 25);
                    break;
                case 'q':
                    result += (i* 26);
                    break;
                case 'r':
                    result += (i* 27);
                    break;
                case 's':
                    result += (i* 28);
                    break;
                case 't':
                    result += (i* 29);
                    break;
                case 'u':
                    result += (i* 30);
                    break;
                case 'v':
                    result += (i* 31);
                    break;
                case 'w':
                    result += (i* 32);
                    break;
                case 'x':
                    result += (i* 33);
                    break;
                case 'y':
                    result += (i* 34);
                    break;
                case 'z':
                    result += (i* 35);
                    break;
            }
        }
        return result;
    }

}
