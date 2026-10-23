import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

//import static java.util.Arrays.*;
/**
 * Ein VideoSpiel ist ein Medium. Zusätzlich zu den Eigenschaften eines Mediums erfasst
 * sie Informationen zu den SpielLevels und entwickler.
 * 
 * @author Sayyam,Sayyam
 * @version SoSe 2026
 */
class VideoSpiel implements Medium
{
    /**
     * Ein Kommentar zum Medium
     */
    private String _kommentar;

    /**
     * Der Titel des Mediums
     */
    private String _titel;
    
    /**
     * Die Systeme , auf denen das Spiel lauffähig ist
     */
    private Set<String> _systeme;
    

    /**
     * Initialisiert ein neues Exemplar.
     * 
     * @param titel Der Titel des VideoSpiels
     * @param kommentar Ein Kommentar zu dem VideoSpiel
     * @param systeme ,auf den das Spiel lauffähig ist, müssen mit einem "," getrennt geschrieben werden.
     * 
     * @require titel != null
     * @require kommentar != null
     * @require systeme != null
     * @require systeme.length() > 0
     * @require !systeme.contains("")
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getSysteme() == systeme 
     */
    public VideoSpiel(String titel, String kommentar, String systeme)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        assert systeme != null : "Vorbedingung verletzt: systeme != null";
        assert systeme.length() > 0 : "Vorbedinung verletzt: systeme.length() > 0";
        
        _titel = titel;
        _kommentar = kommentar;
        _systeme = stringToListWandler(systeme);
    }

    @Override
    public String getMedienBezeichnung()
    {
        return "VideoSpiel";
    }

    @Override
    public String getKommentar()
    {
        return _kommentar;
    }

    @Override
    public String getTitel()
    {
        return _titel;
    }
    /**
     * Gibt die Systeme, auf den das Speil lauffähig ist.
     * 
     * @return Die Systeme des Videosspiel
     * 
     * @ensure _systeme != null
     */
    public Set<String> getSysteme()
    {
    	return _systeme;
    }
    
    /**
     * Wandle bitte als ein einziger String gegebene alle Systeme in einem List vom String und liefer sie zurück.
     * 
     * @param systeme ,auf den das Spiel lauffähig ist.
     * @return eine Liste Strings,wo alle Systeme Namen Stehen.
     */
    public Set<String> stringToListWandler(String systeme)
    {
    	assert systeme != null : "Vorbedingung verletzt: systeme != null";
    	assert systeme.length() > 0 : "Vorbedinung verletzt: systeme.length() > 0";
    	
    	systeme = systeme.toUpperCase(); // Damit es keinen Änderungen macht , ob jemand PS5 oder ps5 schreibt
    	                                 //,da die sind halt gleich
    	
    	String[] systemeArray = systeme.split(","); // Alle zusammen mit einem , getrennte Systeme als Array zusammenfassen
    	
    	List<String> temp = new ArrayList<>();
    	
    	for(String s : systemeArray)
    	{
    		if(!(s == null || s.isEmpty())) //prüfen ob da null oder "" string drin sind , wenn ja nein fügen wir
    			                            // sonst springen wir einfach zum nächsten
    		{
    			temp.add(s.trim()); //damit alle vordere und hintere leerzeichnen weg gehen!
    		}
    	}
    	return new HashSet<String>(temp); //damit alle Duplikate weg gehen
    }
    
    
//    private Set<String> stringToListWandler(String systeme)
//    {
//    	assert systeme != null : "Vorbedingung verletzt: systeme != null";
//    	assert systeme.length() > 0 : "Vorbedinung verletzt: systeme.length() > 0";
//    	
//    	systeme = systeme.toUpperCase(); // Damit es keinen Änderungen macht , ob jemand PS5 oder ps5 schreibt
//    	                                 //,da die sind halt gleich
//    	
//    	String[] systemeArray = systeme.split(","); // Alle zusammen mit einem , getrennte Systeme als Array zusammenfassen
//    	
//    	Set<String> temp = new HashSet<>(asList(systemeArray));
//    	temp.remove(null);
//    	temp.remove("");
//    	
//    	return temp; //damit alle Duplikate weg gehen
//    }
    
    /**
     * @return Die Eigenschaften der VideoSpiel
     * 
     * @ensure Result != null
     */
    public String getFormatiertenString()
    {
    	return  "VideoSpiel -\n"
    			+"Titel : "+getTitel()+"\n"
    			+"Kommentar : "+getKommentar()+"\n"
    			+"System : "+getSysteme()+"\n\n";
    }

}
