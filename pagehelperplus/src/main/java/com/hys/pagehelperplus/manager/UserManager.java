package com.hys.pagehelperplus.manager;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hys.pagehelperplus.dao.UserDAO;
import com.hys.pagehelperplus.entity.Pager;
import com.hys.pagehelperplus.entity.UserDO;
import com.hys.pagehelperplus.util.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户Manager
 *
 * @author Robert Hou
 * @since 2020年11月28日 10:59
 **/
@Component
public class UserManager {

    @Autowired
    private UserDAO userDAO;

    //    @KeyNamesStrategy(keyNames = {"id", "name"})
    public Pager<UserDO> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<UserDO> list = userDAO.list();
        return PageHelperUtils.pageTransform(list);
    }
}
