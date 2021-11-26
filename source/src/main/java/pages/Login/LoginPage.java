package pages.Login;


import lombok.extern.log4j.Log4j2;
import support.browser.BrowserManager;
import support.data.DataYaml;


import static support.report.Report.takeScreenShot;

@Log4j2
public class LoginPage extends BrowserManager {


    String txtUsuario = "#cpf";
    String txtSenha = "#senha";
    String btnAcessar = "//button[contains(text(),'acessar')]";
    String linkDirect = "img[title=\"Direct BTB\"]";

    public void realizarLogin() {
        if (page.isVisible(btnAcessar)) {
            page.type(txtUsuario, DataYaml.getMapYamlValues("Usuarios", "credenciais").get("usuario"));
            page.type(txtSenha, DataYaml.getMapYamlValues("Usuarios", "credenciais").get("senha"));
            page.click(btnAcessar);


        } else {
            log.info("Login já realizado");
       }
    }

        public void navigate (String s){
            page.navigate(s);
            takeScreenShot();
        }

    public void navigateToUrl() {
            tentarIrPara(configuration.url());
    }
}



