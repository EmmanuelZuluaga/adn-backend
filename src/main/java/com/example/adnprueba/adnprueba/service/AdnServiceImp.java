package com.example.adnprueba.adnprueba.service;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class AdnServiceImp implements AdnService {

    private final Integer identification=4;
    private final String A ="AAAA";
    private final String C ="CCCC";
    private final String G ="GGGG";
    private final String T ="TTTT";


    public AdnServiceImp(){

    }


    @Override
    public ArrayList<String> hasVerticalMutation(String[] matrix) throws Exception  {
        ArrayList<String> mutations = new  ArrayList<String>();

        for (int i=0;i<matrix.length;i++){
            String list=makeStringVertical(matrix,i);
            for(int j=0; j<list.length();j++){
               // System.out.println(hasSetList(list.substring(j,j+4)));
                if(j+4<=list.length()&&hasSetList(list.substring(j,j+4))){
                    mutations.add("Mutacion en dirección vertical en coordenada ("+i+","+j+")");
                    j=j+4;

                }
            }
        }
        return mutations;
    }



    @Override
    public ArrayList<String> hasHorizontalMutation(String[] matrix) throws Exception {
        ArrayList<String> mutations = new  ArrayList<String>();
        for (int i=0;i<matrix.length;i++){
            String list=matrix[i];

            for(int j=0; j<=4;j++){
                if(j+4<=list.length()&&hasSetList(list.substring(j,j+4))){
                    mutations.add("Mutacion en dirección horizontal en coordenada ("+j+","+i+")");
                    j=j+4;

                }
            }
        }
        return mutations;
    }

    @Override
    public ArrayList<String> hasObliqueMutation(String[] matrix)  throws Exception {
        ArrayList<String> mutations = new  ArrayList<String>();
        int widthAndHeight = matrix.length;

        for ( int i = 1 - widthAndHeight; i <= widthAndHeight - 1; i++) {
            String cadena="";
            for (int j = Math.max(0, i), k = -Math.min(0, i); j < widthAndHeight && k < widthAndHeight; j++,k++) {
                 cadena+=matrix[j].charAt(k);
            }
            for(int j=0; j<=4;j++){
                if(j+4<=cadena.length()&&hasSetList(cadena.substring(j,j+4))){
                    mutations.add("Mutacion en dirección oblicua en coordenada ("+j+","+i+")");
                    j=j+4;

                }
            }

        }

        return mutations;
    }



    // Aux methods -------------------------------------------------------------------------------------------

    public String makeStringVertical(String[] matrix,int index){
        String makeString="";
        for (int i=0;i<matrix.length;i++){
            makeString+=matrix[i].charAt(index);
        }

        return makeString;
    }

    public boolean hasSetList(String cadena) {
        if(cadena.equalsIgnoreCase(this.A)||cadena.equalsIgnoreCase(this.C)||
                cadena.equalsIgnoreCase(this.G)||cadena.equalsIgnoreCase(this.T)){
            return true;
        }else{
            return false;
        }

    }

    public  List<String> getStateMutations(String [] matrixs) throws Exception {
      //  String [] matrixs={"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        ArrayList<String> allMutations= new ArrayList<>();
        return  new ArrayList<String>() {{
               addAll(hasObliqueMutation(matrixs));
               addAll(hasHorizontalMutation(matrixs));
               addAll(hasVerticalMutation(matrixs));
        }};
    }



}
