package kr.co.ensmart.frameworkdemo.app.dao.sample;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.ensmart.frameworkdemo.common.dto.sample.Sample;

@Repository
public interface SampleMapper {
	List<Sample> selectAllSampleList();
	
	Sample selectSampleById(Integer id);

    Sample selectSampleByIdDynamic(Map<String,Object> params);

}
