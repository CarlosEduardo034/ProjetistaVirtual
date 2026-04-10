package com.fotovoltaico.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fotovoltaico.backend.model.Projeto;
import com.fotovoltaico.backend.repository.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto salvarProjeto(Projeto projeto) {

        if (projeto.getModulo() != null) {
            projeto.getModulo().setProjeto(projeto);
        }

        if (projeto.getInversor() != null) {
            projeto.getInversor().setProjeto(projeto);
        }

        Projeto projetoSalvo = projetoRepository.save(projeto);
        String base = System.getProperty("user.home") + "/Desktop/Projetos em execução/";
        String nomeCliente = projeto.getNomeCliente().replaceAll("[\\\\/:*?\"<>|]", "_");
        String caminhoExcel = base + nomeCliente +
        "/DOCUMENTOS DA CONCESSIONARIA/" +
        "Formulario-de-Solicitacao-de-Orcamento-de-Microgeracao-Distribuida-Grupo-B.xlsx";

        ExcelService excelService = new ExcelService();
        excelService.preencherFormulario(caminhoExcel, projeto);

        criarPastaProjeto(projeto.getNomeCliente());
        return projetoSalvo;
    }

    public void criarPastaProjeto(String nomeCliente){
        try {
            String basePath = System.getProperty("user.home") + "/Desktop/Projetos em execução/";
            
            Path origem = Paths.get(basePath + "Projeto Modelo");
            Path destino = Paths.get(basePath + nomeCliente);

            Files.walk(origem).forEach(source -> {
            try {
                Path target = destino.resolve(origem.relativize(source));
                if (Files.isDirectory(source)) {
                    Files.createDirectories(target);
                } else {
                    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Projeto criado com sucesso na pasta!");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}