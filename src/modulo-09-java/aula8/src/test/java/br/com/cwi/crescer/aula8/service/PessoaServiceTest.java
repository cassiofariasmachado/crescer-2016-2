package br.com.cwi.crescer.aula8.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Carlos H. Nonnemacher
 */
@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private Iterable<Pessoa> pessoas;

    @Mock
    private Pageable pageable;

    @Mock
    private Page<Pessoa> page;
    
    @Mock
    private Pessoa pessoa;

    @Before
    public void setUp() {
        when(pessoaRepository.findAll()).thenReturn(pessoas);
        when(pessoaRepository.findAll(pageable)).thenReturn(page);
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);
        when(pessoaService.findOne(1l)).thenReturn(pessoa);
    }

    /**
     * Test of list method, of class PessoaService.
     */
    @Test
    public void testList() {
        assertNotNull(pessoaService.list());
    }

    /**
     * Test of findAll method, of class PessoaService.
     */
    @Test
    public void testFindAll_Pageable() {
        assertEquals(page, pessoaService.findAll(pageable));
        verify(pessoaRepository).findAll(pageable);
    }

    /**
     * Test of findAll method, of class PessoaService.
     */
    @Test
    public void testFindAll_0args() {
        assertEquals(pessoas, pessoaService.findAll());
        verify(pessoaRepository).findAll();
    }

    /**
     * Test of save method, of class PessoaService.
     */
    @Test
    public void testSave() {
        assertEquals(pessoa, pessoaService.save(pessoa));
        verify(pessoaRepository).save(pessoa);
    }

    /**
     * Test of delete method, of class PessoaService.
     */
    @Test
    public void testDelete() {
        pessoaService.delete(1l);
        verify(pessoaRepository).delete(1l);
    }

    /**
     * Test of findOne method, of class PessoaService.
     */
    @Test
    public void testFindOne() {
        assertEquals(pessoa, pessoaService.findOne(1l));
        verify(pessoaRepository).findOne(1l);
    }

}
