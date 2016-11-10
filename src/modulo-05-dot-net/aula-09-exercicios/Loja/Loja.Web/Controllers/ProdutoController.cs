using Loja.Dominio;
using Loja.Dominio.Exceptions;
using Loja.Web.Filters;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    [LojaAutorizador]
    public class ProdutoController : Controller
    {
        public ActionResult ListaDeProdutos()
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            IList<Produto> produtos = produtoServico.ListarProdutos();
            IList<ProdutoModel> produtosModel = new List<ProdutoModel>();

            foreach(var produto in produtos)
            {
                produtosModel.Add(produto.ConverterParaModel());
            }

            ListaDeProdutosModel model = new ListaDeProdutosModel(produtosModel);

            return View(model);
        }

        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
                ProdutoModel model = produtoServico.BuscarProdutoPorId(id.Value).ConverterParaModel();
                return View(model);
            }
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(ProdutoModel model)
        {
            if(ModelState.IsValid)
            {
                try
                {
                    ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
                    Produto produto = model.ConverterParaProduto();

                    if (model.Id.HasValue)
                        TempData["Mensagem"] = "Produto editado com sucesso.";
                    else
                        TempData["Mensagem"] = "Produto cadatrado com sucesso.";

                    produtoServico.Salvar(produto);

                    return RedirectToAction("ListaDeProdutos");
                }
                catch (ProdutoException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro. Tente novamente ou entre em contato com o administrador.");
            }

            return View("Manter", model);
        }

        public ActionResult Excluir(int id)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            Produto produto = produtoServico.BuscarProdutoPorId(id);
            produtoServico.Excluir(produto);

            TempData["Mensagem"] = "Produto excluído com sucesso.";
            return RedirectToAction("ListaDeProdutos");
        }

        public ActionResult Editar(int id)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();

            return RedirectToAction("Manter", id);
        }

    }
}