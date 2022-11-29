package br.com.alurafood.pagamentos.model;

import java.util.List;

public class Pedido {

	private List<ItemDoPedido>itens;

	public List<ItemDoPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemDoPedido> itens) {
		this.itens = itens;
	}
	
	
}
