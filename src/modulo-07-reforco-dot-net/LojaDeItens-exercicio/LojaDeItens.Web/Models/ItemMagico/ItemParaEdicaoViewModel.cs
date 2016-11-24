using LojaDeItens.Dominio.ItemMagico;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaDeItens.Web.Models.ItemMagico
{
    public class ItemParaEdicaoViewModel
    {
        public int? Id { get; set; }

        [Required]
        [StringLength(50)]
        public string Nome { get; set; }

        [Required]
        [StringLength(100)]
        public string Descricao { get; set; }

        [Required]
        public decimal Preco { get; set; }

        [Required]
        public int Estoque { get; set; }

        public bool Raro { get; set; }

        public ItemParaEdicaoViewModel() { }

        public ItemParaEdicaoViewModel(ItemMagicoEntidade item)
        {
            this.Id = item.Id;
            this.Nome = item.Nome;
            this.Descricao = item.Descricao;
            this.Preco = item.Preco;
            this.Estoque = item.Estoque;
            this.Raro = item.Raro;
        }

        public ItemMagicoEntidade ConverterParaItemMagicoEntidade()
        {
            return new ItemMagicoEntidade()
            {
                Id = this.Id.HasValue ? this.Id.Value : 0,
                Nome = this.Nome,
                Descricao = this.Descricao,
                Preco = this.Preco,
                Estoque = this.Estoque,
                Raro = this.Raro
            };
        }
    }
}