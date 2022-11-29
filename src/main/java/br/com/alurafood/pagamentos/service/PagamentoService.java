package br.com.alurafood.pagamentos.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.http.PedidoClient;
import br.com.alurafood.pagamentos.model.Pagamento;
import br.com.alurafood.pagamentos.model.Status;
import br.com.alurafood.pagamentos.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PedidoClient pedido;
	
	public Page<PagamentoDto> obterTodos(Pageable paginacao){
	
		return pagamentoRepository
				.findAll(paginacao)
				.map(pagina->modelMapper.map(pagina, PagamentoDto.class));
				
	}
	
	public PagamentoDto obterPorId(Long id) {
		Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		return modelMapper.map(pagamento, PagamentoDto.class);
	}
	
	public PagamentoDto criarPagamento(PagamentoDto dto){
		Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
		pagamento.setStatus(Status.CRIADO);
		pagamentoRepository.save(pagamento);
		return modelMapper.map(pagamento, PagamentoDto.class);
		
	}
	
	  public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
	        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
	        pagamento.setId(id);
	        pagamento = pagamentoRepository.save(pagamento);
	        return modelMapper.map(pagamento, PagamentoDto.class);
	    }
	  
	  public void excluirPagamento(Long id) {
			pagamentoRepository.deleteById(id);
	  }
	  
	  public void confirmarPagamento(Long id) {
		  Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		  if(pagamento.isEmpty()) {
			  throw new EntityNotFoundException();
		  }
		  pagamento.get().setStatus(Status.CONFIRMADO);
		  pagamentoRepository.save(pagamento.get());
		  pedido.atualizaPagamento(pagamento.get().getPedidoId());
	  }

	public void alterarStatus(Long id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		  if(pagamento.isEmpty()) {
			  throw new EntityNotFoundException();
		  }
		  pagamento.get().setStatus(Status.CONFIRMADO_SEM_INTEGRACAO);
		  pagamentoRepository.save(pagamento.get());
		
	}
}
