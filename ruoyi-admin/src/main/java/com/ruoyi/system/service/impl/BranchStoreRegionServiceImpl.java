package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.system.domain.BranchStoreRegion;
import com.ruoyi.system.mapper.BranchStoreRegionMapper;
import com.ruoyi.system.service.IBranchStoreRegionService;

/**
 * 區域類型 服务层实现
 * 
 * @author liuzhen
 * @date 2019-02-24
 */
@Service
public class BranchStoreRegionServiceImpl implements IBranchStoreRegionService 
{
	@Autowired
	private BranchStoreRegionMapper branchStoreRegionMapper;

	/**
     * 查询區域類型信息
     * 
     * @param id 區域類型ID
     * @return 區域類型信息
     */
    @Override
	public BranchStoreRegion selectBranchStoreRegionById(Integer id)
	{
	    return branchStoreRegionMapper.selectBranchStoreRegionById(id);
	}
	
	/**
     * 查询區域類型列表
     * 
     * @param branchStoreRegion 區域類型信息
     * @return 區域類型集合
     */
	@Override
	public List<BranchStoreRegion> selectBranchStoreRegionList(BranchStoreRegion branchStoreRegion)
	{
	    return branchStoreRegionMapper.selectBranchStoreRegionList(branchStoreRegion);
	}
	
    /**
     * 新增區域類型
     * 
     * @param branchStoreRegion 區域類型信息
     * @return 结果
     */
	@Override
	public int insertBranchStoreRegion(BranchStoreRegion branchStoreRegion)
	{
	    return branchStoreRegionMapper.insertBranchStoreRegion(branchStoreRegion);
	}
	
	/**
     * 修改區域類型
     * 
     * @param branchStoreRegion 區域類型信息
     * @return 结果
     */
	@Override
	public int updateBranchStoreRegion(BranchStoreRegion branchStoreRegion)
	{
	    return branchStoreRegionMapper.updateBranchStoreRegion(branchStoreRegion);
	}

	/**
     * 删除區域類型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBranchStoreRegionByIds(String ids)
	{
		return branchStoreRegionMapper.deleteBranchStoreRegionByIds(Convert.toStrArray(ids));
	}
	
}
