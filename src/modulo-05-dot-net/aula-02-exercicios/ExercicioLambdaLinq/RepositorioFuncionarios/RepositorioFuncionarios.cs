﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return this.Funcionarios.Where(funcionario => funcionario.Cargo.Equals(cargo)).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return this.Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo)
                                    .ThenBy(funcionario => funcionario.Nome)
                                    .ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return this.Funcionarios.Where(funcionario => new Regex(nome, RegexOptions.IgnoreCase | RegexOptions.CultureInvariant)
                                                          .IsMatch(funcionario.Nome))
                                    .ToList();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            return this.Funcionarios.Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho))
                                    .ToList();
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            return this.Funcionarios.Where(funcionario =>
            {
                int idadeDoFuncionario = CalcularIdade(funcionario.DataNascimento);
                return idadeDoFuncionario >= idade - 5 && idadeDoFuncionario <= idade + 5;
            })
                                    .ToList();
        }

        private int CalcularIdade(DateTime dataNascimento)
        {
            int anos = DateTime.Now.Year - dataNascimento.Year;
            bool mesMenor = DateTime.Now.Month < dataNascimento.Month;
            bool mesIgualEDiaMenor = DateTime.Now.Month == dataNascimento.Month && DateTime.Now.Day < dataNascimento.Day;

            if (mesMenor || mesIgualEDiaMenor)
            {
                anos--;
            }
            return anos;
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            bool turnoEhNulo = turno == null;
            var funcionariosPorTurno = this.Funcionarios.Where(funcionario => turnoEhNulo || funcionario.TurnoTrabalho.Equals(turno)).ToList();
            return funcionariosPorTurno.Sum(funcionario => funcionario.Cargo.Salario) / funcionariosPorTurno.Count;
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var mesAtual = DateTime.Now.Month;
            return this.Funcionarios.Where(funcionario => funcionario.DataNascimento.Month.Equals(mesAtual)).ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            return this.Funcionarios.Select(funcionario => new
            {
                NomeFuncionario = funcionario.Nome,
                TituloCargo = funcionario.Cargo.Titulo
            })
                                    .ToList<dynamic>();
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            return this.Funcionarios.GroupBy(funcionario => funcionario.TurnoTrabalho)
                                    .Select(grupo => new
                                    {
                                        Turno = grupo.Key,
                                        Quantidade = grupo.Count()
                                    })
                                    .ToList<dynamic>();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            return this.Funcionarios.Where(funcionario => !funcionario.Cargo.Titulo.Equals("Desenvolvedor Júnior") && !funcionario.TurnoTrabalho.Equals(TurnoTrabalho.Tarde))
                                    .OrderBy(funcionario => GetQuantidadeDeConsoantes(funcionario.Nome))
                                    .Select(funcionario => new
                                    {
                                        Nome = funcionario.Nome,
                                        //DataNascimento(data denascimento do funcionário no formato "25/01/2016")
                                        DataNascimento = funcionario.DataNascimento.ToLocalTime().ToString()
                                        //SalarioRS(salário do funcionário no formato brasileiro, exemplo: "R$ 999,99")
                                        //SalarioUS(salário do funcionário no formato americano, exemplo: ""$999.99")
                                        //QuantidadeMesmoCargo(quantidade de funcionários que estão no mesmo cargo que ele)
                                    }
                                    );
        }

        private int GetQuantidadeDeConsoantes(string palavra)
        {
            int quantidadeConsoantes = 0;
            var regexDeConsoantes = new Regex("bcdfghjklmnpqrstvwxyz", RegexOptions.IgnoreCase | RegexOptions.CultureInvariant);
            foreach (char letra in palavra)
            {
                bool ehConsoante = regexDeConsoantes.IsMatch(letra.ToString());
                if (ehConsoante)
                    quantidadeConsoantes++;
            }
            return quantidadeConsoantes;
        }
    }
}
