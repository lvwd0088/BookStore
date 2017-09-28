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
public class LabelServiceImpl implements LabelService{

    @Resource
    private LabelRepository LabelRepository;

    @Override
    public List<Label> query() {
        return LabelRepository.findAllByOrderByAddTimeAsc();
    }

    @Override
    public void save(String labelName) throws MyException{
        Optional<Integer> count=Optional.ofNullable(LabelRepository.countByName(labelName));
        if(ConvertUtils.parseIntegerToInt(count)>0){
            throw new MyException(CodeConstant.DATA_EXIST);
        }
        Label Label=new Label();
        Label.setAddTime(new Date());
        Label.setName(labelName);
        LabelRepository.save(Label);
    }

    @Override
    public void delete(Long id) {
        LabelRepository.delete(id);
    }
}
