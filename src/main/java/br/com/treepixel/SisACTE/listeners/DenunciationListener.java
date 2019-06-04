package br.com.treepixel.SisACTE.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import br.com.treepixel.SisACTE.entities.City;
import br.com.treepixel.SisACTE.entities.Denunciation;
import br.com.treepixel.SisACTE.repositories.CityRepository;

@Component
public class DenunciationListener {
	
	private static CityRepository service;
	
	@Autowired
	public void setMyService (CityRepository cityRepository) {
		DenunciationListener.service = cityRepository;
	}
	
	@PrePersist
	public void onPersist(Denunciation denunciation) {
		this.setLatLongPosition(denunciation);
	}
	
	@PreUpdate
	public void onUpdate(Denunciation Denunciation) {
		this.setLatLongPosition(Denunciation);
	}
	
	private void setLatLongPosition(Denunciation Denunciation) {
		Point pos;
		
		GeometryFactory factory = new GeometryFactory();
		
		if(Denunciation.getEmployerLat() == null || Denunciation.getEmployerLong() == null) {
			City city = service.getOne(Denunciation.getEmployerCity().getId());
			pos = factory.createPoint(new Coordinate( city.getLatitude(), city.getLongitude()));
			Denunciation.setEmployerLat(Double.parseDouble(Float.toString(city.getLatitude())));
			Denunciation.setEmployerLong(Double.parseDouble(Float.toString(city.getLongitude())));
		} else {
			pos = factory.createPoint(new Coordinate( Denunciation.getEmployerLat(), Denunciation.getEmployerLong())) ; 
		}
		
		Denunciation.setEmployerPosition(pos);
	}
}
