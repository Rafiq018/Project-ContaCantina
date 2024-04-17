public class ContaCantina {
    private TipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public void debitar(double valor) {
        if(tipoConta.equals(TipoContaEnum.DIRETOR)){
            this.saldo -= valor;
        }
        if (tipoConta.equals(TipoContaEnum.PROFESSOR) &&
                saldo+ limite >= valor) {
            this.saldo -= valor;
        }
        else
            System.out.println("Saldo insuficiente");
    }
    public void creditar(double valor) {
        this.saldo += valor;
        emitirAlertaSaldoBaixo();
        if(tipoConta.equals(TipoContaEnum.ALUNO))
        {
            if(valor > 100)
                this.saldo += 5;
        }
    }
    public void emitirAlertaSaldoBaixo() {
        if (this.saldo <= this.saldoMinimo) {
            System.out.println("ALERTA DE SALDO BAIXO: R$"+ saldo);

        }else {
            System.out.println("Saldo: R$" +saldo);
        }
    }
    public ContaCantina(double saldo) {
        this.saldo = saldo;
        this.tipoConta = TipoContaEnum.ALUNO;
        this.saldoMinimo = 10;
    }
    public ContaCantina(TipoContaEnum tipoConta, double saldo){
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        if (tipoConta.equals(TipoContaEnum.PROFESSOR)) {
            this.limite += 100;
        }
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
        emitirAlertaSaldoBaixo();
    }
}
