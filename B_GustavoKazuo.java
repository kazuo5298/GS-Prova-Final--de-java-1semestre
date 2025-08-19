import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        //variáveis
        int idade = 0, contD = 0, contH = 0, contA = 0, contC = 0, contNecessidade = 0, contP = 0, contF = 0, contM = 0, doc = 0, crianca = 0, adole = 0, adulto = 0, idoso = 0, menorId = 0, maiorId = 0;
        char sexo, qualProb;
        String nome, resp, respG, necEsp, probS, data, nomeJovem = "", nomeVelho = "";
        double porcH, porcD, porcC, porcA;

        System.out.printf("Deseja cadastrar um novo abrigado? ");
        resp = entrada.next();


        while (!resp.equalsIgnoreCase("sim") && (!resp.equalsIgnoreCase("não"))) {
            System.out.println("Digite se deseja cadastrar um novo abrigado sim/não");
            resp = entrada.next();
        }

        while (resp.equalsIgnoreCase("sim")) {
            ++contP;


            System.out.printf("qual seu nome? ");
            nome = entrada.next().toUpperCase();

            System.out.println("qual sua idade? ");
            idade = entrada.nextInt();

            if (idade < 11) {
                crianca++;
            } else if ((idade >= 12) && (idade <= 17)) {
                adole++;
            } else if ((idade >= 18) && (idade <= 59)) {
                adulto++;
            } else {
                idoso++;
            }

            if (contP == 1) {
                menorId = idade;
                maiorId = idade;
                nomeJovem = nome;
                nomeVelho = nome;
            }

            else if (idade < menorId) {
                menorId = idade;
                nomeJovem = nome;
            } else if (idade > maiorId) {
                maiorId = idade;
                nomeVelho = nome;
            }


            System.out.printf("Qual seu sexo F/M ? ");
            sexo = entrada.next().toUpperCase().charAt(0);

            if (sexo == 'M') {
                contM++;
            } else {
                contF++;
                System.out.printf("Você é gestante sim/não ? ");
                respG = entrada.next().toUpperCase();
            }

            System.out.printf("Qual o seu documento ? ");
            doc = entrada.nextInt();

            System.out.printf("você tem nessecidades especiais sim/não ? ");
            necEsp = entrada.next();

            if (necEsp.equalsIgnoreCase("sim")) {
                contNecessidade++;

            }


            System.out.println("Você tem problemas de saúde sim/não ? ");
            probS = entrada.next();

            while (!probS.equalsIgnoreCase("sim") && (!probS.equalsIgnoreCase("não"))) {
                System.out.println("Digite se você tem problemas de saúde sim/não");
                probS = entrada.next();
            }

            if (probS.equalsIgnoreCase("sim")) {

                System.out.println("Qual a sua doença ? D-diabetes, H-hipertensão, A-asma, C-cardíacas");
                qualProb = entrada.next().toUpperCase().charAt(0);


                while ((qualProb != 'D') && (qualProb != 'H') && (qualProb != 'A') && (qualProb != 'C')) {
                    System.out.println("Digite a letra correspondente a doença, D-diabetes, H-hipertensão, A-asma, C-cardíacas ");
                    qualProb = entrada.next().toUpperCase().charAt(0);
                }
                switch (qualProb) {

                    case 'D':
                        contD++;
                        break;

                    case 'H':
                        contH++;
                        break;

                    case 'A':
                        contA++;
                        break;

                    case 'C':
                        contC++;
                        break;

                }//escolha


            }//if problema de saude


            System.out.println("qual é sua data de entrada no abrigo ? ");
            data = entrada.next();


            System.out.printf("Deseja cadastrar um novo abrigado? ");
            resp = entrada.next();

            while (!resp.equalsIgnoreCase("sim") && (!resp.equalsIgnoreCase("não"))) {
                System.out.println("Digite se deseja cadastrar um novo abrigado sim/não");
                resp = entrada.next();
            }

        }//while


        //calculo das porcentagens
        porcD = (double) contD / contP * 100;
        porcH = (double) contH / contP * 100;
        porcA = (double) contA / contP * 100;
        porcC = (double) contC / contP * 100;


        System.out.println("Porcentagem de cada doença" + "Diabetes:" + porcD + "%");
        System.out.println("Porcentagem de cada doença" + "Hipertensão:" + porcH + "%");
        System.out.println("Porcentagem de cada doença" + "Asma:" + porcA + "%");
        System.out.println("Porcentagem de cada doença" + "Cardíacas:" + porcC + "%");
        System.out.println("Número total de pessoas: " + contP + " -número de pessoas por faixa etária- " + " -crianças: " + crianca + " -adolecentes: " + adole + " -adultos: " + adulto + " -idosos: " + idoso);
        System.out.println("Nome pessoa mais jovem: " + nomeJovem + " -idade pessoa mais nova: " + menorId + " -Nome pessoa mais velha: " + nomeVelho + " -idade pessoa mais velha: " + maiorId );
        System.out.println("Número de pessoas no abrigo que precisam de necessidades especiais: " + contNecessidade);


    }//main
}//class
