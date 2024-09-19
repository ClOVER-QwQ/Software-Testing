import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class preDateTest {

    private int year;
    private int month;
    private int day;
    private String expectedResult;
    private PreDate preData = new PreDate();

    @NotNull
    @Contract(pure = true)
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {2024, 13, 30, "请输入有效日期 ! ! !"},
                {2024, 12, 32, "请输入有效日期 ! ! !"},
                {2024, 11, 30, "2024-11-29"},
                {2023, 9, 1, "2023-8-31"},
                {2000, 3, 1, "2000-2-29"},
                {2024, 4, 1, "2024-3-31"},
                {2024, 5, 1, "2024-4-30"},
                {2024, 1, 1, "2023-12-31"},
                {1, 1, 1, "-1-12-31"},
                {-1, 1 , 1, "-2-12-31"}
        });
    }

    public preDateTest(int year, int month, int day, String expectedResult) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testPreDate() {
        String result = preData.preDate(year, month, day);
        assertEquals(expectedResult, result);
    }
}