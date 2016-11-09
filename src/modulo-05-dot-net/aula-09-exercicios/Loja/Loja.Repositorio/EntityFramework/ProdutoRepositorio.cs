using Loja.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Loja.Dominio;
using System.Data.Entity;

namespace Loja.Repositorio.EntityFramework
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public Produto BuscarProdutoPorId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.Find(id);
            }
        }

        public IList<Produto> ListarProdutos()
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.Take(15).ToList();
            }
        }

        public void IncluirProduto(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public void EditarProduto(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public void ExcluirProduto(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Deleted;
                context.SaveChanges();
            }
        }
    }
}
