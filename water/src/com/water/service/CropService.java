package com.water.service;

import com.water.common.bean.Page;
import com.water.common.service.BaseService;
import com.water.model.Area;
import com.water.model.Crop;

public interface CropService extends BaseService<Crop>{

	Page<Crop> findCropListByAreaIdAndPage(Integer pageNo, Integer pageSize,
			Integer regionId);

}
