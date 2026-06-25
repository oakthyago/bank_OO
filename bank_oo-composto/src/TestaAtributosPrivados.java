public class TestaAtributosPrivados {
    public static void main(String[] args) {

        Conta conta = new Conta();

        conta.deposita(1200);
        System.out.printf("Saldo da conta é %.2f",conta.logSaldo());



    }

}
