package 臺灣.試驗;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JUnit試驗 {
    @Test
    public void junit風格() {
        assertTrue(true);
        assertEquals(333, 333);
    }

    @Test
    public void assertj風格() {
        Assertions.assertThat(333).isEqualTo(333);
    }
}
