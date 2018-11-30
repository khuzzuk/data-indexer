package com.example.dataindexer.datasearcher.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonInvolvedView {
    private String documentNumber;
    private long personsInvolved;
}
