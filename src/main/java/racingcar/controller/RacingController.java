package racingcar.controller;

import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.HashSet;

public class RacingController {

    public static void startRacing() {
        HashSet<String> uniqueElements = new HashSet<>();

        String carName = InputView.getCarName();

        InputValidator.validCarName(carName); // 예외처리

        String[] tokens = carName.split(",");

        Cars.validEqualName(tokens, uniqueElements); // 예외처리

        Car[] cars = Cars.rappingCars(tokens);

        String racingCount = InputView.getTryCount();
        int counts = InputValidator.validTryCountNum(racingCount); // 예외처리
        InputValidator.validTryCount(counts); // 예외처리

        OutputView.viewStartResult(tokens, counts, cars);

        OutputView view = new OutputView();
        view.viewWinner(cars);
    }
}
