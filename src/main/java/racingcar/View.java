package racingcar;

public class View {

    public void racingCurrentView(Car car) {
        System.out.println(car.checkCarName() + " : " + "-".repeat(car.checkMovement()));
    }
}
