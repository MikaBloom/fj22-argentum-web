package br.com.caelum.argentum.grafico;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico {
	
	private final SerieTemporal serie;
	private final int comeco;
	private final int fim;
	private CartesianChartModel modeloGrafico;

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim){
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new CartesianChartModel();
	}
	
	public void plotaMediaMovelSimples(){
		MediaMovelSimples indicador = new MediaMovelSimples();
		LineChartSeries chartSerie = new LineChartSeries("MMS - Fechamento");
		
		for(int i = comeco; i <= fim; i++){
			double valor = indicador.calcula(i, serie);
			chartSerie.set(i, valor);
		}
		
		this.modeloGrafico.addSeries(chartSerie);
	
	}
	
	public ChartModel getModeloGrafico() {
		return this.modeloGrafico;
	}
	
}
