package org.tomass.twitch.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import org.sqlproc.engine.annotation.Pojo;

@Pojo
@SuppressWarnings("all")
public class Chatlog implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public static final String ORDER_BY_ID = "ID";
  
  public Chatlog() {
  }
  
  public Chatlog(final String channel, final String user, final String message, final LocalDateTime ts, final Boolean online) {
    super();
    setChannel(channel);
    setUser(user);
    setMessage(message);
    setTs(ts);
    setOnline(online);
  }
  
  private Integer id;
  
  public Integer getId() {
    return this.id;
  }
  
  public void setId(final Integer id) {
    this.id = id;
  }
  
  public Chatlog withId(final Integer id) {
    this.id = id;
    return this;
  }
  
  private String channel;
  
  public String getChannel() {
    return this.channel;
  }
  
  public void setChannel(final String channel) {
    this.channel = channel;
  }
  
  public Chatlog withChannel(final String channel) {
    this.channel = channel;
    return this;
  }
  
  private String user;
  
  public String getUser() {
    return this.user;
  }
  
  public void setUser(final String user) {
    this.user = user;
  }
  
  public Chatlog withUser(final String user) {
    this.user = user;
    return this;
  }
  
  private String message;
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(final String message) {
    this.message = message;
  }
  
  public Chatlog withMessage(final String message) {
    this.message = message;
    return this;
  }
  
  private LocalDateTime ts;
  
  public LocalDateTime getTs() {
    return this.ts;
  }
  
  public void setTs(final LocalDateTime ts) {
    this.ts = ts;
  }
  
  public Chatlog withTs(final LocalDateTime ts) {
    this.ts = ts;
    return this;
  }
  
  private Boolean online;
  
  public Boolean getOnline() {
    return this.online;
  }
  
  public void setOnline(final Boolean online) {
    this.online = online;
  }
  
  public Chatlog withOnline(final Boolean online) {
    this.online = online;
    return this;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (obj == null)
    	return false;
    if (getClass() != obj.getClass())
    	return false;
    Chatlog other = (Chatlog) obj;
    if (id == null || !id.equals(other.id))
    	return false;
    return true;
  }
  
  @Override
  public int hashCode() {
    return java.util.Objects.hash(id);
  }
  
  @Override
  public String toString() {
    return "Chatlog [id=" + id + ", channel=" + channel + ", user=" + user + ", message=" + message + ", ts=" + ts + ", online=" + online + "]";
  }
  
  public String toStringFull() {
    return "Chatlog [id=" + id + ", channel=" + channel + ", user=" + user + ", message=" + message + ", ts=" + ts + ", online=" + online + "]";
  }
  
  public enum OpAttribute {
    id,
    
    channel,
    
    user,
    
    message,
    
    ts,
    
    online;
  }
  
  private Map<String, String> operators_ =  new java.util.HashMap<String, String>();
  
  public Map<String, String> getOperators_() {
    return operators_;
  }
  
  public String getOp_(final String attrName) {
    if (attrName == null)
    	throw new IllegalArgumentException();
    return operators_.get(attrName);
  }
  
  public void setOp_(final String operator, final Chatlog.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), operator);
  }
  
  public Chatlog withOp_(final String operator, final Chatlog.OpAttribute... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final Chatlog.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.remove(attribute.name());
  }
  
  public Chatlog _clearOp_(final Chatlog.OpAttribute... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setOp_(final String operator, final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, operator);
  }
  
  public Chatlog withOp_(final String operator, final String... attributes) {
    setOp_(operator, attributes);
    return this;
  }
  
  public void clearOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.remove(attribute);
  }
  
  public Chatlog _clearOp_(final String... attributes) {
    clearOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final Chatlog.OpAttribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (OpAttribute attribute : attributes)
    	operators_.put(attribute.name(), "is null");
  }
  
  public Chatlog withNullOp_(final Chatlog.OpAttribute... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void setNullOp_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	operators_.put(attribute, "is null");
  }
  
  public Chatlog withNullOp_(final String... attributes) {
    setNullOp_(attributes);
    return this;
  }
  
  public void clearAllOps_() {
    operators_ = new java.util.HashMap<String, String>();
  }
}
