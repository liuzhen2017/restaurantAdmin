package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.system.domain.Banner;
import com.ruoyi.system.mapper.BannerMapper;
import com.ruoyi.system.service.IBannerService;

/**
 * 首頁banner 服务层实现
 * 
 * @author liuzhen
 * @date 2019-02-21
 */
@Service
public class BannerServiceImpl implements IBannerService 
{
	@Autowired
	private BannerMapper bannerMapper;

	/**
     * 查询首頁banner信息
     * 
     * @param id 首頁bannerID
     * @return 首頁banner信息
     */
    @Override
	public Banner selectBannerById(Integer id)
	{
	    return bannerMapper.selectBannerById(id);
	}
	
	/**
     * 查询首頁banner列表
     * 
     * @param banner 首頁banner信息
     * @return 首頁banner集合
     */
	@Override
	public List<Banner> selectBannerList(Banner banner)
	{
	    return bannerMapper.selectBannerList(banner);
	}
	
    /**
     * 新增首頁banner
     * 
     * @param banner 首頁banner信息
     * @return 结果
     */
	@Override
	public int insertBanner(Banner banner)
	{
	    return bannerMapper.insertBanner(banner);
	}
	
	/**
     * 修改首頁banner
     * 
     * @param banner 首頁banner信息
     * @return 结果
     */
	@Override
	public int updateBanner(Banner banner)
	{
	    return bannerMapper.updateBanner(banner);
	}

	/**
     * 删除首頁banner对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBannerByIds(String ids)
	{
		return bannerMapper.deleteBannerByIds(Convert.toStrArray(ids));
	}
	
}
