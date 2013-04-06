package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.Indicador;

public class IndicadorMaximo implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getMaximo();
	}

	@Override
	public String toString() {
		return "Maximo";
	}
	
	

}
