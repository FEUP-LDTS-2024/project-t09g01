package com.t09g01.projeto.states;

import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.screens.CreditsController;
import com.t09g01.projeto.control.screens.EntryController;
import com.t09g01.projeto.model.screens.Credits;
import com.t09g01.projeto.view.image.ImageLoader;
import com.t09g01.projeto.view.screens.ScreenViewer;
import com.t09g01.projeto.view.screens.CreditsViewer;
import com.t09g01.projeto.view.text.ViewerProvider;

import java.io.IOException;

public class CreditsState extends State<Credits>{
    public CreditsState(Credits credits, ImageLoader imageLoader) throws IOException {
        super(credits, imageLoader);
    }

    @Override
    protected Controller<Credits> getController(){
        return new CreditsController(getModel(),  new EntryController(getModel()));}

    @Override
    protected ScreenViewer<Credits> getScreenViewer(ViewerProvider viewerProvider) {
        return new CreditsViewer<>(getModel(), viewerProvider);
    }
}
