package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.blocks.Block;
import com.t09g01.projeto.model.game.elements.players.Watergirl;
import com.t09g01.projeto.model.game.temple.Temple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class WatergirlControllerTest {
    private Temple temple;
    private WatergirlController controller;
    private Watergirl watergirl;
    private Position position;
    private List<Block> blocks;


    @BeforeEach
    void setUp() {
        this.temple = Mockito.mock(Temple.class);
        this.watergirl = Mockito.mock(Watergirl.class);
        this.position = Mockito.mock(Position.class);
        this.blocks = Mockito.mock(List.class);

        when(temple.getWatergirl()).thenReturn(watergirl);
        when(watergirl.getPosition()).thenReturn(position);
        when(temple.getBlocks()).thenReturn(blocks);

        this.controller = new WatergirlController(temple);
    }

    @Test
    void testMove() {
        Position newPosition = mock(Position.class);

        controller.moveWatergirl(newPosition);

        verify(watergirl).setPosition(newPosition);
        verify(temple).retrieveBlueDiamonds(newPosition);
    }


    @Test
    void testMoveRight_NoCollision() {
        when(position.getRight()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.moveWatergirlRight();

        verify(watergirl).setPosition(position);
    }

    @Test
    void testMoveRight_WithCollision() {
        when(position.getRight()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(true);

        controller.moveWatergirlRight();

        verify(watergirl, never()).setPosition(any());
    }

    @Test
    void testMoveLeft_NoCollision() {
        when(position.getLeft()).thenReturn(position);
        when(temple.collidesLeft(position, blocks)).thenReturn(false);

        controller.moveWatergirlLeft();

        verify(watergirl).setPosition(position);
    }

    @Test
    void testMoveLeft_WithCollision() {
        when(position.getLeft()).thenReturn(position);
        when(temple.collidesLeft(position, blocks)).thenReturn(true);

        controller.moveWatergirlLeft();

        verify(watergirl, never()).setPosition(any());
    }

    @Test
    void testMoveUp_NoCollision() {
        when(position.getUp()).thenReturn(position);
        when(temple.collidesUp(position, blocks)).thenReturn(false);

        controller.moveWatergirlUp();

        verify(watergirl).setPosition(position);
    }

    @Test
    void testMoveUp_WithCollision() {
        when(position.getUp()).thenReturn(position);
        when(temple.collidesUp(position, blocks)).thenReturn(true);

        controller.moveWatergirlUp();

        verify(watergirl, never()).setPosition(any());
    }

    @Test
    void testMoveDown_NoCollision() {
        when(position.getDown()).thenReturn(position);
        when(temple.collidesDown(position, blocks)).thenReturn(false);

        controller.moveWatergirlDown();

        verify(watergirl).setPosition(position);
    }

    @Test
    void testMoveDown_WithCollision() {
        when(position.getDown()).thenReturn(position);
        when(temple.collidesDown(position, blocks)).thenReturn(true);

        controller.moveWatergirlDown();

        verify(watergirl, never()).setPosition(any());
    }

    @Test
    void testStepRight() {
        Game game = mock(Game.class);
        when(position.getRight()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.step(game, Set.of(ACTION.WATERGIRL_RIGHT), System.currentTimeMillis());

        verify(watergirl).setPosition(position);
    }

    @Test
    void testStepLeft() {
        Game game = mock(Game.class);
        when(position.getLeft()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.step(game, Set.of(ACTION.WATERGIRL_LEFT), System.currentTimeMillis());

        verify(watergirl).setPosition(position);
    }

    @Test
    void testStepUp() {
        Game game = mock(Game.class);
        when(position.getUp()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.step(game, Set.of(ACTION.WATERGIRL_UP), System.currentTimeMillis());

        verify(watergirl).setPosition(position);
    }

    @Test
    void testStepDown() {
        Game game = mock(Game.class);
        when(position.getDown()).thenReturn(position);
        when(temple.collidesRight(position, blocks)).thenReturn(false);

        controller.step(game, Set.of(ACTION.WATERGIRL_DOWN), System.currentTimeMillis());

        verify(watergirl).setPosition(position);
    }

    @Test
    void testStep_NoActions() {
        Game game = mock(Game.class);

        controller.step(game, Collections.emptySet(), System.currentTimeMillis());

        verify(watergirl, never()).setPosition(any());
    }
}
