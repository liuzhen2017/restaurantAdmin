package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.BranchStore;
import com.ruoyi.system.mapper.BranchStoreMapper;
import com.ruoyi.system.service.IBranchStoreService;

/**
 * 分店管理 服务层实现
 * 
 * @author liuzhen
 * @date 2019-01-22
 */
@Service
public class BranchStoreServiceImpl implements IBranchStoreService 
{
	@Autowired
	private BranchStoreMapper branchStoreMapper;

	/**
     * 查询分店管理信息
     * 
     * @param id 分店管理ID
     * @return 分店管理信息
     */
    @Override
	public BranchStore selectBranchStoreById(Integer id)
	{
	    return branchStoreMapper.selectBranchStoreById(id);
	}
	
	/**
     * 查询分店管理列表
     * 
     * @param branchStore 分店管理信息
     * @return 分店管理集合
     */
	@Override
	public List<BranchStore> selectBranchStoreList(BranchStore branchStore)
	{
	    return branchStoreMapper.selectBranchStoreList(branchStore);
	}
	
    /**
     * 新增分店管理
     * 
     * @param branchStore 分店管理信息
     * @return 结果
     */
	@Override
	public int insertBranchStore(BranchStore branchStore)
	{
		branchStore.setCreateBy(ShiroUtils.getSysUser().getLoginName()+"");
		branchStore.setIsVaild("yes");
	    return branchStoreMapper.insertBranchStore(branchStore);
	}
	
	/**
     * 修改分店管理
     * 
     * @param branchStore 分店管理信息
     * @return 结果
     */
	@Override
	public int updateBranchStore(BranchStore branchStore)
	{
		branchStore.setUpdateBy(ShiroUtils.getSysUser().getLoginName()+"");
	    return branchStoreMapper.updateBranchStore(branchStore);
	}

	/**
     * 删除分店管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBranchStoreByIds(String ids)
	{
		return branchStoreMapper.deleteBranchStoreByIds(Convert.toStrArray(ids));
	}
	
}
