const au = document.querySelector("#au");
const list = document.querySelector(".list");

const formAjoutMention = document.querySelector("#ajoutMention");
const designation = document.querySelector("#designationMention");
const acro = document.querySelector("#acronyme");

const formodificationDm = document.querySelector("#modificationdm");
const designationModifier = document.querySelector("#designationModifier");
const acroModifier = document.querySelector("#acroModifier");

const URL_GET = "http://localhost:8081/api/Au/getAll";
const URL_GETBYID = "http://localhost:8081/api/dm/getAll/au";
const URL_DELETE = "http://localhost:8081/api/dm/delete";
const URL_POST = "http://localhost:8081/api/dm/post";
const URL_PUT =  "http://localhost:8081/api/dm/update"

var selectElement = document.getElementById("au");
var selectedValue;
function getAU() {
    fetch(URL_GET)
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
selectElement.addEventListener("change", refreshListdm);

var idAU = selectElement.value;

function refreshListdm() {
    idAU = selectElement.value;
    console.log("id : ", idAU);
    while (list.firstChild) {
        list.removeChild(list.firstChild);
    }
    fetch(URL_GETBYID + `/${idAU}`)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            data.forEach((itemData) => {
                const {
                    id_DM: iddefinitionMention,
                    id_Mention: idMention,
                    id_AU: idAnneeUniv,
                    nom_Mention: nomMention,
                    abreviation_Mention: Abrmention,
                } = itemData;

                const tr = document.createElement("tr");
                tr.setAttribute("id", iddefinitionMention);

                const td = document.createElement("td");
                td.innerText = nomMention;

                const td1 = document.createElement("td");
                td1.innerText = Abrmention;

                const td2 = document.createElement("td");

                const divIcon = document.createElement("div");
                const divModifier = document.createElement("button");
                divModifier.setAttribute("class", "btn btn-warning col-2 m-2");
                divModifier.setAttribute("type", "button");
                divModifier.setAttribute("data-bs-toggle", "modal");
                divModifier.setAttribute("data-bs-target", "#verticalycentered");
                divModifier.addEventListener("click", () => {
                    // alert('modifier')
                    designationModifier.value = nomMention;
                    acroModifier.value = Abrmention;

                    formodificationDm.addEventListener("submit", (event) => {
                        event.preventDefault();

                        console.log(designationModifier.value);
                        console.log(acroModifier.value);
                        console.log(iddefinitionMention);
                        console.log(idMention);

                        const updateData = {
                                "id_DM": iddefinitionMention,
                                "id_Mention": idMention,
                                "id_AU": idAU,
                                "nom_Mention": designationModifier.value,
                                "abreviation_Mention": acroModifier.value
                            }
                        
                        const updateDataJson = JSON.stringify(updateData)
                        fetch(URL_PUT+`/${iddefinitionMention}`, {
                            method: 'PUT',
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            body: updateDataJson
                        })
                        .then(response  => response.json )
                        .then(data  => {
                            console.log("ici",updateData);
                           
                            refreshListdm()
                        })
                        .catch( error  => {
                            console.error('erreur de modification');
                        })
                    });
                });

                const icon = document.createElement("i");
                icon.setAttribute("class", "bx bx-pencil");

                const divSup = document.createElement("button");
                divSup.setAttribute("class", "btn btn-danger col-2 m-2");
                divSup.setAttribute("type", "button");
                divSup.addEventListener("click", () => {
                    console.log("id sup : ", iddefinitionMention);
                    const confirmDelete = confirm(
                        "Voulez-vous vraiment supprimer cet élément ?"
                    );
                    if (confirmDelete) {
                        fetch(URL_DELETE + `/${iddefinitionMention}`, {
                            method: "DELETE",
                        })
                            .then((response) => response.json())
                            .then((data) => {
                                refreshListdm();
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

formAjoutMention.addEventListener("submit", (event) => {
    event.preventDefault();

    console.log(" desi : ",designation.value);
    console.log("acro : ",acro.value);
    console.log(idAU);
    // console.log(selectElement.value);
    const data = {
        id_AU: idAU,
        nom_Mention: designation.value,
        abreviation_Mention: acro.value,
    };
    const dataJson = JSON.stringify(data);

    fetch(URL_POST + `/${idAU}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: dataJson,
    })
        .then((response) => response.json())
        .then((data) => {
            refreshListdm();
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
    designation.value = "";
    acro.value = "";
});