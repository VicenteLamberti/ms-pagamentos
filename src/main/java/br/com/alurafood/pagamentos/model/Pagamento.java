package br.com.alurafood.pagamentos.model;

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="pagamentos")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Positive
	private BigDecimal valor;
	
	@NotBlank
	@Size(max = 100)
	private String nome;
	
	@NotBlank
	@Size(max = 19)
	private String numero;
	
	@NotBlank
	@Size(max = 7)
	private String expiracao;
	
	@NotBlank
	@Size(min = 3, max = 3)
	private String codigo;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@NotNull
	private Long pedidoId;
	
	@NotNull
	private Long formaDePagamentoId;
	
	
	public Pagamento() {}

	public Pagamento(Long id, @NotNull @Positive BigDecimal valor, @NotBlank @Size(max = 100) String nome,
			@NotBlank @Size(max = 19) String numero, @NotBlank @Size(max = 7) String expiracao,
			@NotBlank @Size(min = 3, max = 3) String codigo, Status status, @NotNull Long pedidoId,
			@NotNull Long formaDePagamentoId) {
		this.id = id;
		this.valor = valor;
		this.nome = nome;
		this.numero = numero;
		this.expiracao = expiracao;
		this.codigo = codigo;
		this.status = status;
		this.pedidoId = pedidoId;
		this.formaDePagamentoId = formaDePagamentoId;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Long getFormaDePagamentoId() {
		return formaDePagamentoId;
	}

	public void setFormaDePagamentoId(Long formaDePagamentoId) {
		this.formaDePagamentoId = formaDePagamentoId;
	}
	
	
	
	
}
