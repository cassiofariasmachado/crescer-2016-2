using Loja.Dominio.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class Produto
    {
        public int Id { get; set; }

        private string nome;
        public string Nome
        {
            get
            {
                return this.nome;
            }
            set
            {
                if (value.Count() < 3)
                    throw new NomePequenoException();
                this.nome = value;
            }
        }

        private decimal valor;
        public decimal Valor
        {
            get
            {
                return this.valor;
            }
            set
            {
                if (value == 0.0M)
                    throw new ValorZeradoException();
                this.valor = value;
            }
        }

    }
}
