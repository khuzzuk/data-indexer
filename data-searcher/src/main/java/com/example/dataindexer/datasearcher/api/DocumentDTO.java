package com.example.dataindexer.datasearcher.api;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class DocumentDTO {
    private String documentNumber;
    private String documentVersion;
    private String documentType;
    private String userId;
    private Set<String> personInvolvedUserIds;
    private Date releasedOn;
}
