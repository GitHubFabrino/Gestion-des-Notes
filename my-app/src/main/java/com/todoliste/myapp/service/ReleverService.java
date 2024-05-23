package com.todoliste.myapp.service;

import com.todoliste.myapp.dto.DMDto;
import com.todoliste.myapp.dto.ListeUeDTO;
import com.todoliste.myapp.dto.ReleverDTO;
import com.todoliste.myapp.dto.ReleverNoteDTO;
import com.todoliste.myapp.models.*;
import com.todoliste.myapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReleverService {

    @Autowired
    CursusRepository cursusRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    DParcoursReository dParcoursReository;

    @Autowired
    ReleverRepository releverRepository;
    @Autowired
    UeEcRepository ueEcRepository;
    @Autowired
    UeRepository ueRepository;


    public void creer(int iddp, ReleverDTO releverDTO) {

        System.out.println("iddp" + iddp);
        System.out.println("id etudiant : " + releverDTO.getIdEtudiant());
        System.out.println("note : " +releverDTO.getReleverNoteDTOS());

        CursusModel cursusExist = cursusRepository.findByIdEtudiantAndIdDP(etudiantRepository.findById(releverDTO.getIdEtudiant()).orElseThrow() , dParcoursReository.findById(iddp) );

        if (cursusExist != null){
            for (ReleverNoteDTO note: releverDTO.getReleverNoteDTOS()){
                ReleveeModel releveeExist = releverRepository.findByIdCursusAndIdUeEc(cursusExist, ueEcRepository.findById(note.getIdUeEc()).orElseThrow());
                if (releveeExist != null){
                    releveeExist.setNote(note.getNote());
                    releverRepository.save(releveeExist);
                }else{
                    return ;
                }
            }
        }
    }

    public List<ReleverDTO> afficherTous(int iddp) {
        ArrayList<CursusModel> ObjetCursus = this.cursusRepository.findByIdDP(dParcoursReository.findById(iddp));
        ArrayList<ReleverDTO> releverDTOS = new ArrayList<>();

            for (CursusModel cursus : ObjetCursus) {
                ArrayList<UeModel> listeUe = ueRepository.findAllByIdDP(dParcoursReository.findById(iddp).orElseThrow());
                ArrayList<ListeUeDTO> listeUeDTOS = new ArrayList<>();

                for (UeModel ue : listeUe){
                    ArrayList<ReleveeModel> releveeList = releverRepository.findByIdCursus(cursusRepository.findById(cursus.getId_Cursus()));
                    ArrayList<ReleverNoteDTO> releverNoteDTOS = new ArrayList<>();
                    for (ReleveeModel releve : releveeList) {
                        UeEcModel ueec = ueEcRepository.findById(releve.getIdUeEc().getIdUeEc()).orElse(null);
                        if (ueec.getIdUe().getIdUe() == ueec.getIdUe().getIdUe()) {
                            try {
                                releverNoteDTOS.add(new ReleverNoteDTO(
                                        releve.getId_Relever(),
                                        releve.getIdCursus().getId_Cursus(),
                                        releve.getNote(),
                                        releve.getIdUeEc().getIdUeEc(),
                                        releve.getIdUeEc().getIdEc().getMatiere()

                                ));

                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }


                    try {
                        listeUeDTOS.add(new ListeUeDTO(
                                ue.getIdUe(),
                                ue.getNomUe(),
                                releverNoteDTOS
                        ));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    releverDTOS.add(new ReleverDTO(
                            iddp,
                            cursus.getId_Cursus(),
                            cursus.getIdEtudiant().getId_Etudiant(),
                            cursus.getIdEtudiant().getIdPersonne().getNom(),
                            cursus.getIdEtudiant().getIdPersonne().getPrenom(),
                            cursus.getIdEtudiant().getNumeromatricule(),
                            listeUeDTOS
                    ));

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        return releverDTOS;
    }

    public void modifier(int idrelever, ReleverNoteDTO releverNoteDTO) {

        ReleveeModel releverExist = releverRepository.findById(idrelever).orElseThrow();
        releverExist.setNote(releverNoteDTO.getNote());
        releverRepository.save(releverExist);
    }
}
