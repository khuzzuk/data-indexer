package com.example.dataindexer.datasearcher.rest;

import com.example.dataindexer.commons.assembler.Assembler;
import com.example.dataindexer.datasearcher.api.DocumentDTO;
import com.example.dataindexer.datasearcher.model.DoorsDocument;
import com.example.dataindexer.datasearcher.model.Person;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class DocumentDTOAssembler implements Assembler<DoorsDocument, DocumentDTO> {
    @Override
    public DocumentDTO assemble(DoorsDocument doorsDocument) {
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setDocumentNumber(doorsDocument.getDocumentNumber());
        documentDTO.setDocumentVersion(doorsDocument.getDocumentVersion());
        documentDTO.setDocumentType(doorsDocument.getDocumentType());
        documentDTO.setUserId(doorsDocument.getCreator().getUserId());

        if (doorsDocument.getReleasedOn() != null) {
            documentDTO.setReleasedOn(from(doorsDocument.getReleasedOn()));
        }

        documentDTO.setPersonInvolvedUserIds(doorsDocument.getInvolved().stream()
                .map(Person::getUserId).collect(Collectors.toSet()));
        return documentDTO;
    }

    private static Date from(Timestamp timestamp) {
        return new Date(timestamp.getTime());
    }
}
