public class testeControctor {

    public static void main(String[] args) {

        Conta conta = new Conta(446,37137);
        System.out.printf("Número de Agencia: %s, conta: %s%n", conta.getAgenciaCompleta(), conta.getNumeroCompleta());
        System.out.println(conta.getTotal());

        Conta conta2 = new Conta(446,48480);
        System.out.printf("Número de Agencia: %s, conta: %s%n", conta2.getAgenciaCompleta(), conta2.getNumeroCompleta());
        System.out.println(conta.getTotal());


    }

}
