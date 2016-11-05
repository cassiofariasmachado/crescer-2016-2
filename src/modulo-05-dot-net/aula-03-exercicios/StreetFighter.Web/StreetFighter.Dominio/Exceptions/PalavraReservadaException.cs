namespace StreetFighter.Dominio.Exceptions
{
    public class PalavraReservadaException : RegraDeNegocioException
    {
        public PalavraReservadaException(string mensagem): base(mensagem)
        { }
    }
}