package pers.xiaomuma.example.portal.crud.service.impl;

import pers.xiaomuma.example.portal.crud.domain.TestTable;
import pers.xiaomuma.example.portal.crud.dao.TestTableDAO;
import pers.xiaomuma.example.portal.crud.service.ITestTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2024-08-31
 */
@Service
public class TestTableServiceImpl extends ServiceImpl<TestTableDAO, TestTable> implements ITestTableService {

}
