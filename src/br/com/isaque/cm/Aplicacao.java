package br.com.isaque.cm;

import br.com.isaque.cm.modelo.Tabuleiro;
import br.com.isaque.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
	}
}
