package MVC.oht.EntityJPA;

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
}
