package com.example.dataindexer.frontend.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@UIScope
@Component
@Route("")
public class HomePage extends Div {
    private Label label = new Label("Hello world");

    @PostConstruct
    private void init() {
        add(label);
    }
}
