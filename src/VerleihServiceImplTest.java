import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
//Die in den Testfällen verwendeten assert-Anweisungen werden über
//einen sogenannten statischen Import bereitgestellt, zum Beispiel:
//import static org.junit.Assert.assertEquals;
//
// Um die Annotation @Test verwenden zu können, muss diese importiert
// werden: import org.junit.Test;

/**
 * Diese Klasse testet die Implementation des VerleihService.
 */
public class VerleihServiceImplTest
{
    private Kunde _homer;
    private Kunde _roger;
    private Kunde _brian;
    private KundenstammService _kundenstamm;

    private Medium _abbey;
    private Medium _bad;
    private Medium _shape;
    private MedienbestandService _medienbestand;

    private VerleihServiceImpl _verleihService;

    public VerleihServiceImplTest()
    {
        setUpKunden();
        setUpMedien();
        setUpVerleihService();
    }

    @Test
    // Alle Testmethoden erhalten die Annotation @Test. Dafür müssen diese nicht
    // mehr mit test im Namen beginnen. Dies wird jedoch aus Gewohnheit
    // oft weiter verwendet.
    public void testKundenstamm()
    {
        assertTrue(_verleihService.kundeImBestand(_homer));
        assertTrue(_verleihService.kundeImBestand(_roger));
        assertTrue(_verleihService.kundeImBestand(_brian));

        Kunde marge = new Kunde(Kundennummer.get(123459), "Marge", "Bouvier");
        assertFalse(_verleihService.kundeImBestand(marge));
    }

    @Test
    public void testAmAnfangIstNichtsVerliehen()
    {
        assertTrue(_verleihService.sindAlleNichtVerliehen(_medienbestand
                .getMedien()));
        for (Kunde kunde : _kundenstamm.getKunden())
        {
            assertTrue(_verleihService.istVerleihenMoeglich(kunde,
                    _medienbestand.getMedien()));
        }
    }

    @Test
    public void testVerleihAn() 
    {
    	List<Medium> median = new ArrayList<>(); 
    	median.add(_abbey);
    	median.add(_shape);
    	median.add(_bad);
    	
    	Datum tag = Datum.heute(); 
    	
  
    	_verleihService.verleiheAn(_homer,median,tag); // Die Median sind zu Homer verliehen !
    	
    	assertTrue(_verleihService.sindAlleVerliehen(median)); // Die Median sind nicht verliehbar !
    	
    	assertTrue(_verleihService.getEntleiherFuer(_abbey).equals(_homer)); 
    	
    }

    @Test
    public void testNimmZurueck()
    {
    	List<Medium> median = new ArrayList<>();
    	median.add(_abbey);
    	median.add(_shape);
    	median.add(_bad);
    	
    	Datum tag = Datum.heute();
    	
    	_verleihService.verleiheAn(_brian, median, tag); // 3 Median ausgeliehen (_abby,_shape,_bad)
    	
    	median.remove(_bad); 
    	
    	_verleihService.nimmZurueck(median, tag); // 2 Median weggenommen ! ( _abby , _shape)
    	 
    	 assertTrue(_verleihService.sindAlleNichtVerliehen(median)); // die Beide die weg sind !
    	                                                            // heißt zurücknehmen geklappt !
    	 
    	 assertTrue(_verleihService.istVerliehen(_bad)); // weil es nicht weggenommen wurde, bleibt es da
    	                                                 // enthalten !
    }

    @Test
    public void testNochEinTestFall3()
    {
    	
    	
    }

    private void setUpKunden()
    {
        _homer = new Kunde(Kundennummer.get(123456), "Homer", "Simpson");
        _roger = new Kunde(Kundennummer.get(123457), "Roger", "Smith");
        _brian = new Kunde(Kundennummer.get(123458), "Brian", "Griffin");

        List<Kunde> testkunden = new ArrayList<Kunde>();
        testkunden.add(_homer);
        testkunden.add(_roger);
        testkunden.add(_brian);
        _kundenstamm = new KundenstammServiceImpl(testkunden);
    }

    private void setUpMedien()
    {
        _abbey = new CD("Abbey Road", "Meisterwerk", "Beatles", 44);
        _bad = new CD("Bad", "not as bad as the title might suggest",
                "Michael Jackson", 48);
        _shape = new CD("The Colour And The Shape", "bestes Album der Gruppe",
                "Foo Fighters", 46);

        List<Medium> _medien = new ArrayList<Medium>();
        _medien.add(_abbey);
        _medien.add(_bad);
        _medien.add(_shape);
        _medienbestand = new MedienbestandServiceImpl(_medien);
    }

    private void setUpVerleihService()
    {
        _verleihService = new VerleihServiceImpl(_kundenstamm, _medienbestand,
                new ArrayList<Verleihkarte>());
    }
}
