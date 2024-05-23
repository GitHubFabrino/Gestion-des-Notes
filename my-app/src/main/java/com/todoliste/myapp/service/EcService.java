package com.todoliste.myapp.service;

import com.todoliste.myapp.models.EcModel;
import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.repository.EcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EcService {

    @Autowired
    EcRepository ecRepository;


    public void creer(EcModel ec) {
        ec.setMatiere(ec.getMatiere());
        this.ecRepository.save(ec);
    }

    public List<EcModel> afficherTous() {
        return this.ecRepository.findAll();
    }

    public EcModel afficherOne(int id_ec) {
        Optional<EcModel> ecExist = this.ecRepository.findById(id_ec);
        if (ecExist.isPresent()){
            return ecExist.get();
        }
        return null;
    }

    public void modifier(int id_ec, EcModel ec) {
        EcModel ecDansBd = this.afficherOne(id_ec);

        if (ecDansBd.getIdEc()== id_ec){

            ecDansBd.setMatiere(ec.getMatiere());
            this.ecRepository.save(ecDansBd);
        }
    }

    public void supprimer(int id_ec) {
        this.ecRepository.deleteById(id_ec);
    }
}
