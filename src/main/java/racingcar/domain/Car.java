package racingcar.domain;

public class Car {
    private String carName;
    private int movement;

    public Car(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차를 적어야합니다.");
        }
        else if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        else if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 적어야 합니다.");
        }
        else if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백은 불가능합니다.");
        }
        else {
            this.carName = carName;
        }
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
