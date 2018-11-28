package com.example.dataindexer.userservice.user;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class UserFormatter implements Formatter<UserDTO> {
    @Override
    public UserDTO parse(String text, Locale locale) throws ParseException {
        if (!text.contains("_")) {
            throw new ParseException(text, text.length());
        }
        String[] userTextParts = text.split("_");
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(userTextParts[0]);
        userDTO.setLastName(userTextParts[1]);
        return userDTO;
    }

    @Override
    public String print(UserDTO userDTO, Locale locale) {
        return userDTO.toString();
    }
}
