package meski.springframework.spring5webapp;

public class Sum implements Expression {
    Money augend;
    Money addend;
    
    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }
    
    public Money reduce(String to) {
        int amount = augend.getAmount() + addend.getAmount();
        return new Money(amount, to);
    }
    
}
