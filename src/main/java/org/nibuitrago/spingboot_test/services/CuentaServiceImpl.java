package org.nibuitrago.spingboot_test.services;

import org.nibuitrago.spingboot_test.models.Banco;
import org.nibuitrago.spingboot_test.models.Cuenta;
import org.nibuitrago.spingboot_test.repositories.BancoRepository;
import org.nibuitrago.spingboot_test.repositories.CuentaRepository;

import java.math.BigDecimal;

public class CuentaServiceImpl implements CuentaService {
    private CuentaRepository cuentaRepository;
    private BancoRepository bancoRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, BancoRepository bancoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.bancoRepository = bancoRepository;
    }

    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public int revisarTotalTransferencia(Long bancoId) {
        Banco banco = bancoRepository.findById(bancoId);
        return banco.getTotalTransferencia();
    }

    @Override
    public BigDecimal revisarSaldo(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id);
        return cuenta.getSaldo();
    }

    @Override
    public void transferir(Long numeroOrigen, Long numeroDestino, BigDecimal monto, Long idBanco) {
        Banco banco = bancoRepository.findById(idBanco);
        int totalTransferencias = banco.getTotalTransferencia();
        banco.setTotalTransferencia(++totalTransferencias);
        bancoRepository.update(banco);

        Cuenta origen = cuentaRepository.findById(numeroOrigen);
        origen.debito(monto);
        cuentaRepository.update(origen);

        Cuenta destino = cuentaRepository.findById(numeroDestino);
        destino.credito(monto);
        cuentaRepository.update(destino);
    }
}
