package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.BranchStoreRegion;

/**
 * 區域類型 服务层
 * 
 * @author liuzhen
 * @date 2019-02-24
 */
public interface IBranchStoreRegionService 
{
	/**
     * 查询區域類型信息
     * 
     * @param id 區域類型ID
     * @return 區域類型信息
     */
	public BranchStoreRegion selectBranchStoreRegionById(Integer id);
	
	/**
     * 查询區域類型列表
     * 
     * @param branchStoreRegion 區域類型信息
     * @return 區域類型集合
     */
	public List<BranchStoreRegion> selectBranchStoreRegionList(BranchStoreRegion branchStoreRegion);
	
	/**
     * 新增區域類型
     * 
     * @param branchStoreRegion 區域類型信息
     * @return 结果
     */
	public int insertBranchStoreRegion(BranchStoreRegion branchStoreRegion);
	
	/**
     * 修改區域類型
     * 
     * @param branchStoreRegion 區域類型信息
     * @return 结果
     */
	public int updateBranchStoreRegion(BranchStoreRegion branchStoreRegion);
		
	/**
     * 删除區域類型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBranchStoreRegionByIds(String ids);
	
}
