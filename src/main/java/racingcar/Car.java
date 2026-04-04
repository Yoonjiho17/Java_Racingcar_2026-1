package racingcar;

public class Car {
    private String carName;
    private int movement;

    public Car(String carName) {
        this.carName = carName;
        this.movement = 0;
    }

    public void move() {
        movement += 1;
    }

    public String checkCarName() {
        return carName;
    }

    public int checkMovement() {
        return movement;
    }
}
