package service;

import java.util.List;

public interface ListePartage {
	
	  List<List<Object>> partition(List<Object> liste, int taille);

}
