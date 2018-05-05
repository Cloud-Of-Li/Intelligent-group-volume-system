package com.cloud.zj.dao;

import java.util.List;

import com.cloud.zj.entity.Major;

public interface MajorDao extends BaseDao<Major>{

	Major getMajorByid(int majorId);

	List<Major> getMajor();

}
