package racingcar.model;

import static racingcar.utils.Constants.ENTER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import racingcar.utils.StringUtils;

public class Cars {

    private final List<Car> items;
    private int maxMove;

    public Cars(List<Car> items) {
        this.items = items;
        this.maxMove = 0;
    }

    public static Cars from(String names) {
        StringUtils.validateInput(names);
        List<Car> list = Arrays.stream(StringUtils.split(",", names, null)).map(Car::from).toList();

        return new Cars(list);
    }

    public void moveAll() {
        for (Car car : items) {
            maxMove = Math.max(maxMove, car.move(Randoms.pickNumberInRange(0, 9)));
        }
    }

    public String statusAll() {
        StringJoiner joiner = new StringJoiner(ENTER);

        for (Car car : items) {
            joiner.add(car.status());
        }

        return joiner.toString();
    }

    public String getWinner() {
        return items.stream()
                .filter(car -> car.isMaxMove(maxMove))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }


    @Override
    public String toString() {
        return "Cars{" +
                "items=" + items +
                '}';
    }
}
