package com.fotovoltaico.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fotovoltaico.backend.dto.ProjetoDTO;
import com.fotovoltaico.backend.model.Cliente;
import com.fotovoltaico.backend.model.Inversor;
import com.fotovoltaico.backend.model.Modulo;
import com.fotovoltaico.backend.model.Projeto;
import com.fotovoltaico.backend.model.Rateio;
import com.fotovoltaico.backend.model.ResponsavelTecnico;
import com.fotovoltaico.backend.model.Solicitacao;
import com.fotovoltaico.backend.model.UnidadeConsumidora;
import com.fotovoltaico.backend.repository.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto salvarProjeto(ProjetoDTO dto) {

    Projeto projeto = new Projeto();

    // CLIENTE
    Cliente cliente = new Cliente();
    cliente.setNome(dto.getCliente().getNome());
    cliente.setCpfCnpj(dto.getCliente().getCpfCnpj());
    cliente.setRg(dto.getCliente().getRg());
    cliente.setEndereco(dto.getCliente().getEndereco());
    cliente.setTelefoneCelular(dto.getCliente().getTelefoneCelular());
    cliente.setTelefoneFixo(dto.getCliente().getTelefoneFixo());
    cliente.setCep(dto.getCliente().getCep());
    cliente.setMunicipio(dto.getCliente().getMunicipio());
    cliente.setUf(dto.getCliente().getUf());
    cliente.setEmail(dto.getCliente().getEmail());

    projeto.setCliente(cliente);
    projeto.setNomeCliente(cliente.getNome());

    // SOLICITAÇÃO
    Solicitacao s = new Solicitacao();
    s.setTipoOrcamento(dto.getSolicitacao().getTipoOrcamento());
    s.setTipoSolicitacao(dto.getSolicitacao().getTipoSolicitacao());
    s.setPotenciaExistente(dto.getSolicitacao().getPotenciaExistente());
    s.setPossuiCargasEspeciais(dto.getSolicitacao().getPossuiCargasEspeciais());
    s.setDetalhamentoCargas(dto.getSolicitacao().getDetalhamentoCargas());
    s.setRamoAtividade(dto.getSolicitacao().getRamoAtividade());
    s.setFontePrimaria(dto.getSolicitacao().getFontePrimaria());
    s.setEspecificacaoFonte(dto.getSolicitacao().getEspecificacaoFonte());
    s.setTipoGeracao(dto.getSolicitacao().getTipoGeracao());
    s.setModalidadeCompensacao(dto.getSolicitacao().getModalidadeCompensacao());

    projeto.setSolicitacao(s);

    // UC
    UnidadeConsumidora uc = new UnidadeConsumidora();
    uc.setContaContrato(dto.getUc().getContaContrato());
    uc.setClasse(dto.getUc().getClasse());
    uc.setTipoLigacao(dto.getUc().getTipoLigacao());
    uc.setTensao(dto.getUc().getTensao());
    uc.setCargaDeclarada(dto.getUc().getCargaDeclarada());
    uc.setDisjuntor(dto.getUc().getDisjuntor());
    uc.setTipoRamal(dto.getUc().getTipoRamal());
    uc.setIdentificacaoPoste(dto.getUc().getIdentificacaoPoste());
    uc.setCoordenadaX(dto.getUc().getCoordenadaX());
    uc.setCoordenadaY(dto.getUc().getCoordenadaY());
    uc.setPossuiRateio(dto.getUc().getPossuiRateio());
    uc.setFormaAlocacao(dto.getUc().getFormaAlocacao());
    uc.setDestinoExcedente(dto.getUc().getDestinoExcedente());

    projeto.setUc(uc);

    // RESPONSÁVEL
    ResponsavelTecnico r = new ResponsavelTecnico();
    r.setNome(dto.getResponsavel().getNome());
    r.setTitulo(dto.getResponsavel().getTitulo());
    r.setRegistro(dto.getResponsavel().getRegistro());
    r.setUfRegistro(dto.getResponsavel().getUfRegistro());
    r.setEmail(dto.getResponsavel().getEmail());
    r.setTelefoneCelular(dto.getResponsavel().getTelefoneCelular());

    projeto.setResponsavel(r);

    // MODULOS
    if (dto.getModulos() != null) {
        projeto.setModulos(
            dto.getModulos().stream().map(m -> {
                Modulo mod = new Modulo();
                mod.setPotencia(m.getPotencia());
                mod.setQuantidade(m.getQuantidade());
                mod.setArea(m.getArea());
                mod.setFabricante(m.getFabricante());
                mod.setModelo(m.getModelo());
                mod.setProjeto(projeto);
                return mod;
            }).toList()
        );
    }

    // INVERSORES
    if (dto.getInversores() != null) {
        projeto.setInversores(
            dto.getInversores().stream().map(i -> {
                Inversor inv = new Inversor();
                inv.setFabricante(i.getFabricante());
                inv.setModelo(i.getModelo());
                inv.setPotenciaNominal(i.getPotenciaNominal());
                inv.setTensaoOperacao(i.getTensaoOperacao());
                inv.setCorrenteNominal(i.getCorrenteNominal());
                inv.setFatorPotencia(i.getFatorPotencia());
                inv.setRendimento(i.getRendimento());
                inv.setDht(i.getDht());
                inv.setProjeto(projeto);
                return inv;
            }).toList()
        );
    }

    // RATEIO
    if (dto.getRateios() != null) {
        projeto.setRateios(
            dto.getRateios().stream().map(rt -> {
                Rateio rtt = new Rateio();
                rtt.setPercentual(rt.getPercentual());
                rtt.setContaContrato(rt.getContaContrato());
                rtt.setClasse(rt.getClasse());
                rtt.setEndereco(rt.getEndereco());
                rtt.setProjeto(projeto);
                return rtt;
            }).toList()
        );
    }

    return projetoRepository.save(projeto);
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