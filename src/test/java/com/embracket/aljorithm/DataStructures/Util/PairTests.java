package com.embracket.aljorithm.DataStructures.Util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PairTests {
    Pair<String> pair;
    final String first = "first";
    final String second = "second";
    @BeforeEach
    void setUp() {
        pair = new Pair(first, second);
    }

    @Test
    @DisplayName("First of pair returns... first element")
    void firstReturnsFirst(){
        assertEquals(first, pair.fst());
    }

    @Test
    @DisplayName("Second of pair returns... second element")
    void secondReturnsSecond(){
        assertEquals(second, pair.snd());
    }
}
