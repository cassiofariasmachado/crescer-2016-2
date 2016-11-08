using StreetFighter.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;
using System.Data.Entity;

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
            using (var contexto = new DatabaseContext())
            {
                contexto.Entry<Personagem>(personagem).State = EntityState.Modified;
                contexto.SaveChanges();
            }
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            using (var contexto = new DatabaseContext())
            {
                contexto.Entry<Personagem>(personagem).State = EntityState.Deleted;
                contexto.SaveChanges();
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            using (var contexto = new DatabaseContext())
            {
                contexto.Entry<Personagem>(personagem).State = EntityState.Added;
                contexto.SaveChanges();
            }
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
