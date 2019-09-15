package com.varnaTravelGuideWeb.service;

import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.entity.TOTPDetails;
import com.varnaTravelGuideWeb.entity.User;
import com.varnaTravelGuideWeb.exception.InvalidTOTPVerificationCode;
import com.varnaTravelGuideWeb.repository.TOTPRepository;
import com.varnaTravelGuideWeb.repository.UserRepository;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

@Service
public class TOTPService {
	
	private final GoogleAuthenticator googleAuth = new GoogleAuthenticator();
	private final TOTPRepository totpRepository;
	private final UserRepository userRepository;
	private static final String ISSUER = "Cryptoportfolio.com";
	
	
	public TOTPService(TOTPRepository totpRepository, UserRepository userRepository) {
		this.totpRepository=totpRepository;
		this.userRepository=userRepository;
	}
	
	public String generateNewGoogleAuthQrUrl(String username) {	
		GoogleAuthenticatorKey authKey = googleAuth.createCredentials();
		String secret = authKey.getKey();
		totpRepository.deleteByUsername(username);
		totpRepository.save(new TOTPDetails(username, secret));
		return GoogleAuthenticatorQRGenerator.getOtpAuthURL(ISSUER, username, authKey);
	}
	
	public boolean isTotpEnabled(String username) {
		return userRepository.findByUsername(username).isTotpEnabled();
	}
	
	public void enableTOTPForUser(String username, int code) {
		if(!verifyCode(username, code)) {
			throw new InvalidTOTPVerificationCode("Verification code is Invalid");
		}
		User user = userRepository.findByUsername(username);
		user.setTotpEnabled(true);
		userRepository.save(user);
	}
	
	public boolean verifyCode(String username, int code) {
		TOTPDetails totpDetails = totpRepository.findByUsername(username);
		return googleAuth.authorize(totpDetails.getSecret(), code);
	}
	
}
