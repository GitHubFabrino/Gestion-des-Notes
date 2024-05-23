const alertsuccee = document.querySelector(".alertsucces");
const btnClose = document.querySelector(".btnClose");
var selectElement = document.getElementById("au");
const list = document.querySelector(".list");

const au = document.querySelector("#au");
const mentionSelect = document.querySelector("#mentionSelect");
const parcoursSelect = document.querySelector("#parcours");
const parcoursSelect2 = document.querySelector("#parcours2");
const niveaua = document.querySelector("#niveau");

const formAjoutEtudiant = document.querySelector("#formAjoutEtudiant");
const nomAjout = document.querySelector("#nomAjout");
const prenomAjout = document.querySelector("#prenomAjout");
const matriculeAjout = document.querySelector("#matriculeAjout");

const formEtudiantModification = document.querySelector('#formEtudiantModification')
const nomModifier = document.querySelector('#nomModifier')
const prenomModifier = document.querySelector('#prenomModifier')
const matriculeModifier = document.querySelector('#matriculeModifier')

var mentionChange = document.getElementById("mentionSelect");
const URL_GETAU = "http://localhost:8081/api/Au/getAll";

function getAU() {
  fetch(URL_GETAU)
    .then((response) => response.json())
    .then((data) => {
      data.forEach((itemData) => {
        const { id_AU: id, nom_AU: nom_AU, session: sessionAu } = itemData;

        const option = document.createElement("option");
        option.setAttribute("value", id);
        option.innerText = sessionAu;

        au.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("erreur de chargement de la liste");
    });
}
getAU();

selectElement.addEventListener("change", getmention);

function getmention() {
  while (mentionSelect.firstChild) {
    mentionSelect.removeChild(mentionSelect.firstChild);
  }
  while (niveaua.firstChild) {
    niveaua.removeChild(niveaua.firstChild);
  }
  while (parcoursSelect.firstChild) {
    parcoursSelect.removeChild(parcoursSelect.firstChild);
  }

  // var selectElement = document.getElementById("au");
  const idAU = selectElement.value;
  //   console.log("idAU :",idAU);

  fetch(`http://localhost:8081/api/dm/getAll/au/${idAU}`)
    .then((response) => response.json())
    .then((data) => {
      data.forEach((itemData) => {
        const {
          id_DM: iddefinitionMention,
          id_Mention: idMention,
          id_AU: idAnneeUniv,
          nom_Mention: nomMention,
          abreviation_Mention: Abrmention,
        } = itemData;

        const option = document.createElement("option");
        option.setAttribute("value", iddefinitionMention);
        option.innerText = nomMention;

        mentionSelect.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("erreur de chargement de la liste");
    });
}

mentionSelect.addEventListener("change", getNiveau);
function getNiveau() {
  while (niveaua.firstChild) {
    niveaua.removeChild(niveaua.firstChild);
  }
  while (parcoursSelect.firstChild) {
    parcoursSelect.removeChild(parcoursSelect.firstChild);
  }
  while (list.firstChild) {
    list.removeChild(list.firstChild);
  }

  fetch("http://localhost:8081/api/niveau/getAll")
    .then((response) => response.json())
    .then((data) => {
      data.forEach((itemData) => {
        const { id_Niveau: idniveau, nom_niveau: niveau } = itemData;

        const option = document.createElement("option");
        option.setAttribute("value", idniveau);
        option.innerText = niveau;

        niveaua.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("erreur de chargement de la liste");
    });
}

niveaua.addEventListener("change", getParcours);
function getParcours() {
  while (parcoursSelect.firstChild) {
    parcoursSelect.removeChild(parcoursSelect.firstChild);
  }
  while (parcoursSelect2.firstChild) {
    parcoursSelect2.removeChild(parcoursSelect2.firstChild);
  }
  while (list.firstChild) {
    list.removeChild(list.firstChild);
  }

  const idAU = selectElement.value;

  fetch(
    `http://localhost:8081/api/dp/getAll/au/${idAU}/dm/${mentionSelect.value}/niveau/${niveaua.value}`
  )
    .then((response) => response.json())
    .then((data) => {
      data.forEach((itemData) => {
        const {
          iddfParcour: iddp,
          idDM: iddm,
          idParcour: idp,
          idNiveau: idniveau,
          idSemestre: idsemestre,
          idAU: idau,
          nomParcours: nomparcours,
          abreviationParcours: abreviationparcours,
          niveau: niveau,
          mention: mention,
          semestre: semestre,
        } = itemData;
        const option = document.createElement("option");
        option.setAttribute("value", iddp);
        option.innerText = abreviationparcours + " ( " + semestre + " ) ";

        parcoursSelect.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("erreur de chargement de la liste");
    });
}

parcoursSelect.addEventListener("change", getParcour2);
function getParcour2() {
  while (parcoursSelect2.firstChild) {
    parcoursSelect2.removeChild(parcoursSelect2.firstChild);
  }
  while (list.firstChild) {
    list.removeChild(list.firstChild);
  }

  const idAU = selectElement.value;

  fetch(
    `http://localhost:8081/api/dp/getAll/au/${idAU}/dm/${mentionSelect.value}/niveau/${niveaua.value}`
  )
    .then((response) => response.json())
    .then((data) => {
      data.forEach((itemData) => {
        const {
          iddfParcour: iddp,
          idDM: iddm,
          idParcour: idp,
          idNiveau: idniveau,
          idSemestre: idsemestre,
          idAU: idau,
          nomParcours: nomparcours,
          abreviationParcours: abreviationparcours,
          niveau: niveau,
          mention: mention,
          semestre: semestre,
        } = itemData;
        const option = document.createElement("option");
        option.setAttribute("value", iddp);
        option.innerText = abreviationparcours + " ( " + semestre + " ) ";

        parcoursSelect2.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("erreur de chargement de la liste");
    });
}

parcoursSelect2.addEventListener("change", listEtudiant);
function listEtudiant() {
  console.log("p1: ", parcoursSelect.value);
  console.log("p2: ", parcoursSelect2.value);
  while (list.firstChild) {
    list.removeChild(list.firstChild);
  }
  while (list.firstChild) {
    list.removeChild(list.firstChild);
  }
  fetch(
    `http://localhost:8081/api/cursus/getAll/dp1/${parcoursSelect.value}/dp2/${parcoursSelect2.value}`
  )
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      data.forEach((itemData) => {
        const {
          id_DP1: id_DP1,
          id_DP2: id_DP2,
          nom: nom,
          prenom: prenom,
          numeromatricule: numeromatricule,
          idCursus: idCursus,
          idEtudiant: idEtudiant,
        } = itemData;

        const tr = document.createElement("tr");
        tr.setAttribute("id", idCursus);

        const td = document.createElement("td");
        td.innerText = numeromatricule;

        const td1 = document.createElement("td");
        td1.innerText = nom.toUpperCase();

        const td3 = document.createElement("td");
        td3.innerText = prenom;

        const td2 = document.createElement("td");

        const divIcon = document.createElement("div");
        const divModifier = document.createElement("button");
        divModifier.setAttribute("class", "btn btn-warning col-2 m-2");
        divModifier.setAttribute("type", "button");
        divModifier.setAttribute("data-bs-toggle", "modal");
        divModifier.setAttribute("data-bs-target", "#verticalycentered");
        divModifier.addEventListener("click", () => {
          // alert('modifier')
          nomModifier.value = nom;
          prenomModifier.value = prenom;
          matriculeModifier.value = numeromatricule;

          formEtudiantModification.addEventListener("submit", (event) => {
            event.preventDefault();

            const updateData = {
              nom: nomModifier.value,
              prenom: prenomModifier.value,
              numeromatricule: matriculeModifier.value,
            };

            const updateDataJson = JSON.stringify(updateData);
            fetch(`http://localhost:8081/api/cursus/update/etudiant/${idEtudiant}`, {
              method: "PUT",
              headers: {
                "Content-Type": "application/json",
              },
              body: updateDataJson,
            })
              .then((response) => response.json)
              .then((data) => {
                console.log("ici", updateData);
                while (list.firstChild) {
                  list.removeChild(list.firstChild);
                }
                listEtudiant();
              })
              .catch((error) => {
                console.error("erreur de modification");
              });
          });
        });

        const icon = document.createElement("i");
        icon.setAttribute("class", "bx bx-pencil");

        const divSup = document.createElement("button");
        divSup.setAttribute("class", "btn btn-danger col-2 m-2");
        divSup.setAttribute("type", "button");
        divSup.addEventListener("click", () => {
          console.log("id sup : ", idCursus);
          const confirmDelete = confirm(
            "Voulez-vous vraiment supprimer cet élément ?"
          );
          if (confirmDelete) {
            fetch(`http://localhost:8081/api/cursus/delete/${idCursus}`, {
              method: "DELETE",
            })
              .then((response) => response.json())
              .then((data) => {
                listEtudiant();
                alertsuccee.style.display = "block";
                alertsuccee.textContent = "Suppression ok";
                const btn = document.createElement("button");
                btn.setAttribute("class", "btn-close btn-close-white btnClose");
                btn.setAttribute("data-bs-dismiss", "alert");
                btn.setAttribute("aria-label", "Close");

                alertsuccee.appendChild(btn);
              })
              .catch((error) => {
                console.error("Erreur lors de la suppression :", error);
              });
          }
        });

        const icon1 = document.createElement("i");
        icon1.setAttribute("class", "bi bi-trash-fill");

        divModifier.appendChild(icon);
        divSup.appendChild(icon1);
        divIcon.appendChild(divModifier);
        divIcon.appendChild(divSup);
        td2.appendChild(divIcon);

        tr.appendChild(td);
        tr.appendChild(td1);

        tr.appendChild(td3);
        tr.appendChild(td2);
        list.appendChild(tr);
      });
    })
    .catch((erreur) => {
      console.error("Erreur lors de chargement de la liste ", erreur);
    });
}

formAjoutEtudiant.addEventListener("submit", (e) => {
  e.preventDefault();
  // console.log(nomAjout.value);
  // console.log(prenomAjout.value);
  // console.log(matriculeAjout.value);
  // console.log(parcoursSelect.value);
  // console.log(parcoursSelect2.value);
  if (parcoursSelect.value != parcoursSelect2.value) {

    console.log('aaaaaaaaaaaaaaaa');

  const data = {
    id_DP1: parcoursSelect.value,
    id_DP2: parcoursSelect2.value,
    nom: nomAjout.value,
    prenom: prenomAjout.value,
    numeromatricule: matriculeAjout.value,
  };
  const dataJson = JSON.stringify(data);

  fetch(
    `http://localhost:8081/api/cursus/post/dp1/${parcoursSelect.value}/dp2/${parcoursSelect2.value}`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: dataJson,
    }
  )
    .then((response) => response.json())
    .then((data) => {
      while (list.firstChild) {
        list.removeChild(list.firstChild);
      }
      listEtudiant();
      alertsuccee.style.display = "block";
      alertsuccee.textContent = data.message;
      const btn = document.createElement("button");
      btn.setAttribute("class", "btn-close btn-close-white btnClose");
      btn.setAttribute("data-bs-dismiss", "alert");
      btn.setAttribute("aria-label", "Close");

      alertsuccee.appendChild(btn);
    })
    .catch((error) => {
      console.error("Echec de création ");
    });
  nomAjout.value = "";
  prenomAjout.value = "";
  matriculeAjout.value = "";
    
  }

});
