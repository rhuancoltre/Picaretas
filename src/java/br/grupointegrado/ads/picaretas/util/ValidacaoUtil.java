package br.grupointegrado.ads.picaretas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoUtil {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Faz a validação de uma String retornando true ou false.<br>
     * Valida se a String não é nula e também o seu tamanho mínimo.
     *
     * @param string
     * @param tamanhoMinimo
     * @return
     */
    public static boolean validaString(String string, int tamanhoMinimo) {
        return string != null && string.trim().length() >= tamanhoMinimo;
    }
    
    /**
     * Faz a validação de uma String retornando true ou false.
     * Valida o tamanho máximo da String.
     * @param string
     * @param tamanhoMaximo
     * @return 
     */
    public static boolean validaStringMaximo(String string, int tamanhoMaximo) {
        return string.trim().length() <= tamanhoMaximo;
    }

    /**
     * Faz a validação do e-mail utilizando expressão regular. <br>
     * O e-mail precisa ter de 0 a 320 carateres e respeitar o padrão:
     * ^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$
     *
     * @param email
     * @return
     */
    public static boolean validaEmail(String email) {
        if (email == null || email.isEmpty() || email.length() > 320) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Validação padrão de senha do sistema.<br>
     * Para ser considerada válida a senha deve ter no mínimo 8 caracteres,
     * contendo letras e números.
     *
     * @param senha
     * @return
     */
    public static boolean validaSenha(String senha) {
        Pattern pl = Pattern.compile("[0-9]+");
        Pattern pn = Pattern.compile("[a-zA-Z]+");

        return validaString(senha, 8) && pl.matcher(senha).find() && pn.matcher(senha).find();
    }
    
    public static boolean validaNumeroNegativo(Float valor) {
        return valor >= 0;
    }
}
