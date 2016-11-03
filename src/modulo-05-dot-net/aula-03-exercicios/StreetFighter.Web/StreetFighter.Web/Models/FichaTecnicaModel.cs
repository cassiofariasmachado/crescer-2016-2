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
        [DisplayName("Url da imagem")]
        public string UrlDaImagem { get; set; }

        [Required(ErrorMessage = "O campo nome do personagem é obrigatório.")]
        [DisplayName("Nome do personagem")]
        public string Nome { set; get; }

        [Required(ErrorMessage = "O campo data de nascimento é obrigatório.")]
        [DisplayName("Data de nascimento")]
        public DateTime DataNascimento { set; get; }

        [Required(ErrorMessage = "O campo altura é obrigatório.")]
        public int Altura { set; get; }

        [Required(ErrorMessage = "O campo peso é obrigatório.")]
        public double Peso { set; get; }

        [Required(ErrorMessage = "O campo origem é obrigatório.")]
        public string Origem { set; get; }

        [Required(ErrorMessage = "O campo golpes especiais é obrigatório.")]
        [DisplayName("Golpes especiais")]
        public string GolpesEspeciais { set; get; }

        [DisplayName("É um personagem oculto?")]
        public bool PersonagemOculto { set; get; }
    }
}