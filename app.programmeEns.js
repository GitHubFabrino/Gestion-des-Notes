const alertsuccee = document.querySelector(".alertsucces");
const btnClose = document.querySelector(".btnClose");
var selectElement = document.getElementById("au");
const list = document.querySelector(".list");

const au = document.querySelector("#au");
const mentionSelect = document.querySelector("#mentionSelect");
const parcoursSelect = document.querySelector("#parcours");
const niveaua = document.querySelector("#niveau");

const ueSelected = document.querySelector("#ueSelected");

const formAjoutUe = document.querySelector("#formAjoutUe");
const ueNom = document.querySelector("#ueNom");
const creditUE = document.querySelector("#creditUE");

const formAjoutEc = document.querySelector("#formAjoutEc");
const nomec = document.querySelector("#nomec");
const coefEc = document.querySelector("#coefEc");
const creditEc = document.querySelector("#creditEc");

const listUEEC = document.querySelector(".listUEEC");

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
  while (list.firstChild) {
    list.removeChild(list.firstChild);
  }
  while (listUEEC.firstChild) {
    listUEEC.removeChild(listUEEC.firstChild);
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

parcoursSelect.addEventListener("change", getUe);
function getUe() {
  //   console.log("idAU :",au.value);
  //   console.log( " mention" , mentionSelect.value);
  //  console.log(" niveau" ,niveaua.value);
  //  console.log(" par :"+parcoursSelect.value);

  while (list.firstChild) {
    list.removeChild(list.firstChild);
  }
  fetch(`http://localhost:8081/api/ue/getAll/dp/${parcoursSelect.value}`)
    .then((response) => response.json())
    .then((data) => {
      // console.log(data);
      data.forEach((itemData) => {
        const {
          idUe: idue,
          nomUe: nomue,
          idDP: iddp,
          creditue: creditue,
        } = itemData;

        const tr = document.createElement("tr");
        tr.setAttribute("id", idue);

        const td = document.createElement("td");
        td.innerText = nomue;

        const td1 = document.createElement("td");
        td1.innerText = creditue;

        const td2 = document.createElement("td");

        const divIcon = document.createElement("div");
        const divModifier = document.createElement("button");
        divModifier.setAttribute("class", "btn btn-warning col-2 m-2");
        divModifier.setAttribute("type", "button");
        divModifier.setAttribute("data-bs-toggle", "modal");
        divModifier.setAttribute("data-bs-target", "#verticalycentered");
        // divModifier.addEventListener("click", () => {
        //   // alert('modifier')
        //   ueNom.value = nomue;
        //   creditUE.value = creditue;

        //   formAjoutUe.addEventListener("submit", (event) => {
        //     event.preventDefault();
        //     console.log("eto");

        //     console.log(" parco :"+parcoursSelect.value);
        //     console.log("nom ue " , ueNom.value);
        //     console.log(" credit :",creditUE.value);
        //     console.log( " idue : ",idue);
        //     console.log("vita");

        //     const updateData = {
        //       idUe: idue,
        //       nomUe: ueNom.value,
        //       idDP: parcoursSelect.value,
        //       creditue: creditUE.value
        //     }
        //     const updateDataJson = JSON.stringify(updateData)
        //     fetch(URL_PUT + `/${iddefinitionMention}`, {
        //       method: "PUT",
        //       headers: {
        //         "Content-Type": "application/json",
        //       },
        //       body: updateDataJson,
        //     })
        //       .then((response) => response.json)
        //       .then((data) => {
        //         console.log("ici", updateData);

        //         refreshListdm();
        //       })
        //       .catch((error) => {
        //         console.error("erreur de modification");
        //       });
        //   });
        // });

        const icon = document.createElement("i");
        icon.setAttribute("class", "bx bx-pencil");

        const divSup = document.createElement("button");
        divSup.setAttribute("class", "btn btn-danger col-2 m-2");
        divSup.setAttribute("type", "button");
        divSup.addEventListener("click", () => {
          //    console.log("id sup : ", idue);
          const confirmDelete = confirm(
            "Voulez-vous vraiment supprimer cet élément ?"
          );
          if (confirmDelete) {
            fetch(`http://localhost:8081/api/ue/delete/${idue}`, {
              method: "DELETE",
            })
              .then((response) => response.json())
              .then((data) => {
                getUe();
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
        tr.appendChild(td2);
        list.appendChild(tr);
      });
    })
    .catch((erreur) => {
      console.error("Erreur lors de chargement de la liste ", erreur);
    });
}

formAjoutUe.addEventListener("submit", (e) => {
  e.preventDefault();
  // console.log(" parco :"+parcoursSelect.value);
  // console.log(ueNom.value);
  // console.log(creditUE.value);

  const data = {
    nomUe: ueNom.value,
    idDP: parcoursSelect.value,
    creditue: creditUE.value,
  };
  const dataJson = JSON.stringify(data);

  fetch(`http://localhost:8081/api/ue/post`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: dataJson,
  })
    .then((response) => response.json())
    .then((data) => {
      getUe();
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
  ueNom.value.value = "";
  creditUE.value = "";
});

parcoursSelect.addEventListener("change", getOptionUE);
function getOptionUE() {
  // console.log(" par aty :"+parcoursSelect.value);
  while (ueSelected.firstChild) {
    ueSelected.removeChild(ueSelected.firstChild);
  }
  fetch(`http://localhost:8081/api/ue/getAll/dp/${parcoursSelect.value}`)
    .then((response) => response.json())
    .then((data) => {
      data.forEach((itemData) => {
        const {
          idUe: idue,
          nomUe: nomue,
          idDP: iddp,
          creditue: creditue,
        } = itemData;
        const option = document.createElement("option");
        option.setAttribute("value", idue);
        option.innerText = nomue;

        ueSelected.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("erreur de chargement de la liste");
    });
}

formAjoutEc.addEventListener("submit", (e) => {
  e.preventDefault();
  console.log(" UE  :" + ueSelected.value);
  console.log("nom ec", nomec.value);
  console.log("coef ec", coefEc.value);
  console.log("credit ec", creditEc.value);

    const data = {
      idUe: ueSelected.value,
        matiere :nomec.value,
        creditec :creditEc.value,
        coefec :coefEc.value
    }
    const dataJson = JSON.stringify(data)

    fetch(`http://localhost:8081/api/ueec/post`, {
      method: "POST",
      headers: {
          "Content-Type": "application/json",
      },
      body: dataJson,
  })
      .then((response) => response.json())
      .then((data) => {
        getUEEC();
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
      nomec.value= ""
      creditEc.value = ""
      coefEc.value = ""
});

//ici
parcoursSelect.addEventListener("change", getUEEC);
function getUEEC() {
  console.log(" par :" + parcoursSelect.value);

  while (listUEEC.firstChild) {
    listUEEC.removeChild(listUEEC.firstChild);
  }
  fetch(`http://localhost:8081/api/ueec/getAll/dp/${parcoursSelect.value}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      data.forEach((item) => {
        item.ueEcDtos.forEach((ec) => {
              const tr = document.createElement("tr");
              tr.setAttribute("id", item.idUe);

              const td = document.createElement("td");
              td.innerText = item.nomUe;

              const td1 = document.createElement("td");
              td1.innerText = ec.matiere;

              const td3 = document.createElement("td");
              td3.innerText = ec.coefec;

              const td4 = document.createElement("td");
              td4.innerText = ec.creditec;

              const td5 = document.createElement("td");
              td5.innerText = item.creditue;

              const td2 = document.createElement("td");
              const divIcon = document.createElement("div");
              const divModifier = document.createElement("button");
              divModifier.setAttribute("class", "btn btn-warning col-2 m-2");
              divModifier.setAttribute("type", "button");
              divModifier.setAttribute("data-bs-toggle", "modal");
              divModifier.setAttribute("data-bs-target", "#verticalycentered");
              // divModifier.addEventListener("click", () => {
              //   // alert('modifier')
              //   ueNom.value = nomue;
              //   creditUE.value = creditue;
              //   formAjoutUe.addEventListener("submit", (event) => {
              //     event.preventDefault();
              //     console.log("eto");
              //     console.log(" parco :"+parcoursSelect.value);
              //     console.log("nom ue " , ueNom.value);
              //     console.log(" credit :",creditUE.value);
              //     console.log( " idue : ",idue);
              //     console.log("vita");
              //     const updateData = {
              //       idUe: idue,
              //       nomUe: ueNom.value,
              //       idDP: parcoursSelect.value,
              //       creditue: creditUE.value
              //     }
              //     const updateDataJson = JSON.stringify(updateData)
              //     fetch(URL_PUT + `/${iddefinitionMention}`, {
              //       method: "PUT",
              //       headers: {
              //         "Content-Type": "application/json",
              //       },
              //       body: updateDataJson,
              //     })
              //       .then((response) => response.json)
              //       .then((data) => {
              //         console.log("ici", updateData);
              //         refreshListdm();
              //       })
              //       .catch((error) => {
              //         console.error("erreur de modification");
              //       });
              //   });
              // });
              const icon = document.createElement("i");
              icon.setAttribute("class", "bx bx-pencil");
              const divSup = document.createElement("button");
              divSup.setAttribute("class", "btn btn-danger col-2 m-2");
              divSup.setAttribute("type", "button");
              divSup.addEventListener("click", () => {
                //    console.log("id sup : ", idue);
                const confirmDelete = confirm(
                  "Voulez-vous vraiment supprimer cet élément ?"
                );
                if (confirmDelete) {
                  fetch(`http://localhost:8081/api/ueec/delete/${ec.idUeEc}`, {
                    method: "DELETE",
                  })
                    .then((response) => response.json())
                    .then((data) => {
                      getUEEC();
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
              tr.appendChild(td4);
              tr.appendChild(td5);
              tr.appendChild(td2);
              listUEEC.appendChild(tr);
        });
      });
    })
    .catch((error) => console.error("Une erreur s'est produite : " + error));

  
}
