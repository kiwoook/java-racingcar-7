package racingcar.model;

import racingcar.exception.CustomIllegalArgumentException;

public class TryCount {

    private final int maxCount;
    private int count;

    public TryCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public static TryCount from(String maxCount) {
        int parseCount = parseCount(maxCount);
        validCount(parseCount);
        return new TryCount(parseCount);
    }

    public static int parseCount(String maxCount) {
        try {
            return Integer.parseInt(maxCount);
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void validCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("자연수의 값을 입력해주세요.");
        }
    }

    public boolean canTry() {
        if (count < maxCount) {
            count++;
            return true;
        }

        return false;
    }
}
