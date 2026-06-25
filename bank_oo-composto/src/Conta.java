public class Conta {
    private double saldo;
    private int agencia;
    private String digitoVerificador;
    private int numero;
    private Cliente titular;

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

    public void setAgencia(int numeroAgencia) {
        if (numeroAgencia <= 0) {
            throw new IllegalArgumentException("Agência deve ser um número positivo");
        }
        this.agencia = numeroAgencia;
        this.digitoVerificador = calculaDigitoVerificador(numeroAgencia);
    }

    public void setCliente (String nomeCliente){

    }

    public int getAgencia() {
        return this.agencia;
    }

    public String getDigitoVerificador() {
        return this.digitoVerificador;
    }

    public String getAgenciaCompleta() {
        return this.agencia + "-" + this.digitoVerificador;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    private String calculaDigitoVerificador(int numeroAgencia) {
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

}
