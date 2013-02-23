package helpers.Pontuacao;

import java.util.Comparator;
import java.util.Map;

import models.Projeto;

public class PontuacaoComparator implements Comparator<Projeto>{

	 Map<Projeto, Integer> base;
	    public PontuacaoComparator(Map<Projeto, Integer> base) {
	        this.base = base;
	    }

	    @Override
		public int compare(Projeto o1, Projeto o2) {
		 if (base.get(o1) >= base.get(o2)) {
	            return -1;
	        } else {
	            return 1;
	        }
		}
}
