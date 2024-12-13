package racingcar.controller;

import racingcar.model.Cars;
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
        System.out.println(cars);
    }

    public Cars getCars() {
        String names = inputViewer.promptCarNames();

        return Cars.from(names);
    }
}
