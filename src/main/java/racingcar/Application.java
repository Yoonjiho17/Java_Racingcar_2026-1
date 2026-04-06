package racingcar;

import java.util.HashSet;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        HashSet<String> uniqueElements = new HashSet<>();

        String carName = InputView.getCarName();

        InputValidator.validCarName(carName); // 예외처리

        String[] tokens = carName.split(",");

        Cars.validEqualName(tokens, uniqueElements); // 예외처리

        Car[] cars = Cars.rappingCars(tokens);

        String racingCount = InputView.getTryCount();
        int counts = InputValidator.validTryCountNum(racingCount); // 예외처리
        InputValidator.validTryCount(counts); // 예외처리

        Racing race = new Racing();
        OutputView.viewStartResult(tokens, counts, cars, race);

        OutputView view = new OutputView();
        view.viewWinner(cars);
    }
}
