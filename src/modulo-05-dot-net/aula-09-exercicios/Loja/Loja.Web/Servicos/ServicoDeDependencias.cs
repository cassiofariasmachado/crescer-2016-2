using Loja.Dominio;
using Loja.Infraestrutura;
using Loja.Repositorio;
using Loja.Repositorio.EntityFramework;

namespace Loja.Web.Servicos
{
    public class ServicoDeDependencias
    {
        public static UsuarioServico MontarUsuarioServico()
        {
            UsuarioServico usuarioServico = new UsuarioServico(new UsuarioRepositorio(), new ServicoDeCriptografia());
            return usuarioServico;
        }

        public static ProdutoServico MontarProdutoServico()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
            return produtoServico;
        }
    }
}