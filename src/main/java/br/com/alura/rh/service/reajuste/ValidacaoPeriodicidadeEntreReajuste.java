package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.ValidacaoReajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal aumento){

        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();

        LocalDate dataAtual = LocalDate.now();

        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste , dataAtual);
        if(mesesDesdeUltimoReajuste < 6){
            throw new ValidacaoException("Intervalo entre reajuste deve ser de no minimo 6 meses.");
        }

    }
}
