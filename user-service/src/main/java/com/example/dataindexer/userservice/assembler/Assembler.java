package com.example.dataindexer.userservice.assembler;

public interface Assembler<E, V> {
    V assemble(E e);
}
