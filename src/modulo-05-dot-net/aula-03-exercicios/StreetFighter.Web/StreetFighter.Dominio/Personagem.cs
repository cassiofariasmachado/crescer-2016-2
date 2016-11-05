using StreetFighter.Dominio.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; set; }

        public string Nome { get; private set; }

        public DateTime DataNascimento { get; private set; }

        public int? Altura { get; private set; }

        public double? Peso { get; private set; }

        public string Origem { get; private set; }
  
        public string GolpesEspeciais { get; private set; }

        public bool PersonagemOculto { get; private set; }
        public string UrlDaImagem { get; private set; }

        public Personagem( int id, 
                           string nome,
                           DateTime dataNascimento,
                           int altura,
                           double peso,
                           string origem,
                           string golpesEspeciais,
                           string urlDaImagem = "Não informado",
                           bool personagemOculto = false)
            :this(nome, dataNascimento, altura, peso, origem, golpesEspeciais, urlDaImagem, personagemOculto)
        {
            this.Id = id;
        }

        public Personagem( string nome, 
                           DateTime dataNascimento,
                           int? altura, 
                           double? peso,
                           string origem,
                           string golpesEspeciais,
                           string urlDaImagem = "Não informado",
                           bool personagemOculto = false )
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new PalavraReservadaException("Não é permitido cadastrar personagens overpowered.");
            if (origem.ToUpperInvariant().Contains("MORRO DA PEDRA"))
                throw new LocalDeOrigemException($"Somente um personagem pode ser dessa região e esse personagem não é o {nome}.");

            this.Nome = nome;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
            this.UrlDaImagem = urlDaImagem;
        }

        public Personagem(string[] atributos) : 
            this( Convert.ToInt32(atributos[0]),
                  atributos[1],
                  Convert.ToDateTime(atributos[2]),
                  Convert.ToInt32(atributos[3]),
                  Convert.ToDouble(atributos[4]),
                  atributos[5],
                  atributos[6],
                  atributos[7],
                  Convert.ToBoolean(atributos[8])) 
        { }

        public override string ToString()
        {
            return $"{Id};{Nome};{DataNascimento.ToString("dd/MM/yyyy")};{Altura};{Peso};{Origem};{GolpesEspeciais};{UrlDaImagem};{PersonagemOculto}";
        }
    }
}
