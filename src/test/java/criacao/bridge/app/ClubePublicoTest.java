package criacao.bridge.app;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClubePublicoTest {

    @Test
    void deveEntrarDiretoEmClubePublicoDeLivro() {
        ClubePublico clube = new ClubePublico("Leitores de Duna", new FabricaLivro());
        assertEquals("Você entrou no clube Leitores de Duna (livro). A discussão é por capítulo.", clube.entrar("Ana"));
    }

    @Test
    void deveEntrarDiretoEmClubePublicoDeSerie() {
        ClubePublico clube = new ClubePublico("Maratona Dark", new FabricaSerie());
        assertEquals("Você entrou no clube Maratona Dark (série). A discussão é por episódio.", clube.entrar("Ana"));
    }

    @Test
    void deveEntrarDiretoEmClubePublicoDeFilme() {
        ClubePublico clube = new ClubePublico("Cine Sexta", new FabricaFilme());
        assertEquals("Você entrou no clube Cine Sexta (filme). A discussão é por Lore.", clube.entrar("Ana"));
    }

    @Test
    void deveVirarMembroUmaUnicaVezAoEntrarEmClubePublico() {
        ClubePublico clube = new ClubePublico("Cine Sexta", new FabricaFilme());
        clube.entrar("Ana");
        assertEquals(List.of("Ana"), clube.getMembros());

        assertThrows(IllegalArgumentException.class, () -> clube.entrar("Ana"));
        assertEquals(List.of("Ana"), clube.getMembros());
    }
}
