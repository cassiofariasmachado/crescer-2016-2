using System;

namespace StreetFighter.Dominio.Exceptions
{
    public class RegraDeNegocioException : Exception
    {
        public RegraDeNegocioException(string mensagem) : base(mensagem)
        { }
    }
}