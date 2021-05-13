package Enum;

public enum ValoresIr {
	
	CASO1(1, 0, 0, 1903.98), CASO2(7.5, 142.80, 1903.99, 2826.65), CASO3(15, 354.8, 2826.66, 3751.05), CASO4(22.5, 636.13, 3751.06, 4664.68), CASO5(27.5, 869.36, 4664.69, 0);


	private final double aliquotaIr;
	private final double valorADescontar;
	private final double condicao1;
	private final double condicao2;
	
	


	private ValoresIr(double aliquotaIr, double valorADescontar, double condicao1, double condicao2) {
		this.aliquotaIr = aliquotaIr;
		this.valorADescontar = valorADescontar;
		this.condicao1 = condicao1;
		this.condicao2 = condicao2;
	}


	public double getAliquotaIr() {
		return aliquotaIr;
	}
	public double getValorADescontar() {
		return valorADescontar;
	}
	public double getCondicao1() {
		return condicao1;
	}
	public double getCondicao2() {
		return condicao2;
	}

	
}
