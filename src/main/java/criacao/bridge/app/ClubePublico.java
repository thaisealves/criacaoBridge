package criacao.bridge.app;

public class ClubePublico extends Clube {

    public ClubePublico(String nome, IFabricaAbstrata fabrica) {
        super(nome, fabrica);
    }

    public String entrar(String usuario) {
        verificarSeNaoEMembro(usuario);
        this.membros.add(usuario);
        return "Você entrou no clube " + this.nome + " (" + this.tipoObra.nomeDoItem() + "). "
                + "A discussão é por " + this.tipoObra.nomeDaUnidade() + ".";
    }
}
