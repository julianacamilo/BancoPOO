package ProjetoBanco;

public class Main {

	public static void main(String[] args) {
		
		Cliente juliana = new Cliente();
		juliana.setNome("Juliana");
		juliana.setCPF("31323976484");
		
		Conta cc = new ContaCorrente(juliana);
		Conta poupanca = new ContaPoupanca(juliana);
		
		cc.depositar(300);
		cc.transferir(200, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	
	}
}
