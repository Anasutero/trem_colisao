package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double posicaoA;
        double posicaoB;
        double velocidadeA;
        double velocidadeB;

        double t;
        int hora =17;

        // variaveis de saida
        double posicao = 0.0, tempo = 0.0, horas = 0.0, minuto = 0, segundo = 0;
        String horario = "";
        // tempo = o instante que colidiu em segundos
        // hora = horario de partida
        // horario = hora de colisão formatada


        Scanner leitura = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("\n---Closão de trens---");
        System.out.println("ALERTA: As extremidades da ferrovia vão do KM 0 até o KM 10.000");


        while (continuar) {
            try {
                System.out.println("\nInsira a posição  do trem A:");
                posicaoA = leitura.nextDouble();

                //  criação do while para dar para repetir novamente o input e caso ele erre oq foi pedido
                while (posicaoA < 0 || posicaoA > 10000) {
                    System.out.println("No programa so é aceito posição entre 0 a 10.000km");
                    System.out.println("Insira novamente o valor da posição A:");
                    posicaoA = leitura.nextDouble();
                }
                System.out.println("O valor da posição A foi armazenado!");


                System.out.println("\nInsira a posição do trem B:");
                posicaoB = leitura.nextDouble();

                while (posicaoB < 0 || posicaoB > 10000) {
                    System.out.println("No programa so é aceito posição entre 0 a 10.000km");
                    System.out.println("Insira o valor novamente da posiçãço B:");
                    posicaoB = leitura.nextDouble();
                }
                System.out.println("O valor da posição B foi armazenado!");


                System.out.println("\nInsira o valor da velocidade A:");
                velocidadeA = leitura.nextDouble();

                while (velocidadeA < 0 || velocidadeA > 300) {
                    System.out.println("A velocidade do trem A deve ser POSITIVA e não deve ultrapassar 300KM.");
                    System.out.println("Insira a velocidade do trem A novamente:");
                    velocidadeA = leitura.nextDouble();
                }
                System.out.println("A velocidade do trem A foi armazenada!");


                System.out.println("\nInsira a velocidade do trem B:");
                velocidadeB = leitura.nextDouble();

                while (velocidadeB > 0 && velocidadeB > -300) {
                    System.out.println("A velocidade do trem B deve ser NEGATIVA e não deve ultrapassar -300km");
                    System.out.println("Insira a velocidade do trem B novamente:");
                    velocidadeB = leitura.nextDouble();
                }
                System.out.println("A velocidadde do trem B foi armazenada!");
                if ((velocidadeA == 0 && velocidadeB == 0) || posicaoA > posicaoB) {
                    System.out.println("\nOs trens não se colidem.");
                }

                //Calculo do tempo:
                t =(posicaoA - posicaoB) / (velocidadeB -velocidadeA);

                //Calculo da colisão dos trens:
                posicao = posicaoA +(velocidadeA * t);

                //conversão de horas para segundos, para apresentar:
                tempo=  t * 3600;

                // horario de colisão
                horas = t + hora;
                minuto = (tempo/60) %60;
                segundo = tempo % 60;

                //formatação da string hora
                horario = String.format("%02.0f:%02.0f:%02.0f", horas, minuto, segundo);


                System.out.printf("\nA colisão de trens acontecerá no KM %2.0f e ocorrerá após %2.0f segundos " +
                        "no horario de %s \n", posicao, tempo, horario);

            } catch (InputMismatchException e) {
                System.out.println("Ops.. você digitou caracteres.Precisamos que digite apenas numeros.");
                leitura.nextLine();//para limprar o buffer e continuar o programa
            }
            System.out.print("\nDeseja: \n1. Rodar novamente\n2.Encerrar programa \nEscolha uma opção (1/2): ");
            int opcao = leitura.nextInt();
            switch (opcao) {
                case 1:
                    continuar = true;
                    break;
                case 2:
                    continuar = false;
                    System.out.println("\nFIM DO PROGRAMA!.");
                    break;
                default:
                    System.out.println("Opção inválida. Encerrando o programa.");
                    continuar = false;
                    break;
            }

        }
    }
}