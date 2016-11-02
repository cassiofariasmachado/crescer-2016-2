using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        [Required(ErrorMessage = "O campo url da imagem é obrigatório.")]
        [DisplayName("Url da imagem")]
        public string UrlDaImagem { get; set; }

        [Required(ErrorMessage = "O campo nome do personagem é obrigatório.")]
        [DisplayName("Nome do personagem")]
        public string Nome { set; get; }

        [Required(ErrorMessage = "O campo data de nascimento é obrigatório.")]
        [DisplayName("Data de nascimento")]
        public DateTime DataNascimento { set; get; }

        [Required(ErrorMessage = "O campo altura é obrigatório.")]
        [Range(1, 300, ErrorMessage = "Deve ser um número entre 1 e 300 centímetros.")]
        public int Altura { set; get; }

        [Required(ErrorMessage = "O campo peso é obrigatório.")]
        [Range(1, 500, ErrorMessage = "Deve ser um número entre 1.00 e 500.00 kilogramas.")]
        public double Peso { set; get; }

        [Required(ErrorMessage = "O campo origem é obrigatório.")]
        public string Origem { set; get; }

        [Required(ErrorMessage = "O campo golpes especiais é obrigatório.")]
        [DisplayName("Golpes especiais")]
        public string GolpesEspeciais { set; get; }

        [Required(ErrorMessage = "O campo personagem oculto é obrigatório.")]
        [DisplayName("É um personagem oculto?")]
        public bool PersonagemOculto { set; get; }
    }
}