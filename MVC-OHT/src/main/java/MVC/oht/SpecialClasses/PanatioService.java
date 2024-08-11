package MVC.oht.SpecialClasses;

import MVC.oht.EntityJPA.entityMulta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanatioService {
    public List<entityMulta> pagination (List<entityMulta> list, int nPage, int nPerpage) {

        /**
         *
         *  'nPage': Se trata do numero da pagina que o user quer buscar.
         *  'nPerpage': Se trata do numero de elementos por pagina.
         *  'n': Se trata de um parametro que ajuda a colocar somente os elementos nescessários na lista de suporte.
         *
         * **/

        int xPage = nPage;
        int n = nPerpage*nPage - nPerpage;

        List<entityMulta> listasuporte  = new ArrayList<>();

        if (nPage*nPerpage > list.size()){


            int parametroA = (nPage*nPerpage) - list.size();
            int parametroB = ((nPage*nPerpage) - parametroA) - 1;

            int sivirino = (nPage*nPerpage) - parametroA - (nPerpage * (nPage - 1));


            n = parametroB  - sivirino;


            for (int i = parametroB ; i > n; i--){

                if (list.get(i) != null){

                    listasuporte.add(list.get(i));

                }}

            Collections.reverse(listasuporte);

            return listasuporte;

        }

        else {

            for (int i = (nPage * nPerpage) - 1 ; i > n-1; i--){


                if (list.get(i) != null){

                    listasuporte.add(list.get(i));

                }}

            Collections.reverse(listasuporte);

            return listasuporte;

        }

}}
