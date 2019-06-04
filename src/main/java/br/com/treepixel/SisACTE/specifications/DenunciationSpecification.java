package br.com.treepixel.SisACTE.specifications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.domain.Specification;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateList;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;

import br.com.treepixel.SisACTE.utils.WithinPredicate;
import br.com.treepixel.SisACTE.entities.Denunciation;

public class DenunciationSpecification implements Specification<Denunciation>{
	

	private static final long serialVersionUID = 5498692635928459753L;
	private GeometryFactory factory;
	private Map<String, String> queryParameters;
	
	List<Predicate> predicates = new ArrayList<>();
	
	public DenunciationSpecification(Map<String, String> queryParameters) {
		super();
		this.queryParameters = queryParameters;
		this.factory = new GeometryFactory();
	}
	
	@Override
	public Predicate toPredicate(Root<Denunciation> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if(!queryParameters.isEmpty()) {
			if(queryParameters.containsKey("archived")) {
				predicates.add(criteriaBuilder.equal(root.get("archived"), Boolean.parseBoolean(queryParameters.get("archived"))));
			}
			
			
			if(queryParameters.containsKey("score_min") && queryParameters.containsKey("score_max")) {
				if(!queryParameters.get("score_min").isEmpty() && !queryParameters.get("score_max").isEmpty()) {
					predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("score"), queryParameters.get("score_min")));
					predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("score"), queryParameters.get("score_max")));
				}
			}
			
			if(queryParameters.containsKey("date_min") && queryParameters.containsKey("date_max")) {
				if(!queryParameters.get("date_min").isEmpty() && !queryParameters.get("data_max").isEmpty()) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");						
					try {
						predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), sdf.parse(queryParameters.get("date_min"))));
						predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), sdf.parse(queryParameters.get("date_max"))));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			
			if(queryParameters.containsKey("uf")) {
				predicates.add(criteriaBuilder.equal(root.get("employerUf"), queryParameters.get("uf")));
			}
			
			if(queryParameters.containsKey("city")) {
				predicates.add(criteriaBuilder.equal(root.get("employerCity"), queryParameters.get("city")));
			}
			
			if(queryParameters.containsKey("finishActivity")) {

				switch (queryParameters.get("finishActivity").toString()) {
					case "30 dias":
						System.out.println(plusDays(30));
						predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("employerFinishActivity"), new Date()));
						predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("employerFinishActivity"), plusDays(30)));
						break;
					case "45 dias":
						System.out.println(plusDays(45));
						predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("employerFinishActivity"), plusDays(30)));
						predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("employerFinishActivity"), plusDays(45)));
						break;
					case "60 dias":
						System.out.println(plusDays(60));
						predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("employerFinishActivity"), plusDays(45)));
						predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("employerFinishActivity"), plusDays(60)));
						break;
					case "90 dias":
						System.out.println(plusDays(90));
						predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("employerFinishActivity"), plusDays(60)));
						predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("employerFinishActivity"), plusDays(90)));
						break;
				}
			}
			
			if(queryParameters.containsKey("area")) {
				
				String JSON_STRING = queryParameters.get("area");
				CoordinateList coordinateList = new CoordinateList();
				
				try {
					JSONObject obj = new JSONObject(JSON_STRING);
				    JSONArray vertices = obj.getJSONArray("vertices");
					
				    for(Integer i = 0; i < vertices.length(); i++) {
				    	coordinateList.add(new Coordinate(vertices.getJSONObject(i).getDouble("lat"), vertices.getJSONObject(i).getDouble("lng")));
				    }
				    
				    coordinateList.add(new Coordinate(vertices.getJSONObject(0).getDouble("lat"), vertices.getJSONObject(0).getDouble("lng")));
				    
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
				
				Polygon window= factory.createPolygon(coordinateList.toCoordinateArray());
				predicates.add(new WithinPredicate((CriteriaBuilderImpl) criteriaBuilder, root.get("employerPosition"), window));
			}
			
			if(queryParameters.containsKey("status") && queryParameters.get("status") != "") {
				System.out.println(queryParameters.get("status"));
				predicates.add(criteriaBuilder.equal(root.get("status"), queryParameters.get("status")));
			}
		}

		
		if(!predicates.isEmpty()) {
			return criteriaBuilder.and(predicates.toArray(new Predicate[1]));
		}
		
		return null;
	}
	
	private Date plusDays(Integer days) {		
		LocalDateTime currentDate = LocalDate.now().atTime(23, 59, 59);
		currentDate = currentDate.plusDays(days);
		Date datefinal = Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());
		return datefinal;
	}

}
