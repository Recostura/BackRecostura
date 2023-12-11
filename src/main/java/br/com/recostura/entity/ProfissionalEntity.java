package br.com.recostura.entity;

import br.com.recostura.enumeration.PlanoContratadoEnum;
import br.com.recostura.enumeration.ServicoContratadoEnum;
import jakarta.persistence.*;

@Entity
@Table (name = "TB_PROFISSIONAL")
public class ProfissionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String biografia;
    private ServicoContratadoEnum servicoOferecido;
    private String mediaValor;
    private PlanoContratadoEnum planoContratado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public ServicoContratadoEnum getServicoOferecido() {
        return servicoOferecido;
    }

    public void setServicoOferecido(ServicoContratadoEnum servicoOferecido) {
        this.servicoOferecido = servicoOferecido;
    }

    public String getMediaValor() {
        return mediaValor;
    }

    public void setMediaValor(String mediaValor) {
        this.mediaValor = mediaValor;
    }

    public PlanoContratadoEnum getPlanoContratado() {
        return planoContratado;
    }

    public void setPlanoContratado(PlanoContratadoEnum planoContratado) {
        this.planoContratado = planoContratado;
    }
}
