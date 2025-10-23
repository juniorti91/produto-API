package com.gerenciador.produtos.dto;

public record UpdateProdutoDto(String nome, String descricao, double preco, int quantidadeEstoque) {
}
