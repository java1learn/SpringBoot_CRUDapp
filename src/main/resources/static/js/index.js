showAllUsers();

function showAllUsers() {
    let tBody = document.getElementById("tBody");
    tBody.innerHTML = "";
    fetch("http://localhost:8080/getAllUsers")
        .then(response => response.json())
        .then(users => {
            users.forEach(function (user) {
                var row = tBody.insertRow();
                row.setAttribute("id", user.id);
                var id = tBody.insertCell();
                id.innerHTML = user.id;
                var login = tBody.insertCell();
                login.innerHTML = user.login;
                var lastName = tBody.insertCell();
                lastName.innerHTML = user.lastName;
                var department = tBody.insertCell();
                department.innerHTML = user.department;
                var mail = tBody.insertCell();
                mail.innerHTML = user.mail;
                var password = tBody.insertCell();
                password.innerHTML = user.password;
                var roles = tBody.insertCell();
                roles.innerHTML = rolesList(user).textContent;

                var editButton = row.insertCell();
                editButton.innerHTML =
                    '<button type="button" onclick="getModalEdit(' + user.id + ')" class ="btn btn-primary btn-sm">Edit</button>"';
                var deleteButton = row.insertCell();
                deleteButton.innerHTML =
                    '<button type="button" onclick="getModalDelete(' + user.id + ')" class="btn btn-danger btn-sm">Delete</button>';
            })
        })
}

function rolesList(user) {
    let roleList = document.createElement('ul');
    for (let i = 0; i < user.roles.length; i++) {
        let role = document.createElement('li');
        role.textContent = user.roles[i].roleName + " ";
        roleList.appendChild(role);
    }
    return roleList;
}

function getModalEdit(id) {
    fetch('http://localhost:8080/rest/getUserById/' + id)
        .then(response => response.json())
        .then(user => {
            let adminSelect = "";
            let userSelect = "";

            for (let i = 0; i < user.roles.length; i++) {
                if (user.roles[i].roleName.contains("ADMIN")) {
                    adminSelect = "selected";
                }
                if (user.roles[i].roleName.contains("USER")) {
                    userSelect = "selected";
                }
            }

            let modal = document.getElementById("Modal");

            modal.innerHTML =
                '<div id="modalEdit">'


        })

}