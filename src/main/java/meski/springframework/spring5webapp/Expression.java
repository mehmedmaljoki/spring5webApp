package meski.springframework.spring5webapp;

public interface Expression {
    Money reduce(Bank bank, String to);
}
