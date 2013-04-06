package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.Indicador;

public class IndicadorMinimo implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getMinimo();
	}

	@Override
	public String toString() {
		return "Minimo";
	}

	
	
}
