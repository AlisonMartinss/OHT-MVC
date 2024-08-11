package MVC.oht.Records;

import MVC.oht.EntityJPA.Enderecamento;
import MVC.oht.Records.Enums.Causa;
import MVC.oht.Records.Enums.Situacao;

public record recordMulta(String cep, String cpf, Causa causa, Situacao situacao, String valor, Enderecamento endereco, String codAgente, String data) {
}
