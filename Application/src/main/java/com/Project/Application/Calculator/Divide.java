package com.Project.Application.Calculator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Divide implements OpnImplementation{
    private List<Integer> numbers;
    private int div = 1;

    public Divide() {
    }

    @Override
    public int evaluate(List<Integer> numbers) {
        for(int num: numbers){
            if(num != 0)
                div /= num;
        }
        return getDiv();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getDiv() {
        return div;
    }

    public void setDiv(int div) {
        this.div = div;
    }
}
