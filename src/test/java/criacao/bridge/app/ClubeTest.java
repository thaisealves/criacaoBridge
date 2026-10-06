package criacao.bridge.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ClubeTest {

    @Test
    void deveFuncionarNoFluxoCompletoDoMetodoFabricaAoClube() {
        IFabricaAbstrata fabrica = MetodoFabrica.getInstancia().criarFabrica("Livro");
        Clube clube = new ClubePublico("Leitores de Duna", fabrica);

        assertEquals("Você entrou no clube Leitores de Duna (livro). A discussão é por capítulo.", clube.entrar("Ana"));
        assertEquals("Encontro de Livros: escolhendo dia", clube.escolherEncontro());
    }

    @Test
    void deveMudarMensagemDeEntradaEEncontroAoTrocarFabrica() {
        Clube clube = new ClubePublico("Leitores de Duna", new FabricaLivro());

        clube.setFabrica(new FabricaFilme());

        assertEquals("Você entrou no clube Leitores de Duna (filme). A discussão é por Lore.", clube.entrar("Ana"));
        assertEquals("Encontro de Filmes: escolhendo dia", clube.escolherEncontro());
    }

    @Test
    void deveLancarExcecaoAoCriarClubeComFabricaNula() {
        assertThrows(NullPointerException.class, () -> new ClubePublico("Leitores de Duna", null));
        assertThrows(NullPointerException.class, () -> new ClubePrivado("Leitores de Duna", null));
    }

    @Test
    void deveLancarExcecaoAoTrocarParaFabricaNulaSemAlterarOClube() {
        Clube clube = new ClubePublico("Leitores de Duna", new FabricaLivro());

        assertThrows(NullPointerException.class, () -> clube.setFabrica(null));
        assertEquals("Encontro de Livros: escolhendo dia", clube.escolherEncontro());
    }
}
