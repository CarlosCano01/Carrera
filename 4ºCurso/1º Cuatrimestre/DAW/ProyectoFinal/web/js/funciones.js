function chekcForm() {
                var ok=true;
                var msg = "ERROR: ";
                var user = document.getElementById("user");
                var pass1 = document.getElementById("pwd1");
                var pass2 = document.getElementById("pwd2");
                if (user.value=="" || pass1.value=="" || pass2.value=="") {
                    msg = msg + "Todos los campos son obligatorios. ";
                    ok=false;
                }
                if (pass1.value !== pass2.value) {
                    msg = msg + "Passwords no coinciden. ";
                    ok=false;
                }
                if(!ok) alert(msg);
                
                return ok;
}

