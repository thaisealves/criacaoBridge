package criacao.bridge.app;

public class FabricaLivro implements IFabricaAbstrata {
    @Override
    public ITipoObra criarTipoObra() {
        return new Livro();
    }

    @Override
    public IEncontro criarEncontro() {
        return new EncontroLivro();
    }
    
}
