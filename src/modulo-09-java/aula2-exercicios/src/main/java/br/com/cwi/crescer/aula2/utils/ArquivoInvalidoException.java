/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.utils;

/**
 *
 * @author cfari
 */
public class ArquivoInvalidoException extends Exception {

    public ArquivoInvalidoException() {
        super("Arquivo inválido.");
    }
    
    public ArquivoInvalidoException(String mensagem) {
        super(mensagem);
    }

}
