package br.com.minhamepresa.app_de_recados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minhamepresa.app_de_recados.entity.Recado;
import br.com.minhamepresa.app_de_recados.repository.RecadoRepository;

@Service
public class RecadoService {
    
    @Autowired
    private RecadoRepository recadoRepository;

    // Lista os Recados
    public List<Recado> findAll(){
        return recadoRepository.findAll();
    }

    // Mostra apenas um recado pelo ID
    public Recado findById(Long id){
        return recadoRepository.findById(id).orElse(null);
    }

    // Cadastrar um novo recado
    public Recado insertNew(Recado recado){
        recado.setStatus("não lido");
        return recadoRepository.save(recado);
    }

    // Alterar os dados de um recado
    public Recado update(Long id, Recado recadoAlterado){
        Recado recado = findById(id);
        recado.setMensagem(recadoAlterado.getMensagem());
        recado.setStatus(recadoAlterado.getStatus());
        return recadoRepository.save(recado);
    }

    // Deletar um recado
    public Boolean deleteById(Long id){
        Recado recado = findById(id);
        if (recado == null){
            return false;
        }else{
            recadoRepository.deleteById(id);
            return true;
        }
    }
}
