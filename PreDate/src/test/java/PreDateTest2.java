import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PreDateTest2 {

    private int year;
    private int month;
    private int day;
    private String expectedResult;
    private PreDate preData = new PreDate();

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {2024, 9, 11, "2024-9-10"},
                {2024, 1, 1, "2023-12-31"},
                {2024, 2, 28, "2024-2-27"}
        });
    }

    public PreDateTest2(int year, int month, int day, String expectedResult) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testPreDate() {
        String result = PreDate.preDate(year, month, day);
        assertEquals(expectedResult, result);
        System.out.println(result);
    }
}