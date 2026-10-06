package criacao.bridge.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    void getInstanciaSempreRetornaAMesmaReferenciaNaoNula() {
        MetodoFabrica instancia1 = MetodoFabrica.getInstancia();
        MetodoFabrica instancia2 = MetodoFabrica.getInstancia();

        assertNotNull(instancia1);
        assertSame(instancia1, instancia2);
    }
}
