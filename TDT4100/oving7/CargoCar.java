public class CargoCar extends TrainCar {
    private int cargoWeight;

    public CargoCar(int deadWeight, int cargoWeight) {
        super(deadWeight);
        this.cargoWeight = cargoWeight;
    }

    public int getTotalWeight() {
        return this.deadWeight + this.cargoWeight;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
}