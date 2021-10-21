import java.util.ArrayList;

public class Train {
    private ArrayList<TrainCar> train = new ArrayList<TrainCar>();

    public void addTrainCar(TrainCar trainCar) {
        this.train.add(trainCar);
    }

    public boolean contains(TrainCar trainCar) {
        return this.train.contains(trainCar);
    }

    public int getTotalWeight() {
        int weight = 0;

        for (TrainCar trainCar : this.train) {
            weight += trainCar.getTotalWeight();
        }

        return weight;

    }

    public int getPassengerCount() {
        int count = 0;

        for (int i = 0; i < this.train.size(); i++) {
            if (this.train.get(i) instanceof PassengerCar) {
                PassengerCar pCar = (PassengerCar) this.train.get(i);
                count += pCar.getPassengerCount();
            }
        }

        return count;


        
    }

    public int getCargoWeight() {
        int count = 0;

        for (int i = 0; i < this.train.size(); i++) {
            if (this.train.get(i) instanceof CargoCar) {
                CargoCar cCar = (CargoCar) this.train.get(i);
                count += cCar.getCargoWeight();
            }
        }

        return count;

    }

    public String toString() {
        String train = "";

        for (int i = 0; i < this.train.size(); i++) {
            if (this.train.get(i) instanceof PassengerCar) {
                PassengerCar pCar = (PassengerCar) this.train.get(i);
                train += "";
            } else {
                CargoCar cCar = (CargoCar) this.train.get(i);
                train += "";
            }
        }

        return train;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}