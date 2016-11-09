using Loja.Web.Models;
using System.Web;

namespace Loja.Web.Servicos
{
    public static class ServicoDeAutenticacao
    {
        private const string USUARIO_LOGADO_CHAVE = "USUARIO_LOGADO_CHAVE";
        public static void Autenticar(UsuarioLogadoModel model)
        {
            HttpContext.Current.Session[USUARIO_LOGADO_CHAVE] = model;
        }

        public static UsuarioLogadoModel UsuarioLogado
        {
            get
            {
                return (UsuarioLogadoModel)HttpContext.Current.Session[USUARIO_LOGADO_CHAVE];
            }
        }

    }
}