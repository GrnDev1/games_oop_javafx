package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
    @Test
    public void whenPositionA1ThenA1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell result = bishopBlack.position();
        assertThat(result).isEqualTo(Cell.A1);
    }

    @Test
    public void whenCopyA2ThenA2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell result = bishopBlack.copy(Cell.A2).position();
        assertThat(result).isEqualTo(Cell.A2);
    }

    @Test
    public void whenWayC1ThenD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenIsDiagonalException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.D1);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to D1");
    }
}