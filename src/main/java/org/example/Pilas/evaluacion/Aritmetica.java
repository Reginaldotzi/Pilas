package org.example.Pilas.evaluacion;


import org.example.Pilas.PilaLineal;

public class Aritmetica {



    //evaluar una expresión aritmética
    public static int evaluar(String expresion) throws Exception {
        PilaLineal operandos = new PilaLineal();
        PilaLineal operadores = new PilaLineal();
        int resultado = 0;
        int operando1, operando2;
        char operador;
        int i = 0;


        //recorre la expresion y categoriza los operadores
        while (i < expresion.length()){
            if (expresion.charAt(i) == ' '){
                i++;

            } else if (expresion.charAt(i) == '+' || expresion.charAt(i) == '-' || expresion.charAt(i) == '*' || expresion.charAt(i) == '/'){
                operadores.insertar(expresion.charAt(i));
                i++;
            } else { //insertar operando
                String numero = "";
                while (i < expresion.length() && expresion.charAt(i) != ' ' && expresion.charAt(i) != '+' && expresion.charAt(i) != '-' && expresion.charAt(i) != '*' && expresion.charAt(i) != '/'){
                    numero += expresion.charAt(i); //concatena los digitos
                    i++;
                }
                operandos.insertar(Integer.parseInt(numero));
            }
        }

        while (!operadores.pilaVacia()){
            try {
                operando2 = (int) operandos.quitar();//Quita los operando
                operando1 = (int) operandos.quitar();
                operador = (char) operadores.quitar();
                switch (operador){
                    case '+':
                        resultado = operando1 + operando2; //realiza las operaciones
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                }
                operandos.insertar(resultado); //inserta los resultados
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }
}
