package com.example.dataindexer.frontend.ui;

import com.example.dataindexer.frontend.document.DocumentDTO;
import com.example.dataindexer.frontend.document.DocumentService;
import com.example.dataindexer.frontend.document.PersonInvolvedDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@UIScope
@Component
@Route("")
public class HomePage extends Div {
    private final DocumentService documentService;
    private Grid<DocumentDTO> documents = new Grid<>(DocumentDTO.class);
    private TextField nameFilter = new TextField("Name");
    private Button searchButton = new Button("Search");
    private Button searchPersonInvolved = new Button("Persons involved");

    @PostConstruct
    private void init() {
        HorizontalLayout searchGroup = new HorizontalLayout(nameFilter, searchButton, searchPersonInvolved);
        add(searchGroup, documents);
        searchButton.addClickListener(e -> searchByName());
        searchPersonInvolved.addClickListener(e -> searchPersonInvolved());
    }

    private void searchByName() {
        if (StringUtils.isBlank(nameFilter.getValue())) {
            documents.setItems(documentService.findAll());
        } else {
            documents.setItems(documentService.findByName(nameFilter.getValue()));
        }
    }

    private void searchPersonInvolved() {
        PersonInvolvedDTO personInvolved = documentService.findPersonInvolved(nameFilter.getValue());

        Grid<PersonInvolvedDTO> personInvolvedDTOGrid = new Grid<>(PersonInvolvedDTO.class);
        personInvolvedDTOGrid.setItems(personInvolved);

        Dialog dialog = new Dialog();
        dialog.add(personInvolvedDTOGrid);
        dialog.open();
    }
}
