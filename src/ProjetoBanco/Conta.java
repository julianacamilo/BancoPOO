package ProjetoBanco;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		System.out.println("Realizando Saque:");
	        System.out.println("- Saldo Anterior: "+ this.saldo);

	        if(valor < this.saldo){ //caso tenha saldo
	            this.saldo -= valor;
	        System.out.println("Saldo Posterior: "+ this.saldo);
	        }        
	        else{//caso não tenha saldo
	            System.out.println("Saldo Insuficiente");
	        }
		
	}

	@Override
	public void depositar(double valor) {
		
		 System.out.println("Realizando Depósito:");
	        System.out.println("- Saldo Anterior: "+ this.saldo);

	        this.saldo += valor; //this.saldo = this.saldo + valor
	        
	        System.out.println("Saldo Poterior:"+ this.saldo);
	      
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
	
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

}
