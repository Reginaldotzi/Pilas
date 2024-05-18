package org.example.Pilas;

public class TextoUtil {
    public static String procesarTexto(String texto) {
        // Convertir a minúsculas
        texto = texto.toLowerCase();

        // Quitar espacios en blanco
        texto = texto.replaceAll("\\s+", "");

        // Quitar signos de puntuación, números y símbolos
        texto = texto.replaceAll("[\\p{Punct}\\d]", "");

        // Quitar acentos y tildes
        texto = texto.replaceAll("[áàäâ]", "a");
        texto = texto.replaceAll("[éèëê]", "e");
        texto = texto.replaceAll("[íìïî]", "i");
        texto = texto.replaceAll("[óòöô]", "o");
        texto = texto.replaceAll("[úùüû]", "u");

        return texto;
    }
}
