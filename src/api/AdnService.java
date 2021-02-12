package api;

public class AdnService {
	
	public Boolean isMutant(String[] dna)
	{
		int cantidadAdn = TotalHorizontal(dna) + TotalVertical(dna) + TotalDiagonal(dna);
				
		return cantidadAdn > 1;
	}
	
	  int TotalHorizontal(String[] dna)
	{
		int contadorPalabra = 0;
		int contadorTotal = 0;

		for (int i = 0; i < dna.length; i++) {

			String palabra2 = dna[i];
			char letra;
            int contadorLetra = 0;
            contadorPalabra = 0;
            
            for (int j = 0; j < palabra2.length(); j++) {

				letra = palabra2.charAt(j);

				if (palabra2.length() == j +1)
				{
					if(contadorPalabra < 3)
						contadorPalabra = 0;
					continue;
				}
				contadorLetra = j + 1;
				if (letra == palabra2.charAt(contadorLetra)) 
					contadorPalabra++;				
				else {
					if(contadorPalabra < 3)
						contadorPalabra = 0;
				}
			}
			
			if(contadorPalabra >= 3)
				contadorTotal++;
			
		}
		
		return contadorTotal;
	}
	
	  int TotalVertical(String[] dna)
	{
        char[][] arrayNuevo = new char[6][6];
		String [] arrayFinal = new String[6];
		
		for (int i = 0; i < dna.length; i++) {
			
			String palabraInicial = dna[i];
			
			for (int j = 0; j < palabraInicial.length(); j++) 
				arrayNuevo[j][i] = palabraInicial.charAt(j);			
		}
		
		for(int i = 0; i<arrayNuevo.length; i++) 
			arrayFinal[i] =new String(arrayNuevo[i]);		
		
		return TotalHorizontal(arrayFinal);
	}
	
	  int TotalDiagonal(String[] dna)
		{		 
			 char[][] arrayNuevo = new char[6][6];
				
				for (int i = 0; i < dna.length; i++) {
					
					String palabraInicial = dna[i];
					
					for (int j = 0; j < palabraInicial.length(); j++) 
						arrayNuevo[i][j] = palabraInicial.charAt(j);			
				}
				
				int contador = 0;
				int contadorTotal = 0;
				try {
					for(int i = 0; i<arrayNuevo.length; i++) {
					    for(int j = 0; j < arrayNuevo[i].length; j++) {
					    	for (int j2 = 1; j2 < arrayNuevo[i].length; j2++) {
					    		if(arrayNuevo[i].length - j <= j2)
					    		{
					    			if(contador < 3)
					            		contador = 0;
					    			continue;
					    		}
					            if(arrayNuevo[i][j] == arrayNuevo[i+j2][j+j2])
					            {
					            	contador++; 
					            }
					            else
					            {
					            	if(contador < 3)
					            		contador = 0;
					            }
					         }
					    	
					    	if(contador > 1)
					    		contadorTotal ++;
					    	
					    	contador = 0;
					    }
				}
				} catch (Exception e) 
				{
					
				}
				
				return contadorTotal;
		}
	}
