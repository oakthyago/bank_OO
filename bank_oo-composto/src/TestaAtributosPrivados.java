public class TestaAtributosPrivados {
    public static void main(String[] args) {

        Conta conta = new Conta();

        conta.deposita(1200);
        System.out.printf("Saldo da conta é %.2f%n", conta.getSaldo());

        // Teste do dígito verificador (módulo 11 do BB)
        // Para a agência 1234, o DV correto é 3 -> esperado "1234-3"
        conta.setAgencia(446);
        System.out.println("Agência completa: " + conta.getAgenciaCompleta());
        System.out.println("Esperado: 446-4");

        // Teste da validação: agência <= 0 deve lançar exceção
        try {
            conta.setAgencia(-5);
            System.out.println("ERRO: deveria ter recusado agência negativa");
        } catch (IllegalArgumentException e) {
            System.out.println("OK, recusou agência inválida: " + e.getMessage());
        }
    }

}
