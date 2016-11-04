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


        protected virtual List<Personagem> lerPersonagensDoArquivoCsv()
        {
            string[] personagensComoString = File.ReadAllLines(CaminhoArquivo);
            List<Personagem> personagens = new List<Personagem>();

            foreach (string personagem in personagensComoString)
            {
                personagens.Add(new Personagem(personagem));
            }

            return personagens;
        }

        protected virtual void salvarPersonagensNoArquivoCsv(List<Personagem> personagens)
        {
            List<string> personagensComoString = new List<string>();

            foreach (Personagem personagem in personagens)
            {
                personagensComoString.Add(personagem.ToString());
            }

            File.WriteAllLines(CaminhoArquivo, personagensComoString);
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
