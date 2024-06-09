package meski.springframework.spring5webapp;

public class Bank {
    Money reduce(Expression source, String to) {
        return source.reduce(to);
    }
}
