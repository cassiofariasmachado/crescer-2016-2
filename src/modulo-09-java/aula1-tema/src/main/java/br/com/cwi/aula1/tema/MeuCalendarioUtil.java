/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aula1.tema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cássio
 */
public class MeuCalendarioUtil {

    public static void main(String[] args) {
        int opcao;
        List<String> listaDeOpcoes = new ArrayList();
        listaDeOpcoes.add("-------------------------------------------------------");
        listaDeOpcoes.add("1 - retornarDiaDaSemana() - retorna o dia da semana da sua data de aniversario, por exemplo");
        listaDeOpcoes.add("2 - retornarTempoDecorridoAteHoje() - retorna o tempo decorrido até hoje");
        listaDeOpcoes.add("3 - sair");

        do {
            opcao = MeuConsoleUtil.lerOpcao(listaDeOpcoes);
            String retorno = "";
            String dataDigitada = MeuConsoleUtil.lerString("Digite a data: ");
            Date data = converterData(dataDigitada);

            switch (opcao) {
                case 1:
                    retorno = retornarDiaDaSemana(data);
                    break;
                case 2:
                    retorno = retornarTempoDecorridoAteHoje(data);
                    break;
            }

            System.out.println(retorno);
        } while (opcao != 3);
    }

    public static String retornarDiaDaSemana(Date data) {
        return new SimpleDateFormat("EEEE").format(data);
    }

    public static String retornarTempoDecorridoAteHoje(Date data) {
        //TO-DO: Terminar, não está calculando corretamente
        Calendar dataAtual = Calendar.getInstance();
        dataAtual.setTime(new Date());
        
        dataAtual.add(Calendar.DATE, -data.getDate());
        dataAtual.add(Calendar.MONTH, -data.getMonth());
        dataAtual.add(Calendar.YEAR, -data.getYear());

        return String.format("%d ano(s), %d mes(es) e %d dia(s)",
                dataAtual.get(Calendar.YEAR),
                dataAtual.get(Calendar.MONTH),
                dataAtual.get(Calendar.DATE));
    }

    public static Date converterData(String data) {
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            return formatoData.parse(data);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            System.out.println("Erro ao converter a data informada!!");
        }
        return null;
    }

}
