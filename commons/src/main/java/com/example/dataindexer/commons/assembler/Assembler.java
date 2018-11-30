package com.example.dataindexer.commons.assembler;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface Assembler<E, V> {
    V assemble(E e);

    default Set<V> assembleToSet(Collection<E> elements) {
        return elements.stream().map(this::assemble).collect(Collectors.toSet());
    }

    default List<V> assembleToList(Collection<E> elements) {
        return elements.stream().map(this::assemble).collect(Collectors.toList());
    }
}
