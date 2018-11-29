package com.example.dataindexer.frontend.ui.login;

import com.example.dataindexer.frontend.ui.HomePage;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@UIScope
@Component
@Route("login")
public class LoginPage extends Div {
    private final AuthenticationManager authenticationManager;

    private TextField username = new TextField("User name");
    private PasswordField password = new PasswordField("Password");
    private Button login = new Button("Login");

    @PostConstruct
    private void init() {
        add(username, password, login);

        login.addClickListener(e -> doLogin());
    }

    private void doLogin() {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username.getValue(), password.getValue()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        getUI().get().navigate(HomePage.class);
    }
}
