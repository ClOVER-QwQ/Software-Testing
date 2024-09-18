import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreDateTest {

    private PreDate preDate;

    @Before
    public void setUp() {
        preDate = new PreDate();
    }

    @DisplayName("测试获取前一天日期")
    @ParameterizedTest
    @CsvSource({
            "2024, 9, 11, 2024-9-10",
            "2024, 1, 1, 2023-12-31",
    })
    public void testPreData(int year, int month, int day, String expectedResult) {
        String result = preDate.preDate(year, month, day);
        assertEquals(expectedResult, result);
    }

    @DisplayName("测试日期有效性验证")
    @ParameterizedTest
    @CsvSource({
            "2024, 9, 18, true",
            "2024, 13, 18, false",
            "2024, 9, 32, false"
    })
    public void testValidateDate(int year, int month, int day, boolean expectedResult) {
        boolean result = preDate.validateDate(year, month, day);
        assertEquals(expectedResult, result);
    }

    @DisplayName("测试闰年判断")
    @ParameterizedTest
    @CsvSource({
            "2024, true",
            "2023, false"
    })
    public void testIsLeapYear(int year, boolean expectedResult) {
        boolean result = preDate.isLeapYear(year);
        assertEquals(expectedResult, result);
    }

    @DisplayName("测试大月判断")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, false"
    })
    public void testIsBigMonth(int month, boolean expectedResult) {
        boolean result = preDate.isBigMonth(month);
        assertEquals(expectedResult, result);
    }
}