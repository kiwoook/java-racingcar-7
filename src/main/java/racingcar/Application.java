package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputViewer;
import racingcar.view.OutputViewer;

public class Application {
    public static void main(String[] args) {
        InputViewer inputViewer = new InputViewer();
        OutputViewer outputViewer = new OutputViewer();

        RacingCarController carController = new RacingCarController(inputViewer, outputViewer);

        carController.execute();
    }
}
