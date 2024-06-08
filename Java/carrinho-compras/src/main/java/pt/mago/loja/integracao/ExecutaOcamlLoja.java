package pt.mago.loja.integracao;

import pt.mago.loja.Cart;

/**
 * Executa o código Ocaml da loja usando a classe de integração
 * mais genérica
 */
public class ExecutaOcamlLoja {
    static String executable = "./precos.exe";

    public void teste() {
        String result = ExecutaOcaml.execute(executable, "show", "");
        System.out.println("Calculos executados : " + result);
    }

    public int precoTotal(Cart cart) {
        String result = ExecutaOcaml.execute(executable, "preco_total", cart);
        int preco = Integer.parseInt(result);
        return preco;
    }

    public int descontosCategoria(Cart cart) {
        String result = ExecutaOcaml.execute(executable, "descontos_categoria", cart);
        int preco = Integer.parseInt(result);
        return preco;
    }

    public int descontosLealdade(Cart cart) {
        String result = ExecutaOcaml.execute(executable, "descontos_lealdade", cart);
        int preco = Integer.parseInt(result);
        return preco;
    }

    public int custosEnvio(Cart cart) {
        String result = ExecutaOcaml.execute(executable, "custos_envio", cart);
        int custosEnvio = Integer.parseInt(result);
        return custosEnvio;
    }

    public int precoFinal(Cart cart) {
        String result = ExecutaOcaml.execute(executable, "preco_final", cart);
        int custosEnvio = Integer.parseInt(result);
        return custosEnvio;
    }

    public void mostraCarrinho(Cart cart) {
        String result = ExecutaOcaml.execute(executable, "mostra_carrinho", cart);
        System.out.println("Carrinho de compras : " + result);
    }



}
