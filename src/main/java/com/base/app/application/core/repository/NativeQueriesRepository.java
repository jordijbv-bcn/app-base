package com.base.app.application.core.repository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xml.sax.InputSource;

import groovy.util.logging.Slf4j;

@Repository
@Slf4j
public class NativeQueriesRepository {

	@Autowired
	private EntityManager em;

	public String getQuery(String name) {
		String sql = null;
		try {
			ClassPathResource r = new ClassPathResource("native-queries.xml");
			InputSource inputSource = new InputSource(r.getInputStream());
			XPath xpath = XPathFactory.newInstance().newXPath();
			sql = xpath.evaluate("/queries/query[@name='" + name + "']", inputSource);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		if (sql == null || "".equals(sql)) {
			throw new RuntimeException("Query not found: " + name);
		}
		return sql;
	}
	
	private Boolean getBooleanValueIfExists(Object object) {
		return object != null ? (Boolean) object : null;
	}

	private Date getDateValueIfExists(Object object) {
		return object != null ? (Date) object : null;
	}

	private String getStringValueIfExists(Object object) {
		return object != null ? object.toString() : "";
	}

	private String getStringValueOnLike(Object object) {
		return object != null ? "%" + object.toString() + "%" : "%%";
	}

	private Boolean getBoolean(Integer value) {
		return value == 1;
	}

	private String getStringFromBoolean(Object value) {
		if (value == null) {
			return null;
		}
		return (Boolean) value ? "1" : "0";
	}

	private BigDecimal getBigDecimalValueIfExists(Object value) {
		return value != null ? new BigDecimal(value.toString()) : null;
	}

	private Integer getIntegerValueIfExists(Object value) {
		return (Integer) value;
	}

	private String getStringValueIfExists(Date value) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return value != null ? sdf.format(value) : null;
	}
	
	
//	#--- EXAMPLE FUNCTION ---# //
	
	
//	@SuppressWarnings("unchecked")
//	public List<ClaimsModel> getReclamacionsByUsuari(final Map<String, Object> params) {
//		log.info("Method: getReclamacionsByUsuari() -> NativeQueriesRepository");
//		List<Object[]> rows = new ArrayList<Object[]>();
//		List<ClaimsModel> result = new ArrayList<>();
//		String sql = getQuery("reclamacionsByUsuari");
//		Query query = em.createNativeQuery(sql);
//		query = em.createNativeQuery(sql);
//		query.setParameter(1, params.get("usuari"));
//		query.setParameter(2, params.get("unitatPrescriptora"));		
//		query.setParameter(3, params.get("unitatPrescriptora"));
//		rows = query.getResultList();
//		try {
//			log.info("Rows size: " + rows.size());
//			for (Object[] row : rows) {
//				ClaimsModel claim = new ClaimsModel();
//				claim.setPrescriptionCode((String) row[0]);
//				claim.setClaimType((String) row[1]);
//				claim.setClaimCreationDate(DateUtil.toString(row[2]));
//				claim.setClaimSendDate(DateUtil.toString(row[3]));
//				claim.setClaim((String) row[4]);
//				claim.setClaimState((String) row[5]);
//				claim.setTravelType((BigDecimal) row[6]);
//				claim.setPrescriptionStartDateTime(DateUtil.toString(row[7]));
//				claim.setClaimStateColor((String) row[8]);
//				BigDecimal claimId = (BigDecimal) row[9];
//				claim.setClaimId(claimId.longValue());
//				BigDecimal travelId = (BigDecimal) row[10];
//				claim.setTravelId(travelId.longValue());
//				result.add(claim);
//			}
//			return result;
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
	
}