package com.example.dataindexer.datasearcher.rest;

import com.example.dataindexer.commons.assembler.Assembler;
import com.example.dataindexer.datasearcher.api.DocumentDTO;
import com.example.dataindexer.datasearcher.api.PersonInvolvedView;
import com.example.dataindexer.datasearcher.doors.DoorsDocumentService;
import com.example.dataindexer.datasearcher.model.DoorsDocument;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("document")
public class DocumentRemoteService {
    private DoorsDocumentService doorsDocumentService;
    private Assembler<DoorsDocument, DocumentDTO> documentDTOAssembler;

    @GetMapping("findAll")
    public DocumentResultList findAll() {
        List<DoorsDocument> doorsDocuments = doorsDocumentService.findAll();
        List<DocumentDTO> documents = documentDTOAssembler.assembleToList(doorsDocuments);
        DocumentResultList resultList = new DocumentResultList();
        resultList.setDocuments(documents);
        return resultList;
    }

    @GetMapping("findByName/{name}")
    public DocumentDTO findByName(@PathVariable(name = "name") String name) {
        DoorsDocument document = doorsDocumentService.findByDocumentNumber(name);
        return documentDTOAssembler.assemble(document);
    }

    @GetMapping("findPersonsInvolved/{documentNumber}")
    public PersonInvolvedView findPersonsInvolved(@PathVariable(name = "documentNumber") String documentNumber) {
        PersonInvolvedView personInvolved = doorsDocumentService.getPersonInvolved(documentNumber);
        return personInvolved;
    }

    @ExceptionHandler(NullPointerException.class)
    public void handleMissingResult(HttpServletResponse response) {
        response.setStatus(400);
    }
}
