package pt.mago.loja;

/**
 * Items adquiridos pelos clientes
 */
public class Item {
    private int quantidade;
    private Produto produto;

    public int getQuantidade() {
        return quantidade;
    }
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
