package racingcar;

public class View {

    public void racingCurrentView(Car car) {
        System.out.println(car.checkCarName() + " : " + "-".repeat(car.checkMovement()));
    }

    public void winnerView(Car[] cars) {


        System.out.println("최종 우승자 : " + Winner.winner(cars));
    }
}
