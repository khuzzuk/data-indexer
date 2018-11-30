package com.example.dataindexer.datasearcher.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
public class SapDocument {
    @SequenceGenerator(name = "sap_document_id_gen", sequenceName = "sap_document_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sap_document_id_gen")
    @Id
    private Long id;
    private String documentNumber;
    private String documentVersion;
    private String documentType;
    private Person creator;
    @ManyToMany
    @JoinTable(name = "sap_document_editors",
            joinColumns = @JoinColumn(name = "sap_document_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Person> involved;
    private Timestamp releasedOn;
    @ManyToMany(mappedBy = "relatedDocuments")
    private Set<DoorsDocument> relatedDocument;
}
