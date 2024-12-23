package com.t09g01.projeto.states;

import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.screens.MainMenuController;
import com.t09g01.projeto.model.menu.MainMenu;
import com.t09g01.projeto.view.image.ImageLoader;
import com.t09g01.projeto.view.screens.ScreenViewer;
import com.t09g01.projeto.view.screens.MenuViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class MainMenuStateTest {
    private MainMenu mainMenu;
    private ImageLoader imageLoader;
    private ViewerProvider viewerProvider;
    private MainMenuState mainMenuState;

    @BeforeEach
    void setUp() throws IOException {
        this.mainMenu = Mockito.mock(MainMenu.class);
        this.imageLoader = Mockito.mock(ImageLoader.class);
        this.viewerProvider = Mockito.mock(ViewerProvider.class);

        mainMenuState = new MainMenuState(mainMenu, imageLoader);
    }

    @Test
    void testMainMenuStateConstructor() {
        assertNotNull(mainMenuState);
    }

    @Test
    void testGetController() {
        Controller<MainMenu> controller = mainMenuState.getController();

        assertNotNull(controller);
        assertTrue(controller instanceof MainMenuController);
    }

    @Test
    void testGetScreenViewer() {
        ScreenViewer<MainMenu> screenViewer = mainMenuState.getScreenViewer(viewerProvider);

        assertNotNull(screenViewer);
        assertTrue(screenViewer instanceof MenuViewer);
    }
}
