using StreetFighter.Dominio;
using StreetFighter.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio.ArquivoCSV
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        const string CaminhoArquivo = @"C:\Users\Cassio\Documents\git\crescer-2016-2\src\modulo-05-dot-net\aula-03-exercicios\StreetFighter.Web\BaseArquivosCsv\personagem.csv";

        protected virtual List<Personagem> lerPersonagensDoArquivoCsv()
        {
            string[] personagensComoString = File.ReadAllLines(CaminhoArquivo);
            List<Personagem> personagens = new List<Personagem>();

            foreach (string personagem in personagensComoString)
            {
                personagens.Add(new Personagem(personagem.Split(';')));
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

        private int gerarProximoId(List<Personagem> personagens)
        {
            int maiorId = 0;
            foreach (var personagem in personagens)
            {
                if (personagem.Id > maiorId)
                    maiorId = (int)personagem.Id;
            }
            return maiorId + 1;
        }

        public List<Personagem> ListarPersonagens (string filtroNome = null)
        {
            List<Personagem> personagens = this.lerPersonagensDoArquivoCsv();

            if (String.IsNullOrEmpty(filtroNome))
                return personagens;

            return personagens.Where(personagem => personagem.Nome.ToUpperInvariant().Contains(filtroNome.ToUpperInvariant()))
                              .ToList();
        }

        public void IncluirPersonagem (Personagem personagem)
        {
            List<Personagem> personagens = this.lerPersonagensDoArquivoCsv();

            personagem.Id = this.gerarProximoId(personagens);

            personagens.Add(personagem);

            this.salvarPersonagensNoArquivoCsv(personagens);
        }

        public void EditarPersonagem (Personagem personagem)
        {
            List<Personagem> personagens = this.lerPersonagensDoArquivoCsv();

            for (int i = 0; i < personagens.Count; i++)
            {
                if (personagens[i].Id == personagem.Id)
                {
                    personagens.RemoveAt(i);
                    personagens.Insert(i, personagem);
                }
            }

            this.salvarPersonagensNoArquivoCsv(personagens);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            List<Personagem> personagens = this.lerPersonagensDoArquivoCsv();

            for (int i = 0; i < personagens.Count; i++)
            {
                if (personagens[i].Id == personagem.Id)
                {
                    personagens.RemoveAt(i);
                }
            }

            this.salvarPersonagensNoArquivoCsv(personagens);
        }

        public Personagem BuscarPersonagemPorId(int id)
        {
            List<Personagem> personagens = this.lerPersonagensDoArquivoCsv();

            return personagens.Find(personagem => personagem.Id == id);
        }
    }
}
