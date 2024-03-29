package br.com.caelum.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.IndicadorFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@SessionScoped
public class ArgentumBean {

	private String titulo;
	private String nomeIndicador;
	private String nomeMedia;

	public String getNomeIndicador() {
		return nomeIndicador;
	}

	public void setNomeIndicador(String nomeIndicador) {
		this.nomeIndicador = nomeIndicador;
	}

	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private List<Negociacao> negociacoes;

	private ChartModel modeloGrafico;

	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	// @PostConstruct
	public void preparaDados() {

		System.out.println("Indicador: " + nomeIndicador + ", " + nomeMedia);

		ClienteWebService cliente = new ClienteWebService();
		this.negociacoes = cliente.getNegociacoes();

		List<Candle> candles = new CandleFactory()
				.constroiCandles(this.negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		GeradorModeloGrafico gerador = new GeradorModeloGrafico(serie, 2,
				serie.getTotal() - 1);

		IndicadorFactory indicadorFactory = new IndicadorFactory(getNomeIndicador(), getNomeMedia());
		
		gerador.plotaIndicador(indicadorFactory.getIndicador());
		
		// gerador.plotaMediaMovelPonderada();
		// gerador.plotaMediaMovelSimples();
		// gerador.plotaIndicador(new MediaMovelSimples(new
		// IndicadorFechamento()));
		// gerador.plotaIndicador(new MediaMovelPonderada(new
		// IndicadorFechamento()));
		// gerador.plotaIndicador(new IndicadorFechamento());
		// gerador.plotaIndicador(new IndicadorAbertura());
		// gerador.plotaIndicador(new IndicadorVolume());
		// gerador.plotaIndicador(new IndicadorMaximo());
		this.modeloGrafico = gerador.getModeloGrafico();
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}

}
