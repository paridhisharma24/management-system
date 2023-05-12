package com.Project.Application.Calculator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Multiply implements OpnImplementation{
    private List<Integer> numbers;
    private int mul = 1;

    public Multiply() {
    }

    @Override
    public int evaluate(List<Integer> numbers) {
        for(int num: numbers){
            mul *= num;
        }
        return getMul();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getMul() {
        return mul;
    }

    public void setMul(int mul) {
        this.mul = mul;
    }
}
