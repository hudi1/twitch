package org.tomass.twitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tomass.twitch.dao.ChatlogDao;
import org.tomass.twitch.model.Chatlog;

@Service
@Transactional
public class ChatlogService {

	@Autowired
	private ChatlogDao chatlogDao;

	public Chatlog createChatlog(Chatlog chatlog) {
		return chatlogDao.insert(chatlog);
	}

	public Chatlog getChatlog(Integer id) {
		return chatlogDao.get(new Chatlog().withId(id));
	}

	public int updateChatlog(Chatlog Chatlog) {
		return chatlogDao.update(Chatlog);
	}

	public int deleteChatlog(Chatlog Chatlog) {
		return chatlogDao.delete(Chatlog);
	}

}