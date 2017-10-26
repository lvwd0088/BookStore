package com.lyg.bookstore.service.basic.impl;

import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.dao.basic.LabelRepository;
import com.lyg.bookstore.model.basic.Label;
import com.lyg.bookstore.service.basic.LabelService;
import com.lyg.bookstore.utils.ConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by weida on 2017/7/18.
 */
@Service
@Transactional
public class LabelServiceImpl implements LabelService {

    @Resource
    private LabelRepository labelRepository;

    @Override
    public List<Label> query() {
        return labelRepository.findAllByOrderByAddTimeAsc();
    }

    @Override
    public void save(String labelName) throws MyException {
        Integer count = labelRepository.countByName(labelName);
        if (count > 0) {
            throw new MyException(CodeConstant.DATA_EXIST);
        }
        Label label = new Label();
        label.setAddTime(new Date());
        label.setName(labelName);
        labelRepository.save(label);
    }

    @Override
    public void delete(Long id) {
        labelRepository.delete(id);
    }
}
