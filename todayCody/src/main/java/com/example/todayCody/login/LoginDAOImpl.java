package com.example.todayCody.login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LoginDAOImpl implements LoginDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public String getUserId(){
        String userId = this.sqlSession.selectOne("com.example.todayCody.LoginDAO.getUserId");

        return userId;
    }

  @Override
  public Map<String, Object> getUserInfoById(HashMap<String, Object> vo) throws Exception {
      HashMap<String, Object> retMap = new HashMap<>();
      retMap.put("test", "성공");
      retMap.put("id", "hwpark93");
      retMap.put("pwd", "1234");
      retMap.put("name", "박한우");
    return retMap;
  }

  ;
}
