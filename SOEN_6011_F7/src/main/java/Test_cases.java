
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_Cases {

    @Test
    public void test_1() {
        assertEquals(F7.power_positive(1,5), 1.0);
    }

    @Test
    public void test_2() {
        assertEquals(F7.power_negative(2,-2), 0.25);
    }


    @Test
    public void test_3() {
        assertEquals(F7.Controller(2,-2.6), 0.164938);
    }

    @Test
    public void test_4() {
        assertEquals(F7.Controller(2,3.7), 12.996038);
    }

    @Test
    public void test_5() {
        assertNotEquals(F7.power_positive(1,5), 2.0);
    }

    @Test
    public void test_6() {
        assertNotEquals(F7.power_positive(1,-5), 15.0);
    }
    @Test
    public void test_7() {
        assertNotEquals(F7.decimal_power(2,-2.6), 6.050000);
    }

    @Test
    public void test_8() {
        assertNotEquals(F7.decimal_power(2,3.7), 12.900000);
    }



}