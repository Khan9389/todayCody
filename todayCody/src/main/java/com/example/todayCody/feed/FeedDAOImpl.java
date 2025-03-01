package com.example.todayCody.feed;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Repository("feedDAO")
public class FeedDAOImpl implements FeedDAO {

  @Autowired
  SqlSessionTemplate sqlSession;

  //[피드 등록] 피드 정보 테이블에 insert
  @Override
  public int insertFeedInfo(HashMap<String, Object> jsonMap) {
    sqlSession.insert("com.example.todayCody.feed.FeedDAO.insertFeedInfo", jsonMap);
    return sqlSession.selectOne("com.example.todayCody.feed.FeedDAO.getMaxFeedSeq");
  }

  //[피드 등록] 파일 정보 테이블에 insert
  @Override
  public int insertFileInfo(HashMap<String, Object> jsonMap) {
    return sqlSession.insert("com.example.todayCody.feed.FeedDAO.insertFileInfo", jsonMap);
  }

  @Override
  public List<FeedDTO> getFeedList(FeedDTO info){

    return sqlSession.selectList("com.example.todayCody.feed.FeedDAO.getFeedList",info);
  }

  @Override
  public List<FeedDTO> getTop3(String year) {
    return sqlSession.selectList("com.example.todayCody.feed.FeedDAO.getTop3",year);
  }

  @Override
  public List<FeedDTO> getFeedRankList(FeedDTO info) {
    return sqlSession.selectList("com.example.todayCody.feed.FeedDAO.getFeedRankList",info);

  }

  // 피드 좋아요 update
  @Override
  public int doUpdateFeedLike(Map<String, String> params){
    return sqlSession.update("com.example.todayCody.feed.FeedDAO.doUpdateFeedLike", params);
  }
}
