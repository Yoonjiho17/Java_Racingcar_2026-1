package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

    public void goOrStrop(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            car.move();
        }
    }
}
