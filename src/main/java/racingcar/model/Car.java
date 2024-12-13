package racingcar.model;

import racingcar.exception.CustomIllegalArgumentException;
import racingcar.utils.StringUtils;

public class Car {

    private final String name;
    private int move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public static Car from(String name) {
        validName(name);
        return new Car(name);
    }

    public static void validName(String name) {
        StringUtils.validateInput(name);

        if (name.length() > 5) {
            throw new CustomIllegalArgumentException("5자 이하의 이름만 사용 가능합니다.");
        }
    }

    public void move(int value) {
        if (value >= 4) {
            move++;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", move=" + move +
                '}';
    }
}
