public class HappyHour {
    private int numeroPessoas;
    private boolean temBebidaAlcoolica;
    private TipoDecoracaoEnum tipoDecoracao;
    private double custoDecoracao;
    private double custoBebida;

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
        adicionarCustoDecoracao();
        adicionarCustoBebida();
    }

    public boolean isTemBebidaAlcoolica() {
        return temBebidaAlcoolica;
    }

    public void setTemBebidaAlcoolica(boolean temBebidaAlcoolica) {
        temBebidaAlcoolica = temBebidaAlcoolica;
        adicionarCustoBebida();
    }

    public TipoDecoracaoEnum getTipoDecoracao() {
        return tipoDecoracao;
    }

    public void setTipoDecoracao(TipoDecoracaoEnum tipoDecoracao) {
        this.tipoDecoracao = tipoDecoracao;
        adicionarCustoDecoracao();
    }

    public double getCustoDecoracao() {
        return custoDecoracao;
    }

    public void setCustoDecoracao(double custoDecoracao) {
        this.custoDecoracao = custoDecoracao;
    }

    public double getCustoBebida() {
        return custoBebida;
    }

    public void setCustoBebida(double custoBebida) {
        this.custoBebida = custoBebida;
    }

    public void adicionarCustoDecoracao() {
        if (tipoDecoracao.equals(TipoDecoracaoEnum.BASICA)) {
            this.custoDecoracao = 80;
        } else if (tipoDecoracao.equals(TipoDecoracaoEnum.TEMATICA)) {
            this.custoDecoracao = 17.50 * numeroPessoas;
        } else {
            this.custoDecoracao = 40 * numeroPessoas + 120;
        }
    }

    public void adicionarCustoBebida() {
        if (this.temBebidaAlcoolica) {
            this.custoBebida = 80 * numeroPessoas;
        } else {
            this.custoBebida = 30 * numeroPessoas;
        }
    }
    public double calcularCustoTotal() {
        double custoTotal = this.custoBebida + this.custoDecoracao + 125 * this.numeroPessoas;
        if (this.temBebidaAlcoolica) {
            custoTotal = custoTotal*0.95;
        }
        return custoTotal;
    }
    public HappyHour(boolean temBebidaAlcoolica) {
        this.temBebidaAlcoolica = temBebidaAlcoolica;
        this.tipoDecoracao = TipoDecoracaoEnum.BASICA;
        adicionarCustoDecoracao();
    }

}
