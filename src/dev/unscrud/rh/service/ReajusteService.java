package dev.unscrud.rh.service;

import java.math.BigDecimal;
import java.util.List;

import dev.unscrud.rh.model.Funcionario;

public class ReajusteService {

  private List<ValidacaoReajuste> validacoes;

  public ReajusteService(List<ValidacaoReajuste> validacoes) {
    this.validacoes = validacoes;
  }

  public void reajustarSalarioDo(Funcionario funcionario, BigDecimal aumento) {
    this.validacoes.forEach(v -> v.validar(funcionario, aumento));

    BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
    funcionario.atualizarSalario(salarioReajustado);
  }
}
