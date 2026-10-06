package criacao.bridge.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Clube {

    protected ITipoObra tipoObra;

    protected IEncontro encontro;

    protected String nome;

    protected List<String> membros = new ArrayList<>();

    public Clube(String nome, IFabricaAbstrata fabrica) {
        this.nome = nome;
        setFabrica(fabrica);
    }

    // trocando pra fábrica tomar conta e continuar consistente
    public void setFabrica(IFabricaAbstrata fabrica) {
        Objects.requireNonNull(fabrica, "O clube precisa de uma fábrica.");
        this.tipoObra = fabrica.criarTipoObra();
        this.encontro = fabrica.criarEncontro();
    }

    public String escolherEncontro() {
        return this.encontro.escolherEncontro();
    }

    public List<String> getMembros() {
        return this.membros;
    }

    protected void verificarSeNaoEMembro(String usuario) {
        if (this.membros.contains(usuario)) {
            throw new IllegalArgumentException("Usuário " + usuario + " já é membro do clube.");
        }
    }

    public abstract String entrar(String usuario);
}
