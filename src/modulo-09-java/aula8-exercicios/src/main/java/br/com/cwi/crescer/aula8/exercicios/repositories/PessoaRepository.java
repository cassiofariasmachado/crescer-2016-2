/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.exercicios.repositories;

import br.com.cwi.crescer.aula8.exercicios.entities.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cassio.machado
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
