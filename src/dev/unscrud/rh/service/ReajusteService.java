package dev.unscrud.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import dev.unscrud.rh.ValidacaoException;
import dev.unscrud.rh.model.Funcionario;

public class ReajusteService {
  public void reajustarSalarioDo(Funcionario funcionario, BigDecimal aumento) {
    BigDecimal salarioAtual = funcionario.getSalario();
    BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
    if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0)
      throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
    BigDecimal salarioReajustado = salarioAtual.add(aumento);
    funcionario.atualizarSalario(salarioReajustado);
  }
}
