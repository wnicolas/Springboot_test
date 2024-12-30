package org.nibuitrago.spingboot_test.services;

import org.nibuitrago.spingboot_test.models.Cuenta;

import java.math.BigDecimal;

public interface CuentaService {
    Cuenta findById(Long id);

    int revisarTotalTransferencia(Long bancoId);

    BigDecimal revisarSaldo(Long id);

    void transferir(Long origen, Long destino, BigDecimal monto, Long bancoId);

}
