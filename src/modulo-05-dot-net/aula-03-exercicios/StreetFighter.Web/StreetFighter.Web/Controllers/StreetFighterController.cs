﻿using StreetFighter.Web.Models;
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
            fichaTecnica.DataNascimento = DateTime.Parse("12/02/1966", new CultureInfo("pt-BR"));
            fichaTecnica.Altura = 192;
            fichaTecnica.Peso = 96;
            fichaTecnica.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
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