using StreetFighter.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioEF : IPersonagemRepositorio
    {
        public Personagem BuscarPersonagemPorId(int id)
        {
            using (var contexto = new DatabaseContext())
            {
                Personagem personagem = contexto.Personagem.Find(id);
                return personagem;
            }
        }

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            using (var contexto = new DatabaseContext())
            {
                List<Personagem> personagens = contexto.Personagem.Where(personagem => personagem.Nome.Contains(filtroNome)).ToList();
                return personagens;
            }
        }
    }
}
