using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Corredor
    {
        public Corredor(string nome, NivelDeHabilidade nivelDeHabilidade)
        {
            this.Nome = nome;
            this.NivelDeHabilidade = nivelDeHabilidade;
        }

        public string Nome { get; private set; }

        public NivelDeHabilidade NivelDeHabilidade { get; set; }

    }
}
