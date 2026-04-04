package racingcar;

import java.util.HashSet;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        HashSet<String> uniqueElements = new HashSet<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = readLine();

        nameException(carName); // 예외처리

        String[] tokens = carName.split(",");

        equalNameException(tokens, uniqueElements); // 예외처리

        Car[] cars = new Car[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            cars[i] = new Car(tokens[i]);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String racingCount = readLine();
        int counts = tryCountNumCheckException(racingCount); // 예외처리
        tryCountException(counts); // 예외처리

        System.out.println();
        System.out.println("실행 결과");
        Racing race = new Racing();
        View view = new View();
        for (int i = 0; i < counts; i++) {
            for (int j = 0; j < tokens.length; j++) {
                race.goOrStrop(cars[j]);
                view.racingCurrentView(cars[j]);
            }
            System.out.println();
        }

        view.winnerView(cars);
    }

    public static void nameException(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("이름을 입력하지 않았습니다.");
        }

        if (carName.endsWith(",")) {
            throw new IllegalArgumentException("마지막은 쉼표로 끝날 수 없습니다.");
        }
    }

    public static void equalNameException(String[] tokens, HashSet<String> uniqueElements) {
        for (String token : tokens) {
            if (!uniqueElements.add(token)) {
                throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
            }
        }
    }

    public static void tryCountException(int counts) {
        if (counts < 1) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
        }
    }

    public static int tryCountNumCheckException(String racingCount) {
        try {
            int box = Integer.parseInt(racingCount);
            return box;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야합니다.");
        }
    }
}
