package racingcar;

public class Winner {

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
