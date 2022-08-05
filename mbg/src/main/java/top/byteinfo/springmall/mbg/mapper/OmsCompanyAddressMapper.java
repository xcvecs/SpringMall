package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.OmsCompanyAddress;

public interface OmsCompanyAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsCompanyAddress record);

    OmsCompanyAddress selectByPrimaryKey(Long id);

    List<OmsCompanyAddress> selectAll();

    int updateByPrimaryKey(OmsCompanyAddress record);
}