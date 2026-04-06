package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class Cars {
    private static final int CAR_MOVE_STANDARD = 4;

    public static Car[] rappingCars(String[] tokens) {
        Car[] cars = new Car[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            cars[i] = new Car(tokens[i]);
        }

        return cars;
    }

    public static void validEqualName(String[] tokens, HashSet<String> uniqueElements) {
        for (String token : tokens) {
            if (!uniqueElements.add(token)) {
                throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
            }
        }
    }

    public static void goOrStop(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= CAR_MOVE_STANDARD) {
            car.move();
        }
    }

    public static StringBuilder calculateWinner(Car[] cars) {
        int max = cars[0].checkMovement();
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            if (max < car.checkMovement()) {
                max = car.checkMovement();
            }
        }

        for (Car car : cars) {
            if (car.checkMovement() == max) {
                if (!sb.isEmpty()) {
                    sb.append(", ");
                }
                sb.append(car.checkCarName());
            }
        }

        return sb;
    }
}
