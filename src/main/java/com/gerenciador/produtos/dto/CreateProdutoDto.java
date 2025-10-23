package com.gerenciador.produtos.dto;

public record CreateProdutoDto(String nome, String descricao, double preco, int quantidadeEstoque) {
}
