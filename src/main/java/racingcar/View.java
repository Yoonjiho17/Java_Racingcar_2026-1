package racingcar;

public class View {

    public void viewRacingCurrent(Car car) {
        System.out.println(car.checkCarName() + " : " + "-".repeat(car.checkMovement()));
    }

    public void viewWinner(Car[] cars) {
        System.out.println("최종 우승자 : " + Winner.calculateWinner(cars));
    }
}
