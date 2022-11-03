package util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;

import static util.SystemProperties.*;

public class Util {

    private static final int DEFAULT_NAME_LENGTH = 5;

    public static long generateRandomId()
    {
        return new RandomDataGenerator().nextLong(0, 999999999);
    }

    public static String generayeRandomName()
    {
        return TEST_NAME_PREFIX + generateRandomString();
    }

    public static String generateRandomString()
    {
        return generateRandomString(DEFAULT_NAME_LENGTH);
    }

    public static String generateRandomString(int length)
    {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
