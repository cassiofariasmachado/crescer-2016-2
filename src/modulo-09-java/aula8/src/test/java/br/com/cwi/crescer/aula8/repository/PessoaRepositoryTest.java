package br.com.cwi.crescer.aula8.repository;

import static org.junit.Assert.assertTrue;

import br.com.cwi.crescer.aula8.AppRun;
import br.com.cwi.crescer.aula8.entity.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Carlos H. Nonnemacher
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppRun.class)
@Transactional
public class PessoaRepositoryTest {

    private static final String NOME_PESSOA = "Carlos Henrique Nonnemacher";

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Before
    public void setBefore() {
        final Pessoa pessoa = new Pessoa();
        pessoa.setIdade(31l);
        pessoa.setNascimento(new Date());
        pessoa.setNome(NOME_PESSOA);
        pessoa.setVlPessoa(BigDecimal.TEN);
        entityManager.persist(pessoa);
    }

    /**
     * Test of findByNome method, of class PessoaRepository.
     */
    @Test
    public void testFindByNome() {
        final List<Pessoa> list = pessoaRepository.findByNome(NOME_PESSOA);
        assertTrue(list.stream().allMatch(p -> p.getNome().equals(NOME_PESSOA)));
    }

}
