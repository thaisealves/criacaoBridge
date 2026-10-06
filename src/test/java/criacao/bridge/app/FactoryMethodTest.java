package criacao.bridge.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class FactoryMethodTest {

    static Stream<Arguments> tiposValidos() {
        return Stream.of(
                Arguments.of("Livro", FabricaLivro.class),
                Arguments.of("Filme", FabricaFilme.class),
                Arguments.of("Serie", FabricaSerie.class));
    }

    @ParameterizedTest
    @MethodSource("tiposValidos")
    void criarFabricaComTipoValidoRetornaFabricaCorrespondente(String tipo, Class<?> classeEsperada) {
        IFabricaAbstrata fabrica = MetodoFabrica.getInstancia().criarFabrica(tipo);

        assertInstanceOf(classeEsperada, fabrica);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "Musica", "livro" })
    void criarFabricaComTipoInexistenteLancaExcecao(String tipo) {
        assertThrows(IllegalArgumentException.class,
                () -> MetodoFabrica.getInstancia().criarFabrica(tipo));
    }

    @Test
    void criarFabricaDeClasseQueNaoImplementaInterfaceLancaExcecao() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> MetodoFabrica.getInstancia().criarFabrica("Invalida"));

        assertEquals("Classe não implementa IFabricaAbstrata", excecao.getMessage());
    }
}

// Classe auxiliar: existe como "Fabrica" + tipo, mas não implementa IFabricaAbstrata
class FabricaInvalida {
}
