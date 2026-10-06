package criacao.bridge.app;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AbstractFactoryTest {

    static Stream<Arguments> familias() {
        return Stream.of(
                Arguments.of(new FabricaLivro(), Livro.class, EncontroLivro.class),
                Arguments.of(new FabricaFilme(), Filme.class, EncontroFilme.class),
                Arguments.of(new FabricaSerie(), Serie.class, EncontroSerie.class));
    }

    @ParameterizedTest
    @MethodSource("familias")
    void fabricaCriaProdutosDaMesmaFamilia(IFabricaAbstrata fabrica, Class<?> tipoObraEsperado,
            Class<?> encontroEsperado) {
        assertInstanceOf(tipoObraEsperado, fabrica.criarTipoObra());
        assertInstanceOf(encontroEsperado, fabrica.criarEncontro());
    }
}
