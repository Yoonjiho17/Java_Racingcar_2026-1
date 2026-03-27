package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = input.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int racingCounts = input.nextInt();
    }
}
