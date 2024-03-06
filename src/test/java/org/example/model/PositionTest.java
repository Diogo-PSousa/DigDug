package org.example.model;

import net.jqwik.api.ForAll;
import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PositionTest {
    Position position;

    @BeforeEach
    void init(){
        position = new Position(2,2);
    }

    @Test
    void getLeft() {
        Position test_position = new Position(1,2);
        assertEquals(test_position, position.getLeft());
    }

    @Test
    void getRight() {
        Position test_position = new Position(3,2);
        assertEquals(test_position, position.getRight());
    }

    @Test
    void getUp() {
        Position test_position = new Position(2,1);
        assertEquals(test_position, position.getUp());
    }

    @Test
    void getDown() {
        Position test_position = new Position(2,3);
        assertEquals(test_position, position.getDown());
    }


}
