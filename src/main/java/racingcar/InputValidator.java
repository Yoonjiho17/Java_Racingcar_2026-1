package racingcar;

public class InputValidator {

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
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야합니다.");
        }
    }
}
