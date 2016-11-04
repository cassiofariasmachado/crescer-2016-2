using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Repositorio
{
    public class PersonagemRepositorioMock : PersonagemRepositorio
    {
        private List<Personagem> personagens = new List<Personagem> {
                                                                        new Personagem(1,"Chun-li",new DateTime(2012,12,12),170,59,"China","Spining Bird Kick, Kikouken.",@"http://www.streetfighter.com.br/upload/editor/20120623181304_27.gif",true),
                                                                        new Personagem(2,"Akuma",new DateTime(1992,01,13),178,80,"Japão","Gouhadouken, Goushoryuken.",@"http://www.streetfighter.com.br/upload/editor/20131018003126_319.png",true)
                                                                    };

        protected override List<Personagem> lePersonagensDoArquivoCsv()
        {
            return this.personagens;
        }

        protected override void salvaPersonagensNoArquivoCsv(List<Personagem> personagens)
        {
            this.personagens = personagens;
        }
    }
}
