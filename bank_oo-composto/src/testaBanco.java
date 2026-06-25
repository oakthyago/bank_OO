public class testaBanco {
    public static void main(String[] args) {
        Cliente oak = new Cliente();
        oak.nome = "Oak Thyago";
        oak.cpf = "123.456.789-00";
        oak.profissao = "engenheiro";

        Conta contaDoThyago = new Conta();
        contaDoThyago.deposita(1621);
        contaDoThyago.titular = oak;
        System.out.printf("O nome do cliente é : %s%n",contaDoThyago.titular.nome);



    }



}
