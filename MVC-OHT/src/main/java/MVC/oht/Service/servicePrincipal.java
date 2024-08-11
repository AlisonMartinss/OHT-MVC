package MVC.oht.Service;

import MVC.oht.EntityJPA.entityMulta;
import MVC.oht.Records.recordMulta;
import MVC.oht.Repository.repositoryMulta;
import MVC.oht.SpecialClasses.PanatioService;
import MVC.oht.SpecialClasses.servicyCEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Comparator;
import java.util.List;

public class servicePrincipal {
    @Autowired
    private PanatioService pagination;
    @Autowired
    private repositoryMulta repositoyMultaa;
    @Autowired
    private servicyCEP serviceCEP;

    @Transactional
    public ResponseEntity Creating(@RequestBody recordMulta multa) {
        var endereco = serviceCEP.searchCEP(multa.cep());
        var User = new entityMulta(multa,endereco);
        repositoyMultaa.save(User);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<List<entityMulta>> realiseAll (@RequestBody recordMulta recordMultaa, int nPage, int nperpage, int option){

        /** Operação responsavel por Buscar Lista e Definir Criterio (49 - 65) **/

        var listaMultas = repositoyMultaa.findByCPF(recordMultaa.cpf());

        if ( option == 1){
            listaMultas.sort(Comparator.comparing(entityMulta::getValor).reversed());
        }

        if ( option == 2){
            listaMultas.sort(Comparator.comparing(entityMulta::getData).reversed());
        }

        if ( option == 3){

            listaMultas = repositoyMultaa.findBySituacao(recordMultaa.cpf(),"PENDENDE");
        }

        if ( option == 4){
            listaMultas = repositoyMultaa.findBySituacao(recordMultaa.cpf(),"PAGO");
        }


        /** Operação responsavel por fazer Paginação (54) **/

        var resultado  = pagination.pagination(listaMultas,nPage,nperpage);

        /** As tres linhas de código a seguir trata-se da definiçõa do numero de paginas do 'Read' (58-65). **/

        double nResto = 0;
        int nPaginas = (listaMultas.size()) / nperpage;

        if ( ((listaMultas.size()) % nperpage) != 0){
            nResto = 1;
        }

        int npag = nPaginas + (int)nResto;


        /** Criação Do cabeçalho, onde vai o n pagina **/

        var head = new HttpHeaders();

        head.add("Numero-de-Paginas",String.valueOf(npag));


        return new ResponseEntity<>(resultado,head, HttpStatus.OK);
    }
}
