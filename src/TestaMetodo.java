public class TestaMetodo {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.saldo = 100;
        conta.deposita(200);
        //System.out.println(conta.saldo);
        boolean resultadoSaque = conta.saca(150);
        //System.out.println(conta.saldo);
        //System.out.println(resultadoSaque);
        Conta contaDoThyago = new Conta ();
        contaDoThyago.deposita(5000);
        System.out.printf("Saldo da conta 1 é R$ %.2f e da conta do Thyago é R$ %.2f%n",conta.saldo,contaDoThyago.saldo);
        boolean bool_transfere = conta.transfere(300,contaDoThyago);
        if(bool_transfere){
            System.out.println("Sucesso ao transferir");
        }else{
            System.out.println("Erro na Transação");
        }
        System.out.printf("Após transferência Saldo da conta 1 é R$ %.2f e da conta do Thyago é R$ %.2f%n",conta.saldo,contaDoThyago.saldo);

    }
}
