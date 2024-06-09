# Spring5 Web Application

This is a web application built with Spring 5 and Java 21.

## Overview

The application is designed with banking in mind. It includes classes for handling common banking scenarios.

## Classes

- `Bank`: Represents a bank that holds multiple accounts.
- `Money`: Represents an amount of money, providing functionality for basic operations like addition and multiplication.
- `Sum`: Represents a sum of two `Money` objects.
- `Expression`: An interface implemented by `Money` and `Sum` to represent expressions involving money.

## Unit Tests

Unit tests are provided in the `MoneyTest` file under the `src/test/java` directory, ensuring that the main functionality works as expected.

## Requirements

- Java SDK 21
- Spring Framework 5
- Spring Data JPA
- Spring MVC
