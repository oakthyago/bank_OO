public class testeControctor {

    public static void main(String[] args) {

        Conta conta = new Conta(2138,70000);
        System.out.printf("Número de Agencia é %d e conta %d:", conta.getAgencia(), conta.getNumero());



    }

}
