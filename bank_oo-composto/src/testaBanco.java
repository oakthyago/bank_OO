public class testaBanco {
    public static void main(String[] args) {

        Cliente oak = new Cliente();
        oak.setNome("Thyago Carvalho");
        oak.setCpf("123.456.789-00");
        oak.setProfissao("engenheiro");

        Conta contaDoThyago = new Conta(446, 37137);
        contaDoThyago.deposita(1621);

        contaDoThyago.setTitular(oak); //assossiação de objetos

        System.out.printf("O nome do cliente é : %s%n",contaDoThyago.getTitular().getNome());

        // atribuição direta
        Conta contaDaVitoria = new Conta(446, 48480);

        contaDaVitoria.setTitular(new Cliente());
        contaDaVitoria.getTitular().setNome("Vitoria Cristina");

        System.out.printf("O nome do cliente com atribuição direta é : %s%n",contaDaVitoria.getTitular().getNome());
        contaDaVitoria.getTitular().setProfissao("Enfermeira");
        System.out.printf("A profissão de %s é %s", contaDaVitoria.getTitular().getNome(),contaDaVitoria.getTitular().getProfissao());


    }



}
