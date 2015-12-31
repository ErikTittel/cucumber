package nicebank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Erik
 */
public class Money {

    private int dollars;
    private int cents;

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money() {
    }

    public Money add(Money amount) {
        int totalDollars = dollars + amount.dollars;
        int totalCents = cents + amount.cents;
        if (totalCents >= 100) {
            totalDollars++;
            totalCents -= 100;
        }
        return new Money(totalDollars, totalCents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return dollars == money.dollars && cents == money.cents;

    }

    @Override
    public int hashCode() {
        int result = dollars;
        result = 31 * result + cents;
        return result;
    }

    @Override
    public String toString() {
        return "Money{" +
                "dollars=" + dollars +
                ", cents=" + cents +
                '}';
    }
}
