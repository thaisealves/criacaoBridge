package criacao.bridge.app;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClubePrivadoTest {

    @Test
    void deveEnviarPedidoEmClubePrivadoDeLivro() {
        ClubePrivado clube = new ClubePrivado("Leitores de Duna", new FabricaLivro());
        assertEquals("Pedido enviado ao clube Leitores de Duna (livro). Após a aprovação do admin, a discussão é por capítulo.", clube.entrar("Ana"));
    }

    @Test
    void deveEnviarPedidoEmClubePrivadoDeSerie() {
        ClubePrivado clube = new ClubePrivado("Maratona Dark", new FabricaSerie());
        assertEquals("Pedido enviado ao clube Maratona Dark (série). Após a aprovação do admin, a discussão é por episódio.", clube.entrar("Ana"));
    }

    @Test
    void deveEnviarPedidoEmClubePrivadoDeFilme() {
        ClubePrivado clube = new ClubePrivado("Cine Sexta", new FabricaFilme());
        assertEquals("Pedido enviado ao clube Cine Sexta (filme). Após a aprovação do admin, a discussão é por Lore.", clube.entrar("Ana"));
    }

    @Test
    void deveVirarMembroApenasOUsuarioAprovadoEmClubePrivado() {
        ClubePrivado clube = new ClubePrivado("Maratona Dark", new FabricaSerie());
        clube.entrar("Ana");
        clube.entrar("Bruno");
        assertEquals(List.of(), clube.getMembros());
        assertEquals(List.of("Ana", "Bruno"), clube.getPedidosPendentes());

        clube.aprovar("Ana");
        assertEquals(List.of("Ana"), clube.getMembros());
        assertEquals(List.of("Bruno"), clube.getPedidosPendentes());
    }

    @Test
    void deveLancarExcecaoAoAprovarUsuarioSemPedidoPendente() {
        ClubePrivado clube = new ClubePrivado("Leitores de Duna", new FabricaLivro());
        clube.entrar("Ana");
        clube.aprovar("Ana");

        assertThrows(IllegalArgumentException.class, () -> clube.aprovar("Bruno"));
        assertThrows(IllegalArgumentException.class, () -> clube.aprovar("Ana"));
        assertEquals(List.of("Ana"), clube.getMembros());
    }

    @Test
    void deveLancarExcecaoAoPedirParaEntrarNovamenteEmClubePrivado() {
        ClubePrivado clube = new ClubePrivado("Cine Sexta", new FabricaFilme());
        clube.entrar("Ana");
        assertThrows(IllegalArgumentException.class, () -> clube.entrar("Ana"));

        clube.aprovar("Ana");
        assertThrows(IllegalArgumentException.class, () -> clube.entrar("Ana"));
        assertEquals(List.of("Ana"), clube.getMembros());
        assertEquals(List.of(), clube.getPedidosPendentes());
    }
}
