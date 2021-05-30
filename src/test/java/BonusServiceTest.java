import static org.junit.jupiter.api.Assertions.*;
class BonusServiceTest {
    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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


