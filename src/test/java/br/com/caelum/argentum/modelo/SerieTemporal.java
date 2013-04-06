package br.com.caelum.argentum.modelo;

import java.util.List;

public class SerieTemporal {

	private final List<Candle> candles;

	public SerieTemporal(List<Candle> candles) {
		if(candles == null){
			throw new IllegalArgumentException("A lista não pode ser nula!");
		}
		this.candles = candles;

	}

	public Candle getCandle(int i) {
		if(i > candles.size() || i < 0){
			throw new IllegalArgumentException("Item não existente na lista!");
		}
		return this.candles.get(i);
	}

	public int getTotal() {
		return this.candles.size();
	}

}
