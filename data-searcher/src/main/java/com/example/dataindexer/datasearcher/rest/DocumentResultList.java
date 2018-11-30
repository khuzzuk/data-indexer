package com.example.dataindexer.datasearcher.rest;

import com.example.dataindexer.datasearcher.api.DocumentDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DocumentResultList {
    private List<DocumentDTO> documents;
}
