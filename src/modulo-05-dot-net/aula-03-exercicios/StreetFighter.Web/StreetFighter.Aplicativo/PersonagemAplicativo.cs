﻿using StreetFighter.Dominio;
using StreetFighter.Dominio.Interfaces;
using StreetFighter.Repositorio;
using StreetFighter.Repositorio.EntityFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo() : this(new PersonagemRepositorioEF()) { }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public List<Personagem> ListaPersonagens(string filtroNome = null)
        {
            return repositorio.ListarPersonagens(filtroNome);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.IncluirPersonagem(personagem);
            else
                repositorio.EditarPersonagem(personagem);
        }

        public Personagem BuscarPersonagemPorId(int id)
        {
            return repositorio.BuscarPersonagemPorId(id);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            repositorio.ExcluirPersonagem(personagem);
        }
    }
}
