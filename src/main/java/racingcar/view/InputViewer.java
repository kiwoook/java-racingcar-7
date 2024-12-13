package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewer {

    public String promptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Console.readLine();
    }

    public String promptTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return Console.readLine();
    }
}
