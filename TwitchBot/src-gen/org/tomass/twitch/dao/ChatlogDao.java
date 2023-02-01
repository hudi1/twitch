package org.tomass.twitch.dao;

import java.util.List;
import org.slf4j.Logger;
import org.sqlproc.engine.SqlControl;
import org.sqlproc.engine.SqlEngineFactory;
import org.sqlproc.engine.SqlRowProcessor;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.SqlSessionFactory;
import org.tomass.twitch.model.Chatlog;

@SuppressWarnings("all")
public class ChatlogDao {
  protected final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
  
  public ChatlogDao() {
  }
  
  public ChatlogDao(final SqlEngineFactory sqlEngineFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
  }
  
  public ChatlogDao(final SqlEngineFactory sqlEngineFactory, final SqlSessionFactory sqlSessionFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  protected SqlEngineFactory sqlEngineFactory;
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public Chatlog insert(final SqlSession sqlSession, final Chatlog chatlog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert chatlog: " + chatlog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "INSERT_CHATLOG";
    org.sqlproc.engine.SqlCrudEngine sqlInsertChatlog = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlInsertChatlog.insert(sqlSession, chatlog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert chatlog result: " + count + " " + chatlog);
    }
    return (count > 0) ? chatlog : null;
  }
  
  public Chatlog insert(final Chatlog chatlog, SqlControl sqlControl) {
    return insert(sqlSessionFactory.getSqlSession(), chatlog, sqlControl);
  }
  
  public Chatlog insert(final SqlSession sqlSession, final Chatlog chatlog) {
    return insert(sqlSession, chatlog, null);
  }
  
  public Chatlog insert(final Chatlog chatlog) {
    return insert(chatlog, null);
  }
  
  public Chatlog get(final SqlSession sqlSession, final Chatlog chatlog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get: " + chatlog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "GET_CHATLOG";
    org.sqlproc.engine.SqlCrudEngine sqlGetEngineChatlog = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    //sqlControl = getMoreResultClasses(chatlog, sqlControl);
    Chatlog chatlogGot = sqlGetEngineChatlog.get(sqlSession, Chatlog.class, chatlog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get chatlog result: " + chatlogGot);
    }
    return chatlogGot;
  }
  
  public Chatlog get(final Chatlog chatlog, SqlControl sqlControl) {
    return get(sqlSessionFactory.getSqlSession(), chatlog, sqlControl);
  }
  
  public Chatlog get(final SqlSession sqlSession, final Chatlog chatlog) {
    return get(sqlSession, chatlog, null);
  }
  
  public Chatlog get(final Chatlog chatlog) {
    return get(chatlog, null);
  }
  
  public int update(final SqlSession sqlSession, final Chatlog chatlog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update chatlog: " + chatlog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "UPDATE_CHATLOG";
    org.sqlproc.engine.SqlCrudEngine sqlUpdateEngineChatlog = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlUpdateEngineChatlog.update(sqlSession, chatlog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update chatlog result count: " + count);
    }
    return count;
  }
  
  public int update(final Chatlog chatlog, SqlControl sqlControl) {
    return update(sqlSessionFactory.getSqlSession(), chatlog, sqlControl);
  }
  
  public int update(final SqlSession sqlSession, final Chatlog chatlog) {
    return update(sqlSession, chatlog, null);
  }
  
  public int update(final Chatlog chatlog) {
    return update(chatlog, null);
  }
  
  public int delete(final SqlSession sqlSession, final Chatlog chatlog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete chatlog: " + chatlog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "DELETE_CHATLOG";
    org.sqlproc.engine.SqlCrudEngine sqlDeleteEngineChatlog = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlDeleteEngineChatlog.delete(sqlSession, chatlog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete chatlog result count: " + count);
    }
    return count;
  }
  
  public int delete(final Chatlog chatlog, SqlControl sqlControl) {
    return delete(sqlSessionFactory.getSqlSession(), chatlog, sqlControl);
  }
  
  public int delete(final SqlSession sqlSession, final Chatlog chatlog) {
    return delete(sqlSession, chatlog, null);
  }
  
  public int delete(final Chatlog chatlog) {
    return delete(chatlog, null);
  }
  
  public List<Chatlog> list(final SqlSession sqlSession, final Chatlog chatlog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list chatlog: " + chatlog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_CHATLOG";
    org.sqlproc.engine.SqlQueryEngine sqlEngineChatlog = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(chatlog, sqlControl);
    List<Chatlog> chatlogList = sqlEngineChatlog.query(sqlSession, Chatlog.class, chatlog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list chatlog size: " + ((chatlogList != null) ? chatlogList.size() : "null"));
    }
    return chatlogList;
  }
  
  public List<Chatlog> list(final Chatlog chatlog, SqlControl sqlControl) {
    return list(sqlSessionFactory.getSqlSession(), chatlog, sqlControl);
  }
  
  public List<Chatlog> list(final SqlSession sqlSession, final Chatlog chatlog) {
    return list(sqlSession, chatlog, null);
  }
  
  public List<Chatlog> list(final Chatlog chatlog) {
    return list(chatlog, null);
  }
  
  public int query(final SqlSession sqlSession, final Chatlog chatlog, SqlControl sqlControl, final SqlRowProcessor<Chatlog> sqlRowProcessor) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query chatlog: " + chatlog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_CHATLOG";
    org.sqlproc.engine.SqlQueryEngine sqlEngineChatlog = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(chatlog, sqlControl);
    int rownums = sqlEngineChatlog.query(sqlSession, Chatlog.class, chatlog, sqlControl, sqlRowProcessor);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query chatlog size: " + rownums);
    }
    return rownums;
  }
  
  public int query(final Chatlog chatlog, SqlControl sqlControl, final SqlRowProcessor<Chatlog> sqlRowProcessor) {
    return query(sqlSessionFactory.getSqlSession(), chatlog, sqlControl, sqlRowProcessor);
  }
  
  public int query(final SqlSession sqlSession, final Chatlog chatlog, final SqlRowProcessor<Chatlog> sqlRowProcessor) {
    return query(sqlSession, chatlog, null, sqlRowProcessor);
  }
  
  public int query(final Chatlog chatlog, final SqlRowProcessor<Chatlog> sqlRowProcessor) {
    return query(chatlog, null, sqlRowProcessor);
  }
  
  public int count(final SqlSession sqlSession, final Chatlog chatlog, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("count chatlog: " + chatlog + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_CHATLOG";
    org.sqlproc.engine.SqlQueryEngine sqlEngineChatlog = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(chatlog, sqlControl);
    int count = sqlEngineChatlog.queryCount(sqlSession, chatlog, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("count: " + count);
    }
    return count;
  }
  
  public int count(final Chatlog chatlog, SqlControl sqlControl) {
    return count(sqlSessionFactory.getSqlSession(), chatlog, sqlControl);
  }
  
  public int count(final SqlSession sqlSession, final Chatlog chatlog) {
    return count(sqlSession, chatlog, null);
  }
  
  public int count(final Chatlog chatlog) {
    return count(chatlog, null);
  }
}
