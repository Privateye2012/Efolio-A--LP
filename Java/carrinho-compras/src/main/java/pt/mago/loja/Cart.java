package pt.mago.loja;

import java.util.ArrayList;

/**
 * Definições do Carrinho de Compras que os clientes
 * irão usar para ir fazendo as suas compras no site
 */
public class Cart {
  private ArrayList<Item> items;

  public void addItem(Item item) {
    items.add(item);
  }

  /**
   * Obtem a lista de items do carrinho sob a forma de string
   * que pode ser passada ao código Ocaml
   */
  public String getItemListAsString() {
    String result = "";
    for (Item item : items) {
      result += item.getProduto().getId() + ";" +
        item.getProduto().getNome() + ";" + item.getQuantidade() + ",";
    }
    return result;
  }
}
