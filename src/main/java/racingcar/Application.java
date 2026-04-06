package racingcar;

import java.util.HashSet;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        HashSet<String> uniqueElements = new HashSet<>();

        String carName = InputView.getCarName();

        validCarName(carName); // 예외처리

        String[] tokens = carName.split(",");

        Cars.validEqualName(tokens, uniqueElements); // 예외처리

        Car[] cars = Cars.rappingCars(tokens);

        String racingCount = InputView.getTryCount();
        int counts = validTryCountNum(racingCount); // 예외처리
        validTryCount(counts); // 예외처리

        System.out.print('\n');
        System.out.println("실행 결과");
        Racing race = new Racing();
        OutputView view = new OutputView();
        for (int i = 0; i < counts; i++) {
            for (int j = 0; j < tokens.length; j++) {
                race.goOrStop(cars[j]);
                view.viewRacingCurrent(cars[j]);
            }
            System.out.print('\n');
        }

        view.viewWinner(cars);
    }

    public static void validCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("이름을 입력하지 않았습니다.");
        }

        if (carName.endsWith(",")) {
            throw new IllegalArgumentException("마지막은 쉼표로 끝날 수 없습니다.");
        }
    }

    public static void validTryCount(int counts) {
        if (counts < 1) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
        }
    }

    public static int validTryCountNum(String racingCount) {
        try {
            int box = Integer.parseInt(racingCount);
            return box;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야합니다.");
        }
    }
}
