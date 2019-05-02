public class Attendant extends User {
    /**
     * used to keep track of the current status of the attendant -> if they can or cannot pickup/take
     */
    private boolean isBusy = false;

    /**
     * used to keep track if a attendant is currently off sick
     */
    private boolean isSick = false;


    /**
     * @return if the attendant is currently doing a job/roaming
     */
    public boolean isBusy() {
        return isBusy;
    }
    /**
     * @param busy sets if the attendant is currently doing a job/roaming
     */
    public void setBusy(boolean busy) {
        this.isBusy = busy;
    }

    /**
     * @return if the attendant is currently off sick...
     */
    public boolean isSick() {
        return isSick;
    }

    /**
     * @param sick sets if a a attendant is off sick or not
     */
    public void setSick(boolean sick) {
        isSick = sick;
    }
}
