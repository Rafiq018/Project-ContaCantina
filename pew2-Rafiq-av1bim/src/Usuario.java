import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {
    private String nome;
    private String senha;
    private int tentativasAcesso;
    private boolean primeiroAcesso;
    private StatusUsuarioEnum status;
    private LocalDateTime dataInativacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (status.equals(StatusUsuarioEnum.ATIVO)) {
            this.senha = senha;
            this.primeiroAcesso = false;
            this.status = StatusUsuarioEnum.ATIVO;
            this.tentativasAcesso = 0;
            this.dataInativacao = null;

        }
        this.senha = senha;
    }

    public int getTentativasAcesso() {
        return tentativasAcesso;
    }

    public void setTentativasAcesso(int tentativasAcesso) {
        this.tentativasAcesso = tentativasAcesso;
    }

    public boolean isPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public void setPrimeiroAcesso(boolean primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }

    public StatusUsuarioEnum getStatus() {
        return status;
    }

    public void setStatus(StatusUsuarioEnum status) {
        this.status = status;
    }

    public LocalDateTime getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(LocalDateTime dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public void inativar() {
        this.primeiroAcesso = false;
        this.status= StatusUsuarioEnum.ATIVO;
        this.dataInativacao = LocalDateTime.now();

    }
    public void desbloquear() {
        this.senha = "etec#123";
        this.primeiroAcesso = false;
        this.status = StatusUsuarioEnum.ATIVO;
    }

    public String autenticar(String senha) {
        if (status.equals(StatusUsuarioEnum.INATIVO) || status.equals(StatusUsuarioEnum.ATIVO)) {
            return "Acesso Negado";
        }
        if (this.tentativasAcesso >= 3) {
            return "Acesso Negado";

        }
        if (senha.equals(this.senha)) {
            this.tentativasAcesso=0;
            return "Acesso Liberado";
        }
        return senha;
    }

    public Usuario() {
        this.senha = "etec#123";
        this.primeiroAcesso = true;
        this.status = StatusUsuarioEnum.ATIVO;

    }
}
