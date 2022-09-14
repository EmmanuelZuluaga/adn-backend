package com.example.adnprueba.adnprueba.service;

import java.util.ArrayList;
import java.util.List;

public interface AdnService {

    public ArrayList<String> hasVerticalMutation(String[] matrix) throws Exception ;
    public ArrayList<String> hasHorizontalMutation(String[] matrix) throws Exception ;
    public ArrayList<String> hasObliqueMutation(String[] matrix) throws Exception ;

    public List<String> getStateMutations(String[] matrix) throws Exception ;
}
