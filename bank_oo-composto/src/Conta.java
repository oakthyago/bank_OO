public class Conta {
    private double saldo;
    int agencia;
    int numero;
    Cliente titular;

   public void deposita(double valor){
        this.saldo = this.saldo + valor;

   }
   public boolean saca (double valor) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            return true;

        }
        return false;

   }

   public boolean transfere (double valor, Conta destino){
       if (this.saldo >= valor){
           this.saldo = this.saldo - valor;
           destino.deposita(valor);
           return true;
       }
       return false;
           }

   public double logSaldo (){
       return this.saldo;
   }

}

