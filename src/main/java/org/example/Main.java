package org.example;

import org.example.Pilas.PilaLineal;

public class Main {

    public static void main(String[] args) {
        // Palabras de prueba
        String[] palabras = {"oso", "Anita lava la tina", "Roma", "amor", "A man a plan a canal Panama",
                "Madam", "Racecar", "No lemon no melon", "Was it a car or a cat I saw",
                "Never odd or even", "Eva can I see bees in a cave", "Red rum sir is murder",
                "Yo hago yoga hoy", "A Santa lived as a devil at NASA", "No 'x' in Nixon"};

        // Procesar cada palabra
        for (String palabra : palabras) {
            String procesada = TextoUtil.procesarTexto(palabra);
            System.out.println("Original: " + palabra);
            System.out.println("Procesada: " + procesada);
            probarPalindromo(procesada);
            System.out.println();
        }
    }

    public static void probarPalindromo(String palabra) {
        PilaLineal pila = new PilaLineal();
        StringBuilder palabraInvertida = new StringBuilder();

        // Crear la pila con la palabra
        for (int i = 0; i < palabra.length(); i++) {
            try {
                pila.insertar(palabra.charAt(i));
            } catch (Exception ex) {
                System.out.println("Problema al insertar! " + ex.getMessage());
            }
        }

        // Comprobar si es palíndromo
        while (!pila.pilaVacia()) {
            try {
                palabraInvertida.append(pila.quitar());
            } catch (Exception ex) {
                System.out.println("Error comprobando! " + ex.getMessage());
            }
        }

        if (palabraInvertida.toString().equals(palabra)) {
            System.out.println("Sí, es un palíndromo");
        } else {
            System.out.println("No, no lo es");
        }
    }
}

class TextoUtil {
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
