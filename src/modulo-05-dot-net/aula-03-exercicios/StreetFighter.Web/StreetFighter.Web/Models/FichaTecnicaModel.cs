using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public string Nome { set; get; }
        public DateTime DataNascimento { set; get; }
        public int Altura { set; get; }
        public double Peso { set; get; }
        public string Origem { set; get; }
    }
}