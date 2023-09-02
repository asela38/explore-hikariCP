package com.explore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ExploreTest {


    @Test
    public void test_assertions() {
        Assertions.assertTrue(true);
    }

    @Test
    public void test_assumptions() {
        Assumptions.assumeFalse(false);
    }

    @Test
    public void test_assertions_on_assumptions() {
        int seconds = LocalDateTime.now().getSecond();
        System.out.println("seconds = " + seconds);
        Assumptions.assumingThat( seconds % 2 == 0, ()-> Assertions.assertEquals(0, seconds%2, "no reminders") );
        Assumptions.assumingThat( seconds % 2 == 1, ()-> Assertions.assertEquals(1, seconds%2," reminders is one") );
    }
}
