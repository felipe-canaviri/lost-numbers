package com.exercises.lostnumbers;

import java.util.List;
import java.util.stream.IntStream;

public class SequentialSearcher implements LostNumberSearcher {

    @Override
    public int searchLostNumber(List<Integer> numbers) {
        if (numbers != null && !numbers.isEmpty() && numbers.size() > 1) {
            int min = 0;
            int max = 0;
            if (numbers.get(0) < numbers.get(1)) {
                min = numbers.get(0);
                max = numbers.get(1);
            } else {
                min = numbers.get(1);
                max = numbers.get(0);
            }
            int sum = min + max;
            for (int i = 2; i < numbers.size(); i++) {
                Integer value = numbers.get(i);
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
                sum += value;
            }
            return IntStream.rangeClosed(min, max).sum() - sum;
        }
        return 0;
    }
}
