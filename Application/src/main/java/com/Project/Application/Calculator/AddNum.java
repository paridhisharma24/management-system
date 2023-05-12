package com.Project.Application.Calculator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddNum implements OpnImplementation{
    private List<Integer> numbers;
    private int sum = 0;

    public AddNum() {
    }

    @Override
    public int evaluate(List<Integer> numbers) {
        for(int num: numbers){
            sum += num;
        }
        return getSum();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
