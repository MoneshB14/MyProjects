package com.qrcode;

import java.io.IOException;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class GenerateQRCode {

    public static void main(String[] args) throws WriterException, IOException {

        String data = "www.youtube.com";
        String path = " ";//your path

        BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
        MatrixToImageWriter.writeToPath(bitMatrix, "jpg", Paths.get(path));
        System.out.println("QR code generated successfully");

    }
}
