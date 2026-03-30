package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(); // 전진상황 리스트
        HashSet<String> uniqueElements = new HashSet<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = readLine();

        nameException(carName);

        String[] tokens = carName.split(",");

        equalException(tokens, uniqueElements);
        arrayList = exception(tokens, arrayList);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String racingCount = readLine();
        int counts = tryCountNumCheckException(racingCount);
        tryCountException(counts);

        System.out.println();
        System.out.println("실행 결과");
        arrayList = startRacing(tokens, counts, arrayList);

        winner(tokens, arrayList);
    }

    public static void nameException(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("이름을 입력하지 않았습니다.");
        }

        if (carName.endsWith(",")) {
            throw new IllegalArgumentException("마지막은 쉼표로 끝날 수 없습니다.");
        }
    }

    public static ArrayList<Integer> exception(String[] tokens, ArrayList<Integer> arrayList) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("자동차를 적어야합니다.");
        }
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (tokens[i].isBlank()) {
                throw new IllegalArgumentException("자동차 이름을 적어야 합니다.");
            }
            if (tokens[i].contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백은 불가능합니다.");
            }
            arrayList.add(0);
        }

        return arrayList;
    }

    public static void equalException(String[] tokens, HashSet<String> uniqueElements) {
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

    public static ArrayList<Integer> startRacing(String[] tokens, int counts, ArrayList<Integer> arrayList) {
        for (int i = 1; i <= counts; i++) {
            for (int j=0; j < tokens.length; j++) {
                System.out.print(tokens[j] + " : ");
                arrayList = goOrStop(j, arrayList);
                System.out.println("-".repeat(arrayList.get(j)));
            }
            System.out.println();
        }

        return arrayList;
    }

    public static ArrayList<Integer> goOrStop(int index, ArrayList<Integer> arrayList) {
        int randomNum = pickNumberInRange(0,9);
        if (randomNum >= 4) {
            arrayList.set(index, arrayList.get(index) + 1);
        }

        return arrayList;
    }

    public static void winner(String[] tokens, ArrayList<Integer> arrayList) {
        int max = Collections.max(arrayList);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == max) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(tokens[i]);
            }
        }

        System.out.println("최종 우승자 : " + sb);
    }
}
