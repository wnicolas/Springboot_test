package org.nibuitrago.spingboot_test;

import org.nibuitrago.spingboot_test.models.Banco;
import org.nibuitrago.spingboot_test.models.Cuenta;

import java.math.BigDecimal;

public class Datos {
    public static final Cuenta CUENTA_001 = new Cuenta(1L, "Nicolas", new BigDecimal("1000"));
    public static final Cuenta CUENTA_002 = new Cuenta(2L, "Liz", new BigDecimal("1500"));
    public static final Banco BANCO = new Banco(1L, "Davivienda", 100);
}
