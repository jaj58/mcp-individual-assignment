public class Attendant extends User {
    /**
     * used to keep track of the current status of the attendant -> if they can or cannot pickup/take
     */
    private boolean isBusy = false;


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
}
