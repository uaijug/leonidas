package br.com.uaijug.leonidas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        // String padrao =
        // ("(0[1-9]|[12][0-9]|3[01])[-  /.](0[1-9]|[0-9]|1[012])[-  /.]((19|20)\\d\\d)[  ](0[0-9]|1[0-9]|2[0-3])[-  :.]([0-5][0-9])[-  :.]([0-5][0-9])");
        // String texto = "01/11/2010  23:40:40";

        /*
         * String padrao = "\w{1,20}@\w{3,20}\.\w{2,6}.{0,1}\w{0,2}"; String
         * texto = "";
         * 
         * if (texto.matches(padrao) == false) { System.out.println("invalido");
         * } else System.out.println("valido");
         */

        String input = "User clientId=23421. Some more text clientId=33432. This clientNum=100";

        Pattern p = Pattern.compile("(clientId=)(\\d+)");
        Matcher m = p.matcher(input);

        // StringBuffer result = new StringBuffer();
        while (m.find()) {
            System.out.println("cliente: " + m.group(2));
            // m.appendReplacement(result, m.group(1) + "***masked***");
        }
        // m.appendTail(result);
        // System.out.println(result);
    }
}
