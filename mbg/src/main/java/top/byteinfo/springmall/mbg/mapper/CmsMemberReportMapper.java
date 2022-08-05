package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsMemberReport;

public interface CmsMemberReportMapper {
    int insert(CmsMemberReport record);

    List<CmsMemberReport> selectAll();
}