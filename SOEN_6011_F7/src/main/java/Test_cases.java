
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This is the test class which handles all the corner cases of our implementation.
 */
class Test_Cases {
    /**
     * Test case 1 to check the validity of power_positive function.
     */
    @Test
    public void test_1() {
        assertEquals(F7.power_positive(1,5), 1.0);
    }

    /**
     * Test case 2 to check the validity of power_negative function.
     */
    @Test
    public void test_2() {
        assertEquals(F7.power_negative(2,-2), 0.25);
    }

    /**
     * Test case 3 to check the validity of Controller function.
     */
    @Test
    public void test_3() {
        assertEquals(F7.Controller(2,-2.6), 0.164938);
    }

    /**
     * Test case 4 to check the validity of Controller function.
     */
    @Test
    public void test_4() {
        assertEquals(F7.Controller(2,3.7), 12.996038);
    }

    /**
     * Test case 5 to check the validity of power_positive function.
     */
    @Test
    public void test_5() {
        assertNotEquals(F7.power_positive(1,5), 2.0);
    }

    /**
     * Test case 6 to check the validity of power_positive function.
     */
    @Test
    public void test_6() {
        assertNotEquals(F7.power_positive(1,-5), 15.0);
    }

    /**
     * Test case 7 to check the validity of decimal_power function.
     */
    @Test
    public void test_7() {
        assertNotEquals(F7.decimal_power(2,-2.6), 6.050000);
    }

    /**
     * Test case 8 to check the validity of decimal_power function.
     */
    @Test
    public void test_8() {
        assertNotEquals(F7.decimal_power(2,3.7), 12.900000);
    }

    /**
     * Test case 9 to check the validity of Controller function.
     */
    @Test
    public void test_9() {
        assertEquals(F7.Controller(0,0), 0);
    }

    /**
     * Test case 10 to check the validity of decimal_power function.
     */
    @Test
    public void test_10() {
        assertEquals(F7.decimal_power(0,3.7), 0);
    }



}