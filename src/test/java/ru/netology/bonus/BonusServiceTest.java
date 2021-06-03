package ru.netology.bonus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {
//    @org.junit.jupiter.api.Test
    @ParameterizedTest
    @CsvSource(
            value = {
                    "'registered user, bonus ander limit',10060,true,30",
                    "'registered user, bonus over limit',10060,true,500"
            }
    )
    void shouldCalculateRegisteredAdderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected , actual);
    }

    @Test
    void shouldCalculateNotRegisteredAdderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected , actual);
    }

    @Test
    void shouldCalculateRegisteredOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected , actual);
    }

    @Test
    void shouldCalculateNotRegisteredOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000_000_60;
        boolean registered = false;
        long expected = 500;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected , actual);
    }
}


