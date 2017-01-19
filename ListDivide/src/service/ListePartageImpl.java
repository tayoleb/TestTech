package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by letayo on 1/16/17.
 */
public class ListePartageImpl implements ListePartage {

	
    /**
     * divide a list into lists of n size
     *
     * @param liste  : The original list
     * @param taille : The size of the sub lists
     * @return : A list of sub lists
     */
		@Override
		public List<List<Object>> partition(List<Object> liste, int taille) {
        List<List<Object>> outputPartitions = new ArrayList<>();
        int sizeOriginalList = liste.size();

        if ((taille <= 0) || (sizeOriginalList < taille)) {
            throw new IllegalArgumentException("Unable to divide the original list.");
        } else {
            int index = 0;
            int nbIterations = sizeOriginalList / taille;
            for (int i = 0; i < nbIterations; i++) {
                outputPartitions.add(new ArrayList<>(liste.subList(index, taille + index)));
                index += taille;
            }

            int modulo = sizeOriginalList % taille;
            if (modulo != 0) {
                outputPartitions.add(new ArrayList<>(liste.subList(liste.size() - modulo, sizeOriginalList)));
            }
        }
        return outputPartitions;
    }

}

