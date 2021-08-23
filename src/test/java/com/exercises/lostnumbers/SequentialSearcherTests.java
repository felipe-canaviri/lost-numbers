package com.exercises.lostnumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SequentialSearcherTests {

    private LostNumberSearcher searcher;

    @BeforeEach
    void initialize() {
        searcher = new SequentialSearcher();
    }

    @Test
    public void testEmptyArray() {
        int result = searcher.searchLostNumber(null);
        assertThat(result).isEqualTo(0);
        result = searcher.searchLostNumber(new ArrayList<>());
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testArrayWithOneElement() {
        int result = searcher.searchLostNumber(Arrays.asList(4));
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testArrayWithTwoElements() {
        int result = searcher.searchLostNumber(Arrays.asList(4, 5));
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldFindNumber5() {
        int result = searcher.searchLostNumber(Arrays.asList(4, 6));
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void shouldFindNumber5InUnsortedList() {
        int result = searcher.searchLostNumber(Arrays.asList(6, 4));
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void shouldFindNumber6() {
        int result = searcher.searchLostNumber(Arrays.asList(4, 5, 7));
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldFindNumber6InUnsortedList() {
        int result = searcher.searchLostNumber(Arrays.asList(7, 4, 5));
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldFindNumber11() {
        int result = searcher.searchLostNumber(Arrays.asList(9, 10, 12, 13));
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void shouldFindNumber12InUnsortedList() {
        int result = searcher.searchLostNumber(Arrays.asList(13, 11, 9, 10));
        assertThat(result).isEqualTo(12);
    }

}
