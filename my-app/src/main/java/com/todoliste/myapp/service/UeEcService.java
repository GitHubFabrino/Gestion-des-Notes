package com.todoliste.myapp.service;

import com.todoliste.myapp.dto.DMDto;
import com.todoliste.myapp.dto.UeEcDto;
import com.todoliste.myapp.dto.UeEcListDTO;
import com.todoliste.myapp.models.*;
import com.todoliste.myapp.repository.DParcoursReository;
import com.todoliste.myapp.repository.EcRepository;
import com.todoliste.myapp.repository.UeEcRepository;
import com.todoliste.myapp.repository.UeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UeEcService {

    @Autowired
    UeEcRepository ueEcRepository;

    @Autowired
    EcRepository ecRepository;

    @Autowired
    UeRepository ueRepository;
    @Autowired
    DParcoursReository dParcoursReository;


    public void creer(UeEcDto ueEcDto) {
        System.out.println("idUe  : " + ueEcDto.getIdUe());
        System.out.println(" id Ec : " + ueEcDto.getIdEc());
        System.out.println(" matiere : " + ueEcDto.getMatiere());
        System.out.println(" credit  : " + ueEcDto.getCreditec());
        System.out.println(" coef : " + ueEcDto.getCoefec());

        UeEcModel newUeec = new UeEcModel();
        EcModel ecExist = ecRepository.findByMatiere(ueEcDto.getMatiere());
        EcModel newEc = new EcModel();
        if (ecExist == null){
            newEc.setMatiere(ueEcDto.getMatiere());
            ecRepository.save(newEc);
            newUeec.setIdEc(newEc);
        }
        else {
            newUeec.setIdEc(ecExist);
        }

        UeModel ue = ueRepository.findById(ueEcDto.getIdUe()).orElseThrow();
        newUeec.setIdUe(ue);
        newUeec.setCreditec(ueEcDto.getCreditec());
        newUeec.setCoefec(ueEcDto.getCoefec());

        ueEcRepository.save(newUeec);



    }

    public List<UeEcListDTO> afficherTous(int iddp) {
    //todo ici
        DefinitionParcours parcours = dParcoursReository.findById(iddp).orElseThrow();
        ArrayList<UeModel> ueList = ueRepository.findAllByIdDP(parcours);

        ArrayList<UeEcListDTO> ueEcListDTOS = new ArrayList<>();

        for (UeModel ue : ueList){
            ArrayList<UeEcModel> UeEcList = ueEcRepository.findAllByIdUe(ue);
            ArrayList<UeEcDto> ueEcDtos = new ArrayList<>();
            for (UeEcModel ueec : UeEcList){

                try{
                    ueEcDtos.add(new UeEcDto(
                            ueec.getIdUeEc(),
                            ueec.getIdUe().getIdUe(),
                            ueec.getIdEc().getIdEc(),
                            ueec.getIdEc().getMatiere(),
                            ueec.getCreditec(),
                            ueec.getCoefec()
                    ));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                ueEcListDTOS.add(new UeEcListDTO(
                        ue.getIdUe(),
                        ue.getNomUe(),
                        ue.getIdParcours().getId_dfParcour(),
                        ue.getCreditUe(),
                        ueEcDtos
                ));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        return ueEcListDTOS;
    }

    public void supprimer(int idueec) {
        this.ueEcRepository.deleteById(idueec);
    }
}
