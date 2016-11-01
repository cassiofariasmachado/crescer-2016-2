using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class SobreModel
    {
        public string Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public int Altura { get; set; }
        public double Peso { get; set; }
        public TipoSanguineo TipoSanguineo { get; set; }
        public string HabilidadesEspeciais { get; set; }
        public string Gosta { get; set; }
        public string Desgosta { get; set; }
        public string FalaDeVitoria { get; set; }
        public string Nacionalidade { get; set; }
        public string Naturalidade { get; set; }
    }
}