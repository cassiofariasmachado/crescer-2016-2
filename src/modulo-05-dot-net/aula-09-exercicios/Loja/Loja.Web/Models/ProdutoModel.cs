using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public int? Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public decimal Valor { get; set; }

        public Produto ConverterParaProduto()
        {
            return new Produto()
            {
                Id = this.Id.HasValue ? Id.Value : 0,
                Nome = this.Nome,
                Valor = this.Valor

            };
        }
    }

    public static class ProdutoModelExtensions
    {
        public static ProdutoModel ConverterParaModel(this Produto produto)
        {
            return new ProdutoModel()
            {
                Id = produto.Id,
                Nome = produto.Nome,
                Valor = produto.Valor
            };
        }
    }
}