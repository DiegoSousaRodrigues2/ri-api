package br.com.fiap.riapi.domains;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "T_RATE_FEEDBACK")
@SequenceGenerator(name = "feedback", sequenceName = "SQ_TB_FEEDBACK", allocationSize = 1)
public class Feedback {

    @Id
    @Column(name = "cd_feedback", nullable = false, precision = 3)
    @GeneratedValue(generator = "feedback", strategy = GenerationType.SEQUENCE)
    private Integer cdFeedback;

    @Column(name = "ds_file_name")
    private String dsFileName;

    @Column(name = "cd_file_id")
    private String fileId;

    @Column(name = "ds_star")
    private Integer star;

    @Column(name = "ds_message")
    private String message;

    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "cd_aluno", nullable = false)
    private Conta conta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_sala")
    private Sala sala;

    public Integer getCdFeedback() {
        return cdFeedback;
    }

    public Feedback setCdFeedback(Integer cdFeedback) {
        this.cdFeedback = cdFeedback;
        return this;
    }

    public String getDsFileName() {
        return dsFileName;
    }

    public Feedback setDsFileName(String dsFileName) {
        this.dsFileName = dsFileName;
        return this;
    }

    public String getFileId() {
        return fileId;
    }

    public Feedback setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    public Conta getConta() {
        return conta;
    }

    public Feedback setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

    public Integer getStar() {
        return star;
    }

    public Feedback setStar(Integer star) {
        this.star = star;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Feedback setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Feedback setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Sala getCdSala() {
        return sala;
    }

    public Feedback setCdSala(Sala cdSala) {
        this.sala = cdSala;
        return this;
    }
}
