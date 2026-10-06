package criacao.bridge.app;

public class Livro implements ITipoObra {

    public String nomeDoItem() {
        return "livro";
    }

    public String nomeDaUnidade() {
        return "capítulo";
    }
}
