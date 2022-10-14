import java.util.Arrays;

public class Main {
    public static String caracteres = "abcdefghijklmnopqrstuvwxyz";

    public static String clave = "GVFH YGI";
    public static Character[][] tabla = new Character[caracteres.length()][caracteres.length()];

    public static void main(String[] args) {
        ingresarTodasLasLetrasALaTabla();
        String mensaje = "AEIS GOD";
        String fraseEncriptada = encriptarFrase(mensaje, clave);
        System.out.println(fraseEncriptada);

        String mensajeNuevo = "Revisen los ejemplos XD";

        String fraseEncriptadaAleatoriamente[] = encriptarFraseAleatoriamente(mensajeNuevo);
        System.out.println(Arrays.toString(fraseEncriptadaAleatoriamente));

        //fraseEncriptadaAleatoriamente[0] = mensajeEncriptado
        //fraseEncriptadaAleatoriamente[1] = clave

        String franseDesencriptada = desencriptarFrase(fraseEncriptadaAleatoriamente[0], fraseEncriptadaAleatoriamente[1]);

        System.out.println(franseDesencriptada);

    }

    private static String desencriptarFrase(String mensajeEncriptado, String clave) {
        String mensajeDesencriptado = "";
        for (int i = 0; i < mensajeEncriptado.length(); i++) {
            if (mensajeEncriptado.charAt(i) == ' ') {
                mensajeDesencriptado += " ";
            }
            for (int j = 0; j < caracteres.length(); j++) {
                if (clave.charAt(i) == tabla[0][j]) {
                    for (int k = 0; k < caracteres.length(); k++) {
                        if (mensajeEncriptado.charAt(i) == tabla[k][j]) {
                            mensajeDesencriptado += tabla[k][0];
                        }
                    }
                    break;
                }
            }
        }
        return mensajeDesencriptado;
    }

    private static String[] encriptarFraseAleatoriamente(String mensaje) {
        String claveGenerada = "";
        for (int i = 0; i < mensaje.length(); i++) {
            if (mensaje.charAt(i) == ' ') {
                claveGenerada += " ";
                continue;
            }
            //Para conseguir un número entero entre M y N con M menor que N y ambos incluídos, debes usar esta fórmula
            //valorEntero = Math.floor(Math.random()*(N-M+1)+M);
            int valorAleatorio = (int) Math.floor(Math.random() * ((caracteres.length() - 1) - 0 + 1) + 0);
            claveGenerada += caracteres.charAt(valorAleatorio);
        }

        return new String[]{encriptarFrase(mensaje, claveGenerada), claveGenerada};
    }

    private static String encriptarFrase(String mensaje, String clave) {
        String mensajeEncriptado = "";
        mensaje = mensaje.toLowerCase();
        clave = clave.toLowerCase();
        for (int i = 0; i < mensaje.length(); i++) {
            if (mensaje.charAt(i) == ' ') {
                mensajeEncriptado += " ";
                continue;
            }

            int indiceDeLaLetraDelMensajeEnLaListaDeLetras = caracteres.indexOf(mensaje.charAt(i));
            int indiceDeLaLetraDeLaClaveEnLaListaDeLetras = caracteres.indexOf(clave.charAt(i));
            int numeroDeCaracteresTotales = caracteres.length();

            int indiceDeLaLetraALaQueSeTransforma = (indiceDeLaLetraDelMensajeEnLaListaDeLetras + indiceDeLaLetraDeLaClaveEnLaListaDeLetras) % numeroDeCaracteresTotales;

            mensajeEncriptado += caracteres.charAt(indiceDeLaLetraALaQueSeTransforma);
        }
        return mensajeEncriptado;
    }

    private static void ingresarTodasLasLetrasALaTabla() {
        for (int i = 0; i < caracteres.length(); i++) {
            String aux = caracteres.substring(i) + caracteres.substring(0, i);
            for (int j = 0; j < caracteres.length(); j++) {
                tabla[i][j] = aux.charAt(j);
            }
        }
    }
}