package racingcar.view;

public class OutputViewer {

    private static final String ERROR_SIGN = "[ERROR] ";

    public void printError(Exception e) {
        System.out.println(ERROR_SIGN + e.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
