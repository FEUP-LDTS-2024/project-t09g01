package com.t09g01.projeto.states;

import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.screens.CreditsController;
import com.t09g01.projeto.model.screens.Credits;
import com.t09g01.projeto.view.image.ImageLoader;
import com.t09g01.projeto.view.screens.ScreenViewer;
import com.t09g01.projeto.view.screens.CreditsViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CreditsStateTest {
    private Credits mockCredits;
    private ImageLoader imageLoader;
    private ViewerProvider viewerProvider;
    private CreditsState creditsState;

    @BeforeEach
    void setUp() throws IOException {
        this.mockCredits = Mockito.mock(Credits.class);
        this.imageLoader = Mockito.mock(ImageLoader.class);
        this.viewerProvider = mock(ViewerProvider.class);

        creditsState = new CreditsState(mockCredits, imageLoader);
    }

    @Test
    void testCreditsStateConstructor() {
        assertNotNull(creditsState, "CreditsState instance should be created successfully.");
    }

    @Test
    void testGetController() {
        Controller<Credits> controller = creditsState.getController();

        assertNotNull(controller, "Controller should not be null.");
        assert(controller instanceof CreditsController);
    }

    @Test
    void testGetScreenViewer() {
        ScreenViewer<Credits> screenViewer = creditsState.getScreenViewer(viewerProvider);

        assertNotNull(screenViewer, "ScreenViewer should not be null.");
        assert(screenViewer instanceof CreditsViewer);
    }
}
