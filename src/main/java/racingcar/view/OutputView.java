package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;

public class OutputView {

    public static void viewStartResult(String[] tokens, int counts, Car[] cars, Racing race) {
        System.out.print('\n');
        System.out.println("실행 결과");
        for (int i = 0; i < counts; i++) {
            for (int j = 0; j < tokens.length; j++) {
                race.goOrStop(cars[j]);
                System.out.println(cars[j].checkCarName() + " : " + "-".repeat(cars[j].checkMovement()));
            }
            System.out.print('\n');
        }
    }

    public void viewWinner(Car[] cars) {
        System.out.println("최종 우승자 : " + Cars.calculateWinner(cars));
    }
}
