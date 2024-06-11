package br.com.jhonnyazevedo.first_steps_dio;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }
}
