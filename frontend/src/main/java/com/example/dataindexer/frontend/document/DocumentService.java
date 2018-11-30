package com.example.dataindexer.frontend.document;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class DocumentService {
    @Value("${dataindexer.data-searcher.document.url}")
    private String documentSearchUrl;
    private final RestTemplate restTemplate;

    public List<DocumentDTO> findAll() {
        DocumentDTOList dtoList = restTemplate.getForObject(documentSearchUrl + "findAll", DocumentDTOList.class);
        return dtoList.getDocuments();
    }

    public DocumentDTO findByName(String name) {
        return restTemplate.getForObject(documentSearchUrl + "findByName/" + name, DocumentDTO.class);
    }

    public PersonInvolvedDTO findPersonInvolved(String documentNumber) {
        return restTemplate.getForObject(documentSearchUrl + "findPersonsInvolved/" + documentNumber, PersonInvolvedDTO.class);
    }
}
