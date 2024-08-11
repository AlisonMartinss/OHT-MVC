package MVC.oht.SpecialClasses;

import MVC.oht.Records.recordCEP;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class servicyCEP {
    public recordCEP searchCEP (String CEP) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<recordCEP> resultado = restTemplate.
                getForEntity(String.format
                        ("https://viacep.com.br/ws/%s/json/",CEP), recordCEP.class);

        return resultado.getBody();

    }
}
