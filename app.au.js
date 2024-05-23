const form = document.querySelector('form')
const nomAu = document.querySelector('#nomAu')
const anneeUniversitaire = document.querySelector('#anneeUniversitaire')
const alertsuccee  = document.querySelector('.alertsucces')
const btnClose = document.querySelector('.btnClose')
const list = document.querySelector('.list')

const modificationNomAu = document.querySelector('#modifiernomAu')
const modificationSession = document.querySelector('#modifieranneeUniversitaire')
const formodification = document.querySelector('#modificationAu')
const URL_POST = 'http://localhost:8081/api/Au/post'
const URL_GET = 'http://localhost:8081/api/Au/getAll'
const URL_DELETE = 'http://localhost:8081/api/Au/delete'
const URL_PUT = 'http://localhost:8081/api/Au/update'



form.addEventListener('submit', event => {
    
    event.preventDefault()
    console.log("ok");
    console.log(nomAu.value);
    console.log(anneeUniversitaire.value);
    const data = {
        "nom_AU" : nomAu.value,
    "session": anneeUniversitaire.value
    }
    const dataJson = JSON.stringify(data)

    fetch(URL_POST, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJson
    })
        .then(response => response.json())
        .then(data => {
            refreshListAu()
            alertsuccee.style.display = "block"
            alertsuccee.textContent = data.message
            const btn = document.createElement('button');
                btn.setAttribute('class', 'btn-close btn-close-white btnClose');
                btn.setAttribute('data-bs-dismiss', 'alert');
                btn.setAttribute('aria-label', 'Close');

                alertsuccee.appendChild(btn)
        })
        .catch(error => {
        console.error('Echec de création ');
        })
    nomAu.value = ""
    anneeUniversitaire.value = ""
})


function refreshListAu() {
    while (list.firstChild) {
        list.removeChild(list.firstChild)
    }

    fetch(URL_GET)
    .then(response => response.json())
    .then(data =>{        
        data.forEach(itemData => {
            const i = 0
            const { id_AU: id, nom_AU: nom_AU, session: sessionAu } = itemData
            
            const tr = document.createElement('tr')
            tr.setAttribute('id' , id)

         

            const td = document.createElement('td')
            td.innerText = nom_AU

            const td1 = document.createElement('td')
            td1.innerText = sessionAu

            const td2 = document.createElement('td')

            const divIcon = document.createElement('div')
            const divModifier = document.createElement('button')
            divModifier.setAttribute('class' , 'btn btn-warning col-2 m-2')
            divModifier.setAttribute('type' , 'button')
            divModifier.setAttribute('data-bs-toggle' , 'modal')
            divModifier.setAttribute('data-bs-target' , '#verticalycentered')
            divModifier.addEventListener('click' , () => {
               
                const nomAuModifier = nom_AU
                const anneeUniversitaireModifier = sessionAu
                
              
                modificationNomAu.value = nomAuModifier
                modificationSession.value = anneeUniversitaireModifier
                

                formodification.addEventListener('submit' , event => {
                    event.preventDefault()

                    const updateNomAu = modificationNomAu.value
                    const updateSession = modificationSession.value

                    const updateData = {
                        "id" : id,
                        "nom_AU" : updateNomAu,
                        "session": updateSession
                    }
                    const updateDataJson = JSON.stringify(updateData)
                    

                    fetch(URL_PUT+`/${id}`, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: updateDataJson
                    })
                    .then(response  => response.json )
                    .then(data  => {
                       
                        refreshListAu()
                    })
                    .catch( error  => {
                        console.error('erreur de modification');
                    })
                })
            })




            const icon = document.createElement('i')
            icon.setAttribute('class' , 'bx bx-pencil')

            const divSup = document.createElement('button')
            divSup.setAttribute('class' , 'btn btn-danger col-2 m-2')
            divSup.setAttribute('type' , 'button')
            divSup.addEventListener('click' , ()=>{
                const confirmDelete = confirm("Voulez-vous vraiment supprimer cet élément ?");
                    if (confirmDelete) {
                        fetch(URL_DELETE+`/${id}`, {
                            method: 'DELETE'
                        })
                        .then(response => response.json())
                        .then(data => {
                            refreshListAu();
                            alertsuccee.style.display = "block"
                            alertsuccee.textContent = "Suppression ok"
                            const btn = document.createElement('button');
                                btn.setAttribute('class', 'btn-close btn-close-white btnClose');
                                btn.setAttribute('data-bs-dismiss', 'alert');
                                btn.setAttribute('aria-label', 'Close');
                
                                alertsuccee.appendChild(btn)
                        })
                        .catch(error => {
                            console.error('Erreur lors de la suppression :', error);
                        });
                    }
            })
            const icon1 = document.createElement('i')
            icon1.setAttribute('class' , 'bi bi-trash-fill')


            divModifier.appendChild(icon)
            divSup.appendChild(icon1)
            divIcon.appendChild(divModifier)
            divIcon.appendChild(divSup)
            td2.appendChild(divIcon)

            // tr.appendChild(th)
            tr.appendChild(td)
            tr.appendChild(td1)
            tr.appendChild(td2)
            list.appendChild(tr)
            
        });
    })
    .catch(error => {
        console.error('erreur de chargement de la liste');
    })
    
}
refreshListAu()