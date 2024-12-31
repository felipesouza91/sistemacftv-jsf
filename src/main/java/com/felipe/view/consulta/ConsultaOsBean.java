package com.felipe.view.consulta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.felipe.model.Cliente;
import com.felipe.model.MotivoOs;
import com.felipe.model.OrdemServico;
import com.felipe.model.PrioridadeOs;
import com.felipe.repository.OrdemServicoRepository;
import com.felipe.util.FacesUtil;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class ConsultaOsBean implements Serializable {

	private Repositorios rep = new Repositorios();

	private int tipoPequisa;

	private String descricaoPesquisa;

	private OrdemServicoRepository osDao;

	private Cliente cliente;

	private Date dataPesquisa;

	private MotivoOs motivoOs;

	private OrdemServico osExcluir;

	private List<OrdemServico> listOs = new ArrayList<OrdemServico>();

	private List<MotivoOs> listMotivoOs = new ArrayList<MotivoOs>();

	private String tipoCampo = null;

	private boolean render = false;

	private boolean renderMotivoOs = false;

	private boolean renderPrioridade = false;

	private boolean renderData = false;

	@PostConstruct
	public void inicio() {
		this.listMotivoOs = rep.getMotivoOss().getTodos();
	}

	public List<OrdemServico> getListOs() {

		if (cliente == null) {
			return listOs;
		} else {
			osDao = rep.getOs();
			listOs = osDao.getTodosPorCliente(cliente);
			if (listOs.isEmpty()) {
				FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, "Não foram encontradas ordens para o cliente selecionado");
			}
			return listOs;
		}

	}

	public void excluir() {
		osDao = rep.getOs();
		try {
			osDao.excluir(osExcluir);
			FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Ordem de Serviço excluida com sucesso");
			listOs = osDao.getPorFiltro(tipoPequisa, descricaoPesquisa);
		} catch (Exception e) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao excluir ordem");
		}
	}

	public void pesquisar() {
		osDao = rep.getOs();
		System.out.println(dataPesquisa);
		if (this.dataPesquisa == null) {
			if (tipoPequisa == 7) {
				listOs = osDao.getPorMotivoOs(motivoOs);
			} else {
				listOs = osDao.getPorFiltro(tipoPequisa, descricaoPesquisa);
			}
		} else {
			listOs = osDao.getPorFiltroData(tipoPequisa, dataPesquisa);
		}
		this.dataPesquisa = null;
		if (listOs.isEmpty()) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, "Nenhuma ordem com os filtros selecionados foi encontrada.");
		}

	}

	public void modificaPesquisaDescricao(ValueChangeEvent event) {
		Integer a = (Integer) event.getNewValue();

		switch (a) {
			case 0: {
				this.render = false;
				this.renderPrioridade = false;
				this.renderData = false;
				this.renderMotivoOs = false;
				break;
			}
			case 5: {
				this.renderData = true;
				this.renderPrioridade = false;
				this.render = false;
				this.renderMotivoOs = false;
				break;
			}

			case 6: {
				this.renderData = false;
				this.renderPrioridade = true;
				this.render = false;
				this.renderMotivoOs = false;
				break;
			}

			case 7: {
				this.renderData = false;
				this.renderPrioridade = false;
				this.render = false;
				this.renderMotivoOs = true;
				break;
			}

			default: {
				this.renderData = false;
				this.renderPrioridade = false;
				this.render = true;
				break;
			}

		}

	}

	public PrioridadeOs[] getPrioridadeOs() {

		return PrioridadeOs.values();
	}

	public void setTipoPequisa(int tipoPequisa) {
		this.tipoPequisa = tipoPequisa;
	}

	public void setDescricaoPesquisa(String descricao) {
		this.descricaoPesquisa = descricao;
	}

	public int getTipoPequisa() {
		return tipoPequisa;
	}

	public String getDescricaoPesquisa() {
		return descricaoPesquisa;
	}

	public String getTipoCampo() {
		return tipoCampo;
	}

	public boolean isRender() {
		return render;
	}

	public boolean isRenderData() {
		return renderData;
	}

	public boolean isRenderPrioridade() {
		return renderPrioridade;
	}

	public boolean isRenderMotivoOs() {
		return renderMotivoOs;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataPesquisa() {
		return dataPesquisa;
	}

	public void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	public List<MotivoOs> getListMotivoOs() {
		return listMotivoOs;
	}

	public MotivoOs getMotivoOs() {
		return motivoOs;
	}

	public void setMotivoOs(MotivoOs motivoOs) {
		this.motivoOs = motivoOs;
	}

	public void setOsExcluir(OrdemServico osExcluir) {
		this.osExcluir = osExcluir;
	}

}
