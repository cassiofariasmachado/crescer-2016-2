using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        const string CaminhoArquivo = @"C:\Users\Cassio\Documents\git\crescer-2016-2\src\modulo-05-dot-net\aula-03-exercicios\StreetFighter.Web\StreetFighter.Repositorio\repositorio-personagem.csv";
        public IList<Personagem> Personagens { get; }

        public PersonagemRepositorio() : this(File.ReadAllLines(CaminhoArquivo).ToList())
        { }

        public PersonagemRepositorio(IList<string> personagens)
        {
            this.Personagens = new List<Personagem>();

            foreach (string personagemComoString in personagens)
            {
                Personagens.Add(new Personagem(personagemComoString));
            }
        }

        public List<Personagem> ListarPersonagens (string filtroNome)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem (Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void EditarPersonagem (Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }
    }
}
