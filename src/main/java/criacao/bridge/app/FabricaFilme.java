package criacao.bridge.app;

public class FabricaFilme implements IFabricaAbstrata {
    @Override
    public ITipoObra criarTipoObra() {
        return new Filme();
    }

    @Override
    public IEncontro criarEncontro() {
        return new EncontroFilme();
    }
}