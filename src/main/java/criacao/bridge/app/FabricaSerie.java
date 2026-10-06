package criacao.bridge.app;

public class FabricaSerie implements IFabricaAbstrata {
    @Override
    public ITipoObra criarTipoObra() {
        return new Serie();
    }

    @Override
    public IEncontro criarEncontro() {
        return new EncontroSerie();
    }

}