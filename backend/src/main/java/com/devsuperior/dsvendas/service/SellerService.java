package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		//recebe a entidade do banco
		List<Seller> result =  repository.findAll();
		//converte para o objeto DTO
		//peguei minha lista de entidades result, criei uma stream e convertir cada entidade da lista em um objeto dto, depois transformei a stream
		//em uma lista novamente com o .collect(Collectors.toList())
		return result.stream().map(x->new SellerDTO(x)).collect(Collectors.toList());
	}
}
