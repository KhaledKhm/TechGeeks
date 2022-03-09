package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.User;

public interface ICertificateService {
	public void addCertificate (Certificate certificat);
	public Certificate updateCertificate(Certificate certificate);
	public void deleteAllCertificates();
	public void deleteCertificateById(int idCertificate);
	public List<Certificate> getAllCertificates();
	public Certificate getCertificateById(int idCertificate);
	public Certificate updatePunishment(Certificate certificate, int idCertificate);
}
