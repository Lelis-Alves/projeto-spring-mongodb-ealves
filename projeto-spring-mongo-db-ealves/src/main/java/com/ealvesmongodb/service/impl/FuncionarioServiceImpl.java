package com.ealvesmongodb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ealvesmongodb.model.Funcionario;
import com.ealvesmongodb.repositories.FuncionarioRepository;
import com.ealvesmongodb.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;

	@Override
	public List<Funcionario> obterTodos() {
		return repo.findAll();
	}

	@Override
	public Funcionario obterPorCodigo(String codigo) {
		return  this.repo
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Funcionário não existe. "));

	}

	@Override
	public Funcionario criar(Funcionario funcionario) {
		return this.repo.save(funcionario);
	}
	
	public Funcionario criarOne(Funcionario funcionario) {
		
		Funcionario chefe = this.repo.findById(funcionario.getChefe().getCodigo())
				.orElseThrow(() -> new IllegalArgumentException("Chefe inexistente. "));
	
		// - nao esquece de setar esse chefe em funcionario.
		funcionario.setChefe(chefe);
		
		return this.repo.save(funcionario);
	}

	@Override
	public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate) {
		return this.repo.obterFuncionarioPorRangeDeIdade(de, ate);
	}

	@Override
	public List<Funcionario> findByNome(String nome) {
		return this.repo.findByNome(nome);
	}

}
