package com.example.dataindexer.datasearcher.repo;

import com.example.dataindexer.datasearcher.model.DoorsDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DoorsDocumentRepository extends JpaRepository<DoorsDocument, Long> {
    DoorsDocument findByDocumentNumber(String documentNumber);

    @Query("SELECT dd FROM DoorsDocument dd WHERE dd.documentNumber = :arg")
    DoorsDocument findCustom(String arg);
}