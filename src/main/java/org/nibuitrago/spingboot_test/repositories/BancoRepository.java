package org.nibuitrago.spingboot_test.repositories;

import org.nibuitrago.spingboot_test.models.Banco;

import java.util.List;

public interface BancoRepository {
    List<Banco> findAll();

    Banco findById(Long id);

    void update(Banco banco);
}
