package ru.job4j.chess;


import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException() {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException() {
        Logic logic = new Logic();
        PawnBlack pawnBlack = new PawnBlack(Cell.D2);
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(pawnBlack);
        logic.add(bishopBlack);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C1, Cell.E3);
        });
        assertThat(exception.getMessage()).isEqualTo("The Cell is occupied");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.C1, Cell.D1);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to D1");
    }
}