using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using StreetFighter.Web.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult FazerLogin(string usuario, string senha)
        {
            UsuarioAplicativo aplicativo = new UsuarioAplicativo();
            Usuario usuarioAutenticado = aplicativo.BuscarUsuarioAutenticado(usuario, senha);

            if (usuarioAutenticado != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(usuarioAutenticado.Login));
                return RedirectToAction("Index", "StreetFighter");
            }

            ViewBag.ErroLogin = "Usuário e/ou senha inválido.";
            return View("Index");
        }
    }
}