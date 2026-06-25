public class testaBanco {
    public static void main(String[] args) {

        Cliente oak = new Cliente();
        oak.nome = "Thyago Carvalho";
        oak.cpf = "123.456.789-00";
        oak.profissao = "engenheiro";

        Conta contaDoThyago = new Conta();
        contaDoThyago.deposita(1621);

        contaDoThyago.titular = oak; //assossiação de objetos

        System.out.printf("O nome do cliente é : %s%n",contaDoThyago.titular.nome);

        // atribuição direta
        Conta contaDaVitoria = new Conta();
        contaDaVitoria.titular =  new Cliente();
        contaDaVitoria.titular.nome = "Vitoria Cristina";
        System.out.printf("O nome do cliente com atribuição direta é : %s%n",contaDaVitoria.titular.nome);



    }



}
