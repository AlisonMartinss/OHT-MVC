package MVC.oht.EntityJPA;

import MVC.oht.Records.Enums.Causa;
import MVC.oht.Records.Enums.Situacao;
import MVC.oht.Records.recordCEP;
import MVC.oht.Records.recordMulta;
import MVC.oht.SpecialClasses.servicyCEP;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "informacoes_cidadao")
@Entity(name = "Informacoes_cidadao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "RU")
public class entityMulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String RU;

    @Enumerated(EnumType.STRING)
    private Causa ocorrido;

    private String codAgente;

    private String data;

    private String valor;

    @Embedded
    private Enderecamento endereco;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private String CPF;

    public entityMulta(recordMulta multa, recordCEP recordCEP) {
        this.CPF = multa.cpf();
        this.codAgente = multa.codAgente();
        this.data = multa.data();
        this.ocorrido = multa.causa();
        this.situacao = multa.situacao();
        this.valor = multa.valor();
        this.endereco = new Enderecamento(recordCEP);
    }
}
