using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Dominio.Exceptions;
using StreetFighter.Web.Filters;
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
        [StreetFighterAutorizador]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        [StreetFighterAutorizador]
        public ActionResult ListaDePersonagens(string filtro)
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            List<Personagem> personagens = aplicativo.ListaPersonagens(filtro);

            return View(personagens);
        }

        [StreetFighterAutorizador]
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

        [HttpGet]
        [StreetFighterAutorizador]
        public ActionResult FichaTecnica(int id)
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            Personagem personagem = aplicativo.BuscarPersonagemPorId(id);

            FichaTecnicaModel fichaTecnica = new FichaTecnicaModel( personagem.Nome,
                                                                    personagem.DataNascimento,
                                                                    personagem.Altura,
                                                                    personagem.Peso,
                                                                    personagem.Origem,
                                                                    personagem.GolpesEspeciais,
                                                                    personagem.UrlDaImagem,
                                                                    personagem.PersonagemOculto );

            return View(fichaTecnica);
        }
        
        [StreetFighterAutorizador]
        public ActionResult Cadastro()
        {
            PopularOrigens();
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        [StreetFighterAutorizador]
        public ActionResult SalvarCadastro(FichaTecnicaModel fichaTecnicaModel)
        {
            if (ModelState.IsValid)
            {
                PersonagemAplicativo aplicativo = new PersonagemAplicativo();

                try
                {
                    Personagem personagem = new Personagem( fichaTecnicaModel.Id == null? 0 : fichaTecnicaModel.Id,
                                                            fichaTecnicaModel.Nome,
                                                            fichaTecnicaModel.DataNascimento,
                                                            fichaTecnicaModel.Altura,
                                                            fichaTecnicaModel.Peso,
                                                            fichaTecnicaModel.Origem,
                                                            fichaTecnicaModel.GolpesEspeciais,
                                                            fichaTecnicaModel.UrlDaImagem,
                                                            fichaTecnicaModel.PersonagemOculto );

                    if (personagem.Id == 0)
                        ViewBag.Mensagem = "Personagem cadastrado com sucesso.";
                    else
                        ViewBag.Mensagem = "Personagem editado com sucesso.";

                    aplicativo.Salvar(personagem);
                }
                catch (RegraDeNegocioException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    PopularOrigens();
                    return View("Cadastro");
                }

                return View("ListaDePersonagens", aplicativo.ListaPersonagens());
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro. Tente novamente ou entre em contato com o administrador.");

                PopularOrigens();
                return View("Cadastro");
            }
        }

        [HttpGet]
        [StreetFighterAutorizador]
        public ActionResult ExcluirPersonagem(int id)
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            Personagem personagem = aplicativo.BuscarPersonagemPorId(id);

            aplicativo.ExcluirPersonagem(personagem);

            ViewBag.Mensagem = "Personagem excluído com sucesso.";
            return View("ListaDePersonagens", aplicativo.ListaPersonagens());
        }

        [HttpGet]
        [StreetFighterAutorizador]
        public ActionResult EditarPersonagem(int id)
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            Personagem personagem = aplicativo.BuscarPersonagemPorId(id);

            FichaTecnicaModel fichaTecnica = new FichaTecnicaModel( personagem.Id,
                                                                    personagem.Nome,
                                                                    personagem.DataNascimento,
                                                                    personagem.Altura,
                                                                    personagem.Peso,
                                                                    personagem.Origem,
                                                                    personagem.GolpesEspeciais,
                                                                    personagem.UrlDaImagem,
                                                                    personagem.PersonagemOculto );

            PopularOrigens();
            return View("Cadastro", fichaTecnica);
        }

        private void PopularOrigens()
        {
            ViewBag.ListaDeOrigens = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "Argentina", Text = "Argentina" },
                new SelectListItem() { Value = "Bolivia", Text = "Bolivia" },
                new SelectListItem() { Value = "Brasil", Text = "Brasil" },
                new SelectListItem() { Value = "Chile", Text = "Chile" },
                new SelectListItem() { Value = "Colômbia", Text = "Colômbia" },
                new SelectListItem() { Value = "Equador", Text = "Equador" },
                new SelectListItem() { Value = "Guiana", Text = "Guiana" },
                new SelectListItem() { Value = "Guiana Francesa", Text = "Guiana Francesa" },
                new SelectListItem() { Value = "Paraguai", Text = "Paraguai" },
                new SelectListItem() { Value = "Peru", Text = "Peru" },
                new SelectListItem() { Value = "Suriname", Text = "Suriname" },
                new SelectListItem() { Value = "Uruguai", Text = "Uruguai" },
                new SelectListItem() { Value = "Venezuela", Text = "Venezuela" },
                new SelectListItem() { Value = "Morro da Pedra", Text = "Morro da Pedra" },
            };
        }

    }
}