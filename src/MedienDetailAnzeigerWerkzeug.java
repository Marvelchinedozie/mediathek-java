import java.util.List;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 * Ein MedienDetailAnzeigerWerkzeug ist ein Werkzeug um die Details von Medien
 * anzuzeigen.
 * 
 * @author SE2-Team, PM2-Team
 * @version SoSe 2026
 */
class MedienDetailAnzeigerWerkzeug
{
    private MedienDetailAnzeigerUI _ui;

    /**
     * Initialisiert ein neues MedienDetailAnzeigerWerkzeug.
     */
    public MedienDetailAnzeigerWerkzeug()
    {
        _ui = new MedienDetailAnzeigerUI();
    }
    
    /**
     * Setzt die Liste der Medien deren Details angezeigt werden sollen.
     * 
     * @param medien Eine Liste von Medien.
     * 
     * @require (medien != null)
     */
    public void setMedien(List<Medium> medien)
    {
        assert medien != null : "Vorbedingung verletzt: (medien != null)";
        
        TextArea selectedMedienTextArea = _ui.getMedienAnzeigerTextArea();
        selectedMedienTextArea.setText("");
        
        for(Medium m : medien)
        {
        	selectedMedienTextArea.appendText(m.getFormatiertenString());
        }
    }

//    /**
//     * Setzt die Liste der Medien deren Details angezeigt werden sollen.
//     * 
//     * @param medien Eine Liste von Medien.
//     * 
//     * @require (medien != null)
//     */
//    public void setMedien(List<Medium> medien)
//    {
//        assert medien != null : "Vorbedingung verletzt: (medien != null)";
//        
//        TextArea selectedMedienTextArea = _ui.getMedienAnzeigerTextArea();
//        selectedMedienTextArea.setText("");
//        
//        for(Medium m : medien)
//        {
//        	if(m instanceof CD)
//        	{
//        		CD cd = (CD) m;
//        		selectedMedienTextArea.setText(cd.getInterpret());
//        	}
//        	if(m instanceof DVD)
//        	{
//        		DVD dvd = (DVD) m;
//        		selectedMedienTextArea.setText(dvd.getRegisseur());
//        	}
//        	if(m instanceof VideoSpiel)
//        	{
//        		VideoSpiel vs = (VideoSpiel) m;
//        		selectedMedienTextArea.setText(vs.getSysteme().toString());
//        	}
//        }
//    }

    /**
     * Gibt das Panel dieses Subwerkzeugs zurück.
     * 
     * @ensure result != null
     */
    public Pane getUIPane()
    {
        return _ui.getUIPane();
    }
}
