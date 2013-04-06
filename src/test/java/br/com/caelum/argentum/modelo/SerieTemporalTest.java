package br.com.caelum.argentum.modelo;

import org.junit.Test;

import br.com.caelum.argentum.indicadores.GeradorDeSerie;

public class SerieTemporalTest {

	@Test(expected = IllegalArgumentException.class)
	public void recebeListaNula() {
		new SerieTemporal(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void posicaoForaDaLista() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
		serie.getCandle(7);
	}

}
