package racingcar;

public class View {

    public void racingCurrentView(Car car) {
        System.out.println(car.checkCarName() + " : " + "-".repeat(car.checkMovement()));
    }

    public void winner(Car[] cars) {
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

        System.out.println("최종 우승자 : " + sb);
    }
}
