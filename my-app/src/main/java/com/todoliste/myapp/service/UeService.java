package com.todoliste.myapp.service;

import com.todoliste.myapp.dto.DMDto;
import com.todoliste.myapp.dto.UeDTO;
import com.todoliste.myapp.models.DefinitionParcours;
import com.todoliste.myapp.models.UeModel;
import com.todoliste.myapp.repository.DParcoursReository;
import com.todoliste.myapp.repository.UeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UeService {

    @Autowired
    UeRepository ueRepository;
    @Autowired
    DParcoursReository dParcoursReository;

    public void creer(UeDTO ue) {

        UeModel newUe = new UeModel();
        newUe.setNomUe(ue.getNomUe());
        newUe.setCreditUe(ue.getCreditue());
        DefinitionParcours Dp = dParcoursReository.findById(ue.getIdDP()).orElseThrow();
        newUe.setIdParcours(Dp);
        this.ueRepository.save(newUe);
    }

    public ArrayList<UeDTO> afficherTous(int idDp) {

        ArrayList<UeModel> ObjetUe = this.ueRepository.findAllByIdDP(dParcoursReository.findById(idDp).orElseThrow());
        ArrayList<UeDTO> UeDTOS = new ArrayList<>();

        for ( UeModel ue : ObjetUe){
            try{
                UeDTOS.add(new UeDTO(
                        ue.getIdUe(),
                        ue.getNomUe(),
                        ue.getIdParcours().getId_dfParcour(),
                        ue.getCreditUe()
                ));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return UeDTOS;
    }

    public UeModel afficherOne(int id_ue) {
        Optional<UeModel> ueExist = this.ueRepository.findById(id_ue);
        if (ueExist.isPresent()){
            return ueExist.get();
        }
        return null;
    }

    public void modifier(int id_ue, UeDTO ue) {
        UeModel ueDansBd = this.afficherOne(id_ue);

        if (ueDansBd.getIdUe() == id_ue){

            ueDansBd.setNomUe(ue.getNomUe());
            ueDansBd.setCreditUe(ue.getCreditue());
            this.ueRepository.save(ueDansBd);
        }
    }

    public void supprimer(int id_ue) {
        this.ueRepository.deleteById(id_ue);
    }
}
