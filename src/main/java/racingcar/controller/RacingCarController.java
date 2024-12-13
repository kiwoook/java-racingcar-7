package racingcar.controller;

import static racingcar.utils.Constants.ENTER;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputViewer;
import racingcar.view.OutputViewer;

public class RacingCarController {

    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;

    public RacingCarController(InputViewer inputViewer, OutputViewer outputViewer) {
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
    }

    public void execute() {
        Cars cars = getCars();
        TryCount tryCount = getTryCount();

        result(cars, tryCount);
    }

    public Cars getCars() {
        String names = inputViewer.promptCarNames();

        return Cars.from(names);
    }

    public TryCount getTryCount() {
        String maxCount = inputViewer.promptTryCount();

        return TryCount.from(maxCount);
    }

    public void result(Cars cars, TryCount tryCount) {
        outputViewer.printMessage(ENTER + "실행 결과");
        while (tryCount.canTry()) {
            cars.moveAll();
            outputViewer.printMessage(cars.statusAll() + ENTER);
        }

        outputViewer.printMessage("최종 우승자 : " + cars.getWinner());
    }
}
