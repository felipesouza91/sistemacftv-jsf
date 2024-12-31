package com.felipe.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.felipe.model.OrdemServico;
import com.felipe.util.Repositorios;

@ManagedBean
@ViewScoped
public class HomeOsBean {

	private List<OrdemServico> listOs;

	private Repositorios rep = new Repositorios();

	public List<OrdemServico> getListOs() {
		return rep.getOs().getComPendencias();
	}

}
