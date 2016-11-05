using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            FichaTecnicaModel fichaTecnica = new FichaTecnicaModel();
            fichaTecnica.UrlDaImagem = @"blanka.png";
            fichaTecnica.Nome = "Blanka";
            fichaTecnica.DataNascimento = DateTime.Parse("12/02/1966", new CultureInfo("pt-BR"));
            fichaTecnica.Altura = 192;
            fichaTecnica.Peso = 96;
            fichaTecnica.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
            fichaTecnica.GolpesEspeciais = "Electric Thunder, Rolling Attack.";
            return View(fichaTecnica);
        }

        public ActionResult Sobre()
        {
            SobreModel sobre = new SobreModel();
            sobre.Nome = "Cássio Farias Machado";
            sobre.DataNascimento = DateTime.Parse("18/09/1996", new CultureInfo("pt-BR"));
            sobre.Altura = 171;
            sobre.Peso = 67;
            sobre.TipoSanguineo = TipoSanguineo.A;
            sobre.HabilidadesEspeciais = "Comer, bater palmas fora do ritmo e tentar programar";
            sobre.Gosta = "Jogar video jogos, nadar e ler livros";
            sobre.Desgosta = "Sopa de janta e ervilha";
            sobre.FalaDeVitoria = "\"Pede pra nerfar noob!\"";
            sobre.Nacionalidade = "Brasil";
            sobre.Naturalidade = "Porto Alegre";
            return View(sobre);
        }

        public ActionResult Cadastro()
        {
            PopularOrigens();
            return View();
        }

        public ActionResult SalvarCadastro(FichaTecnicaModel fichaModel)
        {
            if (ModelState.IsValid)
            {
                ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                return View("Detalhe", fichaModel);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro. Tente novamente ou entre em contato com o administrador.");
                return View("Cadastro");
            }
        }

        public ActionResult ListaDePersonagens()
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            List<Personagem> personagens = aplicativo.ListaPersonagens();
            return View(personagens);
        }

        private void PopularOrigens()
        {
            ViewBag.ListaDeOrigens = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "AR", Text = "Argentina" },
                new SelectListItem() { Value = "BO", Text = "Bolivia" },
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "CL", Text = "Chile" },
                new SelectListItem() { Value = "CO", Text = "Colômbia" },
                new SelectListItem() { Value = "EC", Text = "Equador" },
                new SelectListItem() { Value = "GY", Text = "Guiana" },
                new SelectListItem() { Value = "GF", Text = "Guiana Francesa" },
                new SelectListItem() { Value = "PY", Text = "Paraguai" },
                new SelectListItem() { Value = "PE", Text = "Peru" },
                new SelectListItem() { Value = "SR", Text = "Suriname" },
                new SelectListItem() { Value = "UY", Text = "Uruguai" },
                new SelectListItem() { Value = "VE", Text = "Venezuela" },
            };
        }
    }
}