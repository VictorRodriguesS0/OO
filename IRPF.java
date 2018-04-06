import javax.swing.JOptionPane;

public class IRPF {
	
	//Declaração dos atributos
	Rendimento[] rends = new Rendimento[0];
	
	
	float[] deducoes = new float[0];
	String[] descDeducoes = new String[0];
	
	int numDependentes;
	float deducaoDependente = 189.59f;
	
	float basedeCalculo;
	float[] faixas = new float[5];
	
	//metodo para cadastrar rendimentos
	boolean cadastrarRendimento() {
		boolean resposta = false;
		
		String descricao = JOptionPane.showInputDialog("Informe o nome do rendimento: ");
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor do rendimento: "));
		
		Rendimento temp = new Rendimento();
		temp.descricao = descricao;
		temp.valor = valor;
		
		
		int tamanho = rends.length;
		
		Rendimento[] tempRendimentos = new Rendimento[tamanho + 1];
		
		
		for(int i = 0; i < tamanho; i++) {
			tempRendimentos[i] = rends[i];
		}//fim da copia de vetores
		
		
		//adicionar novo rendimento
		int novaPosicao = tamanho;
		tempRendimentos[novaPosicao] = temp;
		
		rends = tempRendimentos;
		
		resposta = true;
		
		return resposta;
	}
	
	float totalRendimentos() {
		float soma = 0;
		for(Rendimento r: rends) {
			soma += r.valor;
		}
		return soma;
	}
	
	public static void main(String[] args) {
		
		//Objetos
		IRPF contribuinte1,
			 contribuinte2;
		
		contribuinte1 = new IRPF();
		contribuinte2 = new IRPF();
		
		int novoRendimento;
		do {
			contribuinte1.cadastrarRendimento();
			novoRendimento = JOptionPane.showConfirmDialog(null, 
					"Deseja cadastrar um novo Rendimento?", 
					"Novo rendimento?", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
		} while(novoRendimento == JOptionPane.YES_NO_OPTION);
		
		do {
			contribuinte2.cadastrarRendimento();
			novoRendimento = JOptionPane.showConfirmDialog(null, 
					"Deseja cadastrar um novo Rendimento?", 
					"Novo rendimento?", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
		} while(novoRendimento == JOptionPane.YES_NO_OPTION);
		
		System.out.println(contribuinte1 + ": " + contribuinte1.totalRendimentos());
		System.out.println(contribuinte2 + ": " + contribuinte2.totalRendimentos());
	}
}