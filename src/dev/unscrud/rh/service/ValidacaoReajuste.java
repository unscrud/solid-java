package dev.unscrud.rh.service;

import java.math.BigDecimal;

import dev.unscrud.rh.model.Funcionario;

public interface ValidacaoReajuste {
  void validar(Funcionario funcionario, BigDecimal aumento);
}
