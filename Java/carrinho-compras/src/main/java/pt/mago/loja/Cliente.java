package pt.mago.loja;

/**
 * Definições do Cliente
 */
public class Cliente {
    private int id;
    private String cidade;
    private String distrito;
    private int anosLealdade;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getAnosLealdade() {
        return anosLealdade;
    }

    public void setAnosLealdade(int anosLealdade) {
        this.anosLealdade = anosLealdade;
    }
    
}
