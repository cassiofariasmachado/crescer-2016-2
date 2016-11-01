using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public string Nome { set; get; }
        public string PrimeiraAparicao { set; get; }
        public DateTime DataNascimento { set; get; }
        public int Altura { set; get; }
        public double Peso { set; get; }
        public int MedidaBusto { set; get; }
        public int MedidaCintura { set; get; }
        public int MedidaQuadril { set; get; }
        public TipoSanguineo TipoSanguineo { set; get; }
        public string HabilidadesEspeciais { set; get; }
        public string Gosta { set; get; }
        public string Desgosta { set; get; }
        public string EstiloDeLuta { set; get; }
        public string Origem { set; get; }
        public string FalaDeVitoria { set; get; }
        public string NickNameDoSSF2 { set; get; }
        public string NickNameDoSFA3 { set; get; }
        public string NickNameDoSF4 { set; get; }
        public string StageDoSFA3 { set; get; }
        public string StageDoSF2 { set; get; }
        public string GolpesEspeciaisFamosos { set; get; }
    }
}