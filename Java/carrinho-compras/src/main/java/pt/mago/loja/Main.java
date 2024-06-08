package pt.mago.loja;

import pt.mago.loja.integracao.ExecutaOcamlLoja;

/**
 * Hello world!
 *
 */
public class Main
{
    private Cart createTestCart() {
        Cart cart = new Cart();
        Produto p1 = new Produto();
        p1.setId(1);
        p1.setNome("Produto 1");
        p1.setPreco(10.0);
        Produto p2 = new Produto();
        p2.setId(2);
        p2.setNome("Produto 2");
        p2.setPreco(20.0);
        Item i1 = new Item();
        i1.setProduto(p1);
        i1.setQuantidade(2);
        Item i2 = new Item();
        i2.setProduto(p2);
        i2.setQuantidade(1);
        cart.addItem(i1);
        cart.addItem(i2);
        return cart;
    }

    public static void main( String[] args )
    {
        Main m = new Main();
        System.out.println( "Going to execute something" );
        Cart cart = m.createTestCart();
        ExecutaOcamlLoja executaOcamlLoja = new ExecutaOcamlLoja();
        executaOcamlLoja.precoTotal(cart);
        // executaOcamlLoja.teste();
    }
}
