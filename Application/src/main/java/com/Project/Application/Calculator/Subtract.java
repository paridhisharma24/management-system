package com.Project.Application.Calculator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Subtract implements OpnImplementation{
    private List<Integer> numbers;
    private int difference = 0;

    public Subtract() {
    }

    @Override
    public int evaluate(List<Integer> numbers) {
        for(int num: numbers){
            difference -= num;
        }
        return getDifference();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }
}
