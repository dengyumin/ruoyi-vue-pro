package cn.iocoder.yudao.module.ai.service.model;

import cn.iocoder.yudao.framework.ai.core.enums.AiPlatformEnum;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey.AiApiKeyPageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey.AiApiKeySaveReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiApiKeyDO;
import jakarta.validation.Valid;
import org.springframework.ai.chat.StreamingChatClient;
import org.springframework.ai.image.ImageClient;

import java.util.List;

/**
 * AI API 密钥 Service 接口
 *
 * @author 芋道源码
 */
public interface AiApiKeyService {

    /**
     * 创建 API 密钥
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createApiKey(@Valid AiApiKeySaveReqVO createReqVO);

    /**
     * 更新 API 密钥
     *
     * @param updateReqVO 更新信息
     */
    void updateApiKey(@Valid AiApiKeySaveReqVO updateReqVO);

    /**
     * 删除 API 密钥
     *
     * @param id 编号
     */
    void deleteApiKey(Long id);

    /**
     * 获得 API 密钥
     *
     * @param id 编号
     * @return API 密钥
     */
    AiApiKeyDO getApiKey(Long id);

    /**
     * 校验 API 密钥
     *
     * @param id 比那好
     * @return API 密钥
     */
    AiApiKeyDO validateApiKey(Long id);

    /**
     * 获得 API 密钥分页
     *
     * @param pageReqVO 分页查询
     * @return API 密钥分页
     */
    PageResult<AiApiKeyDO> getApiKeyPage(AiApiKeyPageReqVO pageReqVO);

    /**
     * 获得 API 密钥列表
     *
     * @return API 密钥列表
     */
    List<AiApiKeyDO> getApiKeyList();

    // ========== 与 spring-ai 集成 ==========

    /**
     * 获得 StreamingChatClient 对象
     *
     * @param id 编号
     * @return StreamingChatClient 对象
     */
    StreamingChatClient getStreamingChatClient(Long id);

    /**
     * 获得 ImageClient 对象
     *
     * TODO 可优化点：目前默认获取 platform 对应的第一个开启的配置用于绘画；后续可以支持配置选择
     *
     * @param platform 平台
     * @return ImageClient 对象
     */
    ImageClient getImageClient(AiPlatformEnum platform);

}