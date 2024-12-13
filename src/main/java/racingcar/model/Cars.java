package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.StringUtils;

public class Cars {

    private final List<Car> items;

    public Cars(List<Car> items) {
        this.items = items;
    }

    public static Cars from(String names) {
        StringUtils.validateInput(names);
        List<Car> list = Arrays.stream(StringUtils.split(",", names, null)).map(Car::from).toList();

        return new Cars(list);
    }

    public void moveAll() {
        for (Car car : items) {
        }
    }

    @Override
    public String toString() {
        return "Cars{" +
                "items=" + items +
                '}';
    }
}
