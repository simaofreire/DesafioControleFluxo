public class Contador {
  public static void main(String[] args) throws ParametrosInvalidosException {
    RegrasDeNegocio contador = new RegrasDeNegocio();

    contador.obterParametros();
    contador.contar();
    contador.realizarNovaOperacao();
  }
}
