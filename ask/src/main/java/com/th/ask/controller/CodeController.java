package com.th.ask.controller;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.th.ask.model.request.ValidateCodeRequest;
import com.th.ask.model.response.ValidationResponse;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/code")
public class CodeController {

    private final GoogleAuthenticator gAuth;

    @GetMapping("/generate/{username}")
    public void generate(@PathVariable String username, HttpServletResponse response) throws WriterException, IOException {
        final GoogleAuthenticatorKey key = gAuth.createCredentials(username);

        //I've decided to generate QRCode on backend site
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        String otpAuthURL = GoogleAuthenticatorQRGenerator.getOtpAuthTotpURL("my-demo", username, key);

        BitMatrix bitMatrix = qrCodeWriter.encode(otpAuthURL, BarcodeFormat.QR_CODE, 200, 200);

        //Simple writing to outputstream
        ServletOutputStream outputStream = response.getOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        outputStream.close();
    }

    @PostMapping("/validate/key")
    public ValidationResponse validateKey(@RequestBody ValidateCodeRequest body) {
        return new ValidationResponse(gAuth.authorizeUser(body.getUsername(), body.getCode()));
    }
}
