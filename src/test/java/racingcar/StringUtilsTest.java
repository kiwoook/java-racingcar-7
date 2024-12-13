package racingcar;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.utils.StringUtils;

class StringUtilsTest {

    @Test
    void test1() {
        String a = ",1,2,3,4";
        System.out.println(Arrays.toString(StringUtils.split(",", a, null)));
        String b = "1,2,3,4,";
        System.out.println(Arrays.toString(b.split(",")));
    }


}
