package pacoteEnum;

public enum ValoresInss {
	 CASO1(1, 0, 0, 1903.98), CASO2(7.5, 0, 1903.99, 2826.65), CASO3(9, 16.5, 2826.66, 3751.05), CASO4(12, 82.51, 3751.06, 4664.68), CASO5(14, 148.72, 4664.69, 0);

	private final double aliquotaInss;
	private final double valorADescontar;
	private final double condicao1;
	private final double condicao2;
	

	private ValoresInss(double aliquotaInss, double valorADescontar, double condicao1, double condicao2) {
		this.aliquotaInss = aliquotaInss;
		this.valorADescontar = valorADescontar;
		this.condicao1 = condicao1;
		this.condicao2 = condicao2;
	}

	
	public double getAliquotaIr() {
		return aliquotaInss;
	}
	public double getValorADescontar() {
		return valorADescontar;
	}public double getAliquotaInss() {
		return aliquotaInss;
	}public double getCondicao1() {
		return condicao1;
	}
	public double getCondicao2() {
		return condicao2;
	}

	
	
}
