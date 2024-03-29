package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.Indicador;

public class IndicadorFechamento implements Indicador {

	@Override
	public String toString() {
		return "Fechamento";
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getFechamento();
	}

}
