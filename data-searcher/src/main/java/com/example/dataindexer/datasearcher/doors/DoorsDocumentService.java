package com.example.dataindexer.datasearcher.doors;

import com.example.dataindexer.datasearcher.api.PersonInvolvedView;
import com.example.dataindexer.datasearcher.model.DoorsDocument;
import com.example.dataindexer.datasearcher.repo.DoorsDocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@AllArgsConstructor
@Service
public class DoorsDocumentService {
    private final DoorsDocumentRepository doorsDocumentRepository;
    private final EntityManager entityManager;

    public List<DoorsDocument> findAll() {
        doorsDocumentRepository.count();
        doorsDocumentRepository.findAll(new PageRequest(6, 20));
        return doorsDocumentRepository.findAll();
    }

    public DoorsDocument findByDocumentNumber(String documentNumber) {
        return doorsDocumentRepository.findByDocumentNumber(documentNumber);
    }

    public PersonInvolvedView getPersonInvolved(String documentNumber) {
        Query query = entityManager.createQuery(
                "SELECT new com.example.dataindexer.datasearcher.api.PersonInvolvedView(dd.documentNumber, COUNT(i)) " +
                "FROM DoorsDocument dd " +
                "   JOIN dd.involved i " +
                "WHERE dd.documentNumber = :docNum " +
                        "GROUP BY dd.documentNumber");
        query.setParameter("docNum", documentNumber);
        return (PersonInvolvedView) query.getSingleResult();
    }
}
