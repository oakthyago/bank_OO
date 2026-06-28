public class testeControctor {

    public static void main(String[] args) {

        Conta conta = new Conta(2138,70000);
        System.out.printf("Número de Agencia é %s e conta %s:", conta.getAgenciaCompleta(), conta.getNumeroCompleta());



    }

}
