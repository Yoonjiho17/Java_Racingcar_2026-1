package racingcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>(); // 전진상황 리스트

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = input.nextLine();
        String tokens[] = carName.split(",");
        for (int i = 0; i < tokens.length; i++) {
            arrayList.add(0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int racingCounts = input.nextInt();

        System.out.println("\n실행 결과");
        arrayList = startRacing(tokens, racingCounts, arrayList);
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
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if (randomNum >= 4) {
            arrayList.set(index, arrayList.get(index) + 1);
        }

        return arrayList;
    }
}
