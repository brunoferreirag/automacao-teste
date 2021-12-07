package support.Utils;

public class Proposta {

    private static String preproposta = "";
    private static String proposta = "";
    private static String cpfCnpjProponente = "";

    public static String getCpfCnpjProponente() {
        return cpfCnpjProponente;
    }

    public static void setCpfCnpjProponente(String cpfCnpjProponente) {
        Proposta.cpfCnpjProponente = cpfCnpjProponente;
    }


    public static String getPreproposta() {
        return preproposta;
    }

    public static void setPreproposta(String preproposta) {
        Proposta.preproposta = preproposta;
    }

    public static String getProposta() {
        return proposta;
    }

    public static void setProposta(String proposta) {
        Proposta.proposta = proposta;
    }

    public static void resetarProposta(){
        Proposta.preproposta = "";
        Proposta.proposta = "";
        Proposta.cpfCnpjProponente = "";
    }

}
