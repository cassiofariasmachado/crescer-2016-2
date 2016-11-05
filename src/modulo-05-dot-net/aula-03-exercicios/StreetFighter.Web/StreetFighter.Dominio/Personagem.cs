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
            this.Nome = nome;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
            this.UrlDaImagem = urlDaImagem;
        }

        public Personagem(string personagemComoString) 
        {
            string[] atributos = personagemComoString.Split(';');

            this.Id = Convert.ToInt32(atributos[0]);
            this.Nome = atributos[1];
            this.DataNascimento = Convert.ToDateTime(atributos[2]);
            this.Altura = Convert.ToInt32(atributos[3]);
            this.Peso = Convert.ToDouble(atributos[4]);
            this.Origem = atributos[5];
            this.GolpesEspeciais = atributos[6];
            this.UrlDaImagem = atributos[7];
            this.PersonagemOculto = Convert.ToBoolean(atributos[8]);
        }

        public override string ToString()
        {
            return $"{Id};{Nome};{DataNascimento.ToString("dd/MM/yyyy")};{Altura};{Peso};{Origem};{GolpesEspeciais};{UrlDaImagem};{PersonagemOculto}";
        }
    }
}
