package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.game.FireboyController;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.Block;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.model.game.temple.Temple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

public class FireboyControllerTest {
    private Temple temple;
    private FireboyController controller;
    private Fireboy fireboy;
    private Position position;
    private List<Block> blocks;


    @BeforeEach
    void setUp() {
        this.temple = Mockito.mock(Temple.class);
        this.fireboy = Mockito.mock(Fireboy.class);
        this.position = Mockito.mock(Position.class);
        this.blocks = Mockito.mock(List.class);

        when(temple.getFireboy()).thenReturn(fireboy);
        when(fireboy.getPosition()).thenReturn(position);
        when(temple.getBlocks()).thenReturn(blocks);

        this.controller = new FireboyController(temple);
    }

    @Test
    void testMove() {
        Position newPosition = mock(Position.class);

        controller.moveFireboy(newPosition);

        verify(fireboy).setPosition(newPosition);
        verify(temple).retrieveRedDiamonds(newPosition);
    }


    @Test
    void testMoveRight_NoCollision() {
        when(position.getRight()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.moveFireboyRight();

        verify(fireboy).setPosition(position);
    }

    @Test
    void testMoveRight_WithCollision() {
        when(position.getRight()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(true);

        controller.moveFireboyRight();

        verify(fireboy, never()).setPosition(any());
    }

    @Test
    void testMoveLeft_NoCollision() {
        when(position.getLeft()).thenReturn(position);
        when(temple.collidesLeft(position, blocks)).thenReturn(false);

        controller.moveFireboyLeft();

        verify(fireboy).setPosition(position);
    }

    @Test
    void testMoveLeft_WithCollision() {
        when(position.getLeft()).thenReturn(position);
        when(temple.collidesLeft(position, blocks)).thenReturn(true);

        controller.moveFireboyLeft();

        verify(fireboy, never()).setPosition(any());
    }

    @Test
    void testMoveUp_NoCollision() {
        when(position.getUp()).thenReturn(position);
        when(temple.collidesUp(position, blocks)).thenReturn(false);

        controller.moveFireboyUp();

        verify(fireboy).setPosition(position);
    }

    @Test
    void testMoveUp_WithCollision() {
        when(position.getUp()).thenReturn(position);
        when(temple.collidesUp(position, blocks)).thenReturn(true);

        controller.moveFireboyUp();

        verify(fireboy, never()).setPosition(any());
    }

    @Test
    void testMoveDown_NoCollision() {
        when(position.getDown()).thenReturn(position);
        when(temple.collidesDown(position, blocks)).thenReturn(false);

        controller.moveFireboyDown();

        verify(fireboy).setPosition(position);
    }

    @Test
    void testMoveDown_WithCollision() {
        when(position.getDown()).thenReturn(position);
        when(temple.collidesDown(position, blocks)).thenReturn(true);

        controller.moveFireboyDown();

        verify(fireboy, never()).setPosition(any());
    }

    @Test
    void testStepRight() {
        Game game = mock(Game.class);
        when(position.getRight()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.step(game, Set.of(ACTION.FIREBOY_RIGHT), System.currentTimeMillis());

        verify(fireboy).setPosition(position);
    }

    @Test
    void testStepLeft() {
        Game game = mock(Game.class);
        when(position.getLeft()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.step(game, Set.of(ACTION.FIREBOY_LEFT), System.currentTimeMillis());

        verify(fireboy).setPosition(position);
    }

    @Test
    void testStepUp() {
        Game game = mock(Game.class);
        when(position.getUp()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.step(game, Set.of(ACTION.FIREBOY_UP), System.currentTimeMillis());

        verify(fireboy).setPosition(position);
    }

    @Test
    void testStepDown() {
        Game game = mock(Game.class);
        when(position.getDown()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.step(game, Set.of(ACTION.FIREBOY_DOWN), System.currentTimeMillis());

        verify(fireboy).setPosition(position);
    }

    @Test
    void testStep_NoActions() {
        Game game = mock(Game.class);

        controller.step(game, Collections.emptySet(), System.currentTimeMillis());

        verify(fireboy, never()).setPosition(any());
    }
}