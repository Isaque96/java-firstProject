package br.com.isaque.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.isaque.cm.excecao.ExplosaoException;

class CampoTeste {
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo vizinhoEsquerda = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinhoEsquerda);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinhoDireita = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinhoDireita);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Cima() {
		Campo vizinhoCima = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinhoCima);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Baixo() {
		Campo vizinhoBaixo = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinhoBaixo);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoMarcado() {
		campo.alternarMarcacao();
		
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirComVizinho() {
		Campo vizinhoDoVizinho = new Campo(1, 1);
		Campo vizinho = new Campo(2, 2);
		
		vizinho.adicionarVizinho(vizinhoDoVizinho);		
		campo.adicionarVizinho(vizinho);
		
		campo.abrir();
		
		assertTrue(vizinho.isAberto() && vizinhoDoVizinho.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhoComCampoMinado() {
		Campo vizinhoDoVizinho = new Campo(1, 1);
		Campo vizinhoComMina = new Campo(1, 2);
		vizinhoComMina.minar();
		
		Campo vizinho = new Campo(2, 2);
				
		vizinho.adicionarVizinho(vizinhoDoVizinho);
		vizinho.adicionarVizinho(vizinhoComMina);
		campo.adicionarVizinho(vizinho);		
		
		campo.abrir();
		
		assertTrue(vizinho.isAberto() && vizinhoDoVizinho.isFechado());
	}
	
	@Test
	void testeAbrirCampoMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> campo.abrir());
	}
}
