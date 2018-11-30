package com.example.dataindexer.frontend.document;

import lombok.Data;

import java.util.Date;

@Data
public class DocumentDTO {
    private String userId;
    private String documentNumber;
    private String documentVersion;
    private Date releasedOn;
}
