package criacao.bridge.app;

public class MetodoFabrica {

    private MetodoFabrica() {
    }

    private static MetodoFabrica instancia = new MetodoFabrica();

    public static MetodoFabrica getInstancia() {
        return instancia;
    }

    public IFabricaAbstrata criarFabrica(String tipo) {

        Class<?> classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("criacao.bridge.app.Fabrica" + tipo);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de fabrica não encontrado");
        }
        if (!(objeto instanceof IFabricaAbstrata)) {
            throw new IllegalArgumentException("Classe não implementa IFabricaAbstrata");
        }
        return (IFabricaAbstrata) objeto;
    }
}
