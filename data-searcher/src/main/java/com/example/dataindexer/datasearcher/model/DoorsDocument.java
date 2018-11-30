package com.example.dataindexer.datasearcher.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
public class DoorsDocument {
    @SequenceGenerator(name = "doors_document_id_gen", sequenceName = "doors_document_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doors_document_id_gen")
    @Id
    private Long id;
    private String documentNumber;
    private String documentVersion;
    private String documentType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by")
    private Person creator;
    @ManyToMany
    @JoinTable(name = "door_document_editors",
            joinColumns = @JoinColumn(name = "doors_document_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Person> involved;
    private @NotNull Timestamp releasedOn;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<SapDocument> relatedDocuments;

    void addRelatedDocument(SapDocument sapDocument) {
        relatedDocuments.add(sapDocument);
        sapDocument.getRelatedDocument().add(this);
    }
}
