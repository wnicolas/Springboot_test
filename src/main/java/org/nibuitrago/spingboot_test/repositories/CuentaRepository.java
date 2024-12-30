package org.nibuitrago.spingboot_test.repositories;

import org.nibuitrago.spingboot_test.models.Cuenta;

import java.util.List;

public interface CuentaRepository {
    List<Cuenta> findAll();

    Cuenta findById(Long id);

    void update(Cuenta cuenta);


}
