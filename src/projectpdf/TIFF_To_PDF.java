/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;

/**
 *
 * @author Eurequat-Algerie
 */
/*
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfException;
import com.gnostice.pdfone.PdfImage;
import com.gnostice.pdfone.PdfMeasurement;
import com.gnostice.pdfone.PdfPage;
import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;

public class TIFF_To_PDF {

  public static void main(String[] args) throws IOException, PdfException {
    PdfDocument doc = new PdfDocument();
    doc.setMeasurementUnit(PdfMeasurement.MU_PIXELS);

    // Gain seekable access to the multi-page TIFF image
    SeekableStream seekableStream1 =
      new FileSeekableStream(new File("sample_image.tiff"));

    // Create an TIFF image decoder for the image
    ImageDecoder imageDecoder1 =
        ImageCodec.createImageDecoder(
            "tiff",
            seekableStream1,
            (TIFFDecodeParam) null);

    // Count number of pages in the image
    int n = imageDecoder1.getNumPages();

    // Parse individual pages in the TIFF image
    for (int i = 0; i < n; i++) {

        // Access current image
        RenderedImage renderedImage = imageDecoder1.decodeAsRenderedImage(i);

        // Create a new PDF page with same dimensions as current image
        PdfPage page = new PdfPage(
                            renderedImage.getWidth(),
                            renderedImage.getHeight(),
                            PdfMeasurement.MU_PIXELS);
        // Draw image on the page
        page.drawImage(PdfImage.create(renderedImage), 0, 0);

        // Add the page to the document
        doc.add(page);
    }

    // Save document to file
    doc.save("tiff_to_pdf_demo.pdf");
  }
}*/