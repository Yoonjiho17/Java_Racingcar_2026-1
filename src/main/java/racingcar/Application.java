package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(); // 전진상황 리스트

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = readLine();
        String[] tokens = carName.split(",");

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            arrayList.add(0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String racingCounts = readLine();
        int counts = Integer.parseInt(racingCounts);

        System.out.println("\n실행 결과");
        arrayList = startRacing(tokens, counts, arrayList);

        winner(tokens, arrayList);
    }

    public static ArrayList<Integer> startRacing(String[] tokens, int counts, ArrayList<Integer> arrayList) {
        for (int i = 1; i <= counts; i++) {
            for (int j=0; j < tokens.length; j++) {
                System.out.print(tokens[j] + " : ");
                arrayList = goOrStop(j, arrayList);
                System.out.println("- ".repeat(arrayList.get(j)));
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
                if (!sb.isEmpty()) {
                    sb.append(", ");
                }
                sb.append(tokens[i]);
            }
        }

        System.out.println("최종 우승자 : " + sb);
    }
}
