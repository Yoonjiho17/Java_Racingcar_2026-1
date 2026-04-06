package racingcar;

import java.util.HashSet;

public class Cars {

    public Car[] rappingCars(String[] tokens) {
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

    public static StringBuilder calculateWinner(Car[] cars) {
        int max = cars[0].checkMovement();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cars.length; i++) {
            if (max < cars[i].checkMovement()) {
                max = cars[i].checkMovement();
            }
        }

        for (int j = 0; j < cars.length; j++) {
            if (cars[j].checkMovement() == max) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(cars[j].checkCarName());
            }
        }

        return sb;
    }
}
