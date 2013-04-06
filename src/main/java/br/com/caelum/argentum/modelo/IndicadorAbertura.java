package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.Indicador;

public class IndicadorAbertura implements Indicador {

	@Override
	public String toString() {
		return "Abertura";
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getAbertura();
	}

}
