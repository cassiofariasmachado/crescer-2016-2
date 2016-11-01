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
            fichaTecnica.Nome = "Blanka";
            fichaTecnica.PrimeiraAparicao = "Street Fighter II The World Warrior(1991)";
            fichaTecnica.DataNascimento = DateTime.Parse("12/02/1966", new CultureInfo("pt-BR"));
            fichaTecnica.Altura = 192;
            fichaTecnica.Peso = 96;
            fichaTecnica.MedidaBusto = 198;
            fichaTecnica.MedidaCintura = 120;
            fichaTecnica.MedidaQuadril = 172;
            fichaTecnica.TipoSanguineo = TipoSanguineo.B;
            fichaTecnica.HabilidadesEspeciais = "Caçar, Eletricidade.";
            fichaTecnica.Gosta = "Frutas tropicais, Pirarucu, Sua mãe.";
            fichaTecnica.Desgosta = "Army ants(espécie de formiga).";
            fichaTecnica.EstiloDeLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira.";
            fichaTecnica.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
            fichaTecnica.FalaDeVitoria = "\"Ver você em ação é uma piada!\"";
            fichaTecnica.NickNameDoSSF2 = "\"A selvagem criança da natureza.\"";
            fichaTecnica.NickNameDoSFA3 = "\"A animal pessoa amazônica.\"";
            fichaTecnica.NickNameDoSF4 = "\"Guerreiro da selva.\"";
            fichaTecnica.StageDoSFA3 = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins ?).";
            fichaTecnica.StageDoSF2 = "Bacia do rio Amazonas (Brasil).";
            fichaTecnica.GolpesEspeciaisFamosos = "Electric Thunder, Rolling Attack.";
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


    }
}