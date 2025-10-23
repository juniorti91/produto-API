package com.gerenciador.produtos.service;

import com.gerenciador.produtos.dto.CreateProdutoDto;
import com.gerenciador.produtos.dto.UpdateProdutoDto;
import com.gerenciador.produtos.entity.Produtos;
import com.gerenciador.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Integer createProduto(CreateProdutoDto createProdutoDto) {

        var entity = new Produtos(
                null,
                createProdutoDto.nome(),
                createProdutoDto.descricao(),
                createProdutoDto.preco(),
                createProdutoDto.quantidadeEstoque());

        var produtoSaved = produtoRepository.save(entity);

        return produtoSaved.getId();
    }

    public Optional<Produtos> getProdutoById(Integer id) {
        return produtoRepository.findById(id);
    }

    public List<Produtos> listProdutos() {
        return produtoRepository.findAll();
    }

    public void updateProdutoById(Integer id, UpdateProdutoDto updateProdutoDto) {

        var produtoEntity = produtoRepository.findById(id);

        if (produtoEntity.isPresent()) {
            var produto = produtoEntity.get();

            produto.setNome(updateProdutoDto.nome());
            produto.setDescricao(updateProdutoDto.descricao());
            produto.setPreco(updateProdutoDto.preco());
            produto.setQuantidadeEstoque(updateProdutoDto.quantidadeEstoque());

            produtoRepository.save(produto);
        }
    }

    public void deleteProdutoById(Integer id) {

        var produtoExiste = produtoRepository.existsById(id);

        if (produtoExiste) {
            produtoRepository.deleteById(id);
        }
    }
}
