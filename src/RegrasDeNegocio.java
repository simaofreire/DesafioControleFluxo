import java.util.Scanner;

public class RegrasDeNegocio {
    private int parametroUm;
    private int parametroDois;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to enter two parameters and stores them in the `parametroUm` and `parametroDois` fields.
     * Handles exceptions if the user enters invalid input.
     */
    public void obterParametros() {
        try {
            if (parametroUm <= 0) {
                System.out.println("Digite o primeiro parâmetro");
                parametroUm = Integer.parseInt(scanner.nextLine());
            }

            if (parametroDois <= 0) {
                System.out.println("Digite o segundo parâmetro");
                parametroDois = Integer.parseInt(scanner.nextLine());
            }

        } catch (NumberFormatException e) {
            System.out.println("Digite apenas números inteiros");
            obterParametros();
        }
    }

    /**
     * Performs a counting operation based on the values of `parametroUm` and `parametroDois`.
     * Throws a `ParametrosInvalidosException` if `parametroUm` is greater than `parametroDois`.
     *
     * @throws ParametrosInvalidosException if `parametroUm` is greater than `parametroDois`
     */
    public void contar() throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contador = parametroDois - parametroUm;

        for (int i = 1; i <= contador; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }

    /**
     * Asks the user if they want to perform a new operation.
     * If the user answers "S" (case-insensitive), it resets the parameters, calls `obterParametros()`,
     * `contar()`, and recursively calls itself.
     * If the user answers anything other than "S", it prints a farewell message.
     *
     * @throws ParametrosInvalidosException if `parametroUm` is greater than `parametroDois`
     */
    public void realizarNovaOperacao() throws ParametrosInvalidosException {
        System.out.println("Deseja realizar uma nova operação? (S/N)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            parametroUm = 0;
            parametroDois = 0;
            obterParametros();
            contar();
            realizarNovaOperacao();
        } else {
            System.out.println("Obrigado por utilizar o programa\nFIM");
        }
    }
}