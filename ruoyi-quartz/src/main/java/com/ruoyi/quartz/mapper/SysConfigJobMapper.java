package com.ruoyi.quartz.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.quartz.domain.SysConfigJob;



/**
 * 参数配置 数据层
 * 
 * @author ruoyi
 */
public interface SysConfigJobMapper
{
    /**
     * 查询参数配置信息
     * 
     * @param config 参数配置信息
     * @return 参数配置信息
     */
    public SysConfigJob selectConfig(SysConfigJob config);

    /**
     * 查询参数配置列表
     * 
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    public List<SysConfigJob> selectConfigList(SysConfigJob config);

    /**
     * 根据键名查询参数配置信息
     * 
     * @param configKey 参数键名
     * @return 参数配置信息
     */
    public SysConfigJob checkConfigKeyUnique(String configKey);

    /**
     * 新增参数配置
     * 
     * @param config 参数配置信息
     * @return 结果
     */
    public int insertConfig(SysConfigJob config);

    /**
     * 修改参数配置
     * 
     * @param config 参数配置信息
     * @return 结果
     */
    public int updateConfig(SysConfigJob config);

    /**
     * 批量删除参数配置
     * 
     * @param configIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteConfigByIds(String[] configIds);

	public Map<String, Object> selectByKey(String key);
}