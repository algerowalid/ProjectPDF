package projectpdf;

import org.primaresearch.dla.page.MetaData;
import org.primaresearch.dla.page.Page;
import org.primaresearch.dla.page.io.xml.PageXmlInputOutput;
import org.primaresearch.dla.page.layout.PageLayout;
import org.primaresearch.dla.page.layout.physical.Region;
import org.primaresearch.dla.page.layout.physical.shared.RegionType;
import org.primaresearch.dla.page.layout.physical.text.impl.DefaultTextRegionTypes;
import org.primaresearch.dla.page.layout.physical.text.impl.TextRegion;
import org.primaresearch.ident.IdRegister.InvalidIdException;
import org.primaresearch.io.xml.XmlModelAndValidatorProvider.UnsupportedSchemaVersionException;
import org.primaresearch.maths.geometry.Polygon;

public class CreateAndSaveDocumentLayout {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Create page and meta data
		Page page = new Page();
		try {
			page.setGtsId("pc-00001234");
		} catch (InvalidIdException e) {
			e.printStackTrace();
		}
		page.setImageFilename("d:/article.tif");
		
		MetaData metadata = page.getMetaData();
		metadata.setCreator("CreateAndSaveDocumentLayout example class");
		
		//Create page layout
		PageLayout layout = page.getLayout();
		layout.setSize(1000, 2000);
		
		// Image
		Region region = layout.createRegion(RegionType.ImageRegion);
		Polygon outline = new Polygon();
		outline.addPoint(10, 20);
		outline.addPoint(110, 20);
		outline.addPoint(110, 120);
		outline.addPoint(10, 120);
		region.setCoords(outline);
		
		// Headline
		region = layout.createRegion(RegionType.TextRegion);
		outline = new Polygon();
		outline.addPoint(10, 220);
		outline.addPoint(110, 220);
		outline.addPoint(110, 320);
		outline.addPoint(10, 320);
		region.setCoords(outline);
		TextRegion textRegion = (TextRegion)region;
		textRegion.setTextType(DefaultTextRegionTypes.HEADING);
		textRegion.setText("This is the headline");
		
		// Text paragraph
		region = layout.createRegion(RegionType.TextRegion);
		outline = new Polygon();
		outline.addPoint(10, 350);
		outline.addPoint(110, 350);
		outline.addPoint(110, 520);
		outline.addPoint(10, 520);
		region.setCoords(outline);
		textRegion = (TextRegion)region;
		textRegion.setTextType(DefaultTextRegionTypes.PARAGRAPH);
		textRegion.setText("This is a paragraph.");
	
		//Save document
		try {
			PageXmlInputOutput.writePage(page, "d:/waliiiid.xml");
		} catch (UnsupportedSchemaVersionException e) {
			e.printStackTrace();
		}
	}

}
