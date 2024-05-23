const alertsuccee = document.querySelector(".alertsucces");
const btnClose = document.querySelector(".btnClose");
var selectElement = document.getElementById("au");
const listetudiant = document.querySelector(".listetudiant");

const au = document.querySelector("#au");
const mentionSelect = document.querySelector("#mentionSelect");
const parcoursSelect = document.querySelector("#parcours");
const niveaua = document.querySelector("#niveau");

const ueSelected = document.querySelector("#ueSelected");

var mentionChange = document.getElementById("mentionSelect");
const URL_GETAU = "http://localhost:8081/api/Au/getAll";
const option1 = document.createElement("option");

option1.innerText = "année scolaire";

au.appendChild(option1);
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

  const idAU = selectElement.value;

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
      console.error("erreur de chargement de la liste", error);
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

  const idAU = selectElement.value;
  const option = document.createElement("option");

  option.innerText = "Parcours";

  parcoursSelect.appendChild(option);

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
        option.innerText = semestre + " ( " + abreviationparcours + ")";

        parcoursSelect.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("erreur de chargement de la liste");
    });
}

const listNomUe = document.querySelector(".listNomUe");
const matiereListe = document.querySelector(".matiereListe");
parcoursSelect.addEventListener("change", getEtudiantList);
function getEtudiantList() {
  while (listetudiant.firstChild) {
    listetudiant.removeChild(listetudiant.firstChild);
  }
  while (matiereListe.firstChild) {
    matiereListe.removeChild(matiereListe.firstChild);
  }
  const thue = document.createElement("th");
  thue.innerText = "Matricule";
  const thu = document.createElement("th");
  thu.innerText = "Nom et Prénom";
  matiereListe.appendChild(thue);
  matiereListe.appendChild(thu);
  fetch(
    `http://localhost:8081/api/relever/getAll/relever/${parcoursSelect.value}`
  )
    .then((response) => response.json())
    .then((data) => {
      data[0].listeUeDTOS[0].releverNoteDTOS.forEach((matiere) => {
        const thue = document.createElement("th");
        thue.innerText = matiere.nomMatiere;
        matiereListe.appendChild(thue);
      });

      data.forEach((itemData) => {
        const tr = document.createElement("tr");
        tr.setAttribute("id", itemData.idCursus);

        const td = document.createElement("td");
        td.innerText = itemData.numeromatricule;

        const td1 = document.createElement("td");
        td1.innerText = itemData.nom + " " + itemData.prenom;

        tr.appendChild(td);
        tr.appendChild(td1);

        itemData.listeUeDTOS[0].releverNoteDTOS.forEach((note) => {
          const td2 = document.createElement("td");
          td2.setAttribute("id", note.id_Relever);

          const input = document.createElement("input");

          if (note.note == null) {
            input.setAttribute("value", 0);
          } else {
            input.setAttribute("value", note.note);
          }

          input.setAttribute("class", "col-4");
          td2.appendChild(input);
          tr.appendChild(td2);

          input.addEventListener("change", function (params) {
            const data = {
              note: input.value,
            };
            const dataJson = JSON.stringify(data);

            fetch(`http://localhost:8081/api/relever/put/${note.id_Relever}`, {
              method: "PUT",
              headers: {
                "Content-Type": "application/json",
              },
              body: dataJson,
            })
              .then((response) => response.json())
              .then((data) => {
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
          });
        });

        listetudiant.appendChild(tr);
      });
    })
    .catch((erreur) => {
      console.error("Erreur lors de chargement de la liste ", erreur);
    });
}
