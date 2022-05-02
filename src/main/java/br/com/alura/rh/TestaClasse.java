package br.com.alura.rh;

import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.reajuste.ReajusteService;
import br.com.alura.rh.service.reajuste.ValidacaoPercentualReajuste;
import br.com.alura.rh.service.ValidacaoReajuste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestaClasse {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("teste","01234567890",Cargo.ANALISTA, BigDecimal.valueOf(3464));

        System.out.println(f1.getNome());
        System.out.println(f1.getCargo());
        System.out.println(f1.getCpf());
        System.out.println(f1.getSalario());


        List<ValidacaoReajuste> validacoes = new ArrayList<>();
        validacoes.add(new ValidacaoPercentualReajuste());
        //validacoes.add(new ValidacaoPeriodicidadeEntreReajuste());

        ReajusteService service = new ReajusteService(validacoes);


        System.out.println("Reajuste: " + f1.getSalario());
        System.out.println(f1.getDataUltimoReajuste());
    }
}
