public class PassengerCar extends TrainCar {
    private int passengerCount;

    public PassengerCar(int deadWeight, int passengerCount) {
        super(deadWeight);
        this.passengerCount = passengerCount;
    }

    public int getTotalWeight() {
        return this.deadWeight + this.passengerCount * 80;
    }

    public int getPassengerCount() {
        return this.passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}