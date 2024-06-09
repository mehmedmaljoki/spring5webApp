package meski.springframework.spring5webapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class MoneyTest {

    @Test
    void testMultiplication() {
        var five = Money.dollar(5);

        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

        var fiveF = Money.franc(5);

        assertEquals(Money.franc(10), fiveF.times(2));
        assertEquals(Money.franc(15), fiveF.times(3));
    }

    @Test
    void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(8));

        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(8));
    }


    @Test
    void differenceDollerAndFranc() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).getCurrency());
        assertEquals("CHF", Money.franc(1).getCurrency());
    }

    @Test
    void testSimpleAddition() {
        var five = Money.dollar(5);
        var sum = five.plus(five);
        var bank = new Bank();
        var reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnsSum() {
        var five = Money.dollar(5);
        var result = five.plus(five);
        var sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    void testReduceSum() {
        var sum = new Sum(Money.dollar(3), Money.dollar(4));
        var bank = new Bank();
        var result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }
}
