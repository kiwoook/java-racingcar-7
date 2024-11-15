package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.utils.ErrorMessage.INVALID_INPUT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


class CarCarNameCollectTest {

    @Test
    @DisplayName("정상 입력 테스트")
    void test1() {
        String s = "pobi,woni,jun";

        CarNameCollect carNameCollect = CarNameCollect.create(s);
        CarList expect = new CarList();
        expect.add(CarName.create("pobi"));
        expect.add(CarName.create("woni"));
        expect.add(CarName.create("jun"));

        CarList result = CarList.from(carNameCollect);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {",woni,jun", "pobi,woni,"})
    @DisplayName("에러 올바른 값과 빈값")
    void test2(String s) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameCollect.create(s);
        });

        assertThat(exception.getMessage()).contains(INVALID_INPUT.getMessage());
    }


    @Test
    @DisplayName("에러 : 5자 초과")
    void test3() {
        String s = "pooobi,woni,jun";
        CarNameCollect carNameCollect = CarNameCollect.create(s);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarList.from(carNameCollect);
        });

        assertThat(exception.getMessage()).contains(INVALID_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("빈값 처리")
    void test4() {
        String s = ",,";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameCollect.create(s);
        });

        assertThat(exception.getMessage()).contains(INVALID_INPUT.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, 빈 입력")
    void test5(String s) {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> CarNameCollect.create(s));

        assertThat(exception.getMessage()).contains(INVALID_INPUT.getMessage());
    }


}
