public class Conta {
    private double saldo;

    private int agencia;
    private String digitoVerificadorAgencia;
    private String digitoVerificadorNumero;
    private int numero;
    private Cliente titular;
    private static int total; // contador da classe conta

    public Conta (int age, int conta){
        this.setAgencia(age);
        this.setNumero(conta);
        total +=1;

    }
    public int getTotal(){
        return this.total;
    }


    public Cliente getTitular() {return this.titular;}



    public void setCliente(String nomeCliente) {

    }

    public int getAgencia() { return this.agencia; }
    public int getNumero() {return this.numero;}

    public void deposita(double valor) {
        this.saldo = this.saldo + valor;
    }

    public boolean saca(double valor) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            return true;
        }
        return false;
    }

    public boolean transfere(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            destino.deposita(valor);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getDigitoVerificadorAgencia() {
        return this.digitoVerificadorAgencia;
    }
    public String getDigitoVerificadorNumero() {
        return this.digitoVerificadorNumero;
    }


    private void setAgencia(int numeroAgencia) {
        if (numeroAgencia <= 0) {
            throw new IllegalArgumentException("Agência deve ser um número positivo");
        }
        this.agencia = numeroAgencia;
        this.digitoVerificadorAgencia = calculaDigitoVerificador(numeroAgencia);
    }

    // tornar setNumero privado impede modificar o numero da conta fora da classe conta
    private void setNumero (int numeroConta){
        if (numeroConta <= 0){
            throw new IllegalArgumentException("Número da conta deve ser positivo");
        }
        this.numero = numeroConta;
        this.digitoVerificadorNumero = calculaDigitoVerificador(numeroConta);



    }

    private String calculaDigitoVerificador ( int numeroAgencia){
            int soma = 0;
            int peso = 2;
            while (numeroAgencia > 0) {
                int digito = numeroAgencia % 10;
                soma += digito * peso;
                numeroAgencia /= 10;
                peso++;
                if (peso > 9) {
                    peso = 2;
                }
            }
            int dv = 11 - (soma % 11);
            if (dv == 10) {
                return "X";
            }
            if (dv == 11) {
                return "0";
            }
            return String.valueOf(dv);
    }

    public String getAgenciaCompleta() {
        return this.agencia + "-" + this.digitoVerificadorAgencia;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public String getNumeroCompleta() {
        return this.numero + "-" + this.digitoVerificadorNumero;
    }






}