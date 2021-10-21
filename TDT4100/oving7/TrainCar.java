public class TrainCar {
    protected int deadWeight;

    public TrainCar(int deadWeight) {
        this.deadWeight = deadWeight;
    }

    public int getTotalWeight() {
        return this.deadWeight;
    }

    public void setDeadWeight(int deadWeight) {
        this.deadWeight = deadWeight;
    }

    public int getDeadWeight() {
        return this.deadWeight;
    }
}