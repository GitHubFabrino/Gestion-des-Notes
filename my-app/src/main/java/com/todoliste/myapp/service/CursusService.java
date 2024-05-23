package com.todoliste.myapp.service;

import com.todoliste.myapp.dto.CursusDTO;
import com.todoliste.myapp.models.*;
import com.todoliste.myapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursusService {

    @Autowired
    PersonneRepository personneRepository;

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    CursusRepository cursusRepository;
    @Autowired
    ReleverRepository releverRepository;
    @Autowired
    DParcoursReository dParcoursReository;
    @Autowired
    UeRepository ueRepository;
    @Autowired
    UeEcRepository ueEcRepository;


    public void creer(int iddp1, int iddp2, CursusDTO cursusDTO) {

        System.out.println(cursusDTO.getId_DP1());
        System.out.println(cursusDTO.getId_DP2());
        System.out.println(cursusDTO.getNom());
        System.out.println(cursusDTO.getPrenom());
        System.out.println(cursusDTO.getNumeromatricule());

        Personne personneExist = personneRepository.findByNomAndPrenom(cursusDTO.getNom() , cursusDTO.getPrenom());
        Personne newPersonne = new Personne();
        EtudiantModel newetudiant = new EtudiantModel();
        CursusModel newCursus = new CursusModel();
        if (personneExist == null){

            newPersonne.setNom(cursusDTO.getNom());
            newPersonne.setPrenom(cursusDTO.getPrenom());
            personneRepository.save(newPersonne);

            newetudiant.setIdPersonne(newPersonne);
            newetudiant.setNumeromatricule(cursusDTO.getNumeromatricule());
            etudiantRepository.save(newetudiant);

            newCursus.setIdDP(dParcoursReository.findById(iddp1).orElseThrow());
            newCursus.setIdEtudiant(newetudiant);
            cursusRepository.save(newCursus);

            ArrayList<UeModel> listUe = this.ueRepository.findAllByIdDP(dParcoursReository.findById(iddp1).orElseThrow());
            for (UeModel ue : listUe){
                ArrayList<UeEcModel> listUEEC = this.ueEcRepository.findAllByIdUe(ue);
                for (UeEcModel ueec : listUEEC){
                    ReleveeModel relevee = new ReleveeModel();
                    relevee.setIdCursus(newCursus);
                    relevee.setIdUeEc(ueec);
                    releverRepository.save(relevee);
                }

            }

            CursusModel newCursus2 = new CursusModel();
            newCursus2.setIdDP(dParcoursReository.findById(iddp2).orElseThrow());
            newCursus2.setIdEtudiant(newetudiant);
            cursusRepository.save(newCursus2);
            ArrayList<UeModel> listUe2 = this.ueRepository.findAllByIdDP(dParcoursReository.findById(iddp2).orElseThrow());
            for (UeModel ue : listUe2){
                ArrayList<UeEcModel> listUEEC2 = this.ueEcRepository.findAllByIdUe(ue);
                for (UeEcModel ueec : listUEEC2){
                    ReleveeModel relevee = new ReleveeModel();
                    relevee.setIdCursus(newCursus2);
                    relevee.setIdUeEc(ueec);
                    releverRepository.save(relevee);
                }

            }

        }
        else {
            System.out.println("icicicici");
            Personne personneExist1 = personneRepository.findByNomAndPrenom(cursusDTO.getNom() , cursusDTO.getPrenom());
            System.out.println(personneExist1);

            EtudiantModel etudiantExist = etudiantRepository.findByIdPersonne(personneExist1);

            CursusModel cursusExist = cursusRepository.findByIdEtudiantAndIdDP(etudiantExist,dParcoursReository.findById(iddp1));
            CursusModel cursusExist2 = cursusRepository.findByIdEtudiantAndIdDP(etudiantExist,dParcoursReository.findById(iddp2));

            if (cursusExist == null){
                CursusModel newCursus1 = new CursusModel();
                newCursus1.setIdDP(dParcoursReository.findById(iddp1).orElseThrow());
                newCursus1.setIdEtudiant(etudiantExist);
                cursusRepository.save(newCursus1);

                ArrayList<UeModel> listUe = this.ueRepository.findAllByIdDP(dParcoursReository.findById(iddp1).orElseThrow());
                for (UeModel ue : listUe){
                    ArrayList<UeEcModel> listUEEC = this.ueEcRepository.findAllByIdUe(ue);
                    for (UeEcModel ueec : listUEEC){
                        ReleveeModel relevee = new ReleveeModel();
                        relevee.setIdCursus(newCursus1);
                        relevee.setIdUeEc(ueec);
                        releverRepository.save(relevee);
                    }
                }
            }else{
                ArrayList<UeModel> listUe = this.ueRepository.findAllByIdDP(dParcoursReository.findById(iddp1).orElseThrow());
                for (UeModel ue : listUe){
                    ArrayList<UeEcModel> listUEEC = this.ueEcRepository.findAllByIdUe(ue);
                    for (UeEcModel ueec : listUEEC){
                        ReleveeModel releverExist = releverRepository.findByIdCursusAndIdUeEc(cursusExist,ueec);
                        if (releverExist == null){
                            ReleveeModel relevee = new ReleveeModel();
                            relevee.setIdCursus(cursusExist);
                            relevee.setIdUeEc(ueec);
                            releverRepository.save(relevee);
                        }else {
                            releverExist.setIdCursus(cursusExist);
                            releverExist.setIdUeEc(ueec);
                            releverRepository.save(releverExist);
                        }
                    }
                }

            }

            if (cursusExist2 == null){
                CursusModel newCursus2= new CursusModel();
                newCursus2.setIdDP(dParcoursReository.findById(iddp2).orElseThrow());
                newCursus2.setIdEtudiant(etudiantExist);
                cursusRepository.save(newCursus2);
                ArrayList<UeModel> listUe2 = this.ueRepository.findAllByIdDP(dParcoursReository.findById(iddp2).orElseThrow());
                for (UeModel ue : listUe2){
                    ArrayList<UeEcModel> listUEEC2 = this.ueEcRepository.findAllByIdUe(ue);
                    for (UeEcModel ueec : listUEEC2){
                        ReleveeModel relevee = new ReleveeModel();
                        relevee.setIdCursus(newCursus2);
                        relevee.setIdUeEc(ueec);
                        releverRepository.save(relevee);
                    }

                }
            }else {
                ArrayList<UeModel> listUe2 = this.ueRepository.findAllByIdDP(dParcoursReository.findById(iddp2).orElseThrow());
                for (UeModel ue : listUe2){
                    ArrayList<UeEcModel> listUEEC2 = this.ueEcRepository.findAllByIdUe(ue);
                    for (UeEcModel ueec : listUEEC2){
                        ReleveeModel releverExist2 = releverRepository.findByIdCursusAndIdUeEc(cursusExist2,ueec);
                        if (releverExist2 == null){
                            ReleveeModel relevee = new ReleveeModel();
                            relevee.setIdCursus(cursusExist2);
                            relevee.setIdUeEc(ueec);
                            releverRepository.save(relevee);
                        }else {
                            releverExist2.setIdCursus(cursusExist2);
                            releverExist2.setIdUeEc(ueec);
                            releverRepository.save(releverExist2);
                        }
                    }

                }

            }
        }
    }

    public List<CursusDTO> afficherTous(int iddp1, int iddp2) {
        ArrayList<CursusModel> ObjetCursus = this.cursusRepository.findByIdDP(dParcoursReository.findById(iddp2));

        ArrayList<CursusDTO> CursusDTOs = new ArrayList<>();

        for (CursusModel cursus : ObjetCursus){
            try{
                CursusDTOs.add(new CursusDTO(
                        iddp1,
                        iddp2,
                        cursus.getIdEtudiant().getIdPersonne().getNom(),
                        cursus.getIdEtudiant().getIdPersonne().getPrenom(),
                        cursus.getIdEtudiant().getNumeromatricule(),
                        cursus.getId_Cursus(),
                        cursus.getIdEtudiant().getId_Etudiant()
                ));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return CursusDTOs;
    }

    public void supprimer(int idCursus) {

        Optional<CursusModel> cursusModel = cursusRepository.findById(idCursus);
        ArrayList<ReleveeModel> releverExist = releverRepository.findByIdCursus(cursusModel);
        for (ReleveeModel releveeModel : releverExist){
            this.releverRepository.deleteById(releveeModel.getId_Relever());
        }
        this.cursusRepository.deleteById(idCursus);
    }

    public void modifier(int idEtudiant, CursusDTO cursusDTO) {

        EtudiantModel etudiantupdate = etudiantRepository.findById(idEtudiant).orElseThrow();

        Personne personneUpdate = personneRepository.findById(etudiantupdate.getIdPersonne().getId_Personne()).orElseThrow();
        personneUpdate.setNom(cursusDTO.getNom());
        personneUpdate.setPrenom(cursusDTO.getPrenom());
        etudiantupdate.setNumeromatricule(cursusDTO.getNumeromatricule());

        personneRepository.save(personneUpdate);
        etudiantRepository.save(etudiantupdate);

    }
}
