package nicebank;

public class Money {

    private int dollars;
    private int cents;

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money() {
    }

    public Money(String moneyAsText) {
        String[] moneyParts = moneyAsText.replace("+", "").replace("-", "").split("\\.");
        dollars = Integer.parseInt(moneyParts[0]);
        cents = Integer.parseInt(moneyParts[1]);
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

    public Money minus(Money amount) {
        int totalDollars = dollars - amount.dollars;
        int totalCents = cents - amount.cents;
        if (totalCents < 0) {
            totalDollars--;
            totalCents = 100 + totalCents;
        }
        if (totalDollars < 0) {
            throw new RuntimeException("negative amount not supported yet");
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
        return dollars + "." + cents;
    }
}
