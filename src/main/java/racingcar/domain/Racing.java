package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    private static final int CAR_MOVE_STANDARD = 4;

    public void goOrStop(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= CAR_MOVE_STANDARD) {
            car.move();
        }
    }
}
