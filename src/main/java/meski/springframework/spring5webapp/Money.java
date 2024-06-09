package meski.springframework.spring5webapp;

public class Money implements Expression {
    private final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public int getAmount() {
        return amount;
    }

    String getCurrency() {
        return currency;
    }
    
    @Override
    public Money reduce(Bank bank,String to) {
        int rate = (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
        return new Money(amount / bank.rate(currency, to), to);
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount && this.currency == money.currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
