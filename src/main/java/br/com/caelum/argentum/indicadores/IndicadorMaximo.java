package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

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
