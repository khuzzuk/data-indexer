package com.example.dataindexer.userservice.user;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class UserFormatter implements Formatter<User> {
    @Override
    public User parse(String text, Locale locale) throws ParseException {
        if (!text.contains("_")) {
            throw new ParseException(text, text.length());
        }
        String[] userTextParts = text.split("_");
        User user = new User();
        user.setFirstName(userTextParts[0]);
        user.setLastName(userTextParts[1]);
        return user;
    }

    @Override
    public String print(User user, Locale locale) {
        return user.toString();
    }
}
