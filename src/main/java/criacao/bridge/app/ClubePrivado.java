package criacao.bridge.app;

import java.util.ArrayList;
import java.util.List;

public class ClubePrivado extends Clube {

    private List<String> pedidosPendentes = new ArrayList<>();

    public ClubePrivado(String nome, IFabricaAbstrata fabrica) {
        super(nome, fabrica);
    }

    public List<String> getPedidosPendentes() {
        return this.pedidosPendentes;
    }

    public String entrar(String usuario) {
        verificarSeNaoEMembro(usuario);
        if (this.pedidosPendentes.contains(usuario)) {
            throw new IllegalArgumentException("Usuário " + usuario + " já possui pedido pendente.");
        }
        this.pedidosPendentes.add(usuario);
        return "Pedido enviado ao clube " + this.nome + " (" + this.tipoObra.nomeDoItem() + "). "
                + "Após a aprovação do admin, a discussão é por " + this.tipoObra.nomeDaUnidade() + ".";
    }

    public void aprovar(String usuario) {
        if (!this.pedidosPendentes.remove(usuario)) {
            throw new IllegalArgumentException("Usuário " + usuario + " não possui pedido pendente.");
        }
        this.membros.add(usuario);
    }
}
