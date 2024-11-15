package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.Constant.WINNER_RESULT;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class WinnersTest {

    @Test
    @DisplayName("우승자 출력 테스트")
    void printWinners() {

        // given
        List<Car> test = new ArrayList<>();

        Car pobi = Car.create(CarName.create("pobi"));
        Car woni = Car.create(CarName.create("woni"));

        test.add(pobi);
        test.add(woni);

        CarList carList = new CarList(test);

        // when
        Winners winners = Winners.from(carList);
        Message result = Message.result(winners);

        // then
        assertThat(result).isEqualTo(new Message(WINNER_RESULT + carList));
    }
}
