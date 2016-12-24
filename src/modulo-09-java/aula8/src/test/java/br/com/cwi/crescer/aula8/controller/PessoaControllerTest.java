package br.com.cwi.crescer.aula8.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import org.junit.Before;
import org.junit.Test; 
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Carlos H. Nonnemacher
 */
@RunWith(MockitoJUnitRunner.class)
public class PessoaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private Pessoa pessoa;

    @Mock
    private Page<Pessoa> page;

    @Before
    public void setUp() {

        when(pessoaService.findAll(any())).thenReturn(page);
        when(pessoaService.findOne(any())).thenReturn(pessoa);
        
        final InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/templates/");
        internalResourceViewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(pessoaController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers(internalResourceViewResolver).build();
    }

    /**
     * Test of get method, of class PessoaController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/pessoa/1"))
                .andExpect(model().attributeExists("pessoa", "pessoas"))
                .andExpect(status().isOk())
                .andExpect(view().name("pessoa"));
        verify(pessoaService).findOne(any());
        verify(pessoaService).findAll(any());
    }

    /**
     * Test of list method, of class PessoaController.
     * @throws java.lang.Exception
     */
    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/pessoa"))
                .andExpect(model().attributeExists("pessoa", "pessoas"))
                .andExpect(status().isOk())
                .andExpect(view().name("pessoa"));
        verify(pessoaService).findAll(any());
    }

    /**
     * Test of save method, of class PessoaController.
     */
    @Test
    public void testSave() {
    }

    /**
     * Test of listAll method, of class PessoaController.
     */
    @Test
    public void testListAll() {
    }

}
