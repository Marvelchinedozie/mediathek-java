import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Set;
import java.util.HashSet;

public class VideoSpielTest
{
	private static final String KOMMENTAR = "Kommentar";
	private static final String TITEL = "Titel";
	private static final String VideoSpiel_BEZEICHNUNG = "VideoSpiel";
	private static final String SYSTEME = "PS4,XBOX ONE,WII";

	private VideoSpiel _vs1;
	private VideoSpiel _vs2;

	public VideoSpielTest()
	{
		_vs1 = getMedium();
		_vs2 = getMedium();
	}

	@Test
	public void testGetMedienBezeichnung()
	{
		String VideoSpielBezeichnung = VideoSpiel_BEZEICHNUNG;
		assertEquals(VideoSpielBezeichnung, _vs1.getMedienBezeichnung());
	}

	@Test
	public void testKonstruktor()
	{
		assertEquals(TITEL, _vs1.getTitel());
		assertEquals(KOMMENTAR, _vs1.getKommentar());
		assertEquals(_vs1.stringToListWandler(SYSTEME), _vs1.getSysteme());
	}

	@Test
	/*
	 * Von ein und der selben VideoSpiel kann es mehrere Exemplare geben, die von
	 * unterschiedlichen Personen ausgeliehen werden können.
	 */
	public void testEquals()
	{
		assertFalse("Mehrere Exemplare der gleichen VideoSpiel sind ungleich", _vs1.equals(_vs2));
		assertTrue("Dasselbe Exemplare der gleichen VideoSpiel ist gleich", _vs1.equals(_vs1));
	}

	@Test
	public void testSysteme()
	{
		Set<String> expected = new HashSet<>();
		expected.add("PS4");
		expected.add("XBOX ONE");
		expected.add("WII");

		assertEquals(expected, _vs1.getSysteme());
	}

	private VideoSpiel getMedium()
	{
		return new VideoSpiel(TITEL, KOMMENTAR, SYSTEME);
	}

}
