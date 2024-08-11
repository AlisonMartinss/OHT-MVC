package MVC.oht.EntityJPA;

import MVC.oht.Records.recordCEP;
import MVC.oht.Records.recordMulta;
import MVC.oht.SpecialClasses.servicyCEP;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Enderecamento {

    private String CEP;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String UF;



    public Enderecamento(recordCEP recordCEP) {
        this.CEP = recordCEP.cep();
        this.logradouro = recordCEP.logradouro();
        this.complemento = recordCEP.complemento();
        this.bairro = recordCEP.bairro();
        this.UF = recordCEP.uf();
    }
}
