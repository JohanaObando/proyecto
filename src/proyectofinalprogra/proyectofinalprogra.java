/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalprogra;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class proyectofinalprogra {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int i;
        int j;
        int seguir;
        int suma[];
        suma = new int[4];
        
        Integer MATRICULA = 23000;
        int continuar = 1;
        int ingreso, carrera, curso, prograI, mateII, cantidadDeCursos, totalAPAgar, beca, reporteTotal, totalTecnologia, totalElectronica,
                totalCursosTecnologia, totalCursosElectronica, totalDineroElectronica, totalDineroTecnologia, descuento, 
                reporteTotalPersonas,reporteTotalCursos;
        String tieneRequisito, horario, nombre, cedula;
        List<String> cursosMatriculados = new ArrayList<>();

        ingreso = 0;
        carrera = 0;
        curso = 1;
        cantidadDeCursos = 0;
        prograI = 0;
        mateII = 0;
        totalAPAgar = 0;
        beca = 0;
        tieneRequisito = "x";
        horario = "h";
        reporteTotal = 0;
        totalTecnologia = 0;
        totalElectronica = 0;
        totalCursosTecnologia = 0;
        totalCursosElectronica = 0;
        totalDineroElectronica = 0;
        totalDineroTecnologia = 0;
        descuento = 0;
        reporteTotalPersonas = 0;
        reporteTotalCursos = 0;
        
        System.out.println(ANSI_PURPLE + "//////////////////////////////SISTEMA DE MATRICULA////////////////////////////" + ANSI_RESET );
        System.out.println("");
        System.out.print("Digite (1) Ingresar ESTUDIANTE PRIMER INGRESO , (2)  ESTUDIANTE REGULAR: ");
        ingreso = entrada.nextInt();
                 
        System.out.println("");        
        System.err.println(ANSI_CYAN + "            --------> Inicio Sistema de Matrícula  <-----------" + ANSI_RESET);
        System.err.println(ANSI_CYAN + "               -------->  ESTUDIANTE REGULAR   <---------" + ANSI_RESET);
        System.err.println("");
        while (continuar > 0) {
            cursosMatriculados = new ArrayList<>();
            cantidadDeCursos = 0;

            System.out.print("Ingrese nombre del estudiante: ");
            nombre = entrada.next();
            System.out.print("Ingrese número de cédula: ");
            cedula = entrada.next();
            System.out.print("Ingrese el código de carrera: ( 1=Tecnología de la Información )( 2=Electrónica ): ");
            carrera = entrada.nextInt();
            curso = 1;
            if (carrera == 1) { // Tecnología de  la Información

                while (curso > 0) {
                    System.out.println("");
                    System.out.print("Digite el curso a matricular: ( 1=Programación I )( 2=Matemática II ), (0) Salir: ");
                    curso = entrada.nextInt();

                    switch (curso) {
                        case 1:
                            if (tieneRequisito("                       //Curso asignado: PROGRAMACIÓN I//", "TI-111,TI-112,TI-113")) {
                                horario = pedirInfoHorario();
                                cursosMatriculados.add("Programación");
                                cantidadDeCursos++;
                            }
                            break;

                        case 2:
                            if (tieneRequisito("                       //Curso asignado: MATEMÁTICA II//", "M-114")) {
                                horario = pedirInfoHorario();
                                cursosMatriculados.add("Matemática");
                                cantidadDeCursos++;
                            }
                            break;

                        default: {

                        }
                    }
                }
            } else if (carrera == 2) { // electronicas
                while (curso > 0) {
                    System.out.println("");
                    System.out.print("Digite el curso a matricular:( 1=Circuitos II )( 2=Fisica II ), (0) para Salir: ");
                    curso = entrada.nextInt();

                    switch (curso) {
                        case 1:
                            if (tieneRequisito("                   //Curso asignado: CIRCUITOS II//", "C-110")) {
                                horario = pedirInfoHorario();
                                cursosMatriculados.add("Circuitos");
                                cantidadDeCursos++;
                            }
                            break;

                        case 2:
                            if (tieneRequisito("                   //Curso asignado: FÍSICA II//", "F-122")) {
                                horario = pedirInfoHorario();
                                cursosMatriculados.add("Fisica");
                                cantidadDeCursos++;
                            }
                            break;

                        default: {

                        }

                    }
                }

            }
            System.out.print("¿Tipo de beca del estudiante:(10%, 50%, 100%)? SINO digitar Cero(0): ");
            beca = entrada.nextInt();
            
            if (beca > 0) {
                
                totalAPAgar = 23000 * cantidadDeCursos;
                descuento = (totalAPAgar * beca)/100;
                totalAPAgar = totalAPAgar - descuento;
                
            } else {
                totalAPAgar = (23000 * cantidadDeCursos);
            }

            totalAPAgar += MATRICULA;
            
            System.out.println("");
            System.out.println("          /////////REPORTE DE MATRÍCULA//////////");
            System.out.println("Estudiante: " + nombre);
            System.out.println("Cédula: " + cedula);
            System.out.println("Carrera: " + obtenerNombreCarrera(carrera));
            System.out.println("Cursos: " + obtenerCursosMatriculados(cursosMatriculados));
            System.out.println("Horario: " + horario);
            System.out.println(ANSI_RED + "MONTO A PAGAR -------------------------- : " + totalAPAgar + ANSI_RESET);
            System.out.println("///////////////////////////////////////////////////");
            System.out.println("");
            System.out.print("---------- ¿Desea ingresar otro estudiante? (1=Si) , (0=No) ----------: ");
            continuar = entrada.nextInt();
            System.out.println("");
            System.out.println("");

            if (carrera == 1) {
                totalTecnologia++;
                totalCursosTecnologia += cantidadDeCursos;
                totalDineroTecnologia += totalAPAgar;
            } else if (carrera == 2) {
                totalElectronica++;
                totalCursosElectronica += cantidadDeCursos;
                totalDineroElectronica += totalAPAgar;
            }

            reporteTotal = totalAPAgar + reporteTotal;
            reporteTotalPersonas = totalTecnologia + totalElectronica;
            reporteTotalCursos = totalCursosTecnologia + totalCursosElectronica;
        }
        System.out.println("                       REPORTE TOTAL");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("MATRICULA       Personas        Cursos         Total");
        System.out.println("Tecnología:        " + totalTecnologia + "              " + totalCursosTecnologia  +           "            " + totalDineroTecnologia);
        System.out.println("Electrónica        " + totalElectronica + "              " + totalCursosElectronica +          "            " + totalDineroElectronica);
        System.out.println("TOTAL:             " + reporteTotalPersonas+ "           " + reporteTotalCursos + "            " + reporteTotal);
        System.out.println("");
        System.err.println("----------------------------------------------------------------------");
    }

    static boolean tieneRequisito(String texto, String requisitos) {
        Scanner entrada = new Scanner(System.in);
        String tieneRequisito = "";
        System.out.print("¿El estudiante cumple los requisitos (" + requisitos + ")? Digite S(sí), N(no): ");
        tieneRequisito = entrada.nextLine();
        if (tieneRequisito.toUpperCase().equals("S")) {
            System.out.print(texto);
            System.out.println(" ");
            return true;
        } else {
            System.out.print("                       ¡¡¡Curso NO Asignado!!!");
            System.out.println(" ");
            return false;
        }
    }

    static String pedirInfoHorario() {
        Scanner entrada = new Scanner(System.in);
        String horario = "";

        System.out.print("Digite el horario que desea (m=mañana) (n=noche): ");
        horario = entrada.next();
        if (horario.toLowerCase().equals("m")) {
            System.out.print("Horario asignado: Mañana");
        } else if (horario.toLowerCase().equals("n")) {
            System.out.print("Horario asignado: Noche");
        }
        System.out.println(" ");
        return horario;
    }

    static String obtenerCursosMatriculados(List<String> cursos) {
        String resultado = "";

        for (int i = 0; i < cursos.size(); i++) {
            resultado = "*" + cursos.get(i) + " " + resultado;
        }

        return resultado;
    }

    static String obtenerNombreCarrera(int carreraId) {
        String resultado = "";
        switch (carreraId) {
            case 1:
                resultado = "Tecnología de la Información";
                break;
            case 2:
                resultado = "Electrónica";
                break;
        }
        return resultado;
    }

}

