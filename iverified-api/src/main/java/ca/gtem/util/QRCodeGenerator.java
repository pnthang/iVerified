package ca.gtem.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class QRCodeGenerator {
	
	public static String generateQRCodeImage(String text, int width, int height, String filePath)
        throws WriterException, IOException {
        	QRCodeWriter qrCodeWriter = new QRCodeWriter();
        	BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        	Path path = FileSystems.getDefault().getPath(filePath);
        	MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        	return path.toString();
        }
	
	// Create qr Image from hash string and return uri to location
	public static String createQrCode(String fileName,String domain, String hash, String rootDir, String qrimageDir) {		
		Path destinationPath = Paths.get(rootDir + qrimageDir );		
		String qrCodeImagePath = destinationPath + "/"+ fileName + Long.toString(new Date().getTime()) + ".png"; 
		String qrUrl=qrimageDir + fileName + Long.toString(new Date().getTime()) + ".png"; 
		String content = "\""+ domain.replaceAll("^\"|\"$", "") + hash +"\"";		
		try {
			if (!Files.exists(destinationPath)) {
	       	 	Files.createDirectories(destinationPath);
	        }
			qrCodeImagePath = QRCodeGenerator.generateQRCodeImage(content, 512, 512, qrCodeImagePath);			
		} catch (WriterException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			qrUrl="";
		}
		return qrUrl;
	} 	
}
