package br.com.alurafood.pagamentos.dto;

import java.math.BigDecimal;

import br.com.alurafood.pagamentos.model.Status;

public record PagamentoDto(Long id, BigDecimal valor, String nome, String numero, String expiracao, String codigo,
		Status status, Long formaDePagamentoId, Long pedidoId) {

}
