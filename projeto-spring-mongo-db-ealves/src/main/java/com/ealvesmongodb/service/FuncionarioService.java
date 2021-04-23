package com.ealvesmongodb.service;

import java.util.List;

import com.ealvesmongodb.model.Funcionario;

public interface FuncionarioService {

	public List<Funcionario> obterTodos();

	public Funcionario obterPorCodigo(String codigo);

	public Funcionario criar(Funcionario funcionario);

	public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate);

	public List<Funcionario> findByNome(String nome);

}
