package br.com.cwi.crescer.aula4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Carlos H. Nonnemacher
 */
@WebServlet(name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    @EJB
    private PessoaBean pessoaBean;

    List<String> nomes = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {

            out.append("<table class=\"table is-narrow is-bordered\"><thead><tr><th>Nome</th></tr></thead><tbody>");
            List<Pessoa> listaPessoas = pessoaBean.findAll();

            listaPessoas.stream().forEach((p) -> {
                out.append("<tr><th>").append(p.getNmPessoa()).append("</th></tr>");
            });
            out.append("</tbody></table>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String nome = request.getParameter("nome");

        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa(nome);
        pessoaBean.insert(pessoa);

        response.sendRedirect("");
    }

}
