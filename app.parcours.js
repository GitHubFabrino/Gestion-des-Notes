const au = document.querySelector("#au");
const niveaua = document.querySelector('#niveau')
const semestreSelect = document.querySelector('#semestreSelect')
const mentionSelect = document.querySelector('#mentionSelect')
const desinationParcours = document.querySelector('#desinationParcours')
const acroParcours = document.querySelector('#acroParcours')
const formAjoutParcours = document.querySelector('#formAjoutParcours')


const list = document.querySelector(".list");
const URL_GETAU = "http://localhost:8081/api/Au/getAll";
const URL_GETBYID = "http://localhost:8081/api/dp/getAll/au";

const URL_GETNiveau = "http://localhost:8081/api/niveau/getAll";


formAjoutParcours.addEventListener('submit', (e) =>{
  e.preventDefault()
  console.log(niveaua.value);
  console.log(semestreSelect.value);
  console.log(mentionSelect.value);
  console.log(desinationParcours.value);
  console.log(acroParcours.value);
  console.log(au.value);

  const data = {
    idDM : mentionSelect.value,
    idNiveau:niveaua.value,
    idSemestre:semestreSelect.value,
    idAU:au.value,
    nomParcours:desinationParcours.value,
    abreviationParcours:acroParcours.value

}
  const dataJson = JSON.stringify(data)

  fetch(`http://localhost:8081/api/dp/post/${au.value}`, {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
    },
    body: dataJson,
})
    .then((response) => response.json())
    .then((data) => {
        refreshListdP();
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
    desinationParcours.value = ""
    acroParcours.value = ""
})


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

var selectElement = document.getElementById("au");
selectElement.addEventListener("change", refreshListdP);
function refreshListdP() {
  idAU = selectElement.value;
  console.log("id aaa: ", idAU);
  while (list.firstChild) {
    list.removeChild(list.firstChild);
  }
  fetch(URL_GETBYID + `/${idAU}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
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

        const tr = document.createElement("tr");
        tr.setAttribute("id", iddp);

        const td = document.createElement("td");
        td.innerText = niveau;

        const td1 = document.createElement("td");
        td1.innerText = mention;

        const td3 = document.createElement("td");
        td3.innerText = semestre;

        const td4 = document.createElement("td");
        td4.innerText = nomparcours;

        const td5 = document.createElement("td");
        td5.innerText = abreviationparcours;

        const td2 = document.createElement("td");

        const divIcon = document.createElement("div");
        const divModifier = document.createElement("button");
        divModifier.setAttribute("class", "btn btn-warning col-2 m-2");
        divModifier.setAttribute("type", "button");
        divModifier.setAttribute("data-bs-toggle", "modal");
        divModifier.setAttribute("data-bs-target", "#verticalycentered");
        // divModifier.addEventListener("click", () => {
        //   // alert('modifier')
        //   designationModifier.value = nomMention;
        //   acroModifier.value = Abrmention;

        //   formodificationDm.addEventListener("submit", (event) => {
        //     event.preventDefault();

        //     console.log(designationModifier.value);
        //     console.log(acroModifier.value);
        //     console.log(iddefinitionMention);
        //     console.log(idMention);

        //     const updateData = {
        //       id_DM: iddefinitionMention,
        //       id_Mention: idMention,
        //       id_AU: idAU,
        //       nom_Mention: designationModifier.value,
        //       abreviation_Mention: acroModifier.value,
        //     };

        //     const updateDataJson = JSON.stringify(updateData);
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
          console.log("id sup : ", iddp);
          const confirmDelete = confirm(
            "Voulez-vous vraiment supprimer cet élément ?"
          );
          if (confirmDelete) {
            fetch(`http://localhost:8081/api/dp/delete/${iddp}`, {
              method: "DELETE",
            })
              .then((response) => response.json())
              .then((data) => {
                refreshListdP();
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
        list.appendChild(tr);
      });
    })
    .catch((erreur) => {
      console.error("Erreur lors de chargement de la liste ", erreur);
    });
}

function getNiveau() {
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
getNiveau();

function getsemestre() {
    fetch("http://localhost:8081/api/semestre/getAll")
      .then((response) => response.json())
      .then((data) => {
        data.forEach((itemData) => {
          const { id_Semestre: idsemestre,
          nom_semestre: nomsemestre } = itemData;
  
          const option = document.createElement("option");
          option.setAttribute("value", idsemestre);
          option.innerText = nomsemestre;
  
          semestreSelect.appendChild(option);
        });
      })
      .catch((error) => {
        console.error("erreur de chargement de la liste");
      });
  }
  getsemestre();

  selectElement.addEventListener("change", getmention);
  getmention();
  function getmention() {
    while (mentionSelect.firstChild) {
        mentionSelect.removeChild(mentionSelect.firstChild);
    }
    // var selectElement = document.getElementById("au");
const idAU = selectElement.value
    console.log("idAU :",idAU);

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
