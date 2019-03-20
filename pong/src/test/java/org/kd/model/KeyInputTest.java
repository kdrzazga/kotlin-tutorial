package org.kd.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.kd.view.KeyInput;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KeyInputTest {

    @ParameterizedTest
    @ValueSource(chars = {'a', 'z', 'p', 'l', 'A', 'Z', 'P', 'L'})
    public void testGetBoardMethod(char key) {
        var keyInput = new KeyInput();
        Method boardMethod = keyInput.getBoardMethod(key);

        assertNotNull(boardMethod);
    }

    @ParameterizedTest
    @ValueSource(chars = {'a', 'Z', 'p', 'L'})
    @DisplayName("Integration Test: Test results of called Board methods")
    public void testExecuteBoardMethod(char key) {
        var keyInput = new KeyInput();
        Method boardMethod = keyInput.getBoardMethod(key);

        Map<Character, Double> expectedRedBatY = Map.of(
                'a', (double) 56f,
                'Z', (double) 64f,
                'p', (double) 40f,
                'L', (double) 40f
        );

        Map<Character, Double> expectedBlueBatY = Map.of(
                'a', (double) 40f,
                'Z', (double) 40f,
                'p', (double) 36f,
                'L', (double) 44f
        );

        var board = new Board(100, 100);
        board.redBat = new Bat(10, 60, 10, PongSide.RED);
        board.blueBat = new Bat(90, 40, 10, PongSide.BLUE);

        try {
            boardMethod.invoke(board);

            assertEquals(expectedRedBatY.get(key), board.redBat.getY());
            assertEquals(expectedBlueBatY.get(key), board.blueBat.getY());

        } catch (NullPointerException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
